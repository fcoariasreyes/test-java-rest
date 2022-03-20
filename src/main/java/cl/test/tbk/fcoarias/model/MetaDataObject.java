package cl.test.tbk.fcoarias.model;

import static com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion.NON_EMPTY;

import java.sql.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include=NON_EMPTY)
public class MetaDataObject {

	private Date created;
	private Date modified;
	private Date last_login;
	private String token;
	private Boolean is_active;
	private String uuid;
	private Integer userId;
	private Integer metaDataId;
	
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getModified() {
		return modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}
	public Date getLast_login() {
		return last_login;
	}
	public void setLast_login(Date last_login) {
		this.last_login = last_login;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Boolean getIs_active() {
		return is_active;
	}
	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getMetaDataId() {
		return metaDataId;
	}
	public void setMetaDataId(Integer metaDataId) {
		this.metaDataId = metaDataId;
	}
	@Override
	public String toString() {
		return "MetaDataObject [created=" + created + ", modified=" + modified + ", last_login=" + last_login
				+ ", token=" + token + ", is_active=" + is_active + ", uuid=" + uuid + ", userId=" + userId
				+ ", metaDataId=" + metaDataId + "]";
	}
	
	
	
}
