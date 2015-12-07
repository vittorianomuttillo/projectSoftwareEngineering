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

import domain.entity.EDipendente;
import domain.entity.ETariffa;

import java.util.List;

public class EDipendenteDAO {
	public static EDipendente loadEDipendenteByORMID(String codiceFiscale) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return loadEDipendenteByORMID(session, codiceFiscale);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EDipendente getEDipendenteByORMID(String codiceFiscale) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return getEDipendenteByORMID(session, codiceFiscale);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EDipendente loadEDipendenteByORMID(String codiceFiscale, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return loadEDipendenteByORMID(session, codiceFiscale, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EDipendente getEDipendenteByORMID(String codiceFiscale, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return getEDipendenteByORMID(session, codiceFiscale, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EDipendente loadEDipendenteByORMID(PersistentSession session, String codiceFiscale) {
		try {
			return (EDipendente) session.load(domain.entity.EDipendente.class, codiceFiscale);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EDipendente getEDipendenteByORMID(PersistentSession session, String codiceFiscale) {
		try {
			return (EDipendente) session.get(domain.entity.EDipendente.class, codiceFiscale);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EDipendente loadEDipendenteByORMID(PersistentSession session, String codiceFiscale, org.hibernate.LockMode lockMode) {
		try {
			return (EDipendente) session.load(domain.entity.EDipendente.class, codiceFiscale, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EDipendente getEDipendenteByORMID(PersistentSession session, String codiceFiscale, org.hibernate.LockMode lockMode) {
		try {
			return (EDipendente) session.get(domain.entity.EDipendente.class, codiceFiscale, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List queryEDipendente(String condition, String orderBy) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return queryEDipendente(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List queryEDipendente(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return queryEDipendente(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EDipendente[] listEDipendenteByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return listEDipendenteByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EDipendente[] listEDipendenteByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return listEDipendenteByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List queryEDipendente(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From domain.entity.EDipendente as EDipendente");
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
	
	public static List queryEDipendente(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From domain.entity.EDipendente as EDipendente");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("EDipendente", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EDipendente[] listEDipendenteByQuery(PersistentSession session, String condition, String orderBy) {
		try {
			List list = queryEDipendente(session, condition, orderBy);
			return (EDipendente[]) list.toArray(new EDipendente[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EDipendente[] listEDipendenteByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			List list = queryEDipendente(session, condition, orderBy, lockMode);
			return (EDipendente[]) list.toArray(new EDipendente[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EDipendente loadEDipendenteByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return loadEDipendenteByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EDipendente loadEDipendenteByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return loadEDipendenteByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static EDipendente loadEDipendenteByQuery(PersistentSession session, String condition, String orderBy) {
		EDipendente[] eDipendentes = listEDipendenteByQuery(session, condition, orderBy);
		if (eDipendentes != null && eDipendentes.length > 0)
			return eDipendentes[0];
		else
			return null;
	}
	
	public static EDipendente loadEDipendenteByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		EDipendente[] eDipendentes = listEDipendenteByQuery(session, condition, orderBy, lockMode);
		if (eDipendentes != null && eDipendentes.length > 0)
			return eDipendentes[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateEDipendenteByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return iterateEDipendenteByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateEDipendenteByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return iterateEDipendenteByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateEDipendenteByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From domain.entity.EDipendente as EDipendente");
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
	
	public static java.util.Iterator iterateEDipendenteByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From domain.entity.EDipendente as EDipendente");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("EDipendente", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static boolean save(domain.entity.EDipendente eDipendente) {
		try {
			persistence.DAO.TimeloggingPersistentManager.instance().saveObject(eDipendente);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean delete(domain.entity.EDipendente eDipendente) {
		try {
			persistence.DAO.TimeloggingPersistentManager.instance().deleteObject(eDipendente);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean deleteAndDissociate(domain.entity.EDipendente eDipendente) {
		try {
			domain.entity.ETariffa[] leTariffass = (domain.entity.ETariffa[])eDipendente.geteTariffas().toArray(new domain.entity.ETariffa[eDipendente.geteTariffas().size()]);
			for(int i = 0; i < leTariffass.length; i++) {
				leTariffass[i].seteDipendente(null);
			}
			return delete(eDipendente);
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean deleteAndDissociate(domain.entity.EDipendente eDipendente, org.orm.PersistentSession session) {
		try {
			domain.entity.ETariffa[] leTariffass = (domain.entity.ETariffa[])eDipendente.geteTariffas().toArray(new domain.entity.ETariffa[eDipendente.geteTariffas().size()]);
			for(int i = 0; i < leTariffass.length; i++) {
				leTariffass[i].seteDipendente(null);
			}
			try {
				session.delete(eDipendente);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean refresh(domain.entity.EDipendente eDipendente) {
		try {
			persistence.DAO.TimeloggingPersistentManager.instance().getSession().refresh(eDipendente);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean evict(domain.entity.EDipendente eDipendente) {
		try {
			persistence.DAO.TimeloggingPersistentManager.instance().getSession().evict(eDipendente);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
