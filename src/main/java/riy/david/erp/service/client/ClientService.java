package riy.david.erp.service.client;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import riy.david.erp.model.Client;
import riy.david.erp.repository.ClientRepository;
import riy.david.erp.repository.ClientRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ClientService {

    private final ClientRepository clientRepository;

    public Client addClient(Client client){
        clientRepository.save(client);
        return client;
    }

    public Client updateClient(Client client) {
        Client savedClient = clientRepository.findById(client.getId())
                .orElseThrow( () -> new RuntimeException(
                        String.format("Cannot find Employee by ID %s", client.getId())));
        savedClient.setId(client.getId());
        savedClient.setName(client.getName());
        savedClient.setLast_name(client.getLast_name());
        savedClient.setBuy_list(client.getBuy_list());
        return clientRepository.save(savedClient);
    }

    public ResponseEntity<List<Client>> getAllClients() {
        return ResponseEntity.ok(clientRepository.findAll());
    }

    public Client getClientById(String id) {
        return clientRepository.findById(id)
                .orElseThrow( () -> new RuntimeException(
                        String.format("Cannot find Client by id %s", id)
                ));
    }

    public void deleteClient(String id) {
        clientRepository.deleteById(id);
    }
}
