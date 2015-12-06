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

import domain.entity.ETariffa;

import java.util.List;

public class ETariffaDAO {
	public static ETariffa loadETariffaByORMID(int ID) {
		try {
			PersistentSession session = persistence.DAO.TimelogginPersistentManager.instance().getSession();
			return loadETariffaByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ETariffa getETariffaByORMID(int ID) {
		try {
			PersistentSession session = persistence.DAO.TimelogginPersistentManager.instance().getSession();
			return getETariffaByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ETariffa loadETariffaByORMID(int ID, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimelogginPersistentManager.instance().getSession();
			return loadETariffaByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ETariffa getETariffaByORMID(int ID, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimelogginPersistentManager.instance().getSession();
			return getETariffaByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ETariffa loadETariffaByORMID(PersistentSession session, int ID) {
		try {
			return (ETariffa) session.load(domain.entity.ETariffa.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ETariffa getETariffaByORMID(PersistentSession session, int ID) {
		try {
			return (ETariffa) session.get(domain.entity.ETariffa.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ETariffa loadETariffaByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) {
		try {
			return (ETariffa) session.load(domain.entity.ETariffa.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ETariffa getETariffaByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) {
		try {
			return (ETariffa) session.get(domain.entity.ETariffa.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List queryETariffa(String condition, String orderBy) {
		try {
			PersistentSession session = persistence.DAO.TimelogginPersistentManager.instance().getSession();
			return queryETariffa(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List queryETariffa(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimelogginPersistentManager.instance().getSession();
			return queryETariffa(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ETariffa[] listETariffaByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = persistence.DAO.TimelogginPersistentManager.instance().getSession();
			return listETariffaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ETariffa[] listETariffaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimelogginPersistentManager.instance().getSession();
			return listETariffaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List queryETariffa(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From domain.entity.ETariffa as ETariffa");
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
	
	public static List queryETariffa(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From domain.entity.ETariffa as ETariffa");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("ETariffa", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ETariffa[] listETariffaByQuery(PersistentSession session, String condition, String orderBy) {
		try {
			List list = queryETariffa(session, condition, orderBy);
			return (ETariffa[]) list.toArray(new ETariffa[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ETariffa[] listETariffaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			List list = queryETariffa(session, condition, orderBy, lockMode);
			return (ETariffa[]) list.toArray(new ETariffa[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ETariffa loadETariffaByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = persistence.DAO.TimelogginPersistentManager.instance().getSession();
			return loadETariffaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ETariffa loadETariffaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimelogginPersistentManager.instance().getSession();
			return loadETariffaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ETariffa loadETariffaByQuery(PersistentSession session, String condition, String orderBy) {
		ETariffa[] eTariffas = listETariffaByQuery(session, condition, orderBy);
		if (eTariffas != null && eTariffas.length > 0)
			return eTariffas[0];
		else
			return null;
	}
	
	public static ETariffa loadETariffaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		ETariffa[] eTariffas = listETariffaByQuery(session, condition, orderBy, lockMode);
		if (eTariffas != null && eTariffas.length > 0)
			return eTariffas[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateETariffaByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = persistence.DAO.TimelogginPersistentManager.instance().getSession();
			return iterateETariffaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateETariffaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimelogginPersistentManager.instance().getSession();
			return iterateETariffaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateETariffaByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From domain.entity.ETariffa as ETariffa");
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
	
	public static java.util.Iterator iterateETariffaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From domain.entity.ETariffa as ETariffa");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("ETariffa", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ETariffa createETariffa() {
		return new domain.entity.ETariffa();
	}
	
	public static boolean save(domain.entity.ETariffa eTariffa) {
		try {
			persistence.DAO.TimelogginPersistentManager.instance().saveObject(eTariffa);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean delete(domain.entity.ETariffa eTariffa) {
		try {
			persistence.DAO.TimelogginPersistentManager.instance().deleteObject(eTariffa);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean refresh(domain.entity.ETariffa eTariffa) {
		try {
			persistence.DAO.TimelogginPersistentManager.instance().getSession().refresh(eTariffa);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean evict(domain.entity.ETariffa eTariffa) {
		try {
			persistence.DAO.TimelogginPersistentManager.instance().getSession().evict(eTariffa);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
