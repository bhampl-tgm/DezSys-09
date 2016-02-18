package at.ac.tgm.hit.dezsyslabor.hampl.service;

import at.ac.tgm.hit.dezsyslabor.hampl.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface UserRepository extends CrudRepository<User, String> {

    User findByEmail(@Param("email") String email);
}
