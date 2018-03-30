package com.microsilver.mrcard.common;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;

public class HttpClientUtils {

	public static String doGet(String url, Map<String, String> param,Map<String,String> headers) {

		// 创建Httpclient对象
		CloseableHttpClient httpclient = HttpClients.createDefault();

		String resultString = "";
		CloseableHttpResponse response = null;
		try {
			// 创建uri
			URIBuilder builder = new URIBuilder(url);
			if (param != null) {
				for (String key : param.keySet()) {
					builder.addParameter(key, param.get(key));
				}
			}
			URI uri = builder.build();

			// 创建http GET请求
			HttpGet httpGet = new HttpGet(uri);
			if(headers != null) {
				for (Entry<String, String> entry: headers.entrySet()) {
					httpGet.setHeader(entry.getKey(), entry.getValue());
				}
			}
			// 执行请求
			response = httpclient.execute(httpGet);
			// 判断返回状态是否为200
			if (response.getStatusLine().getStatusCode() == 200) {
				resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (response != null) {
					response.close();
				}
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resultString;
	}

	public static String doGet(String url) {
		return doGet(url, null,null);
	}

	public static String doPost(String url, Map<String, String> param,Map<String,String> headers) {
		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		String resultString = "";
		try {
			// 创建Http Post请求
			HttpPost httpPost = new HttpPost(url);
			if(headers != null) {
				for (Entry<String, String> entry: headers.entrySet()) {
					httpPost.setHeader(entry.getKey(), entry.getValue());
				}
			}
			// 创建参数列表
			if (param != null) {
				List<NameValuePair> paramList = new ArrayList<>();
				for (String key : param.keySet()) {
					paramList.add(new BasicNameValuePair(key, param.get(key)));
				}
				// 模拟表单
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList,"UTF-8");
				httpPost.setEntity(entity);
			}
			// 执行http请求
			response = httpClient.execute(httpPost);
			resultString = EntityUtils.toString(response.getEntity(), "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				response.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return resultString;
	}

	public static String doPost(String url) {
		return doPost(url, null,null);
	}
	public static void main(String[] args) {
		Map<String,String> headers = new HashMap<String,String>();
		headers.put("App-Key", "8luwapkv8rsxl");
		long currentTimeMillis = System.currentTimeMillis();
		int nonce = new Random().nextInt(10000);	
		headers.put("Nonce", nonce+"");
		headers.put("Timestamp", currentTimeMillis+"");
		headers.put("Signature", DigestUtils.sha1Hex("7sitjYoWQ7rK"+nonce+currentTimeMillis));
		/**
		 * userId	String	用户 Id，最大长度 64 字节。是用户在 App 中的唯一标识码，必须保证在同一个 App 内不重复，重复的用户 Id 将被当作是同一用户。（必传）
name	String	用户名称，最大长度 128 字节。用来在 Push 推送时显示用户的名称。（必传）
portraitUri	String	用户头像 URI，最大长度 1024 字节。（必传）
		 */
		Map<String,String> map = new HashMap<String,String>();
		map.put("userId", "43113");
		map.put("name", "zhangsan");
		map.put("portraitUri", "jlkfada");
		String doPost = doPost("http://api.cn.ronghub.com/user/getToken.json", map, headers);
		Map parseObject = JSON.parseObject(doPost, Map.class);
		if(parseObject.containsKey("code")) {
			if((int)(parseObject.get("code"))==200) {
				System.out.println((String)parseObject.get("token"));
			}
		}
		System.out.println(doPost);
	}
}

