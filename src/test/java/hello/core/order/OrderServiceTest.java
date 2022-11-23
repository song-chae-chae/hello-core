package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    public void createOrder() {
        // given
        Member member = new Member(1L, "member1", Grade.VIP);
        memberService.join(member);

        // when
        Order order = orderService.createOrder(member.getId(), "item1", 3000);

        // then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }
}
