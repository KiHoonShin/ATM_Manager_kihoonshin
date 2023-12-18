package ATM;

import java.util.ArrayList;

public class ClientDAO {
	
	Util util;
	ArrayList<Client> cList;
	String log;
	int cnt;
	
	ClientDAO(){
		cList = new ArrayList<Client>();
		util = new Util();
		roadToClientData();
	}
	
	// 로드 불러와서 유저리스트에 저장
	public void roadToClientData() {
		String data = util.roadClientFile();
		if(data == null) return;
		String[] temp = data.split("\n");
		for(int i = 0; i < temp.length; i++) {
			String[] info = temp[i].split("/");
			cList.add(new Client(Integer.parseInt(info[0]), info[1],info[2],info[3]));
		}
		cnt = cList.size();
	}
	
	
	boolean loginClient() {
		if(cnt == 0) return false;
		String id = util.getStr("아이디");
		Client idCheck = isId(id);
		if(idCheck == null) {
			System.err.println("아이디를 다시 입력해주세요.");
			return false;
		}
		String pw = util.getStr("비밀번호");
		Client pwCheck = isPw(pw , idCheck);
		if(pwCheck == null) {
			System.err.println("비밀번호를 다시 입력해주세요.");
			return false;
		}
		log = idCheck.getName();
		System.out.printf("[ %s님 로그인 성공] %n" , log);
		return true;
	}
	
	// id 체크
	private Client isId(String id) {
		for(Client c : cList) {
			if(c.getId().equals(id)){
				return c;
			}
		}
		return null;
	}
	
	// pw 체크
	private Client isPw(String pw , Client idCheck) {
		for(Client c : cList) {
			if(idCheck == c && c.getPw().equals(pw)) {
				return c;
			}
		}
		return null;
	}
	
	// 회원 전체 출력
	public void showAllClient() {
		if(cnt == 0) {
			System.out.println("[no data]");
			return;
		}
		System.out.println("==============================");
		System.out.printf("No \t id \t pw \t name %n");
		System.out.println("------------------------------");
		for(Client c : cList) {
			System.out.println(c);
		}
		System.out.println("==============================");
	}
	
	// 회원 정보 수정 (아이디 입력 받은 후 비밀번호 수정)
	public void modifyClient() {
		String id = util.getStr("아이디");
		Client c = isId(id);
		if(c == null) {
			System.err.println("존재하지 않는 아이디");
			return;
		}
		String newPw = util.getStr("수정할 비밀번호");
		c.setPw(newPw);
		System.out.println("[비밀번호 수정 완료]");
	}
	
	// 회원 정보 삭제  -> 해당 account도 삭제
	public void deleteClient(AccountDAO aDAO) {
		String id = util.getStr("아이디");
		Client idCheck = isId(id);
		if(idCheck == null) {
			System.err.println("존재하지 않는 아이디");
			return;
		}
		int delIdx = findIdx(idCheck);
		for(int i = 0; i < cList.size(); i++) {
			if(delIdx == i) {
				cList.remove(delIdx);
			}
		}
		cnt -= 1;
		aDAO.delAccount(id);
		System.out.println(idCheck);
		System.out.println(" [회원 삭제 완료]");
		
	}
	
	// id로 인덱스 찾기
	private int findIdx(Client idCheck) {
		if(cnt == 0) return -1;
		int idx = 0;
		for(Client c : cList) {
			if(idCheck == c) {
				return idx;
			}
			idx +=1;
		}
		return -1;
	}
	
	
}
