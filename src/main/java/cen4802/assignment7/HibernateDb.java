package cen4802.assignment7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Class that interfaces with a local MySQL database for use with the ToDoItem class
 * @author Sam
 *
 */
public class HibernateDb {
	private static Configuration config;
	private static ServiceRegistry reg;
	private static SessionFactory sf;
	private static Session session;
	
	public HibernateDb() {
		config = new Configuration().configure().addAnnotatedClass(ToDoItem.class);
		reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		sf = config.buildSessionFactory(reg);
	}
	
	/**
	 * Adds an item to the database
	 * @param item ToDoItem to be added
	 * @return True if added successfully, false if it fails
	 */
	@SuppressWarnings("deprecation")
	public boolean addItem(ToDoItem item) {
		boolean success = false;
		session = sf.openSession();
		
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(item);
			tx.commit();
			success = true;
		} catch (Exception e) {
			if (tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return success;
	}
	
	/**
	 * Removes an item from the database
	 * @param s Task to be added
	 * @return True if removed successfully, false if it fails
	 */
	@SuppressWarnings("deprecation")
	public boolean removeItem(String s) {
		boolean success = false;
		session = sf.openSession();
		
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			@SuppressWarnings({ "rawtypes" })
			List results = session.createQuery("FROM ToDoList").list();
			ToDoItem item = null;
			for (Iterator<?> iterator = results.iterator(); iterator.hasNext();) {
				item = (ToDoItem)iterator.next();
				if (s.equals(item.getTask())) {
					session.delete(item);
					tx.commit();
				}
			}
			success = true;
		} catch (Exception e) {
			if (tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		
		return success;
	}
	
	/**
	 * Queries the database for a current list of ToDoItems
	 * @return an ArrayList of the results
	 */
	public ArrayList<ToDoItem> updateList() {
		ArrayList<ToDoItem> newList = new ArrayList<ToDoItem>();
		session = sf.openSession();
		
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			@SuppressWarnings({ "deprecation", "rawtypes" })
			List results = session.createQuery("FROM ToDoList").list();
			for (Iterator<?> iterator = results.iterator(); iterator.hasNext();) {
				ToDoItem item = (ToDoItem) iterator.next();
				newList.add(item);
			}
		} catch (HibernateException e) {
			if (tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return newList;
	}

}
