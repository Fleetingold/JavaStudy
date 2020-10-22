package com.mystudy.icbc.request;

public class QBILLRequestBizV1 extends RequestBizV1 {
	@RequestXMLElement(name = "AccNo", parent = "in")
	private String accNo;
	@RequestXMLElement(name = "BeginDate", parent = "in")
	private String beginDate;
	@RequestXMLElement(name = "EndDate", parent = "in")
	private String endDate;
	@RequestXMLElement(name = "BeginTime", parent = "in")
	private String beginTime;
	@RequestXMLElement(name = "EndTime", parent = "in")
	private String endTime;
	@RequestXMLElement(name = "MinAmt", parent = "in")
	private String minAmt;
	@RequestXMLElement(name = "MaxAmt", parent = "in")
	private String maxAmt;
	@RequestXMLElement(name = "BankType", parent = "in")
	private String bankType;
	@RequestXMLElement(name = "NextTag", parent = "in")
	private String nextTag;
	@RequestXMLElement(name = "CurrType", parent = "in")
	private String currType;
	
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getMinAmt() {
		return minAmt;
	}
	public void setMinAmt(String minAmt) {
		this.minAmt = minAmt;
	}
	public String getMaxAmt() {
		return maxAmt;
	}
	public void setMaxAmt(String maxAmt) {
		this.maxAmt = maxAmt;
	}
	public String getBankType() {
		return bankType;
	}
	public void setBankType(String bankType) {
		this.bankType = bankType;
	}
	public String getNextTag() {
		return nextTag;
	}
	public void setNextTag(String nextTag) {
		this.nextTag = nextTag;
	}
	public String getCurrType() {
		return currType;
	}
	public void setCurrType(String currType) {
		this.currType = currType;
	}
}
