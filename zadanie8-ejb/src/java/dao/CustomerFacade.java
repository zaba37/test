/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.interceptor.Interceptors;
import model.Customer;


/**
 *
 * @author zaba37
 */
@Stateless
@Interceptors({interceptor.class})
public class CustomerFacade extends AbstractFacade<Customer> implements dao.CustomerFacadeRemote {
    @PersistenceContext(unitName = "zadanie8-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerFacade() {
        super(Customer.class);
    }
    
}
