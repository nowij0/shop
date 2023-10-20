package com.example.demo.member.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.member.dto.MemberRequestDto;
import com.example.demo.member.dto.MemberResponseDto;
import com.example.demo.member.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemberApiController {
	
	private final MemberService memberService;
	
	//회원가입
	@PostMapping("/signup")
	public String signup(MemberRequestDto requestDto) {
		return memberService.signup(requestDto);
	}
	
	//로그인
	@GetMapping("/signin")
	public void signin(MemberResponseDto responseDto, HttpServletRequest request) {
		MemberResponseDto response = memberService.signin(responseDto);
		
		HttpSession session = request.getSession();
		session.setAttribute("loginId", response.getId());
		session.setAttribute("nickname", response.getNickname());
		session.setAttribute("role", response.getRole());
	}
	
	//회원 상세조회
	@GetMapping("/detail")
	public MemberResponseDto memberDetail(HttpServletRequest request) {
		String loginId = (String) request.getAttribute("loginId");
		MemberResponseDto response = memberService.readMember(loginId);
		return response;
	}

}
