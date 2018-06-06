package com.doruleanu.Service;

import com.doruleanu.Entity.Client;


public interface IClientService {
	

	Client getClientById(Integer id);
    
    void removeClientById(Integer id);

    void insertClientNou(Client client);

	void updateClient(Client client);



}
