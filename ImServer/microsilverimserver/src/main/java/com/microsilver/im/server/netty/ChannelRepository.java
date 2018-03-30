/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.microsilver.im.server.netty;

import io.netty.channel.Channel;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Channel Repository using HashMap
 *
 * @author Jade
 */
public class ChannelRepository {
    private ConcurrentHashMap<String, Channel> channelCache = new ConcurrentHashMap<String, Channel>();
    private ConcurrentHashMap<String, Integer> messageCache = new ConcurrentHashMap<String, Integer>();

    private Integer all = 0;

    private Long currentTime,countTime;

    public ChannelRepository put(String key, Channel value) {
        channelCache.put(key, value);
        currentTime = System.currentTimeMillis();
        countTime = System.currentTimeMillis();
        return this;
    }

    public Integer messageCacheAdd(String key) {
        all ++;
        Integer count = 0;
        if(messageCache.containsKey(key)){
            count = this.messageCache.get(key);
        }else{
        }
        count++;
        this.messageCache.put(key,count);
       return this.messageCache.get(key);
    }

    public Channel get(String key) {
        return channelCache.get(key);
    }

    public ConcurrentHashMap<String, Integer> getMessageCache() {
        return messageCache;
    }
    public Integer getMessageCacheAll() {
        return all;
    }
    public void clearMessageCache(String cacheKey) {
        all = all - messageCache.get(cacheKey);
        messageCache.remove(cacheKey);
    }

    public ConcurrentHashMap<String, Channel> getChannelCache() {
        return channelCache;
    }

    public void remove(String key) { this.channelCache.remove(key); }

    public int size() {
        return this.channelCache.size();
    }

    public Long getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Long currentTime) {
        this.currentTime = currentTime;
    }

    public Long getCountTime() {
        return countTime;
    }

    public void setCountTime(Long countTime) {
        this.countTime = countTime;
    }
}
