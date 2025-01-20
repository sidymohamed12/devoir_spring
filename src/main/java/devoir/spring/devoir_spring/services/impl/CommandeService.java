package devoir.spring.devoir_spring.services.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import devoir.spring.devoir_spring.data.entities.Client;
import devoir.spring.devoir_spring.data.entities.Commande;
import devoir.spring.devoir_spring.data.repository.IClientRepository;
import devoir.spring.devoir_spring.data.repository.ICommandeRepository;
import devoir.spring.devoir_spring.services.ICommandeService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CommandeService implements ICommandeService {

    private final ICommandeRepository commandeRepository;
    private final IClientRepository clientRepository;

    @Override
    public Commande create(Commande value) {
        return commandeRepository.save(value);
    }

    @Override
    public List<Commande> getAll() {
        return commandeRepository.findAll();
    }

    @Override
    public Commande update(Integer id, Commande value) {
        Commande data = commandeRepository.findById(id).orElse(null);
        if (data != null) {
            data.setClient(value.getClient());
            data.setMontant(value.getMontant());
            data.setDate(value.getDate());
            commandeRepository.save(data);
        }
        return data;
    }

    @Override
    public Commande getById(Integer id) {
        return commandeRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean delete(Integer id) {
        var cmd = commandeRepository.findById(id).orElse(null);
        if (cmd != null) {
            commandeRepository.delete(cmd);
            return true;
        }
        return false;
    }

    @Override
    public Page<Commande> getallCommandes(Pageable pageable) {
        return commandeRepository.findAll(pageable);
    }

    @Override
    public Page<Commande> getClientCommandes(Integer clientId, Pageable pageable) {
        Client client = clientRepository.findById(clientId).orElse(null);
        return commandeRepository.findByClient(client, pageable);
    }
}
