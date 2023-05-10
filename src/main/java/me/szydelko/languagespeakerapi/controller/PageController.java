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

@RestController
@RequestMapping("/api/page")
@CrossOrigin
public class PageController {
    @Autowired
    private PageService pageService;
    @GetMapping("/my")
    public ResponseEntity<List<Page>> myPages() {
        return ResponseEntity.ok(pageService.myPages());
    }
    @GetMapping("/all")
    public ResponseEntity<List<Page>> allPages() {
        return ResponseEntity.ok(pageService.allPages());
    }
    @GetMapping("/search/{text}")
    public ResponseEntity<List<Page>> searchPages(@PathVariable String text) {
        return ResponseEntity.ok(pageService.searchPages(text));
    }

    @PostMapping("/{title}/{content}")
    public ResponseEntity<Page> postPage(@PathVariable String title, @PathVariable String content) {
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
