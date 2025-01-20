package devoir.spring.devoir_spring.web.dto.request;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import devoir.spring.devoir_spring.data.entities.Client;
import devoir.spring.devoir_spring.data.entities.Commande;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientAndCommandeCreateRequest {
    private String name;
    private String telephone;
    private List<CommandeCreateRequest> commandes;

    public Client toEntity() {
        var client = new Client();
        client.setName(name);
        client.setTelephone(telephone);
        List<Commande> commandesEntities = commandes.stream()
                .map(commandeRequest -> {
                    var commande = new Commande();
                    commande.setMontant(commandeRequest.getMontant());
                    commande.setDate(LocalDateTime.now());
                    commande.setClient(client);
                    return commande;
                })
                .collect(Collectors.toList());
        client.setCommandes(commandesEntities);
        return client;
    }
}
