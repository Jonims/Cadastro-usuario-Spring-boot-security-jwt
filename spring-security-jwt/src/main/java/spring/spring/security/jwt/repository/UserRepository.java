package spring.spring.security.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring.spring.security.jwt.model.User;

public interface UserRepository extends JpaRepository<User,  Integer> {

    @Query("SELECT e FROM User e JOIN FETCH e.roles WHERE e.username= (:username)") //jpql query para retornar usuário e verificar um user pelo username.
    public User findByUsername(@Param("username") String username);

    boolean existsByUsername(String username);

}
