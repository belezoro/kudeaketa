package com.kudeaketa.app.core.daos;

import com.kudeaketa.app.core.beans.User;

public interface LoginDao {
	
	/**
	 * Método para obtener el usuario de la base de datos
	 * @param username
	 * @param password
	 * @return
	 */
	User getUsuarioLogin(String username, String password);

	/**
	 * Método para insertar el usuario en la base de datos
	 * @param usuario
	 * @return
	 */
	Integer insertarUsuario(User usuario);
}
