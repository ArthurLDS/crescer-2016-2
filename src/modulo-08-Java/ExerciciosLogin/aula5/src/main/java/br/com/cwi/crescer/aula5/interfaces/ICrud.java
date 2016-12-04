package br.com.cwi.crescer.aula5.interfaces;

import java.util.List;

/**
 * @author Carlos H. Nonnemacher
 * @param <T>
 * @param <ID>
 */
public interface ICrud<T, ID, Nome> {

    void insert(T t);
    
    void delete(T t);
    
    T find(ID id);
    
    List<T> findAll();
    
    boolean findByUsername(Nome n);
}
