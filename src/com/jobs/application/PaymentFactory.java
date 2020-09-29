package com.jobs.application;

import com.jobs.domain.IPaymentRate;

public class PaymentFactory {

	
	//RATE DE MANAGER 10% MAS DE SU SUELDO
	public static IPaymentRate createPaymentRateManager(){
		return new IPaymentRate() {	
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth*1.1;
			}
		};
	}
	
	
	//RATE DE BOSS 50% MAS DE SU SUELDO
	public static IPaymentRate createPaymentRateBoss(){
		return new IPaymentRate() {	
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth*1.5;
			}
		};
	}
	
	//RATE DE EMPLOYEE -15% DE SU SUELDO
	public static IPaymentRate createPaymentRateEmployee(){
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth - (salaryPerMonth * 0.15);
			}
		};
	}
}
