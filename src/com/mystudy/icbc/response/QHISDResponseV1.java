package com.mystudy.icbc.response;

import java.util.ArrayList;

public class QHISDResponseV1 extends ResponseV1 {

	/**
	 * 	�˺�
	 */
	private String accNo;
	/**
	 * 	����
	 */
	private String accName;
	/**
	 * 	����
	 */
	private String currType;
	/**
	 * 	��ʼ����
	 */
	private String beginDate;
	/**
	 * 	��ֹ����
	 */
	private String endDate;
	/**
	 * 	����������
	 */
	private String minAmt;
	/**
	 * 	����������
	 */
	private String maxAmt;
	/**
	 * 	�б�
	 */
	private String bankType;
	/**
	 * 	��ѯ��ҳ
	 */
	private String nextTag;
	/**
	 * 	��������
	 */
	private String totalNum;
	/**
	 * 	��ݱ��
	 */
	private String dueBillNo;
	/**
	 * 	�˺����
	 */
	private String acctSeq;
	
	private ArrayList<QHISDResponseV1Rd> rds = new ArrayList<QHISDResponseV1.QHISDResponseV1Rd>();
	
	public String getAccNo() {
		return accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	
	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public String getCurrType() {
		return currType;
	}

	public void setCurrType(String currType) {
		this.currType = currType;
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

	public String getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(String totalNum) {
		this.totalNum = totalNum;
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

	public ArrayList<QHISDResponseV1Rd> getRds() {
		return rds;
	}

	public void setRds(ArrayList<QHISDResponseV1Rd> rds) {
		this.rds = rds;
	}

	public void addRd(QHISDResponseV1Rd rd) {
		rds.add(rd);
	}
	
	@Override
	boolean isSuccess() {
		// TODO Auto-generated method stub
		return false;
	}

	public static class QHISDResponseV1Rd {
		/**
		 * 	�����־
		 */
		private String drcrf;
		/**
		 * 	ƾ֤��
		 */
		private String vouhNo;
		/**
		 * 	�跽������
		 */
		private String debitAmount;
		/**
		 * 	����������
		 */
		private String creditAmount;
		/**
		 * 	���
		 */
		private String balance;
		/**
		 * 	�Է��к�
		 */
		private String recipBkNo;
		/**
		 * 	�Է�����
		 */
		private String recipBkName;
		/**
		 * 	�Է��˺�
		 */
		private String recipAccNo;
		/**
		 * 	�Է�����
		 */
		private String recipName;
		/**
		 * 	ժҪ
		 */
		private String summary;
		/**
		 * 	��;
		 */
		private String useCN;
		/**
		 * 	����
		 */
		private String postScript;
		/**
		 * 	ҵ�����
		 */
		private String busCode;
		/**
		 * 	��������
		 */
		private String date;
		/**
		 *	ʱ���
		 */
		private String time;
		/**
		 * 	ҵ����
		 */
		private String ref;
		/**
		 * 	���ҵ����
		 */
		private String oref;
		/**
		 * 	Ӣ�ı�ע
		 */
		private String enSummary;
		/**
		 * 	ҵ������
		 */
		private String busType;
		/**
		 * 	ƾ֤����
		 */
		private String vouhType;
		/**
		 * 	������Ϣ
		 */
		private String addInfo;
		/**
		 * 	���ӻص�Ψһ��ʶ
		 */
		private String toutfo;
		/**
		 * 	���н�����ˮ��
		 */
		private String onlySequence;
		/**
		 * 	����˾�����˻�����
		 */
		private String agentAcctName;
		/**
		 * 	����˾�����˻��˺�
		 */
		private String agentAcctNo;
		/**
		 * 	������־
		 */
		private String upDtranf;
		/**
		 * 	��Ϣ��
		 */
		private String valueDate;
		/**
		 * 	���н��״���
		 */
		private String trxCode;
		/**
		 * 	ҵ����1
		 */
		private String ref1;
		/**
		 * 	���ҵ����1
		 */
		private String oref1;
		/**
		 * 	��������
		 */
		private String CASHF;
		/**
		 * 	��������
		 */
		private String busiDate;
		/**
		 * 	����ʱ��
		 */
		private String busiTime;
		/**
		 * 	����ʱ��
		 */
		private String tradeTime;
		/**
		 * 	���׳���
		 */
		private String tradeLocation;
		/**
		 * 	�˺����
		 */
		private String subAcctSeq;
		/**
		 * 	����
		 */
		private String THCurrency;
		/**
		 * 	�Է��������Դ�Ϊ׼��
		 */
		private String recipBkName1;
		/**
		 * 	�Է��кţ��Դ�Ϊ׼��
		 */
		private String recipBkNo1;
		/**
		 * 	�������toutfo[���ӻص�Ψһ��ʶ]һ��
		 */
		private String TInfoNew;
		/**
		 * 
		 */
		private String refundMsg;
		/**
		 * 
		 */
		private String busTypNo;
		/**
		 * 	���recip*[�Է�*],�Է���Ϣ
		 */
		private String receiptInfo;
		/**
		 * 
		 */
		private String telNo;
		/**
		 * 
		 */
		private String mdCardNo;
		/**
		 * 	���trxCode[���н��״���],���н��׽��
		 */
		private String trxAmt;
		/**
		 * 	���trxCode[���н��״���],���н��ױ���
		 */
		private String trxCurr;
		/**
		 * 	����
		 */
		private String currType;

		public String getDrcrf() {
			return drcrf;
		}

		public void setDrcrf(String drcrf) {
			this.drcrf = drcrf;
		}

		public String getVouhNo() {
			return vouhNo;
		}

		public void setVouhNo(String vouhNo) {
			this.vouhNo = vouhNo;
		}

		public String getDebitAmount() {
			return debitAmount;
		}

		public void setDebitAmount(String debitAmount) {
			this.debitAmount = debitAmount;
		}

		public String getCreditAmount() {
			return creditAmount;
		}

		public void setCreditAmount(String creditAmount) {
			this.creditAmount = creditAmount;
		}

		public String getBalance() {
			return balance;
		}

		public void setBalance(String balance) {
			this.balance = balance;
		}

		public String getRecipBkNo() {
			return recipBkNo;
		}

		public void setRecipBkNo(String recipBkNo) {
			this.recipBkNo = recipBkNo;
		}

		public String getRecipBkName() {
			return recipBkName;
		}

		public void setRecipBkName(String recipBkName) {
			this.recipBkName = recipBkName;
		}

		public String getRecipAccNo() {
			return recipAccNo;
		}

		public void setRecipAccNo(String recipAccNo) {
			this.recipAccNo = recipAccNo;
		}

		public String getRecipName() {
			return recipName;
		}

		public void setRecipName(String recipName) {
			this.recipName = recipName;
		}

		public String getSummary() {
			return summary;
		}

		public void setSummary(String summary) {
			this.summary = summary;
		}

		public String getUseCN() {
			return useCN;
		}

		public void setUseCN(String useCN) {
			this.useCN = useCN;
		}

		public String getPostScript() {
			return postScript;
		}

		public void setPostScript(String postScript) {
			this.postScript = postScript;
		}

		public String getBusCode() {
			return busCode;
		}

		public void setBusCode(String busCode) {
			this.busCode = busCode;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getTime() {
			return time;
		}

		public void setTime(String time) {
			this.time = time;
		}

		public String getRef() {
			return ref;
		}

		public void setRef(String ref) {
			this.ref = ref;
		}

		public String getOref() {
			return oref;
		}

		public void setOref(String oref) {
			this.oref = oref;
		}

		public String getEnSummary() {
			return enSummary;
		}

		public void setEnSummary(String enSummary) {
			this.enSummary = enSummary;
		}

		public String getBusType() {
			return busType;
		}

		public void setBusType(String busType) {
			this.busType = busType;
		}

		public String getVouhType() {
			return vouhType;
		}

		public void setVouhType(String vouhType) {
			this.vouhType = vouhType;
		}

		public String getAddInfo() {
			return addInfo;
		}

		public void setAddInfo(String addInfo) {
			this.addInfo = addInfo;
		}

		public String getToutfo() {
			return toutfo;
		}

		public void setToutfo(String toutfo) {
			this.toutfo = toutfo;
		}

		public String getOnlySequence() {
			return onlySequence;
		}

		public void setOnlySequence(String onlySequence) {
			this.onlySequence = onlySequence;
		}

		public String getAgentAcctName() {
			return agentAcctName;
		}

		public void setAgentAcctName(String agentAcctName) {
			this.agentAcctName = agentAcctName;
		}

		public String getAgentAcctNo() {
			return agentAcctNo;
		}

		public void setAgentAcctNo(String agentAcctNo) {
			this.agentAcctNo = agentAcctNo;
		}

		public String getUpDtranf() {
			return upDtranf;
		}

		public void setUpDtranf(String upDtranf) {
			this.upDtranf = upDtranf;
		}

		public String getValueDate() {
			return valueDate;
		}

		public void setValueDate(String valueDate) {
			this.valueDate = valueDate;
		}

		public String getTrxCode() {
			return trxCode;
		}

		public void setTrxCode(String trxCode) {
			this.trxCode = trxCode;
		}

		public String getRef1() {
			return ref1;
		}

		public void setRef1(String ref1) {
			this.ref1 = ref1;
		}

		public String getOref1() {
			return oref1;
		}

		public void setOref1(String oref1) {
			this.oref1 = oref1;
		}

		public String getCASHF() {
			return CASHF;
		}

		public void setCASHF(String cASHF) {
			CASHF = cASHF;
		}

		public String getBusiDate() {
			return busiDate;
		}

		public void setBusiDate(String busiDate) {
			this.busiDate = busiDate;
		}

		public String getBusiTime() {
			return busiTime;
		}

		public void setBusiTime(String busiTime) {
			this.busiTime = busiTime;
		}

		public String getTradeTime() {
			return tradeTime;
		}

		public void setTradeTime(String tradeTime) {
			this.tradeTime = tradeTime;
		}

		public String getTradeLocation() {
			return tradeLocation;
		}

		public void setTradeLocation(String tradeLocation) {
			this.tradeLocation = tradeLocation;
		}

		public String getSubAcctSeq() {
			return subAcctSeq;
		}

		public void setSubAcctSeq(String subAcctSeq) {
			this.subAcctSeq = subAcctSeq;
		}

		public String getTHCurrency() {
			return THCurrency;
		}

		public void setTHCurrency(String tHCurrency) {
			THCurrency = tHCurrency;
		}

		public String getRecipBkName1() {
			return recipBkName1;
		}

		public void setRecipBkName1(String recipBkName1) {
			this.recipBkName1 = recipBkName1;
		}

		public String getRecipBkNo1() {
			return recipBkNo1;
		}

		public void setRecipBkNo1(String recipBkNo1) {
			this.recipBkNo1 = recipBkNo1;
		}

		public String getTInfoNew() {
			return TInfoNew;
		}

		public void setTInfoNew(String tInfoNew) {
			TInfoNew = tInfoNew;
		}

		public String getRefundMsg() {
			return refundMsg;
		}

		public void setRefundMsg(String refundMsg) {
			this.refundMsg = refundMsg;
		}

		public String getBusTypNo() {
			return busTypNo;
		}

		public void setBusTypNo(String busTypNo) {
			this.busTypNo = busTypNo;
		}

		public String getReceiptInfo() {
			return receiptInfo;
		}

		public void setReceiptInfo(String receiptInfo) {
			this.receiptInfo = receiptInfo;
		}

		public String getTelNo() {
			return telNo;
		}

		public void setTelNo(String telNo) {
			this.telNo = telNo;
		}

		public String getMdCardNo() {
			return mdCardNo;
		}

		public void setMdCardNo(String mdCardNo) {
			this.mdCardNo = mdCardNo;
		}

		public String getTrxAmt() {
			return trxAmt;
		}

		public void setTrxAmt(String trxAmt) {
			this.trxAmt = trxAmt;
		}

		public String getTrxCurr() {
			return trxCurr;
		}

		public void setTrxCurr(String trxCurr) {
			this.trxCurr = trxCurr;
		}

		public String getCurrType() {
			return currType;
		}

		public void setCurrType(String currType) {
			this.currType = currType;
		}
	}
}
