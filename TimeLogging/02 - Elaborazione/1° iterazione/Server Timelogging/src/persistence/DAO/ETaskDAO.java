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

import domain.entity.ETask;

import java.util.List;

public class ETaskDAO {
	public static ETask loadETaskByORMID(int idTask) {
		try {
			PersistentSession session = persistence.DAO.TimelogginPersistentManager.instance().getSession();
			return loadETaskByORMID(session, idTask);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ETask getETaskByORMID(int idTask) {
		try {
			PersistentSession session = persistence.DAO.TimelogginPersistentManager.instance().getSession();
			return getETaskByORMID(session, idTask);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ETask loadETaskByORMID(int idTask, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimelogginPersistentManager.instance().getSession();
			return loadETaskByORMID(session, idTask, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ETask getETaskByORMID(int idTask, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimelogginPersistentManager.instance().getSession();
			return getETaskByORMID(session, idTask, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ETask loadETaskByORMID(PersistentSession session, int idTask) {
		try {
			return (ETask) session.load(domain.entity.ETask.class, new Integer(idTask));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ETask getETaskByORMID(PersistentSession session, int idTask) {
		try {
			return (ETask) session.get(domain.entity.ETask.class, new Integer(idTask));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ETask loadETaskByORMID(PersistentSession session, int idTask, org.hibernate.LockMode lockMode) {
		try {
			return (ETask) session.load(domain.entity.ETask.class, new Integer(idTask), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ETask getETaskByORMID(PersistentSession session, int idTask, org.hibernate.LockMode lockMode) {
		try {
			return (ETask) session.get(domain.entity.ETask.class, new Integer(idTask), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List queryETask(String condition, String orderBy) {
		try {
			PersistentSession session = persistence.DAO.TimelogginPersistentManager.instance().getSession();
			return queryETask(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List queryETask(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimelogginPersistentManager.instance().getSession();
			return queryETask(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ETask[] listETaskByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = persistence.DAO.TimelogginPersistentManager.instance().getSession();
			return listETaskByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ETask[] listETaskByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimelogginPersistentManager.instance().getSession();
			return listETaskByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List queryETask(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From domain.entity.ETask as ETask");
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
	
	public static List queryETask(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From domain.entity.ETask as ETask");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("ETask", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ETask[] listETaskByQuery(PersistentSession session, String condition, String orderBy) {
		try {
			List list = queryETask(session, condition, orderBy);
			return (ETask[]) list.toArray(new ETask[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ETask[] listETaskByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			List list = queryETask(session, condition, orderBy, lockMode);
			return (ETask[]) list.toArray(new ETask[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ETask loadETaskByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = persistence.DAO.TimelogginPersistentManager.instance().getSession();
			return loadETaskByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ETask loadETaskByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimelogginPersistentManager.instance().getSession();
			return loadETaskByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ETask loadETaskByQuery(PersistentSession session, String condition, String orderBy) {
		ETask[] eTasks = listETaskByQuery(session, condition, orderBy);
		if (eTasks != null && eTasks.length > 0)
			return eTasks[0];
		else
			return null;
	}
	
	public static ETask loadETaskByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		ETask[] eTasks = listETaskByQuery(session, condition, orderBy, lockMode);
		if (eTasks != null && eTasks.length > 0)
			return eTasks[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateETaskByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = persistence.DAO.TimelogginPersistentManager.instance().getSession();
			return iterateETaskByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateETaskByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = persistence.DAO.TimelogginPersistentManager.instance().getSession();
			return iterateETaskByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateETaskByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From domain.entity.ETask as ETask");
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
	
	public static java.util.Iterator iterateETaskByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From domain.entity.ETask as ETask");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("ETask", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ETask createETask() {
		return new domain.entity.ETask();
	}
	
	public static boolean save(domain.entity.ETask eTask) {
		try {
			persistence.DAO.TimelogginPersistentManager.instance().saveObject(eTask);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean delete(domain.entity.ETask eTask) {
		try {
			persistence.DAO.TimelogginPersistentManager.instance().deleteObject(eTask);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean refresh(domain.entity.ETask eTask) {
		try {
			persistence.DAO.TimelogginPersistentManager.instance().getSession().refresh(eTask);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean evict(domain.entity.ETask eTask) {
		try {
			persistence.DAO.TimelogginPersistentManager.instance().getSession().evict(eTask);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
