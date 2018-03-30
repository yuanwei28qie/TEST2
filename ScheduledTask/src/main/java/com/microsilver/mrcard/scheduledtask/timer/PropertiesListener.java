package com.microsilver.mrcard.scheduledtask.timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 监听Properties属性文件
 */
@WebListener("properties file listener")
public class PropertiesListener implements ServletContextListener {

	/**
	 * 自动监听时钟
	 */
	private PropertiesTimer rt = null;

	@Override
	public void contextInitialized(ServletContextEvent event) {
		// String status = "Properties listener start .";
		// event.getServletContext().log(status);
		// System.out.println(status);

		// 激活自动监听时钟
		rt = new PropertiesTimer(15);
		rt.start();
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// String status = "Properties listener stop .";
		// event.getServletContext().log(status);
		// System.out.println(status);

		// 停止自动监听时钟
		if (rt != null) {
			rt.stop();
		}
	}
}