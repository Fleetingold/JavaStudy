package com.mystudy.icbc.response;

import java.util.ArrayList;

public class BATEBILLResponseV1 extends ResponseV1 {
	/**
	 * 	ƽ̨������ˮ��
	 */
	private String serialNo;
	/**
	 * 	�ܱ���
	 */
	private String totalNum;
	
	private ArrayList<BATEBILLResponseV1Rd> rds = new ArrayList<BATEBILLResponseV1Rd>();
	
	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(String totalNum) {
		this.totalNum = totalNum;
	}

	public ArrayList<BATEBILLResponseV1Rd> getRds() {
		return rds;
	}

	public void setRds(ArrayList<BATEBILLResponseV1Rd> rds) {
		this.rds = rds;
	}
	
	public void addRd(BATEBILLResponseV1Rd rd) {
		rds.add(rd);
	}

	@Override
	boolean isSuccess() {
		// TODO Auto-generated method stub
		return false;
	}

	public static class BATEBILLResponseV1Rd {
		/**
		 * 	ָ���˳���
		 */
		private String iSeqno;
		/**
		 * 	ƽ̨�������
		 */
		private String orderNo;
		/**
		 * 	���ӻص�����
		 */
		private String ebillSerialno;
		/**
		 * 	�����˺�
		 */
		private String payAccount;
		/**
		 * 	�����˻�����
		 */
		private String payAcctName;
		/**
		 * 	����������������
		 */
		private String payBankName;
		/**
		 * 	�շ��˺�
		 */
		private String recAccount;
		/**
		 * 	�շ��˻�����
		 */
		private String recAcctName;
		/**
		 * 	�շ�����������
		 */
		private String recBankName;
		/**
		 * 	���
		 */
		private String payAmt;
		/**
		 * 	����
		 */
		private String currType;
		/**
		 * 	ժҪ
		 */
		private String summary;
		/**
		 * 	ҵ������
		 */
		private String busType;
		/**
		 * 	��;
		 */
		private String useCN;
		/**
		 * 	������ˮ��
		 */
		private String tranSerialNo;
		/**
		 * 	ʱ���
		 */
		private String timeStamp;
		/**
		 * 	��ע
		 */
		private String remark;
		/**
		 * 	��֤��
		 */
		private String ebillKey;
		/**
		 * 	��������
		 */
		private String transNetCode;
		/**
		 * 	���˹�Ա
		 */
		private String transTellno;
		/**
		 * 	��������
		 */
		private String transDate;
		/**
		 * 	�������
		 */
		private String rePrintNum;
		/**
		 * 	����
		 */
		private String postScript;
		/**
		 * 	ƾ֤��
		 */
		private String vouchNo;
		/**
		 * 	ƾ֤����
		 */
		private String vouchType;
		/**
		 * 	������
		 */
		private String result;
		/**
		 * 	��ϸ���׷�����
		 */
		private String iRetCode;
		/**
		 * 	��ϸ���׷�������
		 */
		private String iRetMsg;
		/**
		 * 	�������˺�
		 */
		private String agentPayAcctNo;
		/**
		 * 	�����˻���
		 */
		private String agentPayName;
		/**
		 * 	������־
		 */
		private String updTranf;
		/**
		 * 	��Ϣ��
		 */
		private String valueDate;
		/**
		 * 	�˺����
		 */
		private String acctSeq;
		/**
		 * 	���˻�����
		 */
		private String acctSeqName;
		/**
		 * 	ҵ�񣨲�Ʒ������
		 */
		private String prodType;
		/**
		 * 	�ص����Ի�Ҫ��
		 */
		private String cusInfo;
		/**
		 * 	���н�����ˮ��
		 */
		private String bankSerialNo;
		
