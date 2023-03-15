package hello.basic.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{ //메모리 저장소(MemberRepository 구현체 )

    private static HashMap<Long, Member> store = new HashMap<>();
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findByLid(Long memberId) {
        return store.get(memberId);
    }
}
