package com.core.kyu.member.service;

import com.core.kyu.member.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    Long join(Member member);
    Optional<Member> findMember(Long memberId);
    List<Member> findMemberAll();
}
