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

import domain.entity.EAzienda;

import java.util.List;

public class EAziendaDAO {
	public static EAzienda loadEAziendaByORMID(String nomeAzienda) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return loadEAziendaByORMID(session, nomeAzienda);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EAzienda getEAziendaByORMID(String nomeAzienda) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return getEAziendaByORMID(session, nomeAzienda);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EAzienda loadEAziendaByORMID(String nomeAzienda, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return loadEAziendaByORMID(session, nomeAzienda, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EAzienda getEAziendaByORMID(String nomeAzienda, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return getEAziendaByORMID(session, nomeAzienda, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EAzienda loadEAziendaByORMID(PersistentSession session, String nomeAzienda) {
		try {
			return (EAzienda) session.load(domain.entity.EAzienda.class, nomeAzienda);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EAzienda getEAziendaByORMID(PersistentSession session, String nomeAzienda) {
		try {
			return (EAzienda) session.get(domain.entity.EAzienda.class, nomeAzienda);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EAzienda loadEAziendaByORMID(PersistentSession session, String nomeAzienda, org.hibernate.LockMode lockMode) {
		try {
			return (EAzienda) session.load(domain.entity.EAzienda.class, nomeAzienda, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EAzienda getEAziendaByORMID(PersistentSession session, String nomeAzienda, org.hibernate.LockMode lockMode) {
		try {
			return (EAzienda) session.get(domain.entity.EAzienda.class, nomeAzienda, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List queryEAzienda(String condition, String orderBy) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return queryEAzienda(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List queryEAzienda(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return queryEAzienda(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EAzienda[] listEAziendaByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return listEAziendaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EAzienda[] listEAziendaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return listEAziendaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List queryEAzienda(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From domain.entity.EAzienda as EAzienda");
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
	
	public static List queryEAzienda(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From domain.entity.EAzienda as EAzienda");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("EAzienda", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EAzienda[] listEAziendaByQuery(PersistentSession session, String condition, String orderBy) {
		try {
			List list = queryEAzienda(session, condition, orderBy);
			return (EAzienda[]) list.toArray(new EAzienda[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EAzienda[] listEAziendaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			List list = queryEAzienda(session, condition, orderBy, lockMode);
			return (EAzienda[]) list.toArray(new EAzienda[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EAzienda loadEAziendaByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return loadEAziendaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EAzienda loadEAziendaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return loadEAziendaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EAzienda loadEAziendaByQuery(PersistentSession session, String condition, String orderBy) {
		EAzienda[] eAziendas = listEAziendaByQuery(session, condition, orderBy);
		if (eAziendas != null && eAziendas.length > 0)
			return eAziendas[0];
		else
			return null;
	}
	
	public static EAzienda loadEAziendaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		EAzienda[] eAziendas = listEAziendaByQuery(session, condition, orderBy, lockMode);
		if (eAziendas != null && eAziendas.length > 0)
			return eAziendas[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateEAziendaByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return iterateEAziendaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateEAziendaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return iterateEAziendaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateEAziendaByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From domain.entity.EAzienda as EAzienda");
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
	
	public static java.util.Iterator iterateEAziendaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From domain.entity.EAzienda as EAzienda");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("EAzienda", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EAzienda createEAzienda() {
		return EAzienda.getInstance();
	}
	
	public static boolean save(domain.entity.EAzienda eAzienda) {
		try {
			persistence.DAO.TimeloggingPersistentManager.instance().saveObject(eAzienda);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean delete(domain.entity.EAzienda eAzienda) {
		try {
			persistence.DAO.TimeloggingPersistentManager.instance().deleteObject(eAzienda);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean refresh(domain.entity.EAzienda eAzienda) {
		try {
			persistence.DAO.TimeloggingPersistentManager.instance().getSession().refresh(eAzienda);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean evict(domain.entity.EAzienda eAzienda) {
		try {
			persistence.DAO.TimeloggingPersistentManager.instance().getSession().evict(eAzienda);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
