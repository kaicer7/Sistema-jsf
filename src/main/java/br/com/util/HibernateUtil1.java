/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.util;



import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author kaicer
 */
public class HibernateUtil1 {

    private static final SessionFactory sessionFactory;
    public static final String HIBERNATE_SESSION="hibernate_session";
    
    static {
        try {
            Configuration configuration=new Configuration().configure();
            ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().
                    applySettings(configuration.getProperties()).build();
            
                    
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            System.out.println("Session factory creada");
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
