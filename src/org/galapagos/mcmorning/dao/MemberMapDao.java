package org.galapagos.mcmorning.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.galapagos.mcmorning.vo.Member;

public class MemberMapDao implements MemberDao {
	private Map<String, Member> memberMap;

	public MemberMapDao() {
//		memberList = new ArrayList<Member>();
//		memberList.add(new Member("구", "1234", "기기", "234"));
//		memberList.add(new Member("누", "1234", "니니", "234"));
//		memberList.add(new Member("두", "1234", "디디", "234"));
//		memberList.add(new Member("루", "1234", "리리", "234"));
//		memberList.add(new Member("무", "1234", "미미", "234"));

		memberMap = new HashMap<String, Member>();
		memberMap.put("구", new Member("구", "1234", "기기", "234"));
		memberMap.put("누", new Member("누", "1234", "니니", "234"));
		memberMap.put("두", new Member("두", "1234", "디디", "234"));
		memberMap.put("루", new Member("루", "1234", "리리", "234"));
		memberMap.put("무", new Member("무", "1234", "미미", "234"));
	}

	@Override
	public void add(Member m) {
		// TODO Auto-generated method stub
		memberMap.put(m.getUserid(), m);

	}

	@Override
	public Member findByUserid(String userid) {
		// TODO Auto-generated method stub
		return memberMap.get(userid);
	}

	@Override
	public Member update(Member m) {
		// TODO Auto-generated method stub
		return memberMap.put(m.getUserid(), m);
	}

	@Override
	public Member delete(String userid) {
		// TODO Auto-generated method stub
		return memberMap.remove(userid);
	}

	@Override
	public List<Member> getMemberList() {
		// TODO Auto-generated method stub
		return new ArrayList<>(memberMap.values());
	}

	@Override
	public void setMemberList(List<Member> memberList) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Member> searchByname(String name) {
		List<Member> list = new ArrayList<>();

		for (Member m : memberMap.values()) {
			if (m.getName().contains(name)) { // contains() 또는 substring()
				list.add(m);
			}
		}
		return null;
	}

}
