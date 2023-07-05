package com.techno.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.techno.bean.PublicationBean;

@Component
@Repository("publicationDao")
public class PublicationDaoImpl implements PublicationDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addPublication(PublicationBean publicationBean) {
		sessionFactory.getCurrentSession().saveOrUpdate(publicationBean);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PublicationBean> getPublications() {
		return (List<PublicationBean>) sessionFactory.getCurrentSession().createCriteria(PublicationBean.class).list();
	}

	@Override
	public PublicationBean getPublication(int pubId) {
		return (PublicationBean) sessionFactory.getCurrentSession().get(PublicationBean.class, pubId);
	}

	@Override
	public void deletePublication(int pubId) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Publication WHERE pubId = "+pubId).executeUpdate();
	}

}
