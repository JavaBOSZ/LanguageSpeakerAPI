package me.szydelko.languagespeakerapi.repo;

import jakarta.transaction.Transactional;
import me.szydelko.languagespeakerapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface UserRepo extends JpaRepository<User,Long> {

    void deleteBySub(String sub);
}
