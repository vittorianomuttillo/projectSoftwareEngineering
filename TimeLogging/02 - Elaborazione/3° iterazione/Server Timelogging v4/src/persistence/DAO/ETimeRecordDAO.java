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

import domain.entity.ETimeRecord;

import java.util.List;

public class ETimeRecordDAO {
	public static ETimeRecord loadETimeRecordByORMID(int ID) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return loadETimeRecordByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ETimeRecord getETimeRecordByORMID(int ID) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return getETimeRecordByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ETimeRecord loadETimeRecordByORMID(int ID, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return loadETimeRecordByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ETimeRecord getETimeRecordByORMID(int ID, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return getETimeRecordByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ETimeRecord loadETimeRecordByORMID(PersistentSession session, int ID) {
		try {
			return (ETimeRecord) session.load(domain.entity.ETimeRecord.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ETimeRecord getETimeRecordByORMID(PersistentSession session, int ID) {
		try {
			return (ETimeRecord) session.get(domain.entity.ETimeRecord.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ETimeRecord loadETimeRecordByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) {
		try {
			return (ETimeRecord) session.load(domain.entity.ETimeRecord.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ETimeRecord getETimeRecordByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) {
		try {
			return (ETimeRecord) session.get(domain.entity.ETimeRecord.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List queryETimeRecord(String condition, String orderBy) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return queryETimeRecord(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List queryETimeRecord(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return queryETimeRecord(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ETimeRecord[] listETimeRecordByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return listETimeRecordByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ETimeRecord[] listETimeRecordByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return listETimeRecordByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List queryETimeRecord(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From domain.entity.ETimeRecord as ETimeRecord");
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
	
	public static List queryETimeRecord(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From domain.entity.ETimeRecord as ETimeRecord");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("ETimeRecord", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ETimeRecord[] listETimeRecordByQuery(PersistentSession session, String condition, String orderBy) {
		try {
			List list = queryETimeRecord(session, condition, orderBy);
			return (ETimeRecord[]) list.toArray(new ETimeRecord[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ETimeRecord[] listETimeRecordByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			List list = queryETimeRecord(session, condition, orderBy, lockMode);
			return (ETimeRecord[]) list.toArray(new ETimeRecord[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ETimeRecord loadETimeRecordByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return loadETimeRecordByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ETimeRecord loadETimeRecordByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return loadETimeRecordByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ETimeRecord loadETimeRecordByQuery(PersistentSession session, String condition, String orderBy) {
		ETimeRecord[] eTimeRecords = listETimeRecordByQuery(session, condition, orderBy);
		if (eTimeRecords != null && eTimeRecords.length > 0)
			return eTimeRecords[0];
		else
			return null;
	}
	
	public static ETimeRecord loadETimeRecordByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		ETimeRecord[] eTimeRecords = listETimeRecordByQuery(session, condition, orderBy, lockMode);
		if (eTimeRecords != null && eTimeRecords.length > 0)
			return eTimeRecords[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateETimeRecordByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return iterateETimeRecordByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateETimeRecordByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimeloggingPersistentManager.instance().getSession();
			return iterateETimeRecordByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateETimeRecordByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From domain.entity.ETimeRecord as ETimeRecord");
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
	
	public static java.util.Iterator iterateETimeRecordByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From domain.entity.ETimeRecord as ETimeRecord");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("ETimeRecord", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ETimeRecord createETimeRecord() {
		return new domain.entity.ETimeRecord();
	}
	
	public static boolean save(domain.entity.ETimeRecord eTimeRecord) {
		try {
			persistence.DAO.TimeloggingPersistentManager.instance().saveObject(eTimeRecord);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean delete(domain.entity.ETimeRecord eTimeRecord) {
		try {
			persistence.DAO.TimeloggingPersistentManager.instance().deleteObject(eTimeRecord);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean refresh(domain.entity.ETimeRecord eTimeRecord) {
		try {
			persistence.DAO.TimeloggingPersistentManager.instance().getSession().refresh(eTimeRecord);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean evict(domain.entity.ETimeRecord eTimeRecord) {
		try {
			persistence.DAO.TimeloggingPersistentManager.instance().getSession().evict(eTimeRecord);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
