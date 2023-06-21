package com.core.kyu.member.repository;

import com.core.kyu.member.Member;

public interface MemberRepository {
    void save(Member member);
    Member findById(Long memberId);
}
