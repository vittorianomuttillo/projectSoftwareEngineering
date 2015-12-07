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

import domain.entity.EMarketing;

import java.util.List;

public class EMarketingDAO {
	public static EMarketing loadEMarketingByORMID(int ID) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return loadEMarketingByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EMarketing getEMarketingByORMID(int ID) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return getEMarketingByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EMarketing loadEMarketingByORMID(int ID, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return loadEMarketingByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EMarketing getEMarketingByORMID(int ID, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return getEMarketingByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EMarketing loadEMarketingByORMID(PersistentSession session, int ID) {
		try {
			return (EMarketing) session.load(domain.entity.EMarketing.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EMarketing getEMarketingByORMID(PersistentSession session, int ID) {
		try {
			return (EMarketing) session.get(domain.entity.EMarketing.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EMarketing loadEMarketingByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) {
		try {
			return (EMarketing) session.load(domain.entity.EMarketing.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EMarketing getEMarketingByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) {
		try {
			return (EMarketing) session.get(domain.entity.EMarketing.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List queryEMarketing(String condition, String orderBy) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return queryEMarketing(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List queryEMarketing(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return queryEMarketing(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EMarketing[] listEMarketingByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return listEMarketingByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EMarketing[] listEMarketingByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return listEMarketingByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List queryEMarketing(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From domain.entity.EMarketing as EMarketing");
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
	
	public static List queryEMarketing(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From domain.entity.EMarketing as EMarketing");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("EMarketing", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EMarketing[] listEMarketingByQuery(PersistentSession session, String condition, String orderBy) {
		try {
			List list = queryEMarketing(session, condition, orderBy);
			return (EMarketing[]) list.toArray(new EMarketing[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EMarketing[] listEMarketingByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			List list = queryEMarketing(session, condition, orderBy, lockMode);
			return (EMarketing[]) list.toArray(new EMarketing[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EMarketing loadEMarketingByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return loadEMarketingByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EMarketing loadEMarketingByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return loadEMarketingByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EMarketing loadEMarketingByQuery(PersistentSession session, String condition, String orderBy) {
		EMarketing[] eMarketings = listEMarketingByQuery(session, condition, orderBy);
		if (eMarketings != null && eMarketings.length > 0)
			return eMarketings[0];
		else
			return null;
	}
	
	public static EMarketing loadEMarketingByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		EMarketing[] eMarketings = listEMarketingByQuery(session, condition, orderBy, lockMode);
		if (eMarketings != null && eMarketings.length > 0)
			return eMarketings[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateEMarketingByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return iterateEMarketingByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateEMarketingByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return iterateEMarketingByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateEMarketingByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From domain.entity.EMarketing as EMarketing");
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
	
	public static java.util.Iterator iterateEMarketingByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From domain.entity.EMarketing as EMarketing");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("EMarketing", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EMarketing createEMarketing() {
		return new domain.entity.EMarketing();
	}
	
	public static boolean save(domain.entity.EMarketing eMarketing) {
		try {
			persistence.DAO.TimeloggingPersistentManager.instance().saveObject(eMarketing);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean delete(domain.entity.EMarketing eMarketing) {
		try {
			persistence.DAO.TimeloggingPersistentManager.instance().deleteObject(eMarketing);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean refresh(domain.entity.EMarketing eMarketing) {
		try {
			persistence.DAO.TimeloggingPersistentManager.instance().getSession().refresh(eMarketing);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean evict(domain.entity.EMarketing eMarketing) {
		try {
			persistence.DAO.TimeloggingPersistentManager.instance().getSession().evict(eMarketing);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
