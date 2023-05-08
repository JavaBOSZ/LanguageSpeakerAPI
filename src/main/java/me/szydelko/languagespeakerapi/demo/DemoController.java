package me.szydelko.languagespeakerapi.demo;

import jakarta.transaction.Transactional;
import me.szydelko.languagespeakerapi.model.User;
import me.szydelko.languagespeakerapi.repo.UserRepo;
import me.szydelko.languagespeakerapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo")
@CrossOrigin
public class DemoController {

    @Autowired
    private UserService userService;


    @GetMapping
    public ResponseEntity<String> hello() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();


        userService.userCheck();
        userService.userRepo.deleteBySub(authentication.getName());

        return ResponseEntity.ok("jooooooooo"+  userService.userRepo.count() +" : " );
    }

}
