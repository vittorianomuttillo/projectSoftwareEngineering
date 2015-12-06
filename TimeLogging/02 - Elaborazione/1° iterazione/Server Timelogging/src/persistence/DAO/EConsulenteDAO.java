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

import domain.entity.EConsulente;

import java.util.List;

public class EConsulenteDAO {
	public static EConsulente loadEConsulenteByORMID(int idConsulente) {
		try {
			PersistentSession session = persistence.DAO.TimelogginPersistentManager.instance().getSession();
			return loadEConsulenteByORMID(session, idConsulente);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EConsulente getEConsulenteByORMID(int idConsulente) {
		try {
			PersistentSession session = persistence.DAO.TimelogginPersistentManager.instance().getSession();
			return getEConsulenteByORMID(session, idConsulente);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EConsulente loadEConsulenteByORMID(int idConsulente, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimelogginPersistentManager.instance().getSession();
			return loadEConsulenteByORMID(session, idConsulente, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EConsulente getEConsulenteByORMID(int idConsulente, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimelogginPersistentManager.instance().getSession();
			return getEConsulenteByORMID(session, idConsulente, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EConsulente loadEConsulenteByORMID(PersistentSession session, int idConsulente) {
		try {
			return (EConsulente) session.load(domain.entity.EConsulente.class, new Integer(idConsulente));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EConsulente getEConsulenteByORMID(PersistentSession session, int idConsulente) {
		try {
			return (EConsulente) session.get(domain.entity.EConsulente.class, new Integer(idConsulente));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EConsulente loadEConsulenteByORMID(PersistentSession session, int idConsulente, org.hibernate.LockMode lockMode) {
		try {
			return (EConsulente) session.load(domain.entity.EConsulente.class, new Integer(idConsulente), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EConsulente getEConsulenteByORMID(PersistentSession session, int idConsulente, org.hibernate.LockMode lockMode) {
		try {
			return (EConsulente) session.get(domain.entity.EConsulente.class, new Integer(idConsulente), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List queryEConsulente(String condition, String orderBy) {
		try {
			PersistentSession session = persistence.DAO.TimelogginPersistentManager.instance().getSession();
			return queryEConsulente(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List queryEConsulente(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimelogginPersistentManager.instance().getSession();
			return queryEConsulente(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EConsulente[] listEConsulenteByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = persistence.DAO.TimelogginPersistentManager.instance().getSession();
			return listEConsulenteByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EConsulente[] listEConsulenteByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimelogginPersistentManager.instance().getSession();
			return listEConsulenteByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List queryEConsulente(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From domain.entity.EConsulente as EConsulente");
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
	
	public static List queryEConsulente(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From domain.entity.EConsulente as EConsulente");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("EConsulente", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EConsulente[] listEConsulenteByQuery(PersistentSession session, String condition, String orderBy) {
		try {
			List list = queryEConsulente(session, condition, orderBy);
			return (EConsulente[]) list.toArray(new EConsulente[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EConsulente[] listEConsulenteByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			List list = queryEConsulente(session, condition, orderBy, lockMode);
			return (EConsulente[]) list.toArray(new EConsulente[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EConsulente loadEConsulenteByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = persistence.DAO.TimelogginPersistentManager.instance().getSession();
			return loadEConsulenteByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EConsulente loadEConsulenteByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimelogginPersistentManager.instance().getSession();
			return loadEConsulenteByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EConsulente loadEConsulenteByQuery(PersistentSession session, String condition, String orderBy) {
		EConsulente[] eConsulentes = listEConsulenteByQuery(session, condition, orderBy);
		if (eConsulentes != null && eConsulentes.length > 0)
			return eConsulentes[0];
		else
			return null;
	}
	
	public static EConsulente loadEConsulenteByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		EConsulente[] eConsulentes = listEConsulenteByQuery(session, condition, orderBy, lockMode);
		if (eConsulentes != null && eConsulentes.length > 0)
			return eConsulentes[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateEConsulenteByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = persistence.DAO.TimelogginPersistentManager.instance().getSession();
			return iterateEConsulenteByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateEConsulenteByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimelogginPersistentManager.instance().getSession();
			return iterateEConsulenteByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateEConsulenteByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From domain.entity.EConsulente as EConsulente");
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
	
	public static java.util.Iterator iterateEConsulenteByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From domain.entity.EConsulente as EConsulente");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("EConsulente", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EConsulente createEConsulente() {
		return new domain.entity.EConsulente();
	}
	
	public static boolean save(domain.entity.EConsulente eConsulente) {
		try {
			persistence.DAO.TimelogginPersistentManager.instance().saveObject(eConsulente);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean delete(domain.entity.EConsulente eConsulente) {
		try {
			persistence.DAO.TimelogginPersistentManager.instance().deleteObject(eConsulente);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean refresh(domain.entity.EConsulente eConsulente) {
		try {
			persistence.DAO.TimelogginPersistentManager.instance().getSession().refresh(eConsulente);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean evict(domain.entity.EConsulente eConsulente) {
		try {
			persistence.DAO.TimelogginPersistentManager.instance().getSession().evict(eConsulente);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
