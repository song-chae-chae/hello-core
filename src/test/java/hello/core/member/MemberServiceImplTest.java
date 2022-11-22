package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceImplTest {
    MemberService service = new MemberServiceImpl();

    @Test
    public void join() {
        // given
        Member member = new Member(1L, "memberA", Grade.BASIC);

        // when
        service.join(member);
        Member findMember = service.findMember(1L);

        // then
        Assertions.assertThat(member).isEqualTo(findMember);
    }

    @Test
    public void findId() {

    }
}