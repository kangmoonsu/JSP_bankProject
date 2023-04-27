package dto;

public class AccountVO {
	private String account_num;
	private Integer balance;
	private Integer customer_num;

	public String getAccount_num() {
		return account_num;
	}

	public void setAccount_num(String account_num) {
		this.account_num = account_num;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public Integer getCustomer_num() {
		return customer_num;
	}

	public void setCustomer_num(Integer customer_num) {
		this.customer_num = customer_num;
	}

}
