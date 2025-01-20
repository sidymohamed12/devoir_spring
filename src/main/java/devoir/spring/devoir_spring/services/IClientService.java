package devoir.spring.devoir_spring.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import devoir.spring.devoir_spring.data.entities.Client;
import devoir.spring.devoir_spring.data.entities.Commande;

public interface IClientService {
    Client create(Client value);

    List<Client> getAll();

    Client update(Integer id, Client value);

    Client getById(Integer id);

    Boolean delete(Integer id);

    Page<Client> getallClients(Pageable pageable);

    void createClientWithCommandes(Client clientRequest, Commande commande);
}
