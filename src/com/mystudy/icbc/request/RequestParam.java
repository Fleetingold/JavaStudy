package com.mystudy.icbc.request;

public class RequestParam {
	@RequestXMLElement(name = "userID")
	private String userID;
	@RequestXMLElement(name = "PackageID")
	private String packageID;
	@RequestXMLElement(name = "SendTime")
	private String sendTime;
	@RequestXMLElement(name = "Version")
	private String version;
	@RequestXMLElement(name = "TransCode")
	private String transCode;
	@RequestXMLElement(name = "BankCode")
	private String bankCode;
	@RequestXMLElement(name = "ID")
	private String ID;
	@RequestXMLElement(name = "GroupCIS")
	private String groupCIS;
	@RequestXMLElement(name = "reqData")
	private String reqData;
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getPackageID() {
		return packageID;
	}
	public void setPackageID(String packageID) {
		this.packageID = packageID;
	}
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getTransCode() {
		return transCode;
	}
	public void setTransCode(String transCode) {
		this.transCode = transCode;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getGroupCIS() {
		return groupCIS;
	}
	public void setGroupCIS(String groupCIS) {
		this.groupCIS = groupCIS;
	}
	public String getReqData() {
		return reqData;
	}
	public void setReqData(String reqData) {
		this.reqData = reqData;
	}
}
