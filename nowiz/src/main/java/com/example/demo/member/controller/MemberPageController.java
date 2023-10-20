package com.example.demo.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberPageController {

	// 회원가입
	@GetMapping("/signup")
	public String signup() {
		return "member/signup";
	}

	// 로그인
	@GetMapping("/signin")
	public String signin() {
		return "member/signin";
	}
	
	//회원정보 상세보기
	@GetMapping("/detail")
	public String memberDetail() {
		return "member/detail";
	}

}
