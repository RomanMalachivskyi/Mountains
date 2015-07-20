package com.home.education.mountains.dao.impl;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.google.common.collect.Iterables;
import com.home.education.mountains.dao.CategoryDao;
import com.home.education.mountains.resource.impl.Category;

import java.sql.Connection;

public class CategoryDaoImpl implements CategoryDao {

	public Category getById(int id) {
		Session session = getSessionFactory().openSession();
		//System.out.println(session.load(com.home.education.mountains.resource.impl.Category.class, id));
		session.save(new Category("Captain Nemo","fdfdfd"));
	      
        session.getTransaction().commit();
		//List<Category> category = session.createQuery("from com.home.education.mountains.resource.impl.Category").list();//(Category.class).list();
		session.close();
		//System.out.println("Found " + category.size() );
		return null;
	}


	public Category getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	public static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration
				.buildSessionFactory(builder.build());
		return sessionFactory;
	}
	public void conn() throws SQLException{
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:mysql://localhost:3306/mountains";//"jdbc:mysql://localhost:3306/developers";
		String password = "1111";//"root";
		String userName = "root";
		try {
			conn = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		PreparedStatement	stat = conn.prepareStatement("select * from category");;
		ResultSet rs = stat.executeQuery();
		while(rs.next()){
			System.out.println(rs.getString("name"));
		}
		System.out.println(rs);
	}
}
