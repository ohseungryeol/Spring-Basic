package hello.basic.discount;

import hello.basic.member.Grade;
import hello.basic.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% ")
    void vip_o(){
        //given
        Member vipMember = new Member(1L, "VIPMember", Grade.VIP);
        //when
        int discount = discountPolicy.discount(vipMember, 10000);
        System.out.println("메롱 ");
        //then
        assertThat(discount).isEqualTo(1000);

    }

    @Test
    @DisplayName("VIP는 10% x")
    void vip_x(){
        //given
        Member vipMember = new Member(2L, "BASICMember", Grade.BASIC);
        //when
        int discount = discountPolicy.discount(vipMember, 10000);
        System.out.println("메롱 ");
        //then
        assertThat(discount).isEqualTo(0);

    }
}