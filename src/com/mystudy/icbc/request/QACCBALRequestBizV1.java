package com.mystudy.icbc.request;

import java.util.ArrayList;

public class QACCBALRequestBizV1 extends RequestBizV1 {
	@RequestXMLElement(name = "TotalNum", parent = "in")
	private String totalNum;
//	@RequestXMLElement(name = "BLFlag", parent = "in")
	private String BLFlag;
//	@RequestXMLElement(name = "SynFlag", parent = "in")
	private String synFlag;
	@RequestXMLElement(name = "ReqReserved1", parent = "in")
	private String reqReserved1;
	@RequestXMLElement(name = "ReqReserved2", parent = "in")
	private String reqReserved2;
	@RequestXMLElement(name = "rd", parent = "in")
	private ArrayList<QACCBALRequestV1.QACCBALRequestRdV1> rd;
	
	public String getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(String totalNum) {
		this.totalNum = totalNum;
	}
	
	public String getBLFlag() {
		return BLFlag;
	}
	public void setBLFlag(String bLFlag) {
		BLFlag = bLFlag;
	}
	public String getSynFlag() {
		return synFlag;
	}
	public void setSynFlag(String synFlag) {
		this.synFlag = synFlag;
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
	public ArrayList<QACCBALRequestV1.QACCBALRequestRdV1> getRd() {
		return rd;
	}
	public void setRd(ArrayList<QACCBALRequestV1.QACCBALRequestRdV1> rd) {
		this.rd = rd;
	}
}
