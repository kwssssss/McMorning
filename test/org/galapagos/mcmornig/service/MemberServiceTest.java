package org.galapagos.mcmornig.service;

import org.galapagos.mcmorning.exception.UseridCountOverException;
import org.galapagos.mcmorning.service.MemberService;
import org.galapagos.mcmorning.vo.Member;

public class MemberServiceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testInputMember();
	}

	static void testInputMember() {
		MemberService service = new MemberService();

		Member m;
		try {
			m = service.inputMember();
			System.out.println(m);
		} catch (UseridCountOverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
