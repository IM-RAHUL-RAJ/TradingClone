package com.fidelity.utils;

import com.fidelity.model.Client;

public class LoginClient {
	ClientValidator cValidator=new ClientValidator();
	Client c1;
	public boolean Login() {
		if(cValidator.isClientRegistered(c1)) {
			return true;
		}
		else {
			return false;
		}
	}
}
