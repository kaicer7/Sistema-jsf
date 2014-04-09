/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;

/**
 *
 * @author kaicer
 */
public interface InterfaceDAO<T> {

    void save(T entity);

    void update(T entity);

    void romove(T entity);

    void merge(T entity);

    T gentEntity(Serializable id);

    T getEntityByDatachedCriteria(DetachedCriteria criteria);

    List<T> getEntities();

    List<T> getListByDatachedCriteria(DetachedCriteria criteria);
}
