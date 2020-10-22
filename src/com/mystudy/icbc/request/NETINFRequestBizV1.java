package com.mystudy.icbc.request;

public class NETINFRequestBizV1 extends RequestBizV1 {
	/**
	 * 	��ѯ��ҳ��ʶ
	 */
	@RequestXMLElement(name = "NextTag", parent = "in")
	private String nextTag;
	
	/**
	 * 	�������ֶ�1
	 */
	@RequestXMLElement(name = "ReqReserved1", parent = "in")
	private String reqReserved1;
	
	/**
	 * 	�������ֶ�2
	 */
	@RequestXMLElement(name = "ReqReserved2", parent = "in")
	private String reqReserved2;

	public String getNextTag() {
		return nextTag;
	}

	public void setNextTag(String nextTag) {
		this.nextTag = nextTag;
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
}
