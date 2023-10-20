package com.example.demo.member.dto;

import com.example.demo.member.entity.Member;
import com.example.demo.member.entity.Role;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberRequestDto {
	
	private String id;
	private String pwd;
	private String email;
	private String nickname;
	private Role role;
	
	public Member toEntity() {
		return Member.builder()
				.id(id)
				.pwd(pwd)
				.email(email)
				.nickname(nickname)
				.role(Role.ROLE_USER)
				.build();
	}

}
