package hello.basic;

import hello.basic.discount.DiscountPolicy;
import hello.basic.discount.FixDiscountPolicy;
import hello.basic.discount.RateDiscountPolicy;
import hello.basic.member.MemberRepository;
import hello.basic.member.MemberService;
import hello.basic.member.MemberServiceImpl;
import hello.basic.member.MemoryMemberRepository;
import hello.basic.order.OrderService;
import hello.basic.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
의존관계 주입 역할 클래스 (클라이언트와 서버의 연결) -> 메모리 멤버 리포지토리를 쓸지 db리포지토리르 쓸지,
 고정 할인을 쓸지 정률 할인을 쓸지 객체를 생성하고 주입시켜주는 클래스

*/
@Configuration //스ㅍ
public class AppConfig {
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public MemberRepository memberRepository() { //memberRepository는 memory를 쓸 것이다.
        return new MemoryMemberRepository();
    }
    @Bean
    public DiscountPolicy discountPolicy() { // 할인정책은 Fix를 쓸 것이다.
        return new RateDiscountPolicy();
    }



}
