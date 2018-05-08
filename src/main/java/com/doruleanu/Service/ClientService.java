package com.doruleanu.Service;


import com.doruleanu.Entity.Client;
import com.doruleanu.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Service
public class ClientService implements IClientService {

    @Autowired
    private ClientRepository clientDao;
    
    @PersistenceContext
    private EntityManager eman;

    @Override
    public  Page<Client> listAllByPage(Pageable pageable) {
    	return clientDao.findAll(pageable);
	}


	@Override
    public Client getClientById(Integer id){
    	return eman.find(Client.class, id);
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public Page<Client> getClientByName(String nume, Pageable pageable){
    	String hql = "FROM Client as cli where cli.nume like :nume order by nume, id";
        List<Client> clienti = eman.createQuery(hql).setParameter("nume", "%"+nume+"%").getResultList();
        Page<Client> pages = new PageImpl<Client>(clienti, pageable, clienti.size());
		return pages;
    }

    @Override
    public void removeClientById(Integer id) {
        clientDao.deleteById(id);
    }

    @Override
    public void updateClient(Client client) {
        clientDao.save(client);
    }

    @Override
    public void insertClientNou(Client client) {
       clientDao.save(client);
    }


}
