package org.galapagos.mcmorning.exception;

public class UseridCountOverException extends Exception {

	public UseridCountOverException() {
		super("사용자 ID 입력횟수 초과");
	}
}
