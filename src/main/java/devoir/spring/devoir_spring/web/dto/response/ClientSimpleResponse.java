package devoir.spring.devoir_spring.web.dto.response;

import devoir.spring.devoir_spring.data.entities.Client;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientSimpleResponse {
    private Integer id;
    private String name;
    private String telephone;

    public ClientSimpleResponse(Client client) {
        id = client.getId();
        name = client.getName();
        telephone = client.getTelephone();
    }
}
