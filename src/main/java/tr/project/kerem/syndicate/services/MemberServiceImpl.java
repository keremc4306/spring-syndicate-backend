package tr.project.kerem.syndicate.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.project.kerem.syndicate.entities.Member;
import tr.project.kerem.syndicate.repositories.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberRepository memberRepository;

	@Override
	public Member createMembership(Member member) throws IOException {
		if (!memberRepository.existsByTrIdNumber(member.getTrIdNumber())) {
			return memberRepository.save(member);
		}
		
		throw new IOException("Aynı id de kayıt var");
	}

	@Override
	public List<Member> getAllMembers() {
		return memberRepository.findAll();
	}

	@Override
	public Member getByMemberTrIdNumber(Long trIdNumber) throws IOException {
		Optional<Member> optionalMember = memberRepository.findByTrIdNumber(trIdNumber);
		if (optionalMember.isPresent()) {
			return optionalMember.get();
		}
		throw new IOException("Böyle bir kayıt yok");
	}

}
