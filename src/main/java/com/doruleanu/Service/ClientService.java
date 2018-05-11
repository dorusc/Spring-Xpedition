package com.doruleanu.Service;


import com.doruleanu.Entity.Client;
import com.doruleanu.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import javax.persistence.EntityManager;



@Service
public class ClientService implements IClientService {

    @Autowired
    private ClientRepository clientRepo;
    
    @Autowired
    private EntityManager eman;

/*    @Override
    public  Page<Client> listAllByPage(Pageable pageable) {
    	return clientRepo.findAll(pageable);
	}
*/

	@Override
    public Client getClientById(Integer id){
    	return eman.find(Client.class, id);
    }
    
/*    @SuppressWarnings("unchecked")
	@Override
    public Page<Client> getClientByName(String nume, Pageable pageable){
    	String hql = "FROM Client as cli where cli.nume like :nume order by nume, id";
        List<Client> clienti = eman.createQuery(hql).setParameter("nume", "%"+nume+"%").getResultList();
        Page<Client> pages = new PageImpl<Client>(clienti, pageable, clienti.size());
		return pages;
    }
*/
    @Override
    public void removeClientById(Integer id) {
        clientRepo.deleteById(id);
    }

    @Override
    public void updateClient(Client client) {
        clientRepo.save(client);
    }

    @Override
    public void insertClientNou(Client client) {
       clientRepo.save(client);
    }


}
