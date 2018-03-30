package com.microsilver.mrcard.scheduledtask.timer;

import java.util.Date;
import java.util.Timer;

/**
 * 定时时钟
 */
public class PropertiesTimer {
	private final Timer timer = new Timer();
	private final int sec;

	public PropertiesTimer(int seconds) {
		sec = seconds;
	}

	/**
	 * 启动自动监听任务
	 */
	public void start() {
		// 监听器启动后，定时任务延迟2秒开始执行
		Date date = new Date(System.currentTimeMillis() + 2000);
		timer.schedule(new PropertiesTask(), date, sec * 1000);
	}

	/**
	 * 停止自动监听任务
	 */
	public void stop() {
		timer.cancel();
	}
}