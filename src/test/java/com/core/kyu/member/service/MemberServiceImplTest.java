package com.core.kyu.member.service;

import com.core.kyu.member.Member;
import com.core.kyu.member.repository.MemberRepository;
import com.core.kyu.member.repository.MemberRepositoryImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceImplTest {
    MemberRepositoryImpl memberRepository = new MemberRepositoryImpl();
    MemberServiceImpl memberService = new MemberServiceImpl(memberRepository);

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }
    @Test
    void join() {
        // given
        Member member = new Member();
        member.setName("안녕");
        // when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findMember(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void duplicateMember() {
        Member member1 = new Member();
        member1.setName("안녕");

        Member member2 = new Member();
        member2.setName("안녕");

        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        try {
//            memberService.join(member2);
//            fail();
//        }catch (IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }
    }
    @Test
    void findMember() {
    }

    @Test
    void findMemberAll() {
    }
}