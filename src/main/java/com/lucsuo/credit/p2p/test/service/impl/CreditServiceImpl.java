package com.lucsuo.credit.p2p.test.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
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
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lucsuo.credit.p2p.test.service.CreditService;
import com.lucsuo.credit.p2p.test.util.AESUtil;
/**
 * 
 * @author Sorin
 *
 */
public class CreditServiceImpl implements CreditService {

	// 修改为自己公司的ID
	public static final String ID = "";
	// 修改为自己公司的PrivateKey
	public static final String KEY = "";
	// 央信评分接口对接请求地址URL
	public static final String URL = "http://api.lcsuo.com/company/get_score";
	// 调用时间同步接口请求URL
	public static final String URL_COM_TIME = "http://api.lcsuo.com/company/get_timeDiff";
	// 通讯信用评分对接请求地址URL
	public static final String URL_GET_QUERY = "http://api.lcsuo.com/company/CommunicationService/get_query";
	// 通信评分结果查询接口URL
	public static final String URL_GET_RESULT = "http://api.lcsuo.com/company/CommunicationService/get_result";
	
	private static final Logger LOG = LoggerFactory.getLogger(CreditServiceImpl.class);
	
	/**
	 * 通讯信用评分结果查询
	 */
	public String get_result(String batchCode, int timeDiff) {
		RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(30 * 1000)
				.setConnectTimeout(30 * 1000).setSocketTimeout(30 * 1000).build();
		CloseableHttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
		HttpPost request = new HttpPost(URL_GET_RESULT);
		CloseableHttpResponse response = null;
		String resultJson = null;
		try{
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			nvps.add(new BasicNameValuePair("id", ID));
			// Base64 ( AES ( timeStamp=System.currentTimeMillis()&timeDiff=0 )
			String paramString = "timeStamp="+System.currentTimeMillis()+"&timeDiff="+timeDiff;
			nvps.add(new BasicNameValuePair("param", Base64.encodeBase64URLSafeString(AESUtil.encrypt(paramString, KEY))));
			// sha1(参数串)
			StringBuilder sh1 = new StringBuilder(paramString).append("&id=").append(ID);
			nvps.add(new BasicNameValuePair("signature", DigestUtils.sha1Hex(Base64.encodeBase64URLSafeString(AESUtil.encrypt(sh1.toString(), KEY)))));
			nvps.add(new BasicNameValuePair("data",Base64.encodeBase64URLSafeString(AESUtil.encrypt(batchCode,KEY)).toString()));
			request.setEntity(new UrlEncodedFormEntity(nvps));
			// 发起请求
			response = client.execute(request);
			int resultCode = response.getStatusLine().getStatusCode();
			HttpEntity entity = response.getEntity();
			resultJson = EntityUtils.toString(entity, "UTF-8");
			if (HttpStatus.SC_OK == resultCode) {
				LOG.debug(resultJson);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != request && !request.isAborted()) {
				request.abort();
			}
			HttpClientUtils.closeQuietly(client);
			HttpClientUtils.closeQuietly(response);
		}
		return resultJson;
	}
	/**
	 * 通讯信用评分查询
	 */
	public String get_query(String paramData, int timeDiff) {
		RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(30 * 1000)
				.setConnectTimeout(30 * 1000).setSocketTimeout(30 * 1000).build();
		CloseableHttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
		HttpPost request = new HttpPost(URL_GET_QUERY);
		CloseableHttpResponse response = null;
		String batchCode = null;
		try{
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			nvps.add(new BasicNameValuePair("id", ID));
			// Base64 ( AES ( timeStamp=System.currentTimeMillis()&timeDiff=0 )
			String paramString = "timeStamp="+System.currentTimeMillis()+"&timeDiff="+timeDiff;
			nvps.add(new BasicNameValuePair("param", Base64.encodeBase64URLSafeString(AESUtil.encrypt(paramString, KEY))));
			// sha1(参数串)
			StringBuilder sh1 = new StringBuilder(paramString).append("&id=").append(ID);
			nvps.add(new BasicNameValuePair("signature", DigestUtils.sha1Hex(Base64.encodeBase64URLSafeString(AESUtil.encrypt(sh1.toString(), KEY)))));
			nvps.add(new BasicNameValuePair("data",Base64.encodeBase64URLSafeString(AESUtil.encrypt(paramData,KEY)).toString()));
			request.setEntity(new UrlEncodedFormEntity(nvps));
			// 发起请求
			response = client.execute(request);
			int resultCode = response.getStatusLine().getStatusCode();
			HttpEntity entity = response.getEntity();
			String resultJson = EntityUtils.toString(entity, "UTF-8");
			if (HttpStatus.SC_OK == resultCode) {
				LOG.debug(resultJson);
				JSONObject parseObject = JSON.parseObject(resultJson);
				batchCode = (String) parseObject.get("batchCode");
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != request && !request.isAborted()) {
				request.abort();
			}
			HttpClientUtils.closeQuietly(client);
			HttpClientUtils.closeQuietly(response);
		}
		return batchCode;
	}
	
