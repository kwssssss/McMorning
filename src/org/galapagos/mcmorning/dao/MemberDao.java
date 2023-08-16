package org.galapagos.mcmorning.dao;

import java.util.List;

import org.galapagos.mcmorning.vo.Member;

public interface MemberDao {

	void add(Member m);

	// userid로 찾기
	Member findByUserid(String userid);

	// 수정
	Member update(Member m);

	// 삭제
	Member delete(String userid);

	//

	List<Member> searchByname(String name); // name: 홍길동, 길동, 길, 동.., 한 놈만 찾겠다 하면 리턴타입 member

	List<Member> getMemberList();

	void setMemberList(List<Member> memberList);

}