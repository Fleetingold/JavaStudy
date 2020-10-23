package com.mystudy.icbc.request;

public class DownEBillRequestBizV1 extends RequestBizV1 {
	@RequestXMLElement(name = "AreaCode", parent = "in")
	private String areaCode;
	@RequestXMLElement(name = "NetCode", parent = "in")
	private String netCode;
	@RequestXMLElement(name = "TellerNo", parent = "in")
	private String tellerNo;
	@RequestXMLElement(name = "WorkDate", parent = "in")
	private String workDate;
	@RequestXMLElement(name = "TranSerialNo", parent = "in")
	private String tranSerialNo;
	@RequestXMLElement(name = "AcctNo", parent = "in")
	private String acctNo;
	@RequestXMLElement(name = "CurrencyType", parent = "in")
	private String currencyType;
	@RequestXMLElement(name = "SignTime", parent = "in")
	private String signTime;
	@RequestXMLElement(name = "ReqReserved1", parent = "in")
	private String reqReserved1;
	@RequestXMLElement(name = "ReqReserved2", parent = "in")
	private String reqReserved2;
	@RequestXMLElement(name = "ReqReserved3", parent = "in")
	private String reqReserved3;
	@RequestXMLElement(name = "ReqReserved4", parent = "in")
	private String reqReserved4;
	@RequestXMLElement(name = "AcctSeq", parent = "in")
	private String acctSeq;
	
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getNetCode() {
		return netCode;
	}
	public void setNetCode(String netCode) {
		this.netCode = netCode;
	}
	public String getTellerNo() {
		return tellerNo;
	}
	public void setTellerNo(String tellerNo) {
		this.tellerNo = tellerNo;
	}
	public String getWorkDate() {
		return workDate;
	}
	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}
	public String getTranSerialNo() {
		return tranSerialNo;
	}
	public void setTranSerialNo(String tranSerialNo) {
		this.tranSerialNo = tranSerialNo;
	}
	public String getAcctNo() {
		return acctNo;
	}
	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}
	public String getCurrencyType() {
		return currencyType;
	}
	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}
	public String getSignTime() {
		return signTime;
	}
	public void setSignTime(String signTime) {
		this.signTime = signTime;
	}
	public String getReqReserved1() {
		return reqReserved1;
	}
	public void setReqReserved1(String reqReserved1) {
		this.reqReserved1 = reqReserved1;
	}
	public String getReqReserved2() {
		return reqReserved2;
	}
	public void setReqReserved2(String reqReserved2) {
		this.reqReserved2 = reqReserved2;
	}
	public String getReqReserved3() {
		return reqReserved3;
	}
	public void setReqReserved3(String reqReserved3) {
		this.reqReserved3 = reqReserved3;
	}
	public String getReqReserved4() {
		return reqReserved4;
	}
	public void setReqReserved4(String reqReserved4) {
		this.reqReserved4 = reqReserved4;
	}
	public String getAcctSeq() {
		return acctSeq;
	}
	public void setAcctSeq(String acctSeq) {
		this.acctSeq = acctSeq;
	}
}
