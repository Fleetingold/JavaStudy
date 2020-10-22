package com.mystudy.icbc.request;

public class BATEBILLRequestV1 extends RequestV1 {
	private BATEBILLRequestBizV1 bizContent;
	
	public BATEBILLRequestBizV1 getBizContent() {
		return bizContent;
	}
	public void setBizContent(BATEBILLRequestBizV1 bizContent) {
		this.bizContent = bizContent;
	}
	
	public static class BATEBILLRequestRdV1 {
		@RequestXMLElement(name = "iSeqno")
		private String iSeqno;
		@RequestXMLElement(name = "AreaCode")
		private String areaCode;
		@RequestXMLElement(name = "NetCode")
		private String netCode;
		@RequestXMLElement(name = "TranDate")
		private String tranDate;
		@RequestXMLElement(name = "AccNo")
		private String accNo;
		@RequestXMLElement(name = "TranSerial")
		private String tranSerial;
		@RequestXMLElement(name = "AcctSeq")
		private String acctSeq;
		@RequestXMLElement(name = "CurrType")
		private String currType;
		
		public BATEBILLRequestRdV1() {}

		public String getiSeqno() {
			return iSeqno;
		}

		public void setiSeqno(String iSeqno) {
			this.iSeqno = iSeqno;
		}

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

		public String getTranDate() {
			return tranDate;
		}

		public void setTranDate(String tranDate) {
			this.tranDate = tranDate;
		}

		public String getAccNo() {
			return accNo;
		}

		public void setAccNo(String accNo) {
			this.accNo = accNo;
		}

		public String getTranSerial() {
			return tranSerial;
		}

		public void setTranSerial(String tranSerial) {
			this.tranSerial = tranSerial;
		}

		public String getAcctSeq() {
			return acctSeq;
		}

		public void setAcctSeq(String acctSeq) {
			this.acctSeq = acctSeq;
		}

		public String getCurrType() {
			return currType;
		}

		public void setCurrType(String currType) {
			this.currType = currType;
		}
	}
}
