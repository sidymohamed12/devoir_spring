package devoir.spring.devoir_spring.web.dto.response;

import java.time.LocalDateTime;

import devoir.spring.devoir_spring.data.entities.Commande;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommandeSimpleResponse {
    private Integer id;
    private Double montant;
    private LocalDateTime date;

    public CommandeSimpleResponse(Commande commande) {
        id = commande.getId();
        montant = commande.getMontant();
        date = commande.getDate();
    }
}
