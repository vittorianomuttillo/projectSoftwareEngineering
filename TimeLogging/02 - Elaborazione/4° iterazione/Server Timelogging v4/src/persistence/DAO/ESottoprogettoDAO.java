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

import domain.entity.ESottoprogetto;

import java.util.List;

public class ESottoprogettoDAO {
	public static ESottoprogetto loadESottoprogettoByORMID(int idSottoprogetto) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return loadESottoprogettoByORMID(session, idSottoprogetto);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ESottoprogetto getESottoprogettoByORMID(int idSottoprogetto) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return getESottoprogettoByORMID(session, idSottoprogetto);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ESottoprogetto loadESottoprogettoByORMID(int idSottoprogetto, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return loadESottoprogettoByORMID(session, idSottoprogetto, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ESottoprogetto getESottoprogettoByORMID(int idSottoprogetto, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return getESottoprogettoByORMID(session, idSottoprogetto, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ESottoprogetto loadESottoprogettoByORMID(PersistentSession session, int idSottoprogetto) {
		try {
			return (ESottoprogetto) session.load(domain.entity.ESottoprogetto.class, new Integer(idSottoprogetto));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ESottoprogetto getESottoprogettoByORMID(PersistentSession session, int idSottoprogetto) {
		try {
			return (ESottoprogetto) session.get(domain.entity.ESottoprogetto.class, new Integer(idSottoprogetto));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ESottoprogetto loadESottoprogettoByORMID(PersistentSession session, int idSottoprogetto, org.hibernate.LockMode lockMode) {
		try {
			return (ESottoprogetto) session.load(domain.entity.ESottoprogetto.class, new Integer(idSottoprogetto), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ESottoprogetto getESottoprogettoByORMID(PersistentSession session, int idSottoprogetto, org.hibernate.LockMode lockMode) {
		try {
			return (ESottoprogetto) session.get(domain.entity.ESottoprogetto.class, new Integer(idSottoprogetto), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List queryESottoprogetto(String condition, String orderBy) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return queryESottoprogetto(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List queryESottoprogetto(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return queryESottoprogetto(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ESottoprogetto[] listESottoprogettoByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return listESottoprogettoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ESottoprogetto[] listESottoprogettoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return listESottoprogettoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List queryESottoprogetto(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From domain.entity.ESottoprogetto as ESottoprogetto");
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
	
	public static List queryESottoprogetto(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From domain.entity.ESottoprogetto as ESottoprogetto");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("ESottoprogetto", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ESottoprogetto[] listESottoprogettoByQuery(PersistentSession session, String condition, String orderBy) {
		try {
			List list = queryESottoprogetto(session, condition, orderBy);
			return (ESottoprogetto[]) list.toArray(new ESottoprogetto[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ESottoprogetto[] listESottoprogettoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			List list = queryESottoprogetto(session, condition, orderBy, lockMode);
			return (ESottoprogetto[]) list.toArray(new ESottoprogetto[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ESottoprogetto loadESottoprogettoByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return loadESottoprogettoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ESottoprogetto loadESottoprogettoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return loadESottoprogettoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ESottoprogetto loadESottoprogettoByQuery(PersistentSession session, String condition, String orderBy) {
		ESottoprogetto[] eSottoprogettos = listESottoprogettoByQuery(session, condition, orderBy);
		if (eSottoprogettos != null && eSottoprogettos.length > 0)
			return eSottoprogettos[0];
		else
			return null;
	}
	
	public static ESottoprogetto loadESottoprogettoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		ESottoprogetto[] eSottoprogettos = listESottoprogettoByQuery(session, condition, orderBy, lockMode);
		if (eSottoprogettos != null && eSottoprogettos.length > 0)
			return eSottoprogettos[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateESottoprogettoByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return iterateESottoprogettoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateESottoprogettoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return iterateESottoprogettoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateESottoprogettoByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From domain.entity.ESottoprogetto as ESottoprogetto");
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
	
	public static java.util.Iterator iterateESottoprogettoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From domain.entity.ESottoprogetto as ESottoprogetto");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("ESottoprogetto", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ESottoprogetto createESottoprogetto() {
		return new domain.entity.ESottoprogetto();
	}
	
	public static boolean save(domain.entity.ESottoprogetto eSottoprogetto) {
		try {
			persistence.DAO.TimeloggingPersistentManager.instance().saveObject(eSottoprogetto);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean delete(domain.entity.ESottoprogetto eSottoprogetto) {
		try {
			persistence.DAO.TimeloggingPersistentManager.instance().deleteObject(eSottoprogetto);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean refresh(domain.entity.ESottoprogetto eSottoprogetto) {
		try {
			persistence.DAO.TimeloggingPersistentManager.instance().getSession().refresh(eSottoprogetto);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean evict(domain.entity.ESottoprogetto eSottoprogetto) {
		try {
			persistence.DAO.TimeloggingPersistentManager.instance().getSession().evict(eSottoprogetto);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
