package com.core.kyu.repository;

import com.core.kyu.member.Grade;
import com.core.kyu.member.Member;
import com.core.kyu.member.repository.MemberRepositoryImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryMemberRepositoryTest {
    MemberRepositoryImpl memberRepository = new MemberRepositoryImpl();
    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }
    @Test
    public void save() {
        Member member = new Member();
        member.setName("홍길동");
        member.setId(1L);
        member.setGrade(Grade.BASIC);
        memberRepository.save(member);
        Member savedMember = memberRepository.findById(member.getId()).orElse(null);
        assertThat(member).isEqualTo(savedMember);
    }

    @Test
    public void findByName() {
        Member member = new Member();
        member.setName("홍길동");
        member.setId(1L);
        member.setGrade(Grade.BASIC);
        memberRepository.save(member);

        Member member2 = new Member();
        member2.setName("홍길동");
        Member findMember = memberRepository.findByName(member2.getName()).orElse(null);
        assertThat(findMember.getId()).isEqualTo(member.getId());
    }
    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("홍길동");

        Member member2 = new Member();
        member2.setName("홍길동2");

        memberRepository.save(member1);
        memberRepository.save(member2);
        List<Member> result = memberRepository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}