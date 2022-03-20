package cl.test.tbk.fcoarias.service;

import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.test.tbk.fcoarias.dao.UserDao;
import cl.test.tbk.fcoarias.model.UserObject;
import cl.test.tbk.fcoarias.model.exception.DaoNotUniqueObjectException;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;

	public List<UserObject> findAllUsers() throws HibernateException, ClassNotFoundException, SQLException {
		return userDao.findAllUsers();
	}
	
	public UserObject findByUserId(UserObject user) throws HibernateException, ClassNotFoundException, SQLException {
		return userDao.findById(user.getUserId());
	}

	public void saveUser(UserObject user) throws HibernateException, ClassNotFoundException, SQLException, DaoNotUniqueObjectException {
		
		//Validacion formato correo
		Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(user.getEmail().toUpperCase());

		if (!m.find())
			throw new DaoNotUniqueObjectException("El formato de correo electronico no es correcto.");

		//Validacion de email existente
		if (userDao.findByEmail(user.getEmail())!=null)
			throw new DaoNotUniqueObjectException("El correo ya registrado.");

		//Validacion clave
		p = Pattern.compile("[a-z]{1,}");
		Pattern p2 = Pattern.compile("[A-Z]{1,}");
		Pattern p3 = Pattern.compile("[0-9]{2,}");

		if (!(p.matcher(user.getPassword()).find() 
				&& p2.matcher(user.getPassword()).find()
				&& p3.matcher(user.getPassword()).find()))
			throw new DaoNotUniqueObjectException("El formato de la clave de acceso no es correcto. Debe poseer una mayuscula, una minuscula y dos numeros");
				
		userDao.save(user);
	}

	public void updateUser(UserObject customer) throws HibernateException, ClassNotFoundException, SQLException {
		userDao.update(customer);
	}

	public void deleteUser(UserObject user) throws HibernateException, ClassNotFoundException, SQLException {
		userDao.delete(user);
	}
	
	
  
}
