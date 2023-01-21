package mg.groupe26.model;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

public class Photo {

    String id;
    String image;
    String enchereId;

    public Photo() {
    }

    public Photo(String id, String image, String enchereId) {
        this.id = id;
        this.image = image;
        this.enchereId = enchereId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEnchereId() {
        return enchereId;
    }

    public void setEnchereId(String enchereId) {
        this.enchereId = enchereId;
    }

    public List<Photo> select(String query, JdbcTemplate jt) {
        return jt.query(query, (rs, row) -> new Photo(
                rs.getString("id"),
                rs.getString("image"),
                rs.getString("enchereId")));
    }

    public void insert(JdbcTemplate jt) {
        String query = String.format("insert into photo values (concat('Photo',nextval('seq_photo')), '%s', '%s')", getImage(), getEnchereId());
        jt.update(query);
    }

    public void update(JdbcTemplate j) {
        String query = String.format("update photo set image = '%s', enchereId = '%s' where id = '%s'", getImage(), getEnchereId(), getId());
        j.update(query);
    }
}
