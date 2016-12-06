package com.zeyu.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zeyu.dao.IBaseDao;
import com.zeyu.dao.IBaseHibernateDAO;

public class BaseDaoImpl<T> implements IBaseDao<T>, IBaseHibernateDAO {
	private Class<T> cls;
	@Resource
	protected SessionFactory sessionFactory;

	@Resource
	protected JdbcTemplate jdbcTemplate;

	public BaseDaoImpl(Class<T> cls) {
		this.cls = cls;
	}

	public List excuteQuery(String sql) {
		List<Map<String, Object>> mapList = (List<Map<String, Object>>) jdbcTemplate.queryForList(sql);
		return mapList;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public int updateSQL(String sql) {
		int count = jdbcTemplate.update(sql);
		return count;
	}

	public void add(T entity) {
		try {
			getSession().save(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void attachDirty(T entity) {
		try {
			getSession().saveOrUpdate(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(T entity) {
		try {
			getSession().delete(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Integer deleteByIds(String str) {
		int result = 0;
		try {
			result = getSession().createQuery("delete from " + cls.getName() + " data where  " + str)
					.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

	public void update(T entity) {
		try {
			getSession().update(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	public T findById(Serializable id) {
		T t = null;
		try {
			t = (T) getSession().get(cls, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;

	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		List<T> list = null;
		try {
			Query query = getSession().createQuery("from " + cls.getName());
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<T> findByProperty(Serializable param) {
		String queryString = "from " + cls.getName() + " as model where " + param;
		Query queryObject = getSession().createQuery(queryString);
		return queryObject.list();
	}

	public Integer findCount() {
		int temp = -1;
		try {
			Query query = getSession().createQuery("from " + cls.getName());
			temp = query.list().size();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp;
	}
	public List<Integer> findCountQuestionBank() {
		int temp = -1;
		List<Integer> tempList = new ArrayList<Integer>();
		try {
			for(int a =0;a<3;a++){
				Query query = getSession().createQuery("from " + cls.getName()+ " as model where  questionbank_scope="+a );
				temp = query.list().size();
				tempList.add(temp);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempList;
	
}

	@SuppressWarnings("unchecked")
	public List<T> findAllByPage(int page) {
		List<T> list = null;
		try {
			Query query = getSession().createQuery("from " + cls.getName());
			if (page == -1) {

			} else {
				query.setFirstResult((page - 1) * 10);
				query.setMaxResults((page - 1) * 10 + 10);
			}
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<T> findBySearch(String str) {
		List<T> list = null;
		try {
			String sql="from " + cls.getName() +"join t_user on(t_user.user_id=t_answer.user_id)"+
					"where question_id="+str+" order by user_kind ,recommend,answer_votes";
			Query query = getSession().createQuery("from " + cls.getName() + " where " + str+"order by recommend desc,answer_votes desc");
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<T> findBySearch1(String str) {
		List<T> list = null;
		try {
			String sql="from " + cls.getName()+
					"where article_id="+str+" order by article_user_kind ";
			Query query = getSession().createQuery("from " + cls.getName() + " where " + str);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<T> findConditionByPage(int page, String condition) {
		List<T> list = new ArrayList<>();
		try {
			list.clear();
			Query query = getSession().createQuery("from " + cls.getName()+" "+condition);
			if (page == -1) {

			} else {
				query.setFirstResult((page - 1) * 10);
				query.setMaxResults(10);
			}
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<T> findBankConditionByPage(int page, String condition) {
		List<T> list = new ArrayList<>();
		try {
			list.clear();
			Query query = getSession().createQuery("from " + cls.getName()+" where "+condition);
			if (page == -1) {

			} else {
				query.setFirstResult((page - 1) * 10);
				query.setMaxResults(10);
			}
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<T> findFilterConditionByPage(int page, String condition) {
		List<T> list = new ArrayList<>();
		try {
			list.clear();
			Query query = getSession().createQuery("from " + cls.getName() +" as model where " + condition);
			if (page == -1) {

			} else {
				query.setFirstResult((page - 1) * 10);
				query.setMaxResults(10);
			}
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int getFilterQuestionCount(String condition) {
		int temp = -1;
		try {
			Query query = getSession().createQuery("from " + cls.getName() +" as model where " + condition);
			return query.list().size();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp;
	}



}
