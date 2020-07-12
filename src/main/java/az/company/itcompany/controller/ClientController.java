package az.company.itcompany.controller;

import az.company.itcompany.entities.Client;
import az.company.itcompany.services.ClientService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/client/save")
    public void save(@RequestBody Client client) {
        clientService.save(client);
    }
}
