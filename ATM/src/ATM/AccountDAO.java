package ATM;

import java.util.ArrayList;

public class AccountDAO {
	Util util;
	ArrayList<Account> aList; 
	int cnt;
	
	AccountDAO(){
		util = new Util();
		aList = new ArrayList<Account>(); 
		roadToAccountData();
	}
	// 데이터 불러오기
	public void roadToAccountData() {
		String data = util.roadAccountFile();
		if(data == null) return;
		String[] temp = data.split("\n");
		for(int i = 0; i < temp.length; i++) {
			String[] info = temp[i].split("/");
			aList.add(new Account(info[0],info[1],Integer.parseInt(info[2])));
		}
		cnt = aList.size();
	}
	
	// 회원삭제할때 account도 삭제
	public void delAccount(String id) {
		for(int i = 0; i < aList.size(); i++) {
			if(aList.get(i).getClientId().equals(id)) {
				aList.remove(i);
				cnt -= 1;
			}
		}
	}
	
}
