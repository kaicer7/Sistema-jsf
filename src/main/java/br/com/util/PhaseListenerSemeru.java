/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import org.hibernate.Session;

/**
 *
 * @author kaicer
 */
public class PhaseListenerSemeru implements PhaseListener {

 

    @Override
    public void beforePhase(PhaseEvent event) {
        if(event.getPhaseId().equals(PhaseId.RESTORE_VIEW)){
            System.out.println("Antes de fase"+getPhaseId());
            Session session=HibernateUtil1.getSessionFactory().openSession();
            session.beginTransaction();
            FacesContextUtil.setRequestSession(session);
        }
    }
    
       @Override
    public void afterPhase(PhaseEvent event) {
        if(event.getPhaseId().equals(PhaseId.RENDER_RESPONSE)){
            System.out.println("Despues de fase"+getPhaseId());
            Session session=FacesContextUtil.getRequestSession();
            try {
                session.getTransaction().commit();
            } catch (Exception e) {
                if(session.getTransaction().isActive()){
                    session.getTransaction().rollback();
                }
            }finally{
                session.close();
            }
        }
    }

    @Override
    public PhaseId getPhaseId() {
       return PhaseId.ANY_PHASE;
    }
    
}
