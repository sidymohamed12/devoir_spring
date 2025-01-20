package devoir.spring.devoir_spring.web.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import devoir.spring.devoir_spring.web.dto.request.ClientAndCommandeCreateRequest;
import devoir.spring.devoir_spring.web.dto.response.ClientSimpleResponse;
import devoir.spring.devoir_spring.web.dto.response.Result;

@RequestMapping("/client")
public interface IClientController {

    @PostMapping("/commande")
    ResponseEntity<ClientSimpleResponse> createClient(@RequestBody ClientAndCommandeCreateRequest client);

    @GetMapping("/{id}/commandes")
    ResponseEntity<Result> getClientCommandes(@PathVariable Integer id,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size);
    // ResponseEntity<ClientWithCommandeResponse> getCientWithCommande(@PathVariable
    // Integer id);
}
