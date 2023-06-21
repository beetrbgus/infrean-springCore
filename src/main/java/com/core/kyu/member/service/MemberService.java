package com.core.kyu.member.service;

import com.core.kyu.member.Member;

public interface MemberService {
    void join(Member member);
    Member findMember(Long memberId);
}
