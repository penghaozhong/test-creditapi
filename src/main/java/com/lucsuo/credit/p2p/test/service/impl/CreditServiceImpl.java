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

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lucsuo.credit.p2p.test.entity.AsyncQueryCommunicationVo;
import com.lucsuo.credit.p2p.test.entity.CommunicationScore;
import com.lucsuo.credit.p2p.test.entity.QueryCommunicationInfo;
import com.lucsuo.credit.p2p.test.service.CreditService;
import com.lucsuo.credit.p2p.test.util.AESUtil;

public class CreditServiceImpl implements CreditService {

	// 修改为自己公司的ID
	public static final String ID = "1448874409041";
	// 修改为自己公司的key
	public static final String KEY = "c3JahayZGMlDRS5vNRNwGA0U-AYeLGNo";
	// 央信评分接口对接请求地址URL
	public static final String URL = "http://192.168.1.105/company/CenterScoreService/get_score";
	//通讯信用评分请求URL
	public static final String URL_COM_TIME = "http://127.0.0.1:9090/credit_manage/company/get_timeDiff";
	//post查询通讯信用评分
	public static final String URL_COM = "http://127.0.0.1:9090/credit_manage/company/CommunicationService/get_query";
	//根据查询返回的batchCode,获取评分
	public static final String URL_COM_RESULT = "http://127.0.0.1:9090/credit_manage/company/CommunicationService/get_result";
	
	
	/**
	 * 根据查询返回的batchCode,获取评分
	 * @param batchCode
	 * @return
	 */
	@Override
	public String getComScore(String batchCode,int comScoreTime){
		RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(30 * 1000)
				.setConnectTimeout(30 * 1000).setSocketTimeout(30 * 1000).build();
		CloseableHttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
		HttpPost request = new HttpPost(URL_COM_RESULT);
		CloseableHttpResponse response = null;
		String resultJson = null;
		try{
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			nvps.add(new BasicNameValuePair("id", ID));
			// Base64 ( AES ( timeStamp=System.currentTimeMillis()&timeDiff=0 )
			String paramString = "timeStamp="+System.currentTimeMillis()+"&timeDiff="+comScoreTime;
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
				System.out.println(resultJson);
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
	 * post查询通讯信用评分
	 * @param comScoreTime
	 * @param data
	 * @return
	 */
	@Override
	public String getComScore(int comScoreTime,String data){
		RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(30 * 1000)
				.setConnectTimeout(30 * 1000).setSocketTimeout(30 * 1000).build();
		CloseableHttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
		HttpPost request = new HttpPost(URL_COM);
		CloseableHttpResponse response = null;
		String batchCode = null;
		try{
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			nvps.add(new BasicNameValuePair("id", ID));
			// Base64 ( AES ( timeStamp=System.currentTimeMillis()&timeDiff=0 )
			String paramString = "timeStamp="+System.currentTimeMillis()+"&timeDiff="+comScoreTime;
			nvps.add(new BasicNameValuePair("param", Base64.encodeBase64URLSafeString(AESUtil.encrypt(paramString, KEY))));
			// sha1(参数串)
			StringBuilder sh1 = new StringBuilder(paramString).append("&id=").append(ID);
			nvps.add(new BasicNameValuePair("signature", DigestUtils.sha1Hex(Base64.encodeBase64URLSafeString(AESUtil.encrypt(sh1.toString(), KEY)))));
			nvps.add(new BasicNameValuePair("data",Base64.encodeBase64URLSafeString(AESUtil.encrypt(data,KEY)).toString()));
			request.setEntity(new UrlEncodedFormEntity(nvps));
			// 发起请求
			response = client.execute(request);
			int resultCode = response.getStatusLine().getStatusCode();
			HttpEntity entity = response.getEntity();
			String resultJson = EntityUtils.toString(entity, "UTF-8");
			if (HttpStatus.SC_OK == resultCode) {
				System.out.println(resultJson);
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
	 * 调用时间同步接口
	 * @return
	 */
	@Override
	public int getComScoreTime(){
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
			String paramString = "timeStamp="+System.currentTimeMillis();
			nvps.add(new BasicNameValuePair("param", Base64.encodeBase64URLSafeString(AESUtil.encrypt(paramString, KEY))));
			// sha1(参数串)
			StringBuilder sh1 = new StringBuilder(paramString).append("&id=").append(ID);
			nvps.add(new BasicNameValuePair("signature", DigestUtils.sha1Hex(Base64.encodeBase64URLSafeString(AESUtil.encrypt(sh1.toString(), KEY)))));
			request.setEntity(new UrlEncodedFormEntity(nvps));
			// 发起请求
			response = client.execute(request);
			int resultCode = response.getStatusLine().getStatusCode();
			HttpEntity entity = response.getEntity();
			String resultJson = EntityUtils.toString(entity, "UTF-8");
			// 返回码200，请求成功；其他情况都为请求出现错误
			if (HttpStatus.SC_OK == resultCode) {
				System.out.println(resultJson);
				JSONObject parseObject = JSON.parseObject(resultJson);
				timeDiff = (int) parseObject.get("timeDiff");
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
	/**
	 * 央信评分接口对接示例
	 */
	public int getCenterScore(String paramData) {
		RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(30 * 1000)
				.setConnectTimeout(30 * 1000).setSocketTimeout(30 * 1000).build();
		CloseableHttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
		HttpPost request = new HttpPost(URL);
		CloseableHttpResponse response = null;
		try {
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			nvps.add(new BasicNameValuePair("id", ID));
			// Base64 ( AES ( timeStamp=System.currentTimeMillis()&timeDiff=0 )
			String paramString = "timeStamp="+System.currentTimeMillis()+"&timeDiff=0";
			nvps.add(new BasicNameValuePair("param", Base64.encodeBase64URLSafeString(AESUtil.encrypt(paramString, KEY))));
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
				System.out.println(resultJson);
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
		return 0;
	}

	
}
