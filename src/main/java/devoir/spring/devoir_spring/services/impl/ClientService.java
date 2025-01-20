package devoir.spring.devoir_spring.services.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import devoir.spring.devoir_spring.data.entities.Client;
import devoir.spring.devoir_spring.data.entities.Commande;
import devoir.spring.devoir_spring.data.repository.IClientRepository;
import devoir.spring.devoir_spring.data.repository.ICommandeRepository;
import devoir.spring.devoir_spring.services.IClientService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ClientService implements IClientService {
    private final IClientRepository clientRepository;
    private final ICommandeRepository commandeRepository;

    @Override
    public Client create(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public Page<Client> getallClients(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }

    @Override
    public Client update(Integer id, Client client) {
        Client cl = clientRepository.findById(id).orElse(null);
        if (cl != null) {
            cl.setName(client.getName());
            cl.setTelephone(client.getTelephone());
            clientRepository.save(cl);
        }
        return cl;
    }

    @Override
    public Client getById(Integer id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean delete(Integer id) {
        Client cl = clientRepository.findById(id).orElse(null);
        if (cl != null) {
            clientRepository.delete(cl);
            return true;
        }
        return false;
    }

    @Override
    public void createClientWithCommandes(Client clientRequest, Commande commande) {
        Client client = create(clientRequest);
        commande.setClient(client);
        commandeRepository.save(commande);
    }

}
