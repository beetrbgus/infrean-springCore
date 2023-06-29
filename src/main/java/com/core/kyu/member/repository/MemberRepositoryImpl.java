package com.core.kyu.member.repository;

import com.core.kyu.member.Member;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class MemberRepositoryImpl implements MemberRepository {
    private static Map<Long, Member> store = new HashMap<>();
    private static Long sequence = 0L;
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long memberId) {
        return Optional.ofNullable(store.get(memberId));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                        .filter(member -> member.getName().equals(name))
                        .findFirst();
    }

    @Override
    public List<Member> findAll() {
        return store.values().stream()
                .collect(Collectors.toList());
    }

    public void clearStore() {
        store.clear();
    }
}
