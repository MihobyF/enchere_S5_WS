package mg.groupe26.enchere.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import mg.groupe26.enchere.model.mongo.Produit;

@Repository
public interface ProduitRepository extends MongoRepository<Produit, String> {
    
}
