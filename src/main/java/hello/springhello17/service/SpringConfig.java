package hello.springhello17.service;
import hello.springhello17.repository.JdbcMemberRepository;
import hello.springhello17.repository.MemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private final DataSource dataSource;
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        return new JdbcMemberRepository(dataSource);
    }
}
//    private MemberRepository memberRepository;
//    @Autowired
//    public SpringConfig(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//
//    @Bean
//    public MemberService memberService(){
//
//        return new MemberService(memberRepository);
//    }



    //    @Bean
    //    public TimeTraceAop timeTraceAop(){
    //        return new TimeTraceAop();
    //    }

    //    @Bean
    //    public MemberRepository memberRepository(){
    //        return new MemmoryMemberRepository();
    //        return new JdbcMemberRepository(dataSource);
    //        return new JdbcTemplateMemberRepository(dataSource);
    //        return new JpaMemberRepository(em);
    //   }
