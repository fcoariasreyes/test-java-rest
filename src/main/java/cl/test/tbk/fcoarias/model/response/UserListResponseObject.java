package cl.test.tbk.fcoarias.model.response;

import java.util.List;

import cl.test.tbk.fcoarias.model.UserObject;

public class UserListResponseObject extends BaseResponeObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7609048471188567453L;

	private List<UserObject> users;

	public UserListResponseObject(List<UserObject> users) {
		this.users=users;
	}
	
	public UserListResponseObject(String mensaje) {
		super(mensaje);
	}
	
	public List<UserObject> getUsers() {
		return users;
	}

	public void setUsers(List<UserObject> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "UserListResponseObject [users=" + users + "]";
	}
	
	
}
