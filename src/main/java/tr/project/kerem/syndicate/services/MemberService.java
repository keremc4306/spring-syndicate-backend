package tr.project.kerem.syndicate.services;

import java.io.IOException;

import tr.project.kerem.syndicate.entities.Member;

public interface MemberService {
	Member createMembership(Member member) throws IOException;
}
