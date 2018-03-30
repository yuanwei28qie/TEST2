package com.microsilver.mrcard.scheduledtask.delay;

import com.microsilver.mrcard.cloud.finance.dto.CommissionDto;

import java.util.List;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by Jade on 2017/8/22.
 * 结算对象
 */
public class DelayCommission implements Delayed{
    private int orderId;
    //结算执行次数
    private int count;
    //结算结构
    private CommissionDto element;

    private String orderSn;

    private List<CommissionDto> listElement;

    //延迟结算时间
    private long expiryTime;

    public DelayCommission(int count,int orderId, CommissionDto element, long expiryTime) {
        this.count = count;
        this.orderId = orderId;
        this.element = element;
        this.expiryTime = System.currentTimeMillis() + expiryTime;
    }

    public DelayCommission(int count, String orderSn, List<CommissionDto> listElement, long expiryTime) {
        this.count = count;
        this.orderSn = orderSn;
        this.listElement = listElement;
        this.expiryTime = expiryTime;
    }

    public DelayCommission(int count, int orderId, String orderSn, List<CommissionDto> listElement, long expiryTime) {
        this.orderId = orderId;
        this.count = count;
        this.orderSn = orderSn;
        this.listElement = listElement;
        this.expiryTime = expiryTime;
    }

    @Override
    public long getDelay(TimeUnit timeUnit) {
        long diff = expiryTime - System.currentTimeMillis();
        return timeUnit.convert(diff, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        if (this.expiryTime < ((DelayCommission) o).expiryTime) {
            return -1;
        }
        if (this.expiryTime > ((DelayCommission) o).expiryTime) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return count  + ": " +  element + ": " + expiryTime;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public List<CommissionDto> getListElement() {
        return listElement;
    }

    public void setListElement(List<CommissionDto> listElement) {
        this.listElement = listElement;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public CommissionDto getElement() {
        return element;
    }

    public void setElement(CommissionDto element) {
        this.element = element;
    }

    public long getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(long expiryTime) {
        this.expiryTime =  System.currentTimeMillis() + expiryTime;
    }
}
