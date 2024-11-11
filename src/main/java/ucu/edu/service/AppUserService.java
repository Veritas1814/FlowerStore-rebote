package ucu.edu.service;

import ucu.edu.model.AppUser;
import ucu.edu.repository.AppUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService {
    @Autowired
    private AppUserRepository appUserRepository;
    public List<AppUser> getUsers() {
        return appUserRepository.findAll();
    }

    public AppUser addUser(AppUser appUser) {
        return appUserRepository.save(appUser);
    }
    public AppUser getUserByEmail(String email){
        return appUserRepository.findUserByEmail(email);
    }
}
