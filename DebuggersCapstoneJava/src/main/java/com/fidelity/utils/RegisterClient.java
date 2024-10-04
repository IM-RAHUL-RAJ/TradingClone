package com.fidelity.utils;

import java.time.LocalDate;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

import com.fidelity.model.Client;

public class RegisterClient {
	ClientValidator cValidator=new ClientValidator();
//	Client client1=new Client("John@gmail.com",1,LocalDate.of(2000, 5, 16),"India","826001");
//	Client client2=new Client("Bosh@gmail.com",1,LocalDate.of(2000, 5, 16),"India","826001");
//	Client client3=new Client("John@gmail.com",1,LocalDate.of(2000, 5, 16),"India","826001");
//	Client client4=new Client("Tim@gmail.com",1,LocalDate.of(2000, 5, 16),"India","826001");
//	Client client5=new Client("Ben@gmail.com",1,LocalDate.of(2000, 5, 16),"India","826001");

	Client client1;
	
	public boolean register() {
		if(cValidator.isClientRegistered(client1)) {
			return  true;
		}
		else {
			return false;
		}
	}
	


}
