package com.mystudy.icbc.request;

public class QHISDRequestV1 extends RequestV1 {
	private QHISDRequestBizV1 bizContent;
	
	public QHISDRequestBizV1 getBizContent() {
		return bizContent;
	}
	public void setBizContent(QHISDRequestBizV1 bizContent) {
		this.bizContent = bizContent;
	}
	
	public class QHISDRequestRdV1 {
		@RequestXMLElement(name = "AccNo")
		private String accNo;
		@RequestXMLElement(name = "BeginDate")
		private String beginDate;
		@RequestXMLElement(name = "EndDate")
		private String endDate;
		@RequestXMLElement(name = "MinAmt")
		private String minAmt;
		@RequestXMLElement(name = "MaxAmt")
		private String maxAmt;
		@RequestXMLElement(name = "BankType")
		private String bankType;
		@RequestXMLElement(name = "NextTag")
		private String nextTag;
		@RequestXMLElement(name = "CurrType")
		private String currType;
		@RequestXMLElement(name = "DueBillNo")
		private String dueBillNo;
		@RequestXMLElement(name = "AcctSeq")
		private String acctSeq;
		@RequestXMLElement(name = "ComplementFlag")
		private String complementFlag;
		
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
		public String getDueBillNo() {
			return dueBillNo;
		}
		public void setDueBillNo(String dueBillNo) {
			this.dueBillNo = dueBillNo;
		}
		public String getAcctSeq() {
			return acctSeq;
		}
		public void setAcctSeq(String acctSeq) {
			this.acctSeq = acctSeq;
		}
		public String getComplementFlag() {
			return complementFlag;
		}
		public void setComplementFlag(String complementFlag) {
			this.complementFlag = complementFlag;
		}
	}
}
