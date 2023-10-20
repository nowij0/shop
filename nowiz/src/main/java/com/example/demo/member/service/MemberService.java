package com.example.demo.member.service;

import org.springframework.stereotype.Service;

import com.example.demo.common.exception.BadRequestException;
import com.example.demo.common.exception.ConflictException;
import com.example.demo.common.exception.ErrorCode;
import com.example.demo.member.dto.MemberRequestDto;
import com.example.demo.member.dto.MemberResponseDto;
import com.example.demo.member.entity.Member;
import com.example.demo.member.repository.MemberRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	
	private final MemberRepository memberRepository;
	
	//회원가입
	@Transactional
	public String signup(MemberRequestDto requestDto) {
		boolean checkEmail = checkEmailExists(requestDto.getEmail());		
		boolean checkId = checkIdExists(requestDto.getId());
		if(checkId) {
			throw new ConflictException(ErrorCode.DUPLICATE_RESOURCE, "이미 존재하는 아이디입니다.");
		} else if (checkEmail) {
			throw new ConflictException(ErrorCode.DUPLICATE_RESOURCE, "이미 존재하는 이메일입니다.");
		}
		
		Member member = memberRepository.save(requestDto.toEntity());
		return member.getId();
	}
	
	//로그인
	public MemberResponseDto signin(MemberResponseDto responseDto) {
		Member member = findById(responseDto.getId());
		MemberResponseDto response = new MemberResponseDto(member);
		response.setPwd("");
		return response;
	}
	
	//회원 개인 정보 확인
	public MemberResponseDto readMember(String loginId) {
		Member member = findById(loginId);
		MemberResponseDto response = new MemberResponseDto(member);
		response.setPwd("");
		return response;
	}

	//회원정보 수정
	@Transactional
	public String update(MemberRequestDto requestDto) {
		Member member = findById(requestDto.getId());
		member.update(requestDto.getEmail(), requestDto.getNickname(), requestDto.getPwd());
		return requestDto.getId();
	}
	
	
	
	//이메일 중복체크 
	private boolean checkEmailExists(String email) {
		return memberRepository.existsByEmail(email);
	}
	
	//아이디 중복체크 
	private boolean checkIdExists(String id) {
		return memberRepository.existsById(id);
	}
	
	//회원상세 확인
	private Member findById(String loginId) {
		return memberRepository.findById(loginId)
				.orElseThrow(() -> new BadRequestException(ErrorCode.INVALID_PARAMETER, "아이디를 찾을 수 없습니다."));
	}
	
}
