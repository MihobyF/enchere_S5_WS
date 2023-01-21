package mg.groupe26.model;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

public class ResultatEnchere {

    String id;
    Double prixVente;
    String gagnantId;
    String enchereid;

    public ResultatEnchere() {
    }

    public ResultatEnchere(String id, Double prixVente, String gagnantId, String enchereid) {
        this.id = id;
        this.prixVente = prixVente;
        this.gagnantId = gagnantId;
        this.enchereid = enchereid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGagnantId() {
        return gagnantId;
    }

    public void setGagnantId(String gagnantId) {
        this.gagnantId = gagnantId;
    }

    public String getEnchereid() {
        return enchereid;
    }

    public void setEnchereid(String enchereid) {
        this.enchereid = enchereid;
    }

    public Double getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(Double prixVente) {
        this.prixVente = prixVente;
    }

    public List<ResultatEnchere> select(String query, JdbcTemplate jt) {
        return jt.query(query, (rs, row) -> new ResultatEnchere(
                rs.getString("id"),
                rs.getDouble("prixvente"),
                rs.getString("gagnantId"),
                rs.getString("enchereid")
        ));
    }

    public List<ResultatEnchere> selectAll(JdbcTemplate jt) {
        String query = "select * from resultatEnchere";
        return (select(query, jt));
    }

    public void insert(JdbcTemplate jt) {
        String query = String.format("insert into resultatenchere values (concat('ResutlatEnchere', nextval('seq_resultatenchere')), %s, '%s', '%s')", getPrixVente(), getGagnantId(), getEnchereid());
        jt.update(query);
    }

    public void update(JdbcTemplate j) {
        String query = String.format("update resultatcompte set gagnantId = '%s', enchereid = '%s' prixvente = %s where id= '%s'", getGagnantId(), getEnchereid(), getPrixVente(), getId());
        j.update(query);
    }
}
