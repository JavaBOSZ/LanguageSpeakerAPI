package me.szydelko.languagespeakerapi.repo;

import jakarta.transaction.Transactional;
import me.szydelko.languagespeakerapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Transactional
public interface UserRepo extends JpaRepository<User,Long> {

    Optional<User> findBySub(String sub);

    void deleteBySub(String sub);
}
