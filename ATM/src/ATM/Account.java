package ATM;

// 한 회원마다 계좌 3개까지 만들 수 있음
public class Account {
	private String clientId;
	private String accNumber;
	private int money;
	
	Account(String clientId, String accNumber, int money) {
		super();
		this.clientId = clientId;
		this.accNumber = accNumber;
		this.money = money;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return clientId +"\t" + accNumber +"\t" + money;
	}
	
	
	
}
