package br.com.calcard.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.calcard.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByNome(String nome);

    @Query("SELECT u FROM User u WHERE u.resultadoAnalise = 'Em Análise'")
	List<User> findByEmAnalise();

    @Query("SELECT u FROM User u WHERE u.cpf = ?1")
	User findByCPF(String cpf);
    
}
