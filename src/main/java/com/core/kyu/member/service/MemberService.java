package com.core.kyu.member.service;

import com.core.kyu.member.Member;

import java.util.Optional;

public interface MemberService {
    void join(Member member);
    Optional<Member> findMember(Long memberId);
}
