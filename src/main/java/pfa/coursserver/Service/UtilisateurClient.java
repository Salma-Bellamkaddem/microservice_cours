package pfa.coursserver.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "UtilisateurServer", url = "http://localhost:8088")

public interface UtilisateurClient {

    @GetMapping("/utilisateur/{id}/role")
    String getRoleById(@PathVariable("id") Long id); // Récupère le rôle par l'ID de l'utilisateur

}

