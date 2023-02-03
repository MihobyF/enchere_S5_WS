package mg.groupe26.enchere.controller.psql;

import java.util.List;
import mg.groupe26.enchere.model.psql.Historique;
import mg.groupe26.enchere.model.psql.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HistoriqueRC {
    
    @Autowired
    JdbcTemplate jt;
 
    @GetMapping("/historiqueByEnchere/{enchereId}")
    public List<Historique> getHistoriqueByEnchere(@PathVariable String enchereId) {
        String query = String.format("select * from Historique where enchereId = '%s' ", enchereId);
        List<Historique> result = new Historique(enchereId).select(query, jt);
        
        for (Historique h : result) {
            h.setU(new Utilisateur(h.getUtilisateurId(), null, null, null, null).selectById(jt));
        }
        
        return (result);
    }
    
    
    
}
