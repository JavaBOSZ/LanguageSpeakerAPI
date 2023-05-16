package me.szydelko.languagespeakerapi.service;

import me.szydelko.languagespeakerapi.model.Page;
import me.szydelko.languagespeakerapi.model.User;
import me.szydelko.languagespeakerapi.repo.PageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PageService {

    @Autowired
    private PageRepo pageRepo;
    @Autowired
    private UserService userService;

    public Page create(String title,String content,String lang){
        Page tmp = new Page();
        tmp.setTitle(title);
        tmp.setContent(content);
        tmp.setLang(lang);
        tmp = pageRepo.save(tmp);
        User bySub = userService.findMe();
        bySub.addPage(tmp);
        userService.save(bySub);
        return tmp;
    }

    public Page update(String title,String content,String lang,Long id){
        Page tmp = new Page();
        tmp.setId(id);
        tmp.setTitle(title);
        tmp.setContent(content);
        tmp.setLang(lang);
        tmp = pageRepo.save(tmp);
        return tmp;
    }

    public List<Page> myPages(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return userService.findMe().getPages();
    }
    public Optional<Page> idPage(Long id){
        return pageRepo.findById(id);
    }
    public List<Page> allPages(){
        return pageRepo.findAll(Sort.by(Sort.Direction.ASC,"title"));
    }
    public List<Page> searchPages(String text){

        return pageRepo.findAllByContentContainsOrTitleContainsOrderByTitleAsc(text,text);
    }
    public boolean deleteById(Long id){

//                userService.findMeNone().getPages().stream().anyMatch(e->e.getId().equals(id));
        try {
            pageRepo.deleteByUserIdAndId(userService.findMeNone().getId(),id);
        }catch (Exception e){
         return false;
        }
        return true;
    }
    public boolean deleteByTitle(String title){
//        boolean contains = userService.findMe().getPages().containsAll(pageRepo.findAllByTitle(title));
//        if (contains){
//            pageRepo.deleteByTitle(title);
//        }
//        return contains;
        try {
            pageRepo.deleteByUserIdAndTitle(userService.findMeNone().getId(),title);
        }catch (Exception e){
            return false;
        }
        return true;
    }



}
