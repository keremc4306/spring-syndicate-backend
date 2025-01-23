package tr.project.kerem.syndicate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tr.project.kerem.syndicate.entities.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{
	boolean existsByTrIdNumber(Long trIdNumber);
}
