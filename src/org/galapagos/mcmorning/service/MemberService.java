package org.galapagos.mcmorning.service;

import org.galapagos.mcmorning.cli.input;
import org.galapagos.mcmorning.dao.MemberDao;
import org.galapagos.mcmorning.exception.UseridCountOverException;
import org.galapagos.mcmorning.vo.Member;

public class MemberService {
	MemberDao dao = new MemberDao();

	public void signUp() {
		// Member 정보 입력
		// id 중복 체크
		// Member 인스턴스 생성
		// 리스트에 입력정보 넣기(Dao)

		Member member;
		try {
			member = inputMember();
		} catch (UseridCountOverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Member inputMember() throws UseridCountOverException {
		String userid = inputUserid();

		String password = input.read("비밀번호 : ");
		String name = input.read("이름 : ");
		String email = input.read("email : ");
//		Scanner sc = new Scanner(System.in);
//
//		// 사용자 ID
//		System.out.print("사용자 ID : ");
//		String userid = sc.nextLine();
//
//		// 사용자 비밀번호
//		System.out.print("비밀번호 : ");
//		String password = sc.nextLine();
//
//		// 사용자 이름
//		System.out.print("이름 : ");
//		String name = sc.nextLine();
//
//		// 사용자 비밀번호
//		System.out.print("email : ");
//		String email = sc.nextLine();

		// Member 인스턴스 생성
		Member member = new Member(userid, password, name, email);

		return member;
	}

	public String inputUserid() throws UseridCountOverException {
		String userid = "";
		for (int i = 0; i < 3; i++) {
//		while (true) {
			userid = input.read("사용자 ID: ");
			Member m = dao.findByUserid(userid);
			if (m != null) { // 중복이면
				System.out.println(userid + "는 중복된 ID입니다.");
			} else {
				return userid;
			}
		}

		throw new UseridCountOverException();
	}
}
