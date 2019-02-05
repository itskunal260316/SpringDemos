package com.lti.component;

public class ATM implements ATMInterface, ATMBalance {
	
	double balance;
	/* (non-Javadoc)
	 * @see com.lti.component.ATMInterface#withdraw(java.lang.String, int, double)
	 */
	public void withdraw(String atmid,int acno,double amount) {
		
		System.out.println("withdraw called");
		
	}
    
	/* (non-Javadoc)
	 * @see com.lti.component.ATMBalance#checkBalance(java.lang.String, int, double)
	 */
	public void checkBalance(String atmid, int acno, double balance) {
		System.out.println("Balace is null, you cheapo");
	}
}
