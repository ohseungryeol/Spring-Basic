package hello.basic.member;

public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository; //memberRepository 추상 클래스 의존
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findByLid(memberId);
    }
}
