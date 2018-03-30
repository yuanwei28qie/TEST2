package com.microsilver.mrcard.scheduledtask.timer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.microsilver.mrcard.scheduledtask.timer.observer.EventObj;
import com.microsilver.mrcard.scheduledtask.timer.observer.Observer;
import com.microsilver.mrcard.scheduledtask.timer.observer.Subject;

/**
 * 所有属性配置的Holder
 */
public class PropertiesHolder implements Subject {

	// ********** 单例模块
	private static class SingletonHolder {
		private static final PropertiesHolder INSTANCE = new PropertiesHolder();
	}

	public static final PropertiesHolder getInstance() {
		return SingletonHolder.INSTANCE;
	}

	// ********** 配置信息模块
	private final Map<String, Properties> MAP = new HashMap<>();

	public Properties getPropertiesByKey(String key) {
		return this.MAP.get(key);
	}

	public void setPropertiesByKey(String key, Properties prop) {
		this.MAP.put(key, prop);

		// 每次有更新都通知观察者
		EventObj evt = new EventObj();
		evt.setTag(key);
		evt.setProp(prop);
		this.notifyObservers(evt);
	}

	public Set<String> getMapKeySet() {
		return this.MAP.keySet();
	}

	// 观察者模块
	private List<Observer> observers = new LinkedList<>();

	@Override
	public void add(Observer observer) {
		observers.add(observer);
		MAP.put(observer.getObserverName(), null);
	}

	@Override
	public void notifyObservers(EventObj evt) {
		try {
			for (Observer observer : observers) {
				observer.refresh(evt);
			}
		} catch (Exception e) {
		}
	}
}
