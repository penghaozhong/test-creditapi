package com.lucsuo.credit.p2p.test.net;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

/**
 * HttpClient工具
 */
public class HttpClientFactory {

	private static final String UTF_8 = "UTF-8";
	private static final String EMPTY = "";
	private static final int CONNECTION_REQUEST_TIMEOUT = 30 * 1000;
	private static final int CONNECTION_TIMEOUT = 30 * 1000;
	private static final int SOCKET_TIMEOUT = 30 * 1000;

	private CloseableHttpClient client;

	private HttpClientFactory() {
		this.client = buildClient();
	}

	/**
	 * 构建httpClint工具类
	 * @return
	 */
	public static HttpClientFactory createInstance() {
		HttpClientFactory factory = new HttpClientFactory();
		return factory;
	}

	private CloseableHttpClient buildClient() {
		RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(CONNECTION_REQUEST_TIMEOUT)
				.setConnectTimeout(CONNECTION_TIMEOUT).setSocketTimeout(SOCKET_TIMEOUT).build();
		return HttpClientBuilder.create().setDefaultRequestConfig(config).build();
	}

	/**
	 * 发送POST请求
	 * @param url 网络请求地址
	 * @param nvps 请求参数列表
	 * @return
	 */
	public String post(String url, List<NameValuePair> nvps) {
		HttpPost request = new HttpPost(url);
		CloseableHttpResponse response = null;
		try {
			request.setEntity(new UrlEncodedFormEntity(nvps,"UTF-8")); // 封装post请求参数
			response = client.execute(request); // 发送请求
			int resultCode = response.getStatusLine().getStatusCode(); // 返回响应状态

			/**************** 网络异常, 退出程序 **************/
			if (HttpStatus.SC_OK != resultCode)	return EMPTY;

			/**************** 将响应转换为字符串 **************/
			HttpEntity entity = response.getEntity();
			return EntityUtils.toString(entity, UTF_8);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != request && !request.isAborted()) {
				request.abort();
			}
			HttpClientUtils.closeQuietly(client);
			HttpClientUtils.closeQuietly(response);
		}
		return EMPTY;
	}

}
