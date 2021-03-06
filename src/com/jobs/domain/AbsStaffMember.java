package com.jobs.domain;

public abstract class AbsStaffMember {

	protected int id;
	protected String name;
	protected String address;
	protected String phone;
	protected double totalPaid=0;

	private static int COUNTER_MEMBERS = 1;

	public AbsStaffMember(String name, String address, String phone) throws Exception {
		if (name.equals(""))
			throw new Exception();
		if (address.equals(""))
			throw new Exception();
		if (phone.equals(""))
			throw new Exception();

		this.name = name;
		this.address = address;
		this.phone = phone;
		id = COUNTER_MEMBERS;
		COUNTER_MEMBERS++;
	}


	//METODO ABSTRACTO
	public abstract void pay();


	//GETTERS NECESARIOS
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public double getTotalPaid() {
		return totalPaid;
	}

}
