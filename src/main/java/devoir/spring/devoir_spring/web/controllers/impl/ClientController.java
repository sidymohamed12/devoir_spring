package devoir.spring.devoir_spring.web.controllers.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import devoir.spring.devoir_spring.data.entities.Commande;
import devoir.spring.devoir_spring.services.IClientService;
import devoir.spring.devoir_spring.services.ICommandeService;
import devoir.spring.devoir_spring.web.controllers.IClientController;
import devoir.spring.devoir_spring.web.dto.request.ClientAndCommandeCreateRequest;
import devoir.spring.devoir_spring.web.dto.response.ClientSimpleResponse;
import devoir.spring.devoir_spring.web.dto.response.CommandeSimpleResponse;
import devoir.spring.devoir_spring.web.dto.response.Result;
import lombok.RequiredArgsConstructor;
import lombok.val;

@RestController
@RequiredArgsConstructor
public class ClientController implements IClientController {

    private final IClientService clientService;
    private final ICommandeService commandeService;

    @Override
    public ResponseEntity<ClientSimpleResponse> createClient(ClientAndCommandeCreateRequest client) {
        var data = clientService.create(client.toEntity());
        return new ResponseEntity<>(new ClientSimpleResponse(data), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Result> getClientCommandes(Integer id, int page, int size) {
        var client = clientService.getById(id);
        if (client == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Pageable pageable = PageRequest.of(page, size);
        var commandesPage = commandeService.getClientCommandes(id, pageable);
        var commandes = commandesPage.getContent().stream()
                .map(CommandeSimpleResponse::new)
                .toList();
        var commandeResponse = commandes.stream().map(Result::new).toList();
        return new ResponseEntity<>(commandeResponse, HttpStatus.OK);
    }

}
