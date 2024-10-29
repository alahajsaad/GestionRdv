package com.alabenhajsaad.GestionRDV.Security.Repositories;

import com.alabenhajsaad.GestionRDV.Security.Entites.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole ,Integer> {
    AppRole getAppRoleByRole(String role) ;
    boolean existsAppRoleByRole(String role) ;
}