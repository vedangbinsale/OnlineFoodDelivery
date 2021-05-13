package com.OnlineFoodDelivery.service;

import com.OnlineFoodDelivery.entities.Login;

public interface ILoginService {
	
	public Login signIn(Login login);
	public Login signOut(Login login);
}
