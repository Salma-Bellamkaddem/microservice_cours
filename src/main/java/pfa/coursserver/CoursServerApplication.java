package pfa.coursserver;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import pfa.coursserver.Service.UtilisateurService;
import pfa.coursserver.entity.Cours;
import pfa.coursserver.repository.CoursRepository;
import pfa.utilisateurserver.entity.Utilisateur;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "pfa.coursserver")
public class CoursServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoursServerApplication.class, args);
    }

    // Bean CommandLineRunner pour initialiser des données dans la base
    @Bean
    public CommandLineRunner demo(CoursRepository coursRepository, UtilisateurService utilisateurService) {
        return (args) -> {
            // Exemple d'ajout de cours
            // Vous pouvez aussi obtenir des utilisateurs via UtilisateurService si nécessaire
            Cours cours1 = new Cours();
            cours1.setTitre("Introduction à Spring Boot");
            cours1.setDescription("Cours sur la création d'applications avec Spring Boot");
            cours1.setImage("/images/spring-boot.jpg");
            cours1.setCheminVideo("/videos/spring-boot-tutorial.mp4");


            // Ajouter le cours à la base de données
            coursRepository.save(cours1);

            // Exemple d'utilisation d'un service pour récupérer un utilisateur si nécessaire
            Utilisateur professeur = utilisateurService.userById(1L); // Remplacer par un vrai ID
            System.out.println("Professeur: " + professeur.getNom());

            // Si vous avez besoin d'autres initialisations, vous pouvez les ajouter ici.
        };
    }
}
