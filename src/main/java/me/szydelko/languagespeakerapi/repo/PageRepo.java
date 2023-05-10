package me.szydelko.languagespeakerapi.repo;

import jakarta.transaction.Transactional;
import me.szydelko.languagespeakerapi.model.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Transactional
public interface PageRepo extends JpaRepository<Page,Long> {
    void deleteByTitle(String title);
    List<Page> findAllByContentContainsOrTitleContains(String content, String title);
    List<Page> findAllByTitle(String title);
}
