package riy.david.erp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import riy.david.erp.model.Client;
import riy.david.erp.service.client.ClientService;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping("/add")
    public ResponseEntity<Client> addClient(@RequestBody Client client){
        Client newClient = clientService.addClient(client);
        return new ResponseEntity<>(newClient, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateClient(@RequestBody Client client) {
        Client updatedClient = clientService.updateClient(client);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/all")
    public ResponseEntity getAllClients() {
        return ResponseEntity.ok(clientService.getAllClients());
    }

    @GetMapping("/find/{document}")
    public ResponseEntity getClientById(@PathVariable String id) {
        return ResponseEntity.ok(clientService.getClientById(id));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteClient(@PathVariable String id) {
        clientService.deleteClient(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
