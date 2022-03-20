package cl.test.tbk.fcoarias.model;

import static com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion.NON_EMPTY;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include=NON_EMPTY)
public class PhoneObject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6724167048418443965L;
	private String city_code;
	private String country_code;
	private String number;
	private Integer id;
	private Integer idUser;
	
	public String getCity_code() {
		return city_code;
	}
	public void setCity_code(String city_code) {
		this.city_code = city_code;
	}
	public String getCountry_code() {
		return country_code;
	}
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getIdUser() {
		return idUser;
	}
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	@Override
	public String toString() {
		return "PhoneObject [city_code=" + city_code + ", country_code=" + country_code + ", number=" + number + "]";
	}
	
	
	
}
