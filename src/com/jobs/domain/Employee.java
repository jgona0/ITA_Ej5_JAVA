package com.jobs.domain;

public class Employee extends AbsStaffMember {

	protected double salaryPerMonth;
	protected IPaymentRate paymentRate;	

	
	// CONSTRUCTOR
	public Employee(String name, String address, String phone, double salaryPerMonth,IPaymentRate paymentRate) throws Exception {
		super(name, address, phone);		
		if(salaryPerMonth<0) throw new Exception();
		if(paymentRate==null) throw new Exception();
				
		this.salaryPerMonth=salaryPerMonth;
		this.paymentRate=paymentRate;
	}

	
	@Override
	public void pay() {
		totalPaid=paymentRate.pay(salaryPerMonth);
	}

	// METODO QUE DEVUELVE EL SALARIO MENSUAL DEL EMPLOYEE, NO ESTA EN LA CLASE ABSTRACTA PORQUE ES PROPIA DEL VOLUNTARIO
	public double getSalaryPerMonth() {
		return salaryPerMonth;
	}
	
}
