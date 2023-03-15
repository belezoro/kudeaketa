package com.kudeaketa.app.core.facades.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kudeaketa.app.core.beans.User;
import com.kudeaketa.app.core.daos.LoginDao;
import com.kudeaketa.app.core.facades.LoginFacade;

@Service
public class LoginFacadeImpl implements LoginFacade {

	@Autowired
	private LoginDao loginDao;
	
	@Override
	public User getUsuarioLogin(String username, String password) {
		return loginDao.getUsuarioLogin(username, password);
	}
	
	@Override
	public Integer insertarUsuario(User usuario) {
		return loginDao.insertarUsuario(usuario);
	}

}
