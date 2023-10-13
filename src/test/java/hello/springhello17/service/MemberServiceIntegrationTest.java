package hello.springhello17.service;


import hello.springhello17.domain.Member;
import hello.springhello17.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    @Commit
    void 회원가입() {
        //given 주어진 과제
        Member member = new Member();
        member.setName("spring");

        //when 과제를 실행 했을때
        Long saveId = memberService.join(member);

        //then 결괴값 출력
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }
    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("Spring");

        Member member2 = new Member();
        member2.setName("Spring");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

         /*
         try {
             memberService.join(member2);
             fail();
         }catch (IllegalStateException e){
             assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
         }*/
        //then
    }


}