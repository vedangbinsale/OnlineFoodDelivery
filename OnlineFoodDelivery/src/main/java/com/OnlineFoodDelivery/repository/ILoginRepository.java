package com.OnlineFoodDelivery.repository;

import com.OnlineFoodDelivery.entities.Login;

public interface ILoginRepository {
	
	public Login signIn(Login login);
	public Login signOut(Login login);
}
