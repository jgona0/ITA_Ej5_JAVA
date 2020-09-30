package com.jobs.application;

import java.util.ArrayList;
import java.util.List;

import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Employee;
import com.jobs.domain.Volunteer;
import com.jobs.persistence.EmployeeRepository;

public class JobsController {

	private EmployeeRepository repository = new EmployeeRepository();
	
	//CONSTRUCTOR
	public JobsController(){
		
	}
	
	
	//METODOS DE CREACION DE EMPLEADOS Y VOLUNTARIOS
	public void createBossEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee boss = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateBoss());
		repository.addMember(boss);
	}
	
	public void createEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee employee = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateEmployee());
		repository.addMember(employee);
	}

	public void createManagerEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
		Employee manager = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateManager());
		repository.addMember(manager);
		
	}

	public void createVolunteer(String name, String address, String phone, String description) throws Exception {
		Volunteer volunteer = new Volunteer(name, address, phone, description);
		repository.addMember(volunteer);
	}
	

	//METODO QUE EJECUTA EL PAGO A LOS EMPLEADOS -- SALARIO * PORCENTAGE EN FUNCION DE SU RANGO
	public void payAllEmployeers() {

		List<AbsStaffMember> members=new ArrayList<>();
		members = repository.getAllMembers();

		for(int i=0; i<members.size(); i++) {
			members.get(i).pay();
		}
			
	}

	
	
	// METODO QUE DEVUEVE LA INFO DE TODOS LOS EMPLEADOS
	public String getAllEmployees() {

		// Creamos una lista de staff y recuperamos en ella todos los objetos de AbsStaffMember
		List<AbsStaffMember> members=new ArrayList<>();
		members = repository.getAllMembers();
		
		//String para el return
		String result = "";
		
		// Recorremos la lista y almacenamos la info de los objetos, si son voluntarios o empleados (ya que tienen diferentes atributos)
		for(int i=0; i<members.size(); i++) {
			
			if(members.get(i) instanceof Employee) {
				result += "NOMBRE: " + members.get(i).getName() 
						+ ", TELF: " + members.get(i).getPhone() 
						+ ", DIR: " +members.get(i).getAddress() 
						+ ", SALARIO MENS: " +((Employee) members.get(i)).getSalaryPerMonth() 
						+ ", SALARIO REAL: " + members.get(i).getTotalPaid() + "\n";	
			}
			
		}
		
		return result;
	}
	

	// METODO QUE DEVUEVE LA INFO DE TODOS LOS VOLUNTARIOS
	public String getAllVolunteers() {

		// Creamos una lista de staff y recuperamos en ella todos los objetos de AbsStaffMember
		List<AbsStaffMember> members=new ArrayList<>();
		members = repository.getAllMembers();
		
		//String para el return
		String result = "";
		
		// Recorremos la lista y almacenamos la info de los objetos, si son voluntarios o empleados (ya que tienen diferentes atributos)
		for(int i=0; i<members.size(); i++) {
			
			if(members.get(i) instanceof Volunteer) {
				result += "NOMBRE: " + members.get(i).getName() 
						+ ", TELF: " + members.get(i).getPhone() 
						+ ", DESC: " + ((Volunteer) members.get(i)).getDescription();
			}
			
		}
		
		return result;
	}

	
	
	
}
