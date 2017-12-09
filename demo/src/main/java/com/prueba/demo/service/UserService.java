package com.prueba.demo.service;

import java.util.List;

import com.prueba.demo.model.User;

public interface UserService {

	/**
	 * @author alexissanchez
	 * Guarda un Usuaario
	 * @param user
	 * @return usuario
	 */
	User save(User user);

	/**
	 * @author alexissanchez
	 * Recupera la lista de Usuarios
	 * @return
	 */
	List<User> findAll();

	/**
	 * Elimina un usuario
	 * @param id
	 */
	void deleteUser(Long id);

}
