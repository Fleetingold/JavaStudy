package com.mystudy.icbc.request;

public class QPDRequestV1 extends RequestV1 {
	private QPDRequestBizV1 bizContent;
	
	public QPDRequestBizV1 getBizContent() {
		return bizContent;
	}
	public void setBizContent(QPDRequestBizV1 bizContent) {
		this.bizContent = bizContent;
	}
	
	public static class QPDRequestRdV1 {
		@RequestXMLElement(name = "AccNo")
		private String accNo;
		@RequestXMLElement(name = "AreaCode")
		private String areaCode;
		@RequestXMLElement(name = "MinAmt")
		private String minAmt;
		@RequestXMLElement(name = "MaxAmt")
		private String maxAmt;
		@RequestXMLElement(name = "BeginTime", parent = "in")
		private String beginTime;
		@RequestXMLElement(name = "EndTime", parent = "in")
		private String endTime;
		@RequestXMLElement(name = "NextTag")
		private String nextTag;
		/**
		 * 	请求备用字段1
		 */
		@RequestXMLElement(name = "ReqReserved1")
		private String reqReserved1;
		
		/**
		 * 	请求备用字段2
		 */
		@RequestXMLElement(name = "ReqReserved2")
		private String reqReserved2;
		@RequestXMLElement(name = "CurrType")
		private String currType;
		@RequestXMLElement(name = "AcctSeq")
		private String acctSeq;
		
		public String getAccNo() {
			return accNo;
		}
		public void setAccNo(String accNo) {
			this.accNo = accNo;
		}
		public String getAreaCode() {
			return areaCode;
		}
		public void setAreaCode(String areaCode) {
			this.areaCode = areaCode;
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
		public String getCurrType() {
			return currType;
		}
		public void setCurrType(String currType) {
			this.currType = currType;
		}
		public String getAcctSeq() {
			return acctSeq;
		}
		public void setAcctSeq(String acctSeq) {
			this.acctSeq = acctSeq;
		}
	}
}
