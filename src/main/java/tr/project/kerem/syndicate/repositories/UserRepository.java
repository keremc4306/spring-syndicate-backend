package tr.project.kerem.syndicate.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tr.project.kerem.syndicate.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByUsername(String username);
}
