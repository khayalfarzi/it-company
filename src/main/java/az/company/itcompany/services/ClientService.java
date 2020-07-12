package az.company.itcompany.services;

import az.company.itcompany.entities.Client;
import az.company.itcompany.repository.ClientRepo;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientRepo clientRepo;

    public ClientService(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    public void save(Client client){
        clientRepo.save(client);
    }
}
