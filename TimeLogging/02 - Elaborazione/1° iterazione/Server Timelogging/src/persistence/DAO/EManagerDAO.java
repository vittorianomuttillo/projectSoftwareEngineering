/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Universita degli Studi dell'Aquila
 * License Type: Academic
 */
package persistence.DAO;

import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;

import domain.entity.EManager;

import java.util.List;

public class EManagerDAO {
	public static EManager loadEManagerByORMID(int idManager) {
		try {
			PersistentSession session = persistence.DAO.TimelogginPersistentManager.instance().getSession();
			return loadEManagerByORMID(session, idManager);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EManager getEManagerByORMID(int idManager) {
		try {
			PersistentSession session = persistence.DAO.TimelogginPersistentManager.instance().getSession();
			return getEManagerByORMID(session, idManager);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EManager loadEManagerByORMID(int idManager, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimelogginPersistentManager.instance().getSession();
			return loadEManagerByORMID(session, idManager, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EManager getEManagerByORMID(int idManager, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimelogginPersistentManager.instance().getSession();
			return getEManagerByORMID(session, idManager, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EManager loadEManagerByORMID(PersistentSession session, int idManager) {
		try {
			return (EManager) session.load(domain.entity.EManager.class, new Integer(idManager));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EManager getEManagerByORMID(PersistentSession session, int idManager) {
		try {
			return (EManager) session.get(domain.entity.EManager.class, new Integer(idManager));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EManager loadEManagerByORMID(PersistentSession session, int idManager, org.hibernate.LockMode lockMode) {
		try {
			return (EManager) session.load(domain.entity.EManager.class, new Integer(idManager), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EManager getEManagerByORMID(PersistentSession session, int idManager, org.hibernate.LockMode lockMode) {
		try {
			return (EManager) session.get(domain.entity.EManager.class, new Integer(idManager), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List queryEManager(String condition, String orderBy) {
		try {
			PersistentSession session = persistence.DAO.TimelogginPersistentManager.instance().getSession();
			return queryEManager(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List queryEManager(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimelogginPersistentManager.instance().getSession();
			return queryEManager(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EManager[] listEManagerByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = persistence.DAO.TimelogginPersistentManager.instance().getSession();
			return listEManagerByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EManager[] listEManagerByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimelogginPersistentManager.instance().getSession();
			return listEManagerByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List queryEManager(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From domain.entity.EManager as EManager");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List queryEManager(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From domain.entity.EManager as EManager");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("EManager", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EManager[] listEManagerByQuery(PersistentSession session, String condition, String orderBy) {
		try {
			List list = queryEManager(session, condition, orderBy);
			return (EManager[]) list.toArray(new EManager[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EManager[] listEManagerByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			List list = queryEManager(session, condition, orderBy, lockMode);
			return (EManager[]) list.toArray(new EManager[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EManager loadEManagerByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = persistence.DAO.TimelogginPersistentManager.instance().getSession();
			return loadEManagerByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EManager loadEManagerByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimelogginPersistentManager.instance().getSession();
			return loadEManagerByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EManager loadEManagerByQuery(PersistentSession session, String condition, String orderBy) {
		EManager[] eManagers = listEManagerByQuery(session, condition, orderBy);
		if (eManagers != null && eManagers.length > 0)
			return eManagers[0];
		else
			return null;
	}
	
	public static EManager loadEManagerByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		EManager[] eManagers = listEManagerByQuery(session, condition, orderBy, lockMode);
		if (eManagers != null && eManagers.length > 0)
			return eManagers[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateEManagerByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = persistence.DAO.TimelogginPersistentManager.instance().getSession();
			return iterateEManagerByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateEManagerByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimelogginPersistentManager.instance().getSession();
			return iterateEManagerByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateEManagerByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From domain.entity.EManager as EManager");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateEManagerByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From domain.entity.EManager as EManager");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("EManager", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EManager createEManager() {
		return new domain.entity.EManager();
	}
	
	public static boolean save(domain.entity.EManager eManager) {
		try {
			persistence.DAO.TimelogginPersistentManager.instance().saveObject(eManager);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean delete(domain.entity.EManager eManager) {
		try {
			persistence.DAO.TimelogginPersistentManager.instance().deleteObject(eManager);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean refresh(domain.entity.EManager eManager) {
		try {
			persistence.DAO.TimelogginPersistentManager.instance().getSession().refresh(eManager);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean evict(domain.entity.EManager eManager) {
		try {
			persistence.DAO.TimelogginPersistentManager.instance().getSession().evict(eManager);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
