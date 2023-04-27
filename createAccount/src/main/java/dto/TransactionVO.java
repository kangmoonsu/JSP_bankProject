package dto;

import java.util.Date;

public class TransactionVO {
	private String transaction_num;
	private String sender_account;
	private String receiver_account;
	private Integer amount;
	private String send_context;
	private Date transaction_date;

	public String getTransaction_num() {
		return transaction_num;
	}

	public void setTransaction_num(String transaction_num) {
		this.transaction_num = transaction_num;
	}

	public String getSender_account() {
		return sender_account;
	}

	public void setSender_account(String sender_account) {
		this.sender_account = sender_account;
	}

	public String getReceiver_account() {
		return receiver_account;
	}

	public void setReceiver_account(String receiver_account) {
		this.receiver_account = receiver_account;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	
	
	public String getSend_context() {
		return send_context;
	}

	public void setSend_context(String send_context) {
		this.send_context = send_context;
	}

	public Date getTransaction_date() {
		return transaction_date;
	}

	public void setTransaction_date(Date transaction_date) {
		this.transaction_date = transaction_date;
	}

}
