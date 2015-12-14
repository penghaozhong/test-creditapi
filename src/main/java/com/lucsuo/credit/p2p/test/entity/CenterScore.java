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
	private String customerName;
	private String sex;
	private String degree;
	private String maritalState;
	private int age;
	private String workTime;
	private String house;
	private String area;
	private String cityCategory;
	private String orgType;
	private String submitTime;
	private int s3mquery;
	private int s1yquery;
	private int s2yquery;
	private String FirstLoanOpenMonth;
	private String RecentLoanOpenDate;
	private int HistoryLoanCount;
	private int UnpaidLoanCount;
	private double UnpaidLoanCreditLimit;
	private double UnpaidLoanBlance;
	private String FirstCreditCardOpenTime;
	private String RecentCreditCardOpenTime;
	private int QueryTimesIn6MonthForCreditCard;
	private int QueryTimesIn1YearForCreditCard;
	private int QueryTimesIn2YearForCreditCard;
	private int CreditCardCountOpenIn6Month;
	private int CreditCardCountOpenIn1Year;
	private int CreditCardCountOpenIn2Year;
	private double CreditCardTotalLimit;
	private double CreditCardUsedLimit;
	private double MaxCreditLimit;
	private int CreditCardRecordCount;
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
