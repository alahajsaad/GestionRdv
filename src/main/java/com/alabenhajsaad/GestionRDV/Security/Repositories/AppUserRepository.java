package com.alabenhajsaad.GestionRDV.Security.Repositories;

import com.alabenhajsaad.GestionRDV.Security.Entites.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser , Integer> {
    AppUser findAppUserByUsername(String username) ;
    boolean existsAppUserByUsername(String username) ;
}
