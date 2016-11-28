package com.lucsuo.credit.p2p.test.entity;

/**
 *杭州市民卡vo
 */
public class HZSMKVo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 评分
	private double score;
	// 客户姓名
	private String customerName;
	// 客户证件号码
	private String customerIdNumber;
	//备注
	private String remark;
	// 查询结果代码 
	private int resCode;
	//查询结果描述 
	private String resMsg;
	//查询处理完成时间 
	private String finishTime;

	
	
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerIdNumber() {
		return customerIdNumber;
	}
	public void setCustomerIdNumber(String customerIdNumber) {
		this.customerIdNumber = customerIdNumber;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getResCode() {
		return resCode;
	}
	public void setResCode(int resCode) {
		this.resCode = resCode;
	}
	public String getResMsg() {
		return resMsg;
	}
	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}
	public String getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}
	
	

}
