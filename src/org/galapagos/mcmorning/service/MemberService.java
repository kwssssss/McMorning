package org.galapagos.mcmorning.service;

import java.util.List;

import org.galapagos.mcmorning.cli.input;
import org.galapagos.mcmorning.dao.MemberDao;
import org.galapagos.mcmorning.exception.UseridCountOverException;
import org.galapagos.mcmorning.vo.Member;

public class MemberService {
	MemberDao dao;

	public MemberService(MemberDao dao) {
		this.dao = dao;
	}

	public void signUp() {
		// Member 정보 입력
		// id 중복 체크
		// Member 인스턴스 생성
		// 리스트에 입력정보 넣기(Dao)

		Member member;
		try {
			member = inputMember();
			dao.add(member);

		} catch (UseridCountOverException e) {
			System.out.println(e.getMessage());
//			e.printStackTrace();
		}

	}

	public Member login() {
		System.out.println("[로그인]");
		String userId = input.read("사용자 ID : ");
		String password = input.read("비밀번호 : ");

		// 로그인 검사

		Member m = dao.findByUserid(userId);
		if (m != null) { // 사용자 ID가 존재하는지 검사
			if (password.equals(m.getPassword())) { // 비밀번호가 일치하는지 검사
				// 로그인 성공
				return m;
			}
		}

		// 로그인 실패
		return null;
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

	public void searchByName() {
		System.out.println("[이름으로 찾기]");
		String keyword = input.read("검색어 : ");

		List<Member> list = dao.searchByname(keyword);
		System.out.printf("검색 결과: %d건\n", list.size());
		for (Member m : list) {
			System.out.println(m);
		}
	}
}
