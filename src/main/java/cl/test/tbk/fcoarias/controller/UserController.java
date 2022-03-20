package cl.test.tbk.fcoarias.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.test.tbk.fcoarias.AppBoot;
import cl.test.tbk.fcoarias.model.UserObject;
import cl.test.tbk.fcoarias.model.exception.DaoNotUniqueObjectException;
import cl.test.tbk.fcoarias.model.response.UserListResponseObject;
import cl.test.tbk.fcoarias.model.response.UserResponseObject;
import cl.test.tbk.fcoarias.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(description = "User API", tags = "user")
public class UserController {

	@Autowired
	private UserService service;

	private static final Logger logger = LoggerFactory.getLogger(AppBoot.class);

	@RequestMapping(method = RequestMethod.POST, path = "/user/register", consumes = "application/json", produces = "application/json")
	@ApiOperation(nickname = "Registro de usuarios", 
		value = "Retorna un mensaje de exito o fracaso", 
		notes = "Reviar status code para confirmar exito o fracaso, segun la definicion de REST")
	
	public UserResponseObject register(@RequestBody UserObject user, HttpServletResponse response) {

		logger.info("User object:" + user);

		try {
			service.saveUser(user);
		    response.setStatus(HttpServletResponse.SC_OK);

		} catch (HibernateException | ClassNotFoundException | SQLException e) {
			logger.error(e.getMessage());
		    response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

		    return new UserResponseObject("Ha ocurrido un error al crear el regstro en la base de datos");

		} catch (DaoNotUniqueObjectException e) {
			logger.error(e.getMessage());
		    response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

		    return new UserResponseObject(e.getMessage());
		} 

		return new UserResponseObject("Registro de usuario exitoso");
	}

	@RequestMapping(method = RequestMethod.GET, path = "/user/list", produces = "application/json")
	@ApiOperation(nickname = "Recupera todos los usuarios registrados", value = "Retorna el listado completo de los usuarios registrados.", notes = ""
			+ "Servicio rest")
	public UserListResponseObject getAllUsers(HttpServletResponse response) {

		logger.info("Get all users...");
		try {
			List<UserObject> users = service.findAllUsers();
		    response.setStatus(HttpServletResponse.SC_OK);
			return new UserListResponseObject(users);
		} catch (HibernateException | ClassNotFoundException | SQLException e) {
			logger.error(e.getMessage());
		    response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

			return new UserListResponseObject("Ha ocurrido un error al recuperar la lista de usuarios");

		}

	}

}