package com.lucsuo.credit.p2p.test.entity;

/**
 * 通讯评分请求参数vo
 * @author penghaozhong
 * @date 2017年3月31日 上午10:55:17
 */
public class TxpfRequestVo {
	
	/** 姓名 */
	private String name;
	/** 机主手机号 */
	private String telephone;
	/** 身份证号码 */
	private String idNumber;
	/** 查询时间 */
	private String queryTime;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getQueryTime() {
		return queryTime;
	}
	public void setQueryTime(String queryTime) {
		this.queryTime = queryTime;
	}

}
