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
    private UserRepo userRepo;

    public boolean userCheck(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User user = new User();
        user.setSub(authentication.getName());

        try {
            if (authentication.isAuthenticated()){
                userRepo.save(user);
            }
        }catch (Exception e){
            return true;
        }

        return false;
    }

    public User findBySub(String Sub){

        return userRepo.findBySub(Sub).get();

    }
    public User findMe(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        userCheck();
        return userRepo.findBySub(authentication.getName()).get();

    }
    public User findMeNone(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return userRepo.findBySub(authentication.getName()).get();
    }
    public User save(User e){
        return userRepo.save(e);
    }
}