		public String getiSeqno() {
			return iSeqno;
		}
		public void setiSeqno(String iSeqno) {
			this.iSeqno = iSeqno;
		}
		public String getOrderNo() {
			return orderNo;
		}
		public void setOrderNo(String orderNo) {
			this.orderNo = orderNo;
		}
		public String getEbillSerialno() {
			return ebillSerialno;
		}
		public void setEbillSerialno(String ebillSerialno) {
			this.ebillSerialno = ebillSerialno;
		}
		public String getPayAccount() {
			return payAccount;
		}
		public void setPayAccount(String payAccount) {
			this.payAccount = payAccount;
		}
		public String getPayAcctName() {
			return payAcctName;
		}
		public void setPayAcctName(String payAcctName) {
			this.payAcctName = payAcctName;
		}
		public String getPayBankName() {
			return payBankName;
		}
		public void setPayBankName(String payBankName) {
			this.payBankName = payBankName;
		}
		public String getRecAccount() {
			return recAccount;
		}
		public void setRecAccount(String recAccount) {
			this.recAccount = recAccount;
		}
		public String getRecAcctName() {
			return recAcctName;
		}
		public void setRecAcctName(String recAcctName) {
			this.recAcctName = recAcctName;
		}
		public String getRecBankName() {
			return recBankName;
		}
		public void setRecBankName(String recBankName) {
			this.recBankName = recBankName;
		}
		public String getPayAmt() {
			return payAmt;
		}
		public void setPayAmt(String payAmt) {
			this.payAmt = payAmt;
		}
		public String getCurrType() {
			return currType;
		}
		public void setCurrType(String currType) {
			this.currType = currType;
		}
		public String getSummary() {
			return summary;
		}
		public void setSummary(String summary) {
			this.summary = summary;
		}
		public String getBusType() {
			return busType;
		}
		public void setBusType(String busType) {
			this.busType = busType;
		}
		public String getUseCN() {
			return useCN;
		}
		public void setUseCN(String useCN) {
			this.useCN = useCN;
		}
		public String getTranSerialNo() {
			return tranSerialNo;
		}
		public void setTranSerialNo(String tranSerialNo) {
			this.tranSerialNo = tranSerialNo;
		}
		public String getTimeStamp() {
			return timeStamp;
		}
		public void setTimeStamp(String timeStamp) {
			this.timeStamp = timeStamp;
		}
		public String getRemark() {
			return remark;
		}
		public void setRemark(String remark) {
			this.remark = remark;
		}
		public String getEbillKey() {
			return ebillKey;
		}
		public void setEbillKey(String ebillKey) {
			this.ebillKey = ebillKey;
		}
		public String getTransNetCode() {
			return transNetCode;
		}
		public void setTransNetCode(String transNetCode) {
			this.transNetCode = transNetCode;
		}
		public String getTransTellno() {
			return transTellno;
		}
		public void setTransTellno(String transTellno) {
			this.transTellno = transTellno;
		}
		public String getTransDate() {
			return transDate;
		}
		public void setTransDate(String transDate) {
			this.transDate = transDate;
		}
		public String getRePrintNum() {
			return rePrintNum;
		}
		public void setRePrintNum(String rePrintNum) {
			this.rePrintNum = rePrintNum;
		}
		public String getPostScript() {
			return postScript;
		}
		public void setPostScript(String postScript) {
			this.postScript = postScript;
		}
		public String getVouchNo() {
			return vouchNo;
		}
		public void setVouchNo(String vouchNo) {
			this.vouchNo = vouchNo;
		}
		public String getVouchType() {
			return vouchType;
		}
		public void setVouchType(String vouchType) {
			this.vouchType = vouchType;
		}
		public String getResult() {
			if(result.equals("0")) {
				result += "-�ύ�ɹ�,�ȴ����д���";
			} else if(result.equals("6")) {
				result += "-�����оܾ�";
			} else if(result.equals("7")) {
				result += "-����ɹ�";
			}
			return result;
		}
		public void setResult(String result) {
			this.result = result;
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
		public String getAgentPayAcctNo() {
			return agentPayAcctNo;
		}
		public void setAgentPayAcctNo(String agentPayAcctNo) {
			this.agentPayAcctNo = agentPayAcctNo;
		}
		public String getAgentPayName() {
			return agentPayName;
		}
		public void setAgentPayName(String agentPayName) {
			this.agentPayName = agentPayName;
		}
		public String getUpdTranf() {
			switch(updTranf) {
				case "0" :
					updTranf += "-����";
					break;
				case "1" :
					updTranf += "-�����ֳ��";
					break;
				case "2" :
					updTranf += "-�����ֳ��";
					break;
				case "3" :
					updTranf += "-˫�����ֳ���(���ֵ���)";
					break;
				case "4" :
					updTranf += "-˫�����ֲ���(���ֵ���)";
					break;
				default :
					break;
			}
			
			return updTranf;
		}
		public void setUpdTranf(String updTranf) {
			this.updTranf = updTranf;
		}
		public String getValueDate() {
			return valueDate;
		}
		public void setValueDate(String valueDate) {
			this.valueDate = valueDate;
		}
		public String getAcctSeq() {
			return acctSeq;
		}
		public void setAcctSeq(String acctSeq) {
			this.acctSeq = acctSeq;
		}
		public String getAcctSeqName() {
			return acctSeqName;
		}
		public void setAcctSeqName(String acctSeqName) {
			this.acctSeqName = acctSeqName;
		}
		public String getProdType() {
			return TurnProdType(Integer.parseInt(prodType));
		}
		public void setProdType(String prodType) {
			this.prodType = prodType;
		}
		public String getCusInfo() {
			return cusInfo;
		}
		public void setCusInfo(String cusInfo) {
			this.cusInfo = cusInfo;
		}
		public String getBankSerialNo() {
			return bankSerialNo;
		}
		public void setBankSerialNo(String bankSerialNo) {
			this.bankSerialNo = bankSerialNo;
		}
		
		public String TurnProdType(int iProdType) {
			switch(iProdType) {
				case 0 :
					return iProdType + "-ת��";
				case 1 :
					return iProdType + "-�ֽ�";
				case 2 :
					return iProdType + "-�ֽ����";
				case 3 :
					return iProdType + "-ͬ��ת��";
				case 4 :
					return iProdType + "-�㻮�ձ�";
				case 5 :
					return iProdType + "-�����ձ�";
				case 6 :
					return iProdType + "-��Ϣ����";
				case 7 :
					return iProdType + "-��ʱͨ";
				case 8 :
					return iProdType + "-�Թ��շ�";
				case 9 :
					return iProdType + "-�������";
				case 10 :
					return iProdType + "-����";
				case 11 :
					return iProdType + "-ծȯ";
				case 12 :
					return iProdType + "-�����";
				case 13 :
					return iProdType + "-���з���";
				case 14 :
					return iProdType + "-�㻮����";
				case 15 :
					return iProdType + "-������";
				case 16 :
					return iProdType + "-�ṹ�Դ��";
				case 17 :
					return iProdType + "-��������";
				case 18 :
					return iProdType + "-��λ���ڣ�֪ͨ�����";
				case 19 :
					return iProdType + "-�Թ�����";
				case 20 :
					return iProdType + "-����ҵ��";
				case 21 :
					return iProdType + "-��֤ҵ��";
				case 22 :
					return iProdType + "-����ҵ��";
				case 23 :
					return iProdType + "-����ҵ��";
				case 24 :
					return iProdType + "-����ҵ��";
				case 25 :
					return iProdType + "-��˰ҵ��";
				case 26 :
					return iProdType + "-��������";
				case 27 :
					return iProdType + "-����ҵ��";
				case 28 :
					return iProdType + "-ȫ���ֽ����ҵ��";
				case 29 :
					return iProdType + "-ͨ��ͨ��-���˻��";
				case 30 :
					return iProdType + "-��������";
				case 31 :
					return iProdType + "-�����";
				case 32 :
					return iProdType + "-����黹";
				case 33 :
					return iProdType + "-����������";
				case 34 :
					return iProdType + "-���Ŵ��ʲ�";
				case 35 :
					return iProdType + "-��ծ�ʲ�";
				case 36 :
					return iProdType + "-���";
				case 37 :
					return iProdType + "-������շ�";
				case 38 :
					return iProdType + "-���Ϣ";
				case 39 :
					return iProdType + "-ί�д����շ�";
				case 40 :
					return iProdType + "-�������������";
				case 41 :
					return iProdType + "-���ҵ��";
				case 42 :
					return iProdType + "-��Լ�̻�POS";
				case 43 :
					return iProdType + "-��֤��ҵ��";
				case 44 :
					return iProdType + "-BSP��SLB";
				case 45 :
					return iProdType + "-��֤����";
				case 46 :
					return iProdType + "-�ۺ��ո���";
				case 47 :
					return iProdType + "-�ʽ��";
				case 48 :
					return iProdType + "-���Ͻ����";
				case 49 :
					return iProdType + "-���ת��";
				case 50 :
					return iProdType + "-ί���տ�";
				case 51 :
					return iProdType + "-���ճи�";
				default :
					break;
			}
			return Integer.toString(iProdType);
		}
	}
}
