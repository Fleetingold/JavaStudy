package com.mystudy.icbc.request;

import java.util.ArrayList;

public class BATEBILLRequestBizV1 extends RequestBizV1 {
	@RequestXMLElement(name = "TotalNum", parent = "in")
	private String totalNum;
	@RequestXMLElement(name = "SignTime", parent = "in")
	private String signTime;
	
	@RequestXMLElement(name = "rd", parent = "in")
	private ArrayList<BATEBILLRequestV1.BATEBILLRequestRdV1> rd;
	
	public String getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(String totalNum) {
		this.totalNum = totalNum;
	}
	
	public String getSignTime() {
		return signTime;
	}
	public void setSignTime(String signTime) {
		this.signTime = signTime;
	}
	public ArrayList<BATEBILLRequestV1.BATEBILLRequestRdV1> getRd() {
		return rd;
	}
	public void setRd(ArrayList<BATEBILLRequestV1.BATEBILLRequestRdV1> rd) {
		this.rd = rd;
	}
}
