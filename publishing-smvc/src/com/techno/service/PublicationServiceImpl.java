package com.techno.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.techno.bean.PublicationBean;
import com.techno.dao.PublicationDao;

@Service("publicationService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PublicationServiceImpl implements PublicationService {

	@Autowired
	private PublicationDao publicationDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addPublication(PublicationBean publicationBean) {
		publicationDao.addPublication(publicationBean);
	}

	public List<PublicationBean> getPublications() {
		return publicationDao.getPublications();
	}

	@Override
	public PublicationBean getPublication(int pubId) {
		return publicationDao.getPublication(pubId);
	}

	@Override
	public void deletePublication(int pubId) {
		publicationDao.deletePublication(pubId);
	}

}
