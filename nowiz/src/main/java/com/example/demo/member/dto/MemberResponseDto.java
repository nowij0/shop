package com.example.demo.member.dto;

import com.example.demo.member.entity.Member;
import com.example.demo.member.entity.Role;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberResponseDto {
	
	private String id;
	private String pwd;
	private String email;
	private String nickname;
	private Role role;
	
	public MemberResponseDto(Member entity) {
		this.id = entity.getId();
		this.pwd = entity.getPwd();
		this.email = entity.getEmail();
		this.nickname = entity.getNickname();
		this.role = entity.getRole();
	}
}
