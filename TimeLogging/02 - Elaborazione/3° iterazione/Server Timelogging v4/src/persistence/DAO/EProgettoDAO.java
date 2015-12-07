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

import domain.entity.EProgetto;

import java.util.List;

public class EProgettoDAO {
	public static EProgetto loadEProgettoByORMID(int idProgetto) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return loadEProgettoByORMID(session, idProgetto);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EProgetto getEProgettoByORMID(int idProgetto) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return getEProgettoByORMID(session, idProgetto);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EProgetto loadEProgettoByORMID(int idProgetto, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return loadEProgettoByORMID(session, idProgetto, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EProgetto getEProgettoByORMID(int idProgetto, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return getEProgettoByORMID(session, idProgetto, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EProgetto loadEProgettoByORMID(PersistentSession session, int idProgetto) {
		try {
			return (EProgetto) session.load(domain.entity.EProgetto.class, new Integer(idProgetto));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EProgetto getEProgettoByORMID(PersistentSession session, int idProgetto) {
		try {
			return (EProgetto) session.get(domain.entity.EProgetto.class, new Integer(idProgetto));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EProgetto loadEProgettoByORMID(PersistentSession session, int idProgetto, org.hibernate.LockMode lockMode) {
		try {
			return (EProgetto) session.load(domain.entity.EProgetto.class, new Integer(idProgetto), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EProgetto getEProgettoByORMID(PersistentSession session, int idProgetto, org.hibernate.LockMode lockMode) {
		try {
			return (EProgetto) session.get(domain.entity.EProgetto.class, new Integer(idProgetto), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List queryEProgetto(String condition, String orderBy) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return queryEProgetto(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List queryEProgetto(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return queryEProgetto(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EProgetto[] listEProgettoByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return listEProgettoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EProgetto[] listEProgettoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return listEProgettoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List queryEProgetto(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From domain.entity.EProgetto as EProgetto");
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
	
	public static List queryEProgetto(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From domain.entity.EProgetto as EProgetto");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("EProgetto", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EProgetto[] listEProgettoByQuery(PersistentSession session, String condition, String orderBy) {
		try {
			List list = queryEProgetto(session, condition, orderBy);
			return (EProgetto[]) list.toArray(new EProgetto[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EProgetto[] listEProgettoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			List list = queryEProgetto(session, condition, orderBy, lockMode);
			return (EProgetto[]) list.toArray(new EProgetto[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EProgetto loadEProgettoByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return loadEProgettoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EProgetto loadEProgettoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return loadEProgettoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EProgetto loadEProgettoByQuery(PersistentSession session, String condition, String orderBy) {
		EProgetto[] eProgettos = listEProgettoByQuery(session, condition, orderBy);
		if (eProgettos != null && eProgettos.length > 0)
			return eProgettos[0];
		else
			return null;
	}
	
	public static EProgetto loadEProgettoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		EProgetto[] eProgettos = listEProgettoByQuery(session, condition, orderBy, lockMode);
		if (eProgettos != null && eProgettos.length > 0)
			return eProgettos[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateEProgettoByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return iterateEProgettoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateEProgettoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return iterateEProgettoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateEProgettoByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From domain.entity.EProgetto as EProgetto");
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
	
	public static java.util.Iterator iterateEProgettoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From domain.entity.EProgetto as EProgetto");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("EProgetto", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EProgetto createEProgetto() {
		return new domain.entity.EProgetto();
	}
	
	public static boolean save(domain.entity.EProgetto eProgetto) {
		try {
			persistence.DAO.TimeloggingPersistentManager.instance().saveObject(eProgetto);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean delete(domain.entity.EProgetto eProgetto) {
		try {
			persistence.DAO.TimeloggingPersistentManager.instance().deleteObject(eProgetto);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean refresh(domain.entity.EProgetto eProgetto) {
		try {
			persistence.DAO.TimeloggingPersistentManager.instance().getSession().refresh(eProgetto);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean evict(domain.entity.EProgetto eProgetto) {
		try {
			persistence.DAO.TimeloggingPersistentManager.instance().getSession().evict(eProgetto);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
