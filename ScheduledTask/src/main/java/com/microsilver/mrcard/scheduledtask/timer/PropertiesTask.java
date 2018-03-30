package com.microsilver.mrcard.scheduledtask.timer;

import java.net.URI;
import java.net.URISyntaxException;
import java.io.*;
import java.util.*;

import org.springframework.util.StringUtils;

import com.microsilver.mrcard.scheduledtask.utils.PropertiesUtil;

/**
 * 自动监听任务
 * 
 */
public class PropertiesTask extends TimerTask {

	/**
	 * 配置文件的最后更新时间
	 */
	private long lastModified = 0;

	// 执行定时任务
	public void run() {
		try {
			todo();
		} catch (URISyntaxException e) {
		}
	}

	/**
	 * 监听配置文件是否被更新，自动更新文件中的配置项存储到 application 变量中。
	 * 
	 * @throws URISyntaxException
	 */
	public void todo() throws URISyntaxException {
		Iterator<String> iterator = PropertiesHolder.getInstance().getMapKeySet().iterator();
		while (iterator.hasNext()) {
			String filename = iterator.next();
			if (this.isFileUpdated(filename)) {
				Properties prop = PropertiesUtil.loadProperties(filename);
				PropertiesHolder.getInstance().setPropertiesByKey(filename, prop);
			}
		}
	}

	/**
	 * 判断物理文件是否已被更新
	 * 
	 * @param filename
	 *            物理文件名
	 * @return 是 true 否 false
	 * @throws URISyntaxException
	 */
	private boolean isFileUpdated(String filename) throws URISyntaxException {
		if (StringUtils.isEmpty(filename)) {
			return false;
		}
		URI uri = Thread.currentThread().getContextClassLoader().getResource(filename).toURI();
		File file = new File(uri);
		if (file.isFile()) {
			long lastUpdateTime = file.lastModified();
			if (lastUpdateTime > this.lastModified) {
				this.lastModified = lastUpdateTime;
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
