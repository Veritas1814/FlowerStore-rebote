package ucu.edu.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ucu.edu.model.AppUser;
import ucu.edu.service.AppUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1")
public class AppUserController {
    private AppUserService appUserService;

    @Autowired
    public AppUserController(AppUserService appUserService){
        this.appUserService = appUserService;
    }

    @GetMapping("/user")
    public List<AppUser> get(){
        return appUserService.getUsers();
    }

    @PostMapping("/user")
    public AppUser addUser(@RequestBody AppUser appUser){
        return appUserService.addUser(appUser);
    }

    @GetMapping("/user/email")
    public ResponseEntity<AppUser> getUserByEmail(@RequestParam String email) {
        AppUser userByEmail = appUserService.getUserByEmail(email);
        if(userByEmail != null){
            return ResponseEntity.ok(userByEmail);
        }
        return ResponseEntity.notFound().build();
    }}
