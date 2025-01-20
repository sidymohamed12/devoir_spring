package devoir.spring.devoir_spring.data.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import devoir.spring.devoir_spring.data.entities.Client;
import devoir.spring.devoir_spring.data.entities.Commande;

public interface ICommandeRepository extends JpaRepository<Commande, Integer> {
    Page<Commande> findByClient(Client client, Pageable pageable);

}
