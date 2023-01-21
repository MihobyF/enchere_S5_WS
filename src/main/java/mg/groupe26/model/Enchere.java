package mg.groupe26.model;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

public class Enchere {

    String id;
    String dateDebut;
    String duree;
    Double prixmin;
    Integer status;
    String nomProduit;
    String descriProduit;
    String proprietaireId;
    String categorieId;

    Utilisateur proprietaire;
    Categorie categorie;

    public Enchere() {
    }

    public Enchere(String id, String dateDebut, String duree, Double prixmin, Integer status, String nomProduit, String descriProduit, String proprietaireId, String categorieId) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.duree = duree;
        this.prixmin = prixmin;
        this.status = status;
        this.nomProduit = nomProduit;
        this.descriProduit = descriProduit;
        this.proprietaireId = proprietaireId;
        this.categorieId = categorieId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public String getDescriProduit() {
        return descriProduit;
    }

    public void setDescriProduit(String descriProduit) {
        this.descriProduit = descriProduit;
    }

    public String getProprietaireId() {
        return proprietaireId;
    }

    public void setProprietaireId(String proprietaireId) {
        this.proprietaireId = proprietaireId;
    }

    public String getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(String categorieId) {
        this.categorieId = categorieId;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Double getPrixmin() {
        return prixmin;
    }

    public void setPrixmin(Double prixmin) {
        this.prixmin = prixmin;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Utilisateur getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Utilisateur proprietaire) {
        this.proprietaire = proprietaire;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public List<Enchere> select(String query, JdbcTemplate jt) {
        return jt.query(query, (rs, row) -> new Enchere(
                rs.getString("id"),
                rs.getString("datedebut"),
                rs.getString("duree"),
                rs.getDouble("prixmin"),
                rs.getInt("status"),
                rs.getString("nomproduit"),
                rs.getString("descriproduit"),
                rs.getString("proprietaireid"),
                rs.getString("categorieid")
        ));
    }

    public List<Enchere> selectAll(JdbcTemplate jt) {
        String query = "select * from Enchere";
        return (select(query, jt));
    }

    public void insert(JdbcTemplate jt) {
        String query = String.format("insert into enchere values (concat('Enchere',nextval('seq_enchere')), default, '%s', %s, default, '%s', '%s', '%s', '%s')", getDuree(), getPrixmin(), getNomProduit(), getDescriProduit(), getProprietaireId(), getCategorieId());
        jt.update(query);
    }

    public void update(JdbcTemplate j) {
        String query = String.format("update enchere set duree = '%s', prixMin = %s, status = %s, nomProduit = '%s', descriProduit = '%s' where id = '%s' ", getDuree(), getPrixmin(), getStatus(), getNomProduit(), getDescriProduit(), getId());
        j.update(query);
    }

    public void updateStatus(JdbcTemplate j) {
        String query = String.format("update enchere set status = %s where id = '%s' ", getStatus(), getId());
        j.update(query);
    }

    public void delete(JdbcTemplate j) {
        String query = String.format("delete from enchere where id = '%s'", getId());
        j.update(query);
    }
}