	/**
	 * 央信评分接口对接示例
	 */
	public float get_score(String paramData,int timeDiff) {
		RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(30 * 1000)
				.setConnectTimeout(30 * 1000).setSocketTimeout(30 * 1000).build();
		CloseableHttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
		HttpPost request = new HttpPost(URL);
		CloseableHttpResponse response = null;
		float score = 0;
		try {
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			nvps.add(new BasicNameValuePair("id", ID));
			// Base64 ( AES ( timeStamp=System.currentTimeMillis()&timeDiff=0 )
			String paramString = "timeStamp="+System.currentTimeMillis()+"&timeDiff="+timeDiff+"&id="+ID;
			nvps.add(new BasicNameValuePair("param", Base64.encodeBase64URLSafeString(AESUtil.encrypt("timeStamp="+System.currentTimeMillis()+"&timeDiff="+timeDiff, KEY))));
			// sha1(参数串)
			nvps.add(new BasicNameValuePair("signature", DigestUtils.sha1Hex(Base64.encodeBase64URLSafeString(AESUtil.encrypt(paramString, KEY)))));
			nvps.add(new BasicNameValuePair("data", paramData));
			request.setEntity(new UrlEncodedFormEntity(nvps));
			// 发起请求
			response = client.execute(request);
			int resultCode = response.getStatusLine().getStatusCode();
			HttpEntity entity = response.getEntity();
			String resultJson = EntityUtils.toString(entity, "UTF-8");
			// 返回码200，请求成功；其他情况都为请求出现错误
			if (HttpStatus.SC_OK == resultCode) {
				LOG.debug("央信评分接口:"+resultJson);
				JSONObject parseObject = JSON.parseObject(resultJson);
				score =  parseObject.getFloatValue("queryScore");
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != request && !request.isAborted()) {
				request.abort();
			}
			HttpClientUtils.closeQuietly(client);
			HttpClientUtils.closeQuietly(response);
		}
		return score;
	}

	/**
	 * 调用时间同步接口
	 */
	public int get_timeDiff(String id) {
		RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(30 * 1000)
				.setConnectTimeout(30 * 1000).setSocketTimeout(30 * 1000).build();
		CloseableHttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
		HttpPost request = new HttpPost(URL_COM_TIME);
		CloseableHttpResponse response = null;
		int timeDiff = 0;
		try {
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			nvps.add(new BasicNameValuePair("id", ID));
			// Base64 ( AES ( timeStamp=System.currentTimeMillis()&timeDiff=0 )
			String paramString = "timeStamp="+System.currentTimeMillis()+"&id="+ID;
			nvps.add(new BasicNameValuePair("param", Base64.encodeBase64URLSafeString(AESUtil.encrypt("timeStamp="+System.currentTimeMillis(), KEY))));
			// sha1(参数串)
			nvps.add(new BasicNameValuePair("signature", DigestUtils.sha1Hex(Base64.encodeBase64URLSafeString(AESUtil.encrypt(paramString, KEY)))));
			request.setEntity(new UrlEncodedFormEntity(nvps));
			// 发起请求
			response = client.execute(request);
			int resultCode = response.getStatusLine().getStatusCode();
			HttpEntity entity = response.getEntity();
			String resultJson = EntityUtils.toString(entity, "UTF-8");
			// 返回码200，请求成功；其他情况都为请求出现错误
			if (HttpStatus.SC_OK == resultCode) {
				LOG.debug("时间同步接口:"+resultJson);
				JSONObject parseObject = JSON.parseObject(resultJson);
				timeDiff = parseObject.getIntValue("timeDiff");
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != request && !request.isAborted()) {
				request.abort();
			}
			HttpClientUtils.closeQuietly(client);
			HttpClientUtils.closeQuietly(response);
		}
		return timeDiff;
	}
}
