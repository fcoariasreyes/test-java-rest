package cl.test.tbk.fcoarias.dao;

import java.sql.SQLException;
import java.sql.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import cl.test.tbk.fcoarias.AppBoot;
import cl.test.tbk.fcoarias.model.MetaDataObject;
import cl.test.tbk.fcoarias.model.PhoneObject;
import cl.test.tbk.fcoarias.model.UserObject;
import cl.test.tbk.fcoarias.util.HibernateUtil;


@Repository
public class UserDao {

	private static final Logger logger = LoggerFactory.getLogger(UserDao.class);

	public UserObject findById(int userId) throws HibernateException, ClassNotFoundException, SQLException {
		return HibernateUtil.getSession().get(UserObject.class, userId);
	}
	
	public UserObject findByEmail(String email) throws HibernateException, ClassNotFoundException, SQLException {
		
		List<UserObject> list = HibernateUtil.getSession().createCriteria(UserObject.class).add(Restrictions.ilike("email", email)).list();
		
		if (list != null && list.size()>0)
			return list.get(0);
		else
			return null;
	}
	
	public List<UserObject> findAllUsers() throws HibernateException, ClassNotFoundException, SQLException {
		List<UserObject> list = HibernateUtil.getSession().createCriteria(UserObject.class).list();
		
		
		for (UserObject user : list) {
		
			logger.info("Recuperando telefonos y metadata del ID USUARIO:"+user.getUserId());
			List<PhoneObject> phoneList = HibernateUtil.getSession().createCriteria(PhoneObject.class).add(Restrictions.eq("idUser", user.getUserId())).list();
			List<MetaDataObject> metaDataList = (HibernateUtil.getSession().createCriteria(MetaDataObject.class).add(Restrictions.eq("userId", user.getUserId())).list());
		
			if (phoneList!=null && phoneList.size()>0)
				user.setPhones(phoneList);
		
			if (metaDataList!=null && metaDataList.size()>0)
				user.setMetaData(metaDataList.get(0));
			
		}
		
		return list;
	
	}
	
	public void save(UserObject user) throws HibernateException, ClassNotFoundException, SQLException {
		
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.save(user);
		
		MetaDataObject metaData = new MetaDataObject();
		metaData.setCreated(new Date((new java.util.Date()).getTime()));
		metaData.setUuid(java.util.UUID.randomUUID().toString());
		metaData.setIs_active(true);
		metaData.setToken("");
		metaData.setUserId(user.getUserId());

		session.save(metaData);
		
		if (user.getPhones()!=null && user.getPhones().size()>0) {
			for (PhoneObject phone : user.getPhones()) {
				phone.setIdUser(user.getUserId());
				session.save(phone);
			}
		}
		
		session.getTransaction().commit();
		session.close();
	}

	public void update(UserObject user) throws HibernateException, ClassNotFoundException, SQLException {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
		session.close();
	}

	public void delete(UserObject user) throws HibernateException, ClassNotFoundException, SQLException {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.delete(user);
		session.getTransaction().commit();
		session.close();
	}

}
