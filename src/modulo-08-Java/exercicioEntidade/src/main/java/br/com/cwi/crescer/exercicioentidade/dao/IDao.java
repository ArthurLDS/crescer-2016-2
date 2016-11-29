package br.com.cwi.crescer.exercicioentidade.dao;

import java.util.List;

public interface IDao <T, ID> {
    
    void insert(T t);
    
    void delete(T t);
    
    void update(T t);
    
    List<T> list();
}
