package tr.project.kerem.syndicate.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tr.project.kerem.syndicate.entities.Member;
import tr.project.kerem.syndicate.services.MemberService;

@RestController
@RequestMapping("/api/members")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@PostMapping("/create")
	public ResponseEntity<?> createMembership(@RequestBody Member member) {
		try {
			Member savedMember = memberService.createMembership(member);
			return ResponseEntity.status(HttpStatus.OK).body(savedMember);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Member>> getAllMembers() {
		List<Member> members = memberService.getAllMembers();
		return ResponseEntity.status(HttpStatus.OK).body(members);
	}
	
	@GetMapping("/getByTrIdNumber/{trIdNumber}")
	public ResponseEntity<?> getMemberByTrIdNumber(@PathVariable Long trIdNumber) {
		try {
			Member member = memberService.getByMemberTrIdNumber(trIdNumber);
			return ResponseEntity.status(HttpStatus.OK).body(member);
		} catch (IOException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
}
