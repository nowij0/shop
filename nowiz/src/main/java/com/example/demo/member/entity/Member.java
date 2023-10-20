package com.example.demo.member.entity;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicUpdate
@Table(name = "member")
public class Member {

	@Id
	@Column(nullable = false, unique = true)
	private String id;

	@Column(nullable = false)
	private String pwd;
	
	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String nickname;

	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	private Role role;
	
	
	@Builder
	public Member(String id, String email, String nickname, String pwd, Role role) {
		this.id = id;
		this.email = email;
		this.nickname = nickname;
		this.pwd = pwd;
		this.role = role;
	}

	public void update(String email, String nickname, String pwd) {
		this.email = email;
		this.nickname = nickname;
		this.pwd = pwd;
	}
}
