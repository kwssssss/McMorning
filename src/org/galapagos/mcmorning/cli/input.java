package org.galapagos.mcmorning.cli;

import java.util.Scanner;

public class input { // 여기에 들어가는 메서드는 대부분 스태틱 메서드
	static Scanner sc = new Scanner(System.in);

	// Facade Pattern : 복잡한 절차를 일반화 시켜서 외형을 다시 잡은 것
	public static String read(String title) {
		System.out.print(title);
		return sc.nextLine();

	}
}
