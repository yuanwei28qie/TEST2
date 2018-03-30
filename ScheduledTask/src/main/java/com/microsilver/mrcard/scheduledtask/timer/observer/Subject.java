package com.microsilver.mrcard.scheduledtask.timer.observer;

public interface Subject {

	// 添加观察者
	void add(Observer observer);

	// 通知所有的观察者
	void notifyObservers(EventObj evt);
}
