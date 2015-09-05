package com.home.education.mountains.dao.impl;

import java.util.Collection;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.home.education.mountains.dao.MountainDao;
import com.home.education.mountains.resource.impl.Mountain;

@Repository("mountainDao")
public class MountainDaoImpl extends ReadWriteGenericDaoImpl<Mountain> implements MountainDao {

	public final static String TABLE_NAME = "Mountain";
	
	public MountainDaoImpl() {
		super(TABLE_NAME);
	}
	
	@Override
	public Collection<Mountain> getByName(String name) {
		return (Collection<Mountain>) getHibernateTemplate()
				.find("from " + tableName + " where name=?", name);
	}

	@Override
	public Collection<Mountain> getViaLocationIds(Collection<Integer> locationIds) {
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("locationId", locationIds);
		//Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(buildSql(mapSqlParameterSource));
		return (Collection<Mountain>)  getHibernateTemplate().find(buildSql(mapSqlParameterSource));
	}
}
