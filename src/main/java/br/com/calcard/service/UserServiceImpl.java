package br.com.calcard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.calcard.model.User;
import br.com.calcard.repositories.UserRepository;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	public User findById(Long id) {
		return userRepository.findOne(id);
	}

	public User findByNome(String nome) {
		return userRepository.findByNome(nome);
	}

	public void saveUser(User user) {
		userRepository.save(user);
	}

	public void updateUser(User user){
		saveUser(user);
	}

	public void deleteUserById(Long id){
		userRepository.delete(id);
	}

	public void deleteAllUsers(){
		userRepository.deleteAll();
	}

	public List<User> findAllUsers(){
		return userRepository.findAll();
	}

	public boolean isUserExist(User user) {
		return findByNome(user.getCpf()) != null;
	}

	@Override
	public List<User> findByEmAnalise() {
		return userRepository.findByEmAnalise();
	}

	@Override
	public User findByCPF(String cpf) {
		return userRepository.findByCPF(cpf);
	}

}
