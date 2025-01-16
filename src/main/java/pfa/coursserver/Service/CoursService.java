package pfa.coursserver.Service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pfa.coursserver.dto.reponse.CourResponseDTO;
import pfa.coursserver.dto.request.CoursRequestDTO;
import pfa.coursserver.entity.Cours;
import pfa.coursserver.repository.CoursRepository;
import pfa.utilisateurserver.dto.reponse.UtilisateurResponse;




@Service
@RequiredArgsConstructor
public class CoursService {

    private final CoursRepository coursRepository;
    private final UtilisateurClient utilisateurClient; // Feign client pour récupérer l'utilisateur

    // Feign client pour interagir avec le service utilisateur

    public CourResponseDTO getCoursDetails(Long id) {
        // Récupérer le cours
        Cours cours = coursRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cours non trouvé"));

        // Récupérer le rôle du professeur via le client Feign
        String role = utilisateurClient.getRoleById(cours.getProfesseurId());

        // Mapper les détails du cours avec le rôle du professeur
        return new CourResponseDTO(cours, role);
    }
}

