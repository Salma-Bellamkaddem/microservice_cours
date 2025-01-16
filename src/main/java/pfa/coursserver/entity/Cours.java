package pfa.coursserver.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pfa.utilisateurserver.dto.reponse.UtilisateurResponse;
import pfa.utilisateurserver.entity.Utilisateur;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;

    @Lob
    private String description;

    private String image; // Stocker le chemin de l'image en local

    private String cheminVideo; // Stocker le chemin de la vidéo


    @ManyToOne
    private Categorie categorie; // La catégorie du cours


    private String role;
    private Long professeurId;


}
