package com.doruleanu.Service;

import com.doruleanu.Entity.Client;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IClientService {
	
	Page<Client> listAllByPage(Pageable pageable);

	Client getClientById(Integer id);
    
    void removeClientById(Integer id);

    void insertClientNou(Client client);

	void updateClient(Client client);

	Page<Client> getClientByName(String nume, Pageable pageable);


}
