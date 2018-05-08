/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Usuari;
import java.io.IOException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author Anjo
 */
@Stateless
public class futsalEJB {

   @PersistenceUnit EntityManagerFactory emf;
public void altaUser(Usuari u)throws IOException{
    
    EntityManager em=emf.createEntityManager();
    Usuari aux=em.find(Usuari.class, u.getUsername());
    if(aux!=null){
    
    em.close();
    throw new IOException("Ya existe un usuario con este nombre");
    
    }
em.persist(u);
em.close();

}


}
