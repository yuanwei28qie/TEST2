package com.microsilver.mrcard.scheduledtask.timer.observer;

public abstract class Observer {
	// 观察者名称
	protected String observerName;

	// 得到通知后刷新状态
	public abstract void refresh(EventObj evt);

	public String getObserverName() {
		return observerName;
	}
}
