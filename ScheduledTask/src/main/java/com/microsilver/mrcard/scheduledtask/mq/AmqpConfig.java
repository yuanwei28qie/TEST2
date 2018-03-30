package com.microsilver.mrcard.scheduledtask.mq;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;

import com.microsilver.mrcard.scheduledtask.timer.PropertiesHolder;
import com.microsilver.mrcard.scheduledtask.timer.observer.EventObj;
import com.microsilver.mrcard.scheduledtask.timer.observer.Observer;
import com.microsilver.mrcard.scheduledtask.utils.PropertiesUtil;

/**
 * 队列配置类
 */
@Configuration
public class AmqpConfig extends Observer {
	// 链接工厂
	//private ConnectionFactory connectionFactory;

	// 消费端队列配置
	private Map<String, QueueConfig> queueConfig = new ConcurrentHashMap<>();

	// 生产端路由配置
	private Map<String, RouteConfig> routeConfig = new ConcurrentHashMap<>();

	// 配置文件
	private Properties prop;

	{
		this.observerName = "rabbitmq.properties";
		PropertiesHolder.getInstance().add(this);
		this.initConfig();
	}

	public void initConfig() {
		Properties prop = PropertiesUtil.loadProperties(this.observerName);
		this.refreshConfig(prop);
	}
	@Bean
	// @Scope(value = "prototype")
	public RabbitTemplate rabbitTemplate() {
		RabbitTemplate template = new RabbitTemplate(connectionFactory());
		return template;
	}
	@Bean  
    public DirectExchange msgExchange() {  
        return new DirectExchange(prop.getProperty("rabbitmq.send1.exchange"));
    }  
	@Bean  
    public DirectExchange orderExchange() {  
        return new DirectExchange(prop.getProperty("rabbitmq.send2.exchange"));  
    }
    @Bean
    public DirectExchange sortExchange() {
        return new DirectExchange(prop.getProperty("rabbitmq.send3.exchange"));
    }
    @Bean
    public DirectExchange memberExchange() {
        return new DirectExchange(prop.getProperty("rabbitmq.send5.exchange"));
    }
	@Bean
	public Queue msgQueue() {
		return new Queue(prop.getProperty("rabbitmq.send1.queue"), true); // 队列持久
	}
	@Bean
	public Queue orderQueue() {
		return new Queue(prop.getProperty("rabbitmq.send2.queue"), true); // 队列持久
	}
	@Bean
	public Queue sortQueue() {
		return new Queue(prop.getProperty("rabbitmq.send3.queue"), true); // 队列持久
	}
	@Bean
	public Queue memberQueue() {
		return new Queue(prop.getProperty("rabbitmq.send5.queue"), true); // 队列持久
	}
	@Bean
	public Binding bindingMsg() {
		return BindingBuilder.bind(msgQueue()).to(msgExchange()).with(prop.getProperty("rabbitmq.send1.routingkey"));
	}
	@Bean
	public Binding bindingOrder() {
		return BindingBuilder.bind(orderQueue()).to(orderExchange()).with(prop.getProperty("rabbitmq.send2.routingkey"));
	}
	@Bean
	public Binding bindingSort() {
		return BindingBuilder.bind(sortQueue()).to(sortExchange()).with(prop.getProperty("rabbitmq.send3.routingkey"));
	}
	@Bean
	public Binding bindingMember() {
		return BindingBuilder.bind(memberQueue()).to(memberExchange()).with(prop.getProperty("rabbitmq.send5.routingkey"));
	}
	@Bean  
    public ConnectionFactory connectionFactory() {  
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();  
        connectionFactory.setAddresses(prop.getProperty("rabbitmq.host"));
        connectionFactory.setPort(Integer.parseInt(prop.getProperty("rabbitmq.port")));
        connectionFactory.setUsername(prop.getProperty("rabbitmq.username"));  
        connectionFactory.setPassword(prop.getProperty("rabbitmq.password"));  
        connectionFactory.setVirtualHost(prop.getProperty("rabbitmq.virtualHost"));  
        connectionFactory.setPublisherConfirms(false); //必须要设置  
        return connectionFactory;
    }  
	public void refreshConfig(Properties prop) {
		try {
			// 配置没有变更，不用更新
			if (this.prop != null && this.prop.equals(prop)) {
				return;
			}

			// 1、连接工厂
			/*String host = prop.getProperty("rabbitmq.host");
			String port = prop.getProperty("rabbitmq.port");
			String username = prop.getProperty("rabbitmq.username");
			String password = prop.getProperty("rabbitmq.password");
			String virtualHost = prop.getProperty("rabbitmq.virtualHost");
			String connectionFactoryKey = host + port + virtualHost + username + password;
			prop.setProperty("connectionFactoryKey", connectionFactoryKey);
			if (this.prop == null || !connectionFactoryKey.equals(this.prop.getProperty("connectionFactoryKey"))) {
				if (this.connectionFactory != null) {
					this.connectionFactory.clearConnectionListeners();
				}
				CachingConnectionFactory factory = new CachingConnectionFactory();
				factory.setAddresses(host + ":" + port);
				factory.setUsername(username);
				factory.setPassword(password);
				factory.setVirtualHost(virtualHost);
				this.connectionFactory = factory;
			}*/

			this.prop = prop;

			// 2、消费端队列配置处理
			if (!prop.containsKey("rabbitmq.queue.name")) {
				// 有可能有多个队列配置，默认最多找10个
				for (int i = 1; i <= 10; i++) {
					QueueConfig queueConfig = this.createQueueConfig("" + i);
					if (queueConfig == null) {
						break;
					}
					this.queueConfig.put(queueConfig.name, queueConfig);
				}
			} else {
				// 默认没有序号只处理一个队列
				QueueConfig queueConfig = this.createQueueConfig("");
				this.queueConfig.put(queueConfig.name, queueConfig);
			}

			// 3、生产端
			if (!prop.containsKey("rabbitmq.send.business")) {
				// 有可能有多组路由映射
				for (int i = 1; i <= 10; i++) {
					RouteConfig routeConfig = this.createRouteMapping("" + i);
					if (routeConfig == null) {
						break;
					}
				}
			} else {
				// 默认没有序号只处理一个映射
				this.createRouteMapping("");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*public ConnectionFactory getConnectionFactory() {
		return connectionFactory;
	}*/

	public Map<String, QueueConfig> getQueueConfig() {
		return this.queueConfig;
	}

	// 收到配置更新通知后
	@Override
	public void refresh(EventObj evt) {
		// 只处理自己感兴趣的
		if (evt.getTag().equals(this.observerName)) {
			Properties prop = evt.getProp();

			// 刷新连接工厂
			this.refreshConfig(prop);
		}
	}

	// 队列配置
	private QueueConfig createQueueConfig(String tag) {
		String name = prop.getProperty("rabbitmq.queue" + tag + ".name");
		if (name == null) {
			return null;
		}
		Assert.hasLength(name, "队列名称不能为空");
		String handler = prop.getProperty("rabbitmq.queue" + tag + ".handler");
		Assert.hasLength(handler, "队列消息处理handler不能为空");

		String concurrentConsumers = prop.getProperty("rabbitmq.queue" + tag + ".concurrentConsumers", "1");
		String maxConcurrentConsumers = prop.getProperty("rabbitmq.queue" + tag + ".maxConcurrentConsumers", "1");
		String prefetchCount = prop.getProperty("rabbitmq.queue" + tag + ".prefetchCount", "1");
		String autoack = prop.getProperty("rabbitmq.queue" + tag + ".autoack", "true");
		String durable = prop.getProperty("rabbitmq.queue" + tag + ".durable", "true");

		QueueConfig queueConfig = new QueueConfig();
		queueConfig.name = name;
		queueConfig.handler = handler;
		queueConfig.concurrentConsumers = Integer.valueOf(concurrentConsumers);
		queueConfig.maxConcurrentConsumers = Integer.valueOf(maxConcurrentConsumers);
		queueConfig.prefetchCount = Integer.valueOf(prefetchCount);
		queueConfig.autoack = Boolean.valueOf(autoack);
		queueConfig.durable = Boolean.valueOf(durable);

		return queueConfig;
	}

	// 路由映射
	private RouteConfig createRouteMapping(String tag) {
		String business = prop.getProperty("rabbitmq.send" + tag + ".business");
		if (business == null) {
			return null;
		}
		Assert.hasLength(business, "业务名称不能为空且不能重复");
		String exchange = prop.getProperty("rabbitmq.send" + tag + ".exchange");
		Assert.hasLength(exchange, "exchange不能为空");
		String routingkey = prop.getProperty("rabbitmq.send" + tag + ".routingkey");
		Assert.hasLength(routingkey, "routingkey不能为空");

		RouteConfig routeConfig = new RouteConfig();
		routeConfig.exchange = exchange;
		routeConfig.routingkey = routingkey;
		this.routeConfig.put(business, routeConfig);

		return routeConfig;
	}

	class QueueConfig {
		// 队列名称
		String name;

		// 处理队列消息的bean的id
		String handler;

		// 并发消费者数量
		int concurrentConsumers;

		// 最大消费者数量
		int maxConcurrentConsumers;

		// 每次从队列中获取的消息数量
		int prefetchCount;

		// ack模式 false 手动 / true 自动
		boolean autoack = true;

		// durable false 不持久 / true 持久
		boolean durable = true;
	}

	class RouteConfig {

		String exchange;

		String routingkey;
	}
}
