package devoir.spring.devoir_spring.web.dto.request;

import java.time.LocalDateTime;

import devoir.spring.devoir_spring.data.entities.Commande;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommandeCreateRequest {
    private Integer id;
    private Double montant;
    private LocalDateTime date = LocalDateTime.now();

    public Commande toEntity() {
        var commande = new Commande();
        commande.setDate(date);
        commande.setMontant(montant);
        // client.setCommandes(commandes);
        return commande;
    }

}
