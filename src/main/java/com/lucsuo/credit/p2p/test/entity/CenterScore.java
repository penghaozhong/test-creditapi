package com.lucsuo.credit.p2p.test.entity;

/**
 * 央信po
 * 
 * @author penghaozhong 2015年12月3日
 */
public class CenterScore {

	// 身份证
	private String idNumber;

	private long timeStamp;
	private String privacyNumber;
	// 客户姓名
	private String customerName;
	// 性别
	private String sex;
	// 学历
	private String degree;
	// 婚姻状况
	private String maritalState;
	// 年龄
	private int age;
	// 在现单位工作时间 年月日
	private String workTime;
	// 房产状况 有房有贷款，有房无贷款，无房
	private String house;
	// 所在省份
	private String area;
	// 所在城市
	private String cityCategory;
	// 单位性质 国有企业，机关事业，民营企业，三资企业，其他
	private String orgType;
	// 申请递交时间（信审时间）
	private String submitTime;
	// 近3个月央行征信报告查询次数
	private int s3mquery;
	// 近1年央行征信报告查询次数
	private int s1yquery;
	// 近2年央行征信报告查询次数
	private int s2yquery;
	// 第一笔贷款发放时间
	private String FirstLoanOpenMonth;
	// 最近一笔贷款发放时间
	private String RecentLoanOpenDate;
	// 历史总贷款笔数
	private int HistoryLoanCount;
	// 现有未结清贷款笔数
	private int UnpaidLoanCount;
	// 现有未结清贷款的总合同金额
	private double UnpaidLoanCreditLimit;
	// 现有未结清贷款的总贷款余额
	private double UnpaidLoanBlance;
	// 首张信用卡开卡时间
	private String FirstCreditCardOpenTime;
	// 最近一张信用卡开卡时间
	private String RecentCreditCardOpenTime;
	// 近6个月贷记审批查询次数
	private int QueryTimesIn6MonthForCreditCard;
	// 近1年信用卡审批查询次数
	private int QueryTimesIn1YearForCreditCard;
	// 近2年信用卡审批查询次数
	private int QueryTimesIn2YearForCreditCard;
	// 近6个月信用卡开卡张数
	private int CreditCardCountOpenIn6Month;
	// 近1年信用卡开卡张数
	private int CreditCardCountOpenIn1Year;
	// 近2年信用卡开卡张数
	private int CreditCardCountOpenIn2Year;
	// 信用卡人民币账户的授信总额度
	private double CreditCardTotalLimit;
	// 信用卡人民币账户的已用总额度
	private double CreditCardUsedLimit;
	// 信用卡人民币账户中最高的单家银行授信额度
	private double MaxCreditLimit;
	// 信用卡中所有的记录条数(现有的信用卡张数)
	private int CreditCardRecordCount;
	// 信用卡中人民币卡的记录条数(现有的人民币帐户信用卡张数)
	private int CreditCardCNYCount;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getPrivacyNumber() {
		return privacyNumber;
	}

	public void setPrivacyNumber(String privacyNumber) {
		this.privacyNumber = privacyNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getMaritalState() {
		return maritalState;
	}

	public void setMaritalState(String maritalState) {
		this.maritalState = maritalState;
	}

	

	public String getWorkTime() {
		return workTime;
	}

	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCityCategory() {
		return cityCategory;
	}

	public void setCityCategory(String cityCategory) {
		this.cityCategory = cityCategory;
	}

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	public String getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}

	public int getS3mquery() {
		return s3mquery;
	}

	public void setS3mquery(int s3mquery) {
		this.s3mquery = s3mquery;
	}

	public int getS1yquery() {
		return s1yquery;
	}

	public void setS1yquery(int s1yquery) {
		this.s1yquery = s1yquery;
	}

	public int getS2yquery() {
		return s2yquery;
	}

	public void setS2yquery(int s2yquery) {
		this.s2yquery = s2yquery;
	}

	public String getFirstLoanOpenMonth() {
		return FirstLoanOpenMonth;
	}

	public void setFirstLoanOpenMonth(String firstLoanOpenMonth) {
		FirstLoanOpenMonth = firstLoanOpenMonth;
	}

	public String getRecentLoanOpenDate() {
		return RecentLoanOpenDate;
	}

	public void setRecentLoanOpenDate(String recentLoanOpenDate) {
		RecentLoanOpenDate = recentLoanOpenDate;
	}

	public int getHistoryLoanCount() {
		return HistoryLoanCount;
	}

