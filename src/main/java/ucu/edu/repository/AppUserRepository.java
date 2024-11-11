package ucu.edu.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import ucu.edu.model.AppUser;
import org.springframework.data.jpa.repository.Query;



public interface AppUserRepository extends JpaRepository<AppUser, Integer> {
    @Query("SELECT u FROM app_user u WHERE u.email = ?1")
    AppUser findUserByEmail(String email);
}
