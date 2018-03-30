package com.microsilver.mrcard.scheduledtask.mq;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.microsilver.mrcard.scheduledtask.mq.AmqpConfig.QueueConfig;

/**
 * 此类配置队列消费关系
 */
@Component
public class QueueHandler implements ApplicationContextAware, Runnable {
	// 队列配置
	@Autowired(required = true)
	private AmqpConfig amqpConfig;

	// 每个队列的消息监听器
	private final Map<String, SimpleMessageListenerContainer> containerMap = new ConcurrentHashMap<>();

	// 当前上下文
	private ApplicationContext applicationContext;

	/**
	 * 刷新监听容器.
	 * 
	 * @param queueName
	 * @return
	 */
	public void refreshListenerContainer(QueueConfig queueConfig) {
		try {
			// 查看已有的监听器
			SimpleMessageListenerContainer container = containerMap.get(queueConfig.name);
			if (container != null) {
				container.stop();
			}

			// 队列配置信息
			container = new SimpleMessageListenerContainer(this.amqpConfig.connectionFactory());
			container.setExposeListenerChannel(true);
			container.setMessageListener(applicationContext.getBean(queueConfig.handler));

			// 指定队列为持久化
			container.setQueues(new Queue(queueConfig.name, true));
			// 最大的消费端线程数量
			container.setMaxConcurrentConsumers(queueConfig.maxConcurrentConsumers);
			// 获取消息的并发线程数
			container.setConcurrentConsumers(queueConfig.concurrentConsumers);
			// 设置确认模式手工确认
			container.setAcknowledgeMode(queueConfig.autoack ? AcknowledgeMode.AUTO : AcknowledgeMode.MANUAL);
			// 每个消费者，每次取一个消息
			container.setPrefetchCount(queueConfig.prefetchCount);

			// 启动容器
			container.start();
			containerMap.put(queueConfig.name, container);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		Iterator<String> iterator = containerMap.keySet().iterator();
		while (iterator.hasNext()) {
			containerMap.get(iterator.next()).stop();
		}
	}

	// 在应用程序上下文加载完成后，开始初始化消息队列的监听机制
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
		new Thread(this).start();
	}

	@Override
	public void run() {
		try {
			Map<String, QueueConfig> map = this.amqpConfig.getQueueConfig();
			map.values().forEach(queueConfig -> {
				this.refreshListenerContainer(queueConfig);
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
