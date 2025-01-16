package pfa.coursserver.Mapper;

import pfa.coursserver.dto.reponse.CourResponseDTO;
import pfa.coursserver.entity.Cours;

public class CoursMapper {
    public static CourResponseDTO toResponse(Cours cours, String role) {
        if (cours == null) {
            return null; // Handle null input gracefully
        }

        CourResponseDTO response = new CourResponseDTO();
        response.setId(cours.getId());
        response.setTitre(cours.getTitre());
        response.setDescription(cours.getDescription());
        response.setImage(cours.getImage());
        response.setCheminVideo(cours.getCheminVideo());
        response.setCategorie(cours.getCategorie() != null ? cours.getCategorie().getNom() : null);
        response.setRole(role); // Map role explicitly

        return response;
    }
}
