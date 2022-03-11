/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.util.List;

/**
 *
 * @author vinhn
 */
public abstract class CafeDao<E ,K> {
    abstract public void insert(E entity);
    abstract public void update(E entity);
    abstract public void delete(K id);
    abstract public List<E> selectALL();
    abstract public E selectById(K key);
    abstract protected List<E> selectBySql(String sql,Object...args);
}
