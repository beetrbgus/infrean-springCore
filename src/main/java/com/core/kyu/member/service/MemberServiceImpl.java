package com.core.kyu.member.service;

import com.core.kyu.member.Member;
import com.core.kyu.member.repository.MemberRepository;

import java.util.Optional;

public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;
    MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Optional<Member> findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
