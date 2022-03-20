package cl.test.tbk.fcoarias.model.response;

import static com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion.NON_EMPTY;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include=NON_EMPTY)
public class BaseResponeObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6462146222956545013L;
	private String mensaje;

	protected BaseResponeObject() {
		
	}
	
	protected BaseResponeObject(String mensaje) {
		this.mensaje=mensaje;
	}
	
	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	
}
