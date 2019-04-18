package br.com.calcard.service;


import java.util.List;

import br.com.calcard.model.User;

public interface UserService {
	
	User findById(Long id);

	User findByNome(String nome);

	void saveUser(User user);

	void updateUser(User user);

	void deleteUserById(Long id);

	void deleteAllUsers();

	List<User> findAllUsers();

	boolean isUserExist(User user);

	List<User> findByEmAnalise();

	User findByCPF(String cpf);

}