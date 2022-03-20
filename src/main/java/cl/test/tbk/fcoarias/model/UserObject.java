package cl.test.tbk.fcoarias.model;

import static com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion.NON_EMPTY;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include=NON_EMPTY)
public class UserObject implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 6026935098061451758L;
	
	private Integer userId;
	private String name;
	private String email;
	private String password;
	private List<PhoneObject> phones;
	private MetaDataObject metaData;
	
	// for jackson
	public UserObject() {
	}

	public UserObject(String name, String email, String password, List<PhoneObject> phones) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phones = phones;
	}

	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<PhoneObject> getPhones() {
		return phones;
	}

	public void setPhones(List<PhoneObject> phones) {
		this.phones = phones;
	}

	public MetaDataObject getMetaData() {
		return metaData;
	}

	public void setMetaData(MetaDataObject metaData) {
		this.metaData = metaData;
	}

	@Override
	public String toString() {
		return "UserObject [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", phones=" + phones + ", metaData=" + metaData + "]";
	}

	

	

}
