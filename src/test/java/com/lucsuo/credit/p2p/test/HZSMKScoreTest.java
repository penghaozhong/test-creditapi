package com.lucsuo.credit.p2p.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lucsuo.credit.p2p.test.entity.HZSMKVo;
import com.lucsuo.credit.p2p.test.res.CommunicationResult;
import com.lucsuo.credit.p2p.test.service.TXService;
import com.lucsuo.credit.p2p.test.service.impl.TxServiceImpl;
import com.lucsuo.credit.p2p.test.util.AESUtil;

/**
 * 杭州市民卡评分测试用例
 * @author wangpeng
 * @version 1.0
 */
public class HZSMKScoreTest {

	// 修改为自己公司的ID
	public static final String ID = "";
	// 修改为自己公司的PrivateKey
	public static final String KEY = "";
	// 日志打印
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	// 通讯信用评分对接请求地址URL
	public static final String URL_GET_QUERY = "http://www.lcsuo.com/company/api/hzsmk";
	
	private TXService txService = new TxServiceImpl();
	
	
	
	/**
	 * 通讯信用评分查询接口
	 * @throws Exception
	 */
	@Test
	public void test_Query() throws Exception {
		
		/*************** 初始化查询数据 *************************/
		
		HZSMKVo hzsmk = new HZSMKVo();
		hzsmk.setCustomerIdNumber("");
		hzsmk.setCustomerName("");
		List<HZSMKVo> list = new ArrayList<HZSMKVo>();
		list.add(hzsmk);
		/************************ 调用 杭州市民卡评分结果接口 *************************/
	 	String resultJson = txService.get_Query(URL_GET_QUERY, dataParams( ID,KEY, JSONObject.toJSONString(list)));
	 	if(resultJson !=null){
			LOG.debug("结果信息:" + resultJson);
	 	}
	}

	
	public List<NameValuePair> dataParams(String id,String key, String data) {
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("id", id));
		// sha1(参数串)
		StringBuilder sh1 = new StringBuilder(data).append("&").append(key);
		nvps.add(new BasicNameValuePair("signature", DigestUtils.sha1Hex(sh1.toString())));
		nvps.add(new BasicNameValuePair("data",	data));
		return nvps;
	}
	

}
