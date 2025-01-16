package pfa.coursserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur {
    private Long id;

    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;
    private String photoProfil;
    private String niveauEtudes;
}
