package restorans.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import restorans.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
