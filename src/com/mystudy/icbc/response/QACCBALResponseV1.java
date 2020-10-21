package com.mystudy.icbc.response;

public class QACCBALResponseV1 extends ResponseV1 {
	
	private QACCBALResponseV1.QACCBALResponseV1Rd rd;
	
	public QACCBALResponseV1.QACCBALResponseV1Rd getRd() {
		return rd;
	}
	public void setRd(QACCBALResponseV1.QACCBALResponseV1Rd rd) {
		this.rd = rd;
	}
	
	public static class QACCBALResponseV1Rd {
		private String iSeqno;
		private String accNo;
		private String currType;
		private String cashExf;
		private String acctProperty;
		private String accBalance;
		private String balance;
		private String usableBalance;
		private String frzAmt;
		private String queryTime;
		private String iRetCode;
		private String iRetMsg;
		private String repReserved3;
		private String repReserved4;
		
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
		public String getCashExf() {
			return cashExf;
		}
		public void setCashExf(String cashExf) {
			this.cashExf = cashExf;
		}
		public String getAcctProperty() {
			return acctProperty;
		}
		public void setAcctProperty(String acctProperty) {
			this.acctProperty = acctProperty;
		}
		public String getAccBalance() {
			return accBalance;
		}
		public void setAccBalance(String accBalance) {
			this.accBalance = accBalance;
		}
		public String getBalance() {
			return balance;
		}
		public void setBalance(String balance) {
			this.balance = balance;
		}
		public String getUsableBalance() {
			return usableBalance;
		}
		public void setUsableBalance(String usableBalance) {
			this.usableBalance = usableBalance;
		}
		public String getFrzAmt() {
			return frzAmt;
		}
		public void setFrzAmt(String frzAmt) {
			this.frzAmt = frzAmt;
		}
		public String getQueryTime() {
			return queryTime;
		}
		public void setQueryTime(String queryTime) {
			this.queryTime = queryTime;
		}
		public String getiRetCode() {
			return iRetCode;
		}
		public void setiRetCode(String iRetCode) {
			this.iRetCode = iRetCode;
		}
		public String getiRetMsg() {
			return iRetMsg;
		}
		public void setiRetMsg(String iRetMsg) {
			this.iRetMsg = iRetMsg;
		}
		public String getRepReserved3() {
			return repReserved3;
		}
		public void setRepReserved3(String repReserved3) {
			this.repReserved3 = repReserved3;
		}
		public String getRepReserved4() {
			return repReserved4;
		}
		public void setRepReserved4(String repReserved4) {
			this.repReserved4 = repReserved4;
		}
	}
	@Override
	boolean isSuccess() {
		// TODO Auto-generated method stub
		return false;
	}

}
