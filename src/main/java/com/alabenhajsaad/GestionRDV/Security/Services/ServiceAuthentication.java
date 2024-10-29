package com.alabenhajsaad.GestionRDV.Security.Services;

import com.alabenhajsaad.GestionRDV.Security.Entites.AppRole;
import com.alabenhajsaad.GestionRDV.Security.Entites.AppUser;
import com.alabenhajsaad.GestionRDV.Security.Repositories.AppRoleRepository;
import com.alabenhajsaad.GestionRDV.Security.Repositories.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceAuthentication implements IServiceAuthentication{
    private final AppRoleRepository appRoleRepository ;
    private final AppUserRepository appUserRepository ;
    //private final PasswordEncoder passwordEncoder ;
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Override
    public AppUser createAppUser(AppUser appUser) {
        if (appUserRepository.existsAppUserByUsername(appUser.getUsername())) {
            throw new RuntimeException("Username exists");
        }
        AppUser user = AppUser.builder()
                .username(appUser.getUsername())
                .email(appUser.getEmail())
                .password(passwordEncoder.encode((appUser.getPassword())))
                .roles(appUser.getRoles())
                .build();
        return appUserRepository.save(user);
    }

    @Override
    public AppRole createAppRole(AppRole appRole) {
        if(appRoleRepository.existsAppRoleByRole(appRole.getRole())){
            throw new RuntimeException("Role exist") ;
        }
        return appRoleRepository.save(appRole);
    }

    @Override
    public void addRoleToUser(String username, String role) {
        AppUser user = appUserRepository.findAppUserByUsername(username) ;
        AppRole appRole = appRoleRepository.getAppRoleByRole(role);
        if(!user.getRoles().contains(appRole)){
            user.getRoles().add(appRole) ;
        }
        appUserRepository.save(user) ;
    }

    @Override
    public AppUser LoadUserByUserName(String username) {
        return appUserRepository.findAppUserByUsername(username);
    }
}
