package me.szydelko.languagespeakerapi.service;

import me.szydelko.languagespeakerapi.model.User;
import me.szydelko.languagespeakerapi.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    public UserRepo userRepo;

    public boolean userCheck(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User user = new User();
        user.setSub(authentication.getName());

        try {
            userRepo.save(user);
        }catch (Exception e){
            return true;
        }

        return false;
    }



}
