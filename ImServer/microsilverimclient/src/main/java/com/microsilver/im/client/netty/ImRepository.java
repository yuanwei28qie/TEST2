package com.microsilver.im.client.netty;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Name ImRepository
 * @Description
 * @Author Jade
 * @Version 2017/9/27
 * @Copyright Micro Silver
 */
@Component
public class ImRepository {

    private Map<String, IMclient> imCache = new HashMap<String, IMclient>();

    private Integer reply  = 0;

    public ImRepository put(String key, IMclient value) {
        imCache.put(key, value);
        return this;
    }

    public ImRepository putReply() {
        reply ++;
        return this;
    }

    public IMclient get(String key) {
        return imCache.get(key);
    }

    public void remove(String key) { this.imCache.remove(key); }

    public int size() {
        return this.imCache.size();
    }
    public int sizeByReply() {
        return this.reply;
    }
}
