package mg.groupe26.enchere.controller.mongo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mg.groupe26.enchere.model.mongo.Produit;
import mg.groupe26.enchere.repository.ProduitRepository;

@RestController
public class ProduitController {

    @Autowired
    private ProduitRepository produitRepository;

    @GetMapping("/addProduit")
    public String saveProduit(@RequestBody Produit produit) {
        produitRepository.save(produit);
        return "Added produit : ";
    }

    @GetMapping("/findProduit")
    public List<Produit> findAllProduits() {
        return produitRepository.findAll();
    }

    @GetMapping("/findProduit/{id}")
    public Optional<Produit> getProduits(@PathVariable String id) {
        return produitRepository.findById(id);
    }

    @GetMapping("/deleteProduit/{id}")
    public String deleteProduit(@PathVariable String id) {
        produitRepository.deleteById(id);
        return "produit deleted with id : " + id;
    }

}
