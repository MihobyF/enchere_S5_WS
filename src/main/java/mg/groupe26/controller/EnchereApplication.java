package mg.groupe26.controller;

import java.util.List;
import mg.groupe26.model.Admin;
import mg.groupe26.model.Categorie;
import mg.groupe26.model.Enchere;
import mg.groupe26.model.RechargeCompte;
import mg.groupe26.model.ResultatEnchere;
import mg.groupe26.model.Utilisateur;
import mg.groupe26.model.view.v_EnchereCategorie;
import mg.groupe26.util.Statistiques;
import mg.groupe26.util.Verif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@CrossOrigin
public class EnchereApplication {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(EnchereApplication.class, args);
    }

//    test
    @GetMapping("/hello")
    public String hello() {
        return ("Hello !");
    }

//    admin
    @GetMapping("/admins")
    public List<Admin> getListAdmin() {
        return (new Admin().select("select * from Admin", jdbcTemplate));
    }

    @GetMapping("/loginAdmin")
    public Admin loginAdmin(@RequestParam String email,
            @RequestParam String mdp) {
        return (new Admin(null, email, mdp).login(jdbcTemplate));
    }

    @GetMapping("/addAdmin")
    public void addAdmin(@RequestParam String email,
            @RequestParam String mdp) {
        new Admin(null, email, mdp).insert(jdbcTemplate);
    }

//    enchere
    @GetMapping("/encheres")
    public List<Enchere> getListEnchere() {
        return (new Enchere().select("select * from Enchere", jdbcTemplate));
    }

    @GetMapping("/encheres/{id}")
    public Object[] getEnchere(@PathVariable String id) {
        Object[] result = new Object[1];
        Enchere enchere = null;

        enchere = new Enchere().select(String.format("select * from Enchere where id = '%s'", id), jdbcTemplate).get(0);
        enchere.setProprietaire(new Utilisateur(enchere.getProprietaireId(), null, null, null, null).selectById(jdbcTemplate));
        enchere.setCategorie(new Categorie(enchere.getCategorieId(), null).selectById(jdbcTemplate));

        result[0] = enchere;
        
        return result;
    }

    @GetMapping("/addEnchere")
    public void addEnchere(@RequestParam String duree,
            @RequestParam double prixMin,
            @RequestParam int status,
            @RequestParam String produitId) {
        new Enchere().insert(jdbcTemplate);
    }

    @GetMapping("/updateEnchere")
    public void updateEnchere(
            @RequestParam String id,
            @RequestParam String duree,
            @RequestParam Double prixmin,
            @RequestParam Integer status, 
            @RequestParam String nomProduit,
            @RequestParam String descriProduit) {
        new Enchere(id, null, duree, prixmin, status, nomProduit, descriProduit, null, null).update(jdbcTemplate);
    }
    
    @GetMapping("/deleteEnchere/{id}")
    public void deleteEnchere(@PathVariable String id) {
        new Enchere(id, null, null, null, null, null, null, null, null).delete(jdbcTemplate);
    }

    //    rechargeCompte
    @GetMapping("/rechargeComptes")
    public List<RechargeCompte> getListRechargeCompte() {
        return (new RechargeCompte().select("select * from v_rechargecompte", jdbcTemplate));
    }

    @GetMapping("/addRechargeCompte")
    public void addRechargeCompte(@RequestParam double montant,
            @RequestParam String utilisateurId) {
        new RechargeCompte(null, utilisateurId, montant, null, null).insert(jdbcTemplate);
    }

    @GetMapping("/acceptRechargeCompte/{id}")
    public void acceptRechargeCompte(@PathVariable String id) {
        new RechargeCompte(id, null, null, 1, null).update(jdbcTemplate);
    }

    @GetMapping("/declineRechargeCompte/{id}")
    public void declineRechargeCompte(@PathVariable String id) {
        new RechargeCompte(id, null, null, -1, null).update(jdbcTemplate);
    }

//    utilisateur
    @GetMapping("/utilisateurs")
    public List<Utilisateur> getListUtlisateur() {
        return (new Utilisateur().select("select * from Utilisateur", jdbcTemplate));
    }

    @GetMapping("/loginUtilisateur")
    public Utilisateur loginUtilisateur(@RequestParam String email,
            @RequestParam String mdp) {
        return (new Utilisateur(null, null, null, email, mdp).login(jdbcTemplate));
    }

    @GetMapping("/inscription")
    public void addUtilisateur(@RequestParam String nom,
            @RequestParam String pseudo,
            @RequestParam String email,
            @RequestParam String mdp) {
        new Utilisateur(null, nom, pseudo, email, mdp).insert(jdbcTemplate);
    }

//    resultatEnchere
    @GetMapping("/resultatEnchere")
    public List<ResultatEnchere> getResultatEnchere() {
        return (new ResultatEnchere().select("select * from resultatenchere", jdbcTemplate));
    }

//    categorie
    @GetMapping("/categories")
    public List<Categorie> getCategorie() {
        return (new Categorie().select("select * from categorie", jdbcTemplate));
    }

//    token
    @GetMapping("/verifToken/{token}")
    public int verifToken(@PathVariable String token) {
        return (new Verif().tokenValide(token, jdbcTemplate));
    }
    
//    stat
    @GetMapping("/stat")
    public List<v_EnchereCategorie> getStat() {
        return (new Statistiques().getStat(jdbcTemplate));
    }
}
