package org.galapagos.mcmorning.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Member {
	private String userid;
	private String password;
	private String name;
	private String email;
}
