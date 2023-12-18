package ATM;

public class Client {
	private int clientNo; //1001부터 자동증가
	private String id;
	private String pw;
	private String name;
	
	Client(int clientNo, String id, String pw, String name) {
		super();
		this.clientNo = clientNo;
		this.id = id;
		this.pw = pw;
		this.name = name;
	}

	public int getClientNo() {
		return clientNo;
	}

	public void setClientNo(int clientNo) {
		this.clientNo = clientNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return clientNo +"  " + id + "  " + pw + "  " + name +"  ";
	}
	
	
	
}
