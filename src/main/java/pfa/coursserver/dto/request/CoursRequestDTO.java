package pfa.coursserver.dto.request;

import lombok.Data;
import pfa.utilisateurserver.entity.Utilisateur;

@Data
public class CoursRequestDTO {
    private Long id;
    private String titre;
    private String description;
    private String image; // Path to the image
    private String cheminVideo; // Path to the video
    private String categorie; // Category name or description
    private String role; // Professor ID
}
