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

import com.lucsuo.credit.p2p.test.CreditServiceTest;
import com.lucsuo.credit.p2p.test.service.CreditService;
import com.lucsuo.credit.p2p.test.util.AESUtil;

public class CreditServiceImpl implements CreditService {

	// 修改为自己公司的ID
	public static final String ID = "1453963509180";
	// 修改为自己公司的key
	public static final String KEY = "l9Vld79WTxQMp5nG4hwt6UvBdW4bOzVa";
	// 请求地址URL
	public static final String URL = "http://localhost:8080/credit_manage/company/CenterScoreService/get_score";

	public static final String URLTIME = "http://localhost:8080/credit_manage/company/get_timeDiff";

	private static final Logger LOG = LoggerFactory.getLogger(CreditServiceImpl.class);
	
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
			String paramString = "timeStamp="+System.currentTimeMillis()+"&timeDiff=60&id="+ID;
			nvps.add(new BasicNameValuePair("param", Base64.encodeBase64URLSafeString(AESUtil.encrypt("timeStamp="+System.currentTimeMillis()+"&timeDiff=60", KEY))));
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
		return 0;
	}

	public long get_timeDiff(String id) {
		RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(30 * 1000)
				.setConnectTimeout(30 * 1000).setSocketTimeout(30 * 1000).build();
		CloseableHttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
		HttpPost request = new HttpPost(URLTIME);
		CloseableHttpResponse response = null;
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
=======
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

import com.lucsuo.credit.p2p.test.CreditServiceTest;
import com.lucsuo.credit.p2p.test.service.CreditService;
import com.lucsuo.credit.p2p.test.util.AESUtil;

public class CreditServiceImpl implements CreditService {

	// 修改为自己公司的ID
	public static final String ID = "1453963509180";
	// 修改为自己公司的key
	public static final String KEY = "l9Vld79WTxQMp5nG4hwt6UvBdW4bOzVa";
	// 请求地址URL
	public static final String URL = "http://localhost:8080/credit_manage/company/CenterScoreService/get_score";

	public static final String URLTIME = "http://localhost:8080/credit_manage/company/get_timeDiff";

	private static final Logger LOG = LoggerFactory.getLogger(CreditServiceImpl.class);
	
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
			String paramString = "timeStamp="+System.currentTimeMillis()+"&timeDiff=60&id="+ID;
			nvps.add(new BasicNameValuePair("param", Base64.encodeBase64URLSafeString(AESUtil.encrypt("timeStamp="+System.currentTimeMillis()+"&timeDiff=60", KEY))));
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
		return 0;
	}

	public long get_timeDiff(String id) {
		RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(30 * 1000)
				.setConnectTimeout(30 * 1000).setSocketTimeout(30 * 1000).build();
		CloseableHttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
		HttpPost request = new HttpPost(URLTIME);
		CloseableHttpResponse response = null;
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
