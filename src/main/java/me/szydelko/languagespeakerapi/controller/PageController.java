package me.szydelko.languagespeakerapi.controller;

import me.szydelko.languagespeakerapi.model.Page;
import me.szydelko.languagespeakerapi.service.PageService;
import me.szydelko.languagespeakerapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/page")
@CrossOrigin
public class PageController {
    @Autowired
    private PageService pageService;
    @GetMapping("/me")
    public ResponseEntity<List<Page>> myPages() {
        return ResponseEntity.ok(pageService.myPages());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Page> IdPage(@PathVariable Long id) {
        Optional<Page> page = pageService.idPage(id);
        return page.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/all")
    public ResponseEntity<List<Page>> allPages() {
        return ResponseEntity.ok(pageService.allPages());
    }
    @GetMapping("/search/{text}")
    public ResponseEntity<List<Page>> searchPages(@PathVariable String text) {
        return ResponseEntity.ok(pageService.searchPages(text));
    }

    @PostMapping("/{title}")
    public ResponseEntity<Page> postPage(@PathVariable String title, @RequestBody String content) {
        return ResponseEntity.ok(pageService.create(title,content));
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteByIdPage(@PathVariable Long id) {
        if (pageService.deleteById(id)){
            return ResponseEntity.ok("ok");
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("FORBIDDEN");
    }



}
