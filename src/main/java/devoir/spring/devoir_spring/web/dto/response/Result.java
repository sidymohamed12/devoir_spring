package devoir.spring.devoir_spring.web.dto.response;

import java.util.List;

import devoir.spring.devoir_spring.data.entities.Client;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result {
    private ClientSimpleResponse client;
    private List<CommandeSimpleResponse> commandes;

    public Result(Client client) {
        this.client = new ClientSimpleResponse(client);
        this.commandes = client.getCommandes().stream().map(CommandeSimpleResponse::new).toList();
    }

}
