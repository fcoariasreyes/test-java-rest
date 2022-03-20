package cl.test.tbk.fcoarias.model.response;

import java.sql.Date;

import cl.test.tbk.fcoarias.model.MetaDataObject;

public class UserResponseObject extends BaseResponeObject {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5383231635951288799L;
	private MetaDataObject metaData;
	
	public UserResponseObject(String mensaje) {
		super(mensaje);
	}

	public MetaDataObject getMetaData() {
		return metaData;
	}

	public void setMetaData(MetaDataObject metaData) {
		this.metaData = metaData;
	}	
	
	
}
