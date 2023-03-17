package com.kudeaketa.app.core.daos.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.kudeaketa.app.core.beans.User;
import com.kudeaketa.app.core.daos.LoginDao;

@Repository
public class LoginDaoImpl implements LoginDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginDao.class);
	
	@Autowired
	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	private RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
	
	public LoginDaoImpl(NamedParameterJdbcTemplate pNamedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = pNamedParameterJdbcTemplate;
	}
	
	private static final String SQL_GET_USUARIOS = "SELECT * FROM USER ";
	
	private static final String SQL_INSERT_USUARIO = "INSERT INTO USER VALUES(:username, :pass)";
	
	@Override
	public User getUsuarioLogin(String username, String password) {
		User usuario;
		Map<String, Object> params = new HashMap<>();
		StringBuilder sql = new StringBuilder();
		sql.append(SQL_GET_USUARIOS)
		.append("WHERE username = :username AND pass = :password");
		params.put("username", username);
		params.put("password", password);
		try {
			usuario = namedParameterJdbcTemplate.queryForObject(sql.toString(), params, rowMapper);
		} catch (Exception e) {
			LOGGER.debug("ERROR_MESSAGE", e);
			usuario = null;
		}
		return usuario;
	}
	
	@Override
	public Integer insertarUsuario(User usuario) {
		Integer resultado;
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(usuario);
		try {
			resultado = namedParameterJdbcTemplate.update(SQL_INSERT_USUARIO, paramSource);
		} catch (Exception e) {
			LOGGER.debug("ERROR_MESSAGE", e);
			resultado = -1;
		}
		return resultado;
	}
	
	
}
