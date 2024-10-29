package com.alabenhajsaad.GestionRDV.Security.Services;

import com.alabenhajsaad.GestionRDV.Security.Entites.AppRole;
import com.alabenhajsaad.GestionRDV.Security.Entites.AppUser;

public interface IServiceAuthentication {
    public AppUser createAppUser(AppUser appUser) ;
    public AppRole createAppRole(AppRole appRole) ;
    public void addRoleToUser(String username , String role) ;
    public AppUser LoadUserByUserName(String username) ;
}

