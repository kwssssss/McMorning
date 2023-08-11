package org.galapagos.mcmorning.dao;

import java.util.ArrayList;
import java.util.List;

import org.galapagos.mcmorning.vo.Member;

// Member에 대한 CRUD
public class MemberDao {
	private List<Member> memberList;

	public MemberDao() {
		memberList = new ArrayList<Member>();
		memberList.add(new Member("구", "1234", "기기", "234"));
		memberList.add(new Member("누", "1234", "니니", "234"));
		memberList.add(new Member("두", "1234", "디디", "234"));
		memberList.add(new Member("루", "1234", "리리", "234"));
		memberList.add(new Member("무", "1234", "미미", "234"));
	}

	public void add(Member m) {
		memberList.add(m);
	}

	// userid로 찾기
	public Member findByUserid(String userid) {
//		for (Member m : memberList) {
//			if (userid.equals(m.getUserid())) {
//				return m;
//			}
//
//		}

		int ix = indexOf(userid);

		return ix != -1 ? memberList.get(ix) : null;
	}

	// 수정
	public Member update(Member m) {
//		for (int i = 0; i < memberList.size(); i++) {
//			if (m.getUserid().equals(memberList.get(i).getUserid())) {
//				memberList.set(i, m);
//				return m;
//			}
//		}

		int ix = indexOf(m.getUserid());
		if (ix != -1) {
			memberList.set(ix, m);
			return m;
		}
		return null;
	}

	private int indexOf(String userId) {
		for (int i = 0; i < memberList.size(); i++) {
			if (userId.equals(memberList.get(i).getUserid())) {
				return i;
			}
		}
		return -1;
	}

	// 삭제
	public Member delete(String userid) {
		int ix = indexOf(userid);
//		if (ix != -1) {
//			return memberList.remove(ix);
//		}
//		return null;

		return ix != -1 ? memberList.remove(ix) : null; // (삼항연산자 사용법)
	}

	public List<Member> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<Member> memberList) {
		this.memberList = memberList;
	};

}
