package ATM;

public class BankController {
	final String NAME = "우리은행";
	Util util;
	AccountDAO aDAO;
	ClientDAO cDAO;
	BankController(){
		aDAO = new AccountDAO();
		cDAO = new ClientDAO();
		util = new Util();
//		mainMenu();
	}
	
	public void run() {
		mainMenu();
	}
	
	private void mainMenu() {
		while(true) {
			System.out.println("==["+NAME+" ATM]==");
			System.out.println("[1] 관리자");
			System.out.println("[2] 사용자");
			System.out.println("[0] 종료");
			int sel = util.getInt("메뉴", 0, 2);
			if(sel == 0) {
				System.err.println("["+NAME+" ATM 종료]");
				return;
			} else if(sel == 1) {
				adminMenu();
			} else if(sel == 2) {
				userMenu();
			}
		} //while
	}
	
	private void adminMenu() {
		while(true) {
			System.out.println("==["+NAME+" 관리자]==");
			System.out.println("[1] 회원목록");
			System.out.println("[2] 회원정보 수정");
			System.out.println("[3] 회원정보 삭제");
			System.out.println("[4] 은행 데이터 저장");
			System.out.println("[5] 은행 데이터 불러오기");
			System.out.println("[6] 전체 계좌 목록");
			System.out.println("[0] 뒤로가기");
			int sel = util.getInt("메뉴", 0, 6);
			if(sel == 0) {
				System.out.println("[ 뒤로 ]");
				return;
			} else if(sel == 1) {
				System.out.println("[회원목록]");
				cDAO.showAllClient();
			} else if(sel == 2) {
				System.out.println("[회원정보 수정]");
				cDAO.modifyClient();
			} else if(sel == 3) {
				System.out.println("[회원정보 삭제]");
				cDAO.deleteClient(aDAO);
			} else if(sel == 4) {
				System.out.println("[은행 데이터 저장]");
				//util.saveToFile(cDAO, aDAO);
			} else if(sel == 5) {
				System.out.println("[은행 데이터 불러오기]");
				//util.loadFromFile(cDAO, aDAO);
			} else if(sel == 6) {
				System.out.println("[전체 계좌 목록]");
				//aDAO.printAllAcc();
			}
		} //while
	}
	
	private void userMenu() {
		while(true) {
			System.out.println("==["+NAME+" 사용자]==");
			System.out.println("[1] 회원가입");
			System.out.println("[2] 로그인");
			System.out.println("[0] 뒤로가기");
			int sel = util.getInt("메뉴", 0, 2);
			if(sel == 0) {
				System.out.println("[뒤로]");
				return;
			} else if(sel == 1) {
				System.out.println("[회원가입]");
				//cDAO.joinClient();
			} else if(sel == 2) {
				System.out.println("[로그인]");
				if(!cDAO.loginClient()) {
					System.out.println("[로그인 실패]");
					return;
				}
				loginUserMenu();
			}
		} //while
	}
	
	private void loginUserMenu() {
		while(true) {
			System.out.println("==["+NAME+" ATM]==");
			//aDAO.printClientAccount(cDAO.log);
			System.out.println("[1] 계좌 추가");
			System.out.println("[2] 계좌 삭제");
			System.out.println("[3] 입금");
			System.out.println("[4] 출금");
			System.out.println("[5] 이체");
			System.out.println("[6] 탈퇴");
			System.out.println("[7] 마이페이지");
			System.out.println("[0] 로그아웃");
			int sel = util.getInt("메뉴", 0, 7);
			if(sel == 0) {
				//cDAO.log = null;
				System.out.println("[로그아웃 성공]");
				return;
			} else if(sel == 1) {
				System.out.println("[ 계좌 추가 ]");
				//aDAO.addClientAccount(cDAO.log);
			} else if(sel == 2) {
				System.out.println("[ 계좌 삭제 ]");
				//aDAO.deleteClientAccount(cDAO.log);
			} else if(sel == 3) {
				System.out.println("[ 입금 ]");
				//aDAO.depositMoney(cDAO.log);
			} else if(sel == 4) {
				System.out.println("[ 출금 ]");
				//aDAO.withdrawMoney(cDAO.log);
			} else if(sel == 5) {
				System.out.println("[ 이체 ]");
				//aDAO.transferMoney(cDAO.log);
			} else if(sel == 6) {
				System.out.println("[ 탈 퇴 ]");
				//if(cDAO.deleteLogClient(aDAO)) return;
			} else if(sel == 7) {
				System.out.println("[ 마이 페이지 ]");
				//aDAO.showLogAccount(cDAO.log);
			}
		} //while
	}
	
	
}
