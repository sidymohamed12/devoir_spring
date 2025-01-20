package devoir.spring.devoir_spring.web.dto.request;

import java.util.List;

import devoir.spring.devoir_spring.data.entities.Client;
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
        // client.setCommandes(commandes);
        return client;
    }
}
