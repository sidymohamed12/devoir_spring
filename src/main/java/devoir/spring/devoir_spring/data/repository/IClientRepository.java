package devoir.spring.devoir_spring.data.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import devoir.spring.devoir_spring.data.entities.Client;

public interface IClientRepository extends JpaRepository<Client, Integer> {
    Page<Client> findAll(Pageable pageable);
}
