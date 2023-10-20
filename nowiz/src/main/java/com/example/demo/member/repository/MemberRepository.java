package com.example.demo.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.member.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String> {
	
	//이메일 유효성 검사
	public boolean existsByEmail(String email);
	
	//아이디 유효성 검사
	public boolean existsById(String id);
	
}
