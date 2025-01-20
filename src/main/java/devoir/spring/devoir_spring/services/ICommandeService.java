package devoir.spring.devoir_spring.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import devoir.spring.devoir_spring.data.entities.Commande;

public interface ICommandeService {
    Commande create(Commande value);

    List<Commande> getAll();

    Commande update(Integer id, Commande value);

    Commande getById(Integer id);

    Boolean delete(Integer id);

    Page<Commande> getallCommandes(Pageable pageable);

    Page<Commande> getClientCommandes(Integer clientId, Pageable pageable);
}
