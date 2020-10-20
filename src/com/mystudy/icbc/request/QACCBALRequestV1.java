package com.mystudy.icbc.request;

public class QACCBALRequestV1 extends RequestV1 {
	private QACCBALRequestBizV1 bizContent;
	
	public QACCBALRequestBizV1 getBizContent() {
		return bizContent;
	}
	public void setBizContent(QACCBALRequestBizV1 bizContent) {
		this.bizContent = bizContent;
	}
	
	public static class QACCBALRequestRdV1 {
		@RequestXMLElement(name = "iSeqno")
		private String iSeqno;
		@RequestXMLElement(name = "AccNo")
		private String accNo;
		@RequestXMLElement(name = "CurrType")
		private String currType;
		@RequestXMLElement(name = "ReqReserved3")
		private String reqReserved3;
		@RequestXMLElement(name = "ReqReserved4")
		private String reqReserved4;
		@RequestXMLElement(name = "AcctSeq")
		private String acctSeq;
		
		public QACCBALRequestRdV1() {}
		
		public String getiSeqno() {
			return iSeqno;
		}
		public void setiSeqno(String iSeqno) {
			this.iSeqno = iSeqno;
		}
		public String getAccNo() {
			return accNo;
		}
		public void setAccNo(String accNo) {
			this.accNo = accNo;
		}
		public String getCurrType() {
			return currType;
		}
		public void setCurrType(String currType) {
			this.currType = currType;
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
}
