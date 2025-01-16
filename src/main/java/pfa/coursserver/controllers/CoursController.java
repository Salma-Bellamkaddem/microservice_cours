package pfa.coursserver.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pfa.coursserver.Mapper.CoursMapper;
import pfa.coursserver.Service.UtilisateurClient;
import pfa.coursserver.dto.reponse.CourResponseDTO;
import pfa.coursserver.entity.Cours;
import pfa.coursserver.repository.CoursRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class CoursController {

    private final CoursRepository coursRepository;
    private final UtilisateurClient utilisateurClient; // Client pour récupérer les informations du rôle

    @GetMapping("/cours")
    public List<CourResponseDTO> findAll() {
        // Récupérer tous les cours et les mapper en CoursResponse
        return coursRepository.findAll().stream()
                .map(cours -> {
                    // Récupérer le rôle via le service Utilisateur
                    String role = utilisateurClient.getRoleById(cours.getProfesseurId()); // Assurez-vous que getRoleById est bien défini

                    // Mapper le cours et son rôle
                    return CoursMapper.toResponse(cours, role);
                })
                .collect(Collectors.toList());  // Collecte les résultats dans une liste
    }

    @GetMapping("/cours/{id}")
    public CourResponseDTO findById(@PathVariable long id) throws Exception {
        // Récupérer un cours par son ID
        Cours cours = coursRepository.findById(id)
                .orElseThrow(() -> new Exception("Cours inexistant"));

        // Récupérer le rôle via le service Utilisateur
        String role = utilisateurClient.getRoleById(cours.getProfesseurId()); // Assurez-vous que getRoleById est bien défini

        // Retourner le DTO du cours avec son rôle
        return CoursMapper.toResponse(cours, role);
    }
}
