package com.zeyu.dao;

import java.io.Serializable;
import java.util.List;



public interface IBaseDao<T>{
	public void add(T entity);
	public List<Integer> findCountQuestionBank();
	public void delete(T entity) throws Exception;
	public Integer deleteByIds(String user_id) throws Exception;
	public void update(T entity);
	public T findById(java.io.Serializable id);
	public List<T> findAll();
	public List<T> findByProperty(Serializable param);
	public List<T> findAllByPage(int page);
	public List<T> findConditionByPage(int page,String condition);
	public List<T> findBankConditionByPage(int page,String condition);
	public List<T> findFilterConditionByPage(int page,String condition);
	public List<T> findBySearch(String str);
	public List<T> findByIntSearch(int flag,int page);
	public List<T> findByIntSearchExcep(int flag,int page);
	public T  findByIntSearch1(int flag);
	public T  findByIntSearch2(int flag);
	public List<T> findByIntSearchException(int flag);
	public T  findByIntSearch1Exception(int flag);
	public List<T> findBySearch1(String str);
	public List excuteQuery(String sql);
	public int updateSQL(String sql);
	public void attachDirty(T entity);
	public Integer findCount() ;
	public int getFilterQuestionCount(String filterContent);

}