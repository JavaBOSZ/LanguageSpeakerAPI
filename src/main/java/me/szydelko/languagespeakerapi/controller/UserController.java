package me.szydelko.languagespeakerapi.controller;

import me.szydelko.languagespeakerapi.model.Page;
import me.szydelko.languagespeakerapi.model.User;
import me.szydelko.languagespeakerapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user/me")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;
    @GetMapping()
    public ResponseEntity<User> myPages() {
        return ResponseEntity.ok(userService.findMe());
    }

}
