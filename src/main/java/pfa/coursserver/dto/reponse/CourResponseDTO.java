package pfa.coursserver.dto.reponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pfa.coursserver.entity.Cours;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourResponseDTO {
    private Long id;
    private String titre;
    private String description;
    private String image; // Path to the image
    private String cheminVideo; // Path to the video
    private String categorie; // Category name or description
    private String role; // Role of the professor

    // Constructeur avec cours et rôle
    public CourResponseDTO(Cours cours, String role) {
        this.id = cours.getId();
        this.titre = cours.getTitre();
        this.description = cours.getDescription();
        this.image = cours.getImage();
        this.cheminVideo = cours.getCheminVideo();
        this.categorie = cours.getCategorie() != null ? cours.getCategorie().getNom() : null;
        this.role = role;
    }
}
