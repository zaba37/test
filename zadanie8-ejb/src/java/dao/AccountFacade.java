/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Account;

/**
 *
 * @author zaba37
 */
@Stateless
@Interceptors({interceptor.class})
public class AccountFacade extends AbstractFacade<Account> implements AccountFacadeRemote {
    @PersistenceContext(unitName = "zadanie8-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccountFacade() {
        super(Account.class);
    }
    
}
