package pfa.coursserver.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pfa.utilisateurserver.entity.Utilisateur;


@FeignClient(name = "UtilisateurServer" , url = "http://localhost:8088 ")

public interface UtilisateurService {
    @GetMapping(path = "/user/{id}")
     Utilisateur userById(@PathVariable("id") Long id);
}

