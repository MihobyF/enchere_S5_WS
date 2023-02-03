package mg.groupe26.enchere.model.mongo;

import org.springframework.data.annotation.Id;

public class Produit {
    String enchereId;
    Object[] photos;


    public Produit(String enchereId, Object[] photos) {
        this.enchereId = enchereId;
        this.photos = photos;
    }

    public String getEnchereId() {
        return enchereId;
    }

    public void setEnchereId(String id) {
        this.enchereId = id;
    }

    public Object[] getPhotos() {
        return photos;
    }

    public void setPhotos(Object[] photos) {
        this.photos = photos;
    }

    
}
