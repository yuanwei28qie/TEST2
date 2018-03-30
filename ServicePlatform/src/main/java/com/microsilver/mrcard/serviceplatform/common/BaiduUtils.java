package com.microsilver.mrcard.serviceplatform.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.microsilver.mrcard.common.HttpClientUtils;

public class BaiduUtils {
	/**
	 * 百度地图计算两点之间的距离与骑行时间.
	 * @param origins 起点经纬度 格式 41.45,116.34
	 * @param destinations 终点经纬度 格式 41.45,116.34
	 * @return
	 */
	public static Map<String,String> calDistanceAndTime(String origins,String destinations) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("origins", origins);
		map.put("destinations", destinations);
		map.put("ak", Consts.BAIDUMAP_APP_AK);
		String jsonResult = HttpClientUtils.doGet(Consts.BAIDUMAP_BASE_URL+Consts.BAIDUMAP_ROUTEMATRIX, map,null);
		Map parseObject = JSON.parseObject(jsonResult, Map.class);
		/**
		 * {"status":0,"result":[{"distance":{"text":"201.1公里","value":201126},"duration":{"text":"24.2小时","value":87158}}],"message":"成功"}
		 */
		map = null;
		if(parseObject.containsKey("status")) {
			if((int)(parseObject.get("status"))==0) {			 
				Object object = parseObject.get("result");
				List<Result> results = JSON.parseArray(object.toString(), Result.class);
				Result result = results.get(0);
				map=new HashMap<>();
				map.put("distance", result.getDistance().getValue());
				map.put("time", result.getDuration().getValue());
				return map;
			}
		}
		return null;
	}
	public static void main(String[] args) {
		calDistanceAndTime("41.45,113.34", "41.45,116.34");
	}
	
	static class Result{
		private Distance distance;
		private Duration duration;
		public Distance getDistance() {
			return distance;
		}
		public void setDistance(Distance distance) {
			this.distance = distance;
		}
		public Duration getDuration() {
			return duration;
		}
		public void setDuration(Duration duration) {
			this.duration = duration;
		}
		@Override
		public String toString() {
			return "Result [distance=" + distance + ", duration=" + duration + "]";
		}
		
	}
	static class Distance{
		private String text;
		private String value;
		public String getText() {
			return text;
		}
		public void setText(String text) {
			this.text = text;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		@Override
		public String toString() {
			return "Distance [text=" + text + ", value=" + value + "]";
		}
		
	}
	static class Duration{
		private String text;
		private String value;
		public String getText() {
			return text;
		}
		public void setText(String text) {
			this.text = text;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		@Override
		public String toString() {
			return "Duration [text=" + text + ", value=" + value + "]";
		}
	}
}
