package hello.springhello17.repository;


import hello.springhello17.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringMemberJpaRepository extends JpaRepository<Member, Long>,MemberRepository {
    @Override
    Optional<Member> findByName(String name);
}