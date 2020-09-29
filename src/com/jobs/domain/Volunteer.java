package com.jobs.domain;

public class Volunteer extends AbsStaffMember {
	

	protected String description;

	
	public Volunteer(String name, String address, String phone, String description) throws Exception {

		super(name, address, phone);
		this.description = description;
	}


	@Override
	public void pay() {
		totalPaid=0;
		
	}

	// METODO QUE DEVUELVE LA DESCRIPCION DEL VOLUNTARIO, NO ESTA EN LA CLASE ABSTRACTA PORQUE ES PROPIA DEL VOLUNTARIO
	public String getDescription() {
		return description;
	}
	
	
}