	public void setHistoryLoanCount(int historyLoanCount) {
		HistoryLoanCount = historyLoanCount;
	}

	public int getUnpaidLoanCount() {
		return UnpaidLoanCount;
	}

	public void setUnpaidLoanCount(int unpaidLoanCount) {
		UnpaidLoanCount = unpaidLoanCount;
	}

	public double getUnpaidLoanCreditLimit() {
		return UnpaidLoanCreditLimit;
	}

	public void setUnpaidLoanCreditLimit(double unpaidLoanCreditLimit) {
		UnpaidLoanCreditLimit = unpaidLoanCreditLimit;
	}

	public double getUnpaidLoanBlance() {
		return UnpaidLoanBlance;
	}

	public void setUnpaidLoanBlance(double unpaidLoanBlance) {
		UnpaidLoanBlance = unpaidLoanBlance;
	}

	public String getFirstCreditCardOpenTime() {
		return FirstCreditCardOpenTime;
	}

	public void setFirstCreditCardOpenTime(String firstCreditCardOpenTime) {
		FirstCreditCardOpenTime = firstCreditCardOpenTime;
	}

	public String getRecentCreditCardOpenTime() {
		return RecentCreditCardOpenTime;
	}

	public void setRecentCreditCardOpenTime(String recentCreditCardOpenTime) {
		RecentCreditCardOpenTime = recentCreditCardOpenTime;
	}

	public int getQueryTimesIn6MonthForCreditCard() {
		return QueryTimesIn6MonthForCreditCard;
	}

	public void setQueryTimesIn6MonthForCreditCard(int queryTimesIn6MonthForCreditCard) {
		QueryTimesIn6MonthForCreditCard = queryTimesIn6MonthForCreditCard;
	}

	public int getQueryTimesIn1YearForCreditCard() {
		return QueryTimesIn1YearForCreditCard;
	}

	public void setQueryTimesIn1YearForCreditCard(int queryTimesIn1YearForCreditCard) {
		QueryTimesIn1YearForCreditCard = queryTimesIn1YearForCreditCard;
	}

	public int getQueryTimesIn2YearForCreditCard() {
		return QueryTimesIn2YearForCreditCard;
	}

	public void setQueryTimesIn2YearForCreditCard(int queryTimesIn2YearForCreditCard) {
		QueryTimesIn2YearForCreditCard = queryTimesIn2YearForCreditCard;
	}

	public int getCreditCardCountOpenIn6Month() {
		return CreditCardCountOpenIn6Month;
	}

	public void setCreditCardCountOpenIn6Month(int creditCardCountOpenIn6Month) {
		CreditCardCountOpenIn6Month = creditCardCountOpenIn6Month;
	}

	public int getCreditCardCountOpenIn1Year() {
		return CreditCardCountOpenIn1Year;
	}

	public void setCreditCardCountOpenIn1Year(int creditCardCountOpenIn1Year) {
		CreditCardCountOpenIn1Year = creditCardCountOpenIn1Year;
	}

	public int getCreditCardCountOpenIn2Year() {
		return CreditCardCountOpenIn2Year;
	}

	public void setCreditCardCountOpenIn2Year(int creditCardCountOpenIn2Year) {
		CreditCardCountOpenIn2Year = creditCardCountOpenIn2Year;
	}

	public double getCreditCardTotalLimit() {
		return CreditCardTotalLimit;
	}

	public void setCreditCardTotalLimit(double creditCardTotalLimit) {
		CreditCardTotalLimit = creditCardTotalLimit;
	}

	public double getCreditCardUsedLimit() {
		return CreditCardUsedLimit;
	}

	public void setCreditCardUsedLimit(double creditCardUsedLimit) {
		CreditCardUsedLimit = creditCardUsedLimit;
	}

	public double getMaxCreditLimit() {
		return MaxCreditLimit;
	}

	public void setMaxCreditLimit(double maxCreditLimit) {
		MaxCreditLimit = maxCreditLimit;
	}

	public int getCreditCardRecordCount() {
		return CreditCardRecordCount;
	}

	public void setCreditCardRecordCount(int creditCardRecordCount) {
		CreditCardRecordCount = creditCardRecordCount;
	}

	public int getCreditCardCNYCount() {
		return CreditCardCNYCount;
	}

	public void setCreditCardCNYCount(int creditCardCNYCount) {
		CreditCardCNYCount = creditCardCNYCount;
	}

}
