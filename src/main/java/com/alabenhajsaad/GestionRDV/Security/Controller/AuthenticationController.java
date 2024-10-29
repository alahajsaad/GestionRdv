package com.alabenhajsaad.GestionRDV.Security.Controller;

import com.alabenhajsaad.GestionRDV.Security.Entites.AppRole;
import com.alabenhajsaad.GestionRDV.Security.Entites.AppUser;
import com.alabenhajsaad.GestionRDV.Security.Services.ServiceAuthentication;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/auth")
public class AuthenticationController {
    private final ServiceAuthentication serviceAuthentication ;
    @PostMapping("addUser")
    public AppUser addUser(AppUser appUser) {
        return serviceAuthentication.createAppUser(appUser) ;
    }
    @PostMapping("addRole")
    public AppRole addRole(AppRole appRole) {
        return serviceAuthentication.createAppRole(appRole) ;
    }

    @PostMapping("addRoleToUser")
    public void addRoleToUser(String username , String role) {
        serviceAuthentication.addRoleToUser(username, role); ;
    }
}