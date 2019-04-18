package br.com.calcard.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.calcard.model.User;
import br.com.calcard.service.UserService;
import br.com.calcard.util.CustomErrorType;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class RestApiController {

	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	@Autowired
	UserService userService;

	@ApiOperation(value = "Consulta todos os clientes e propostas.")
	@RequestMapping(value = "/clientes/", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers() {
		List<User> users = userService.findAllUsers();
		if (users.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);

		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Consulta Cliente pelo CPF.")
	@RequestMapping(value = "/cliente/{cpf}", method = RequestMethod.GET)
	public ResponseEntity<?> getUser(@PathVariable("cpf") String cpf) {
		logger.info("Encontrando Cliente com o cpf {}", cpf);
		User user = userService.findByCPF(cpf);
		if (user == null) {
			logger.error("Cadastro com cliente de CPF {} não encontrado.", cpf);
			return new ResponseEntity(new CustomErrorType("Cliente com CPF " + cpf + " não encontrado"),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Consulta a análise e tomada de descisão da proposta.")
	@RequestMapping(value = "/cliente/proposta/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getProposta(@PathVariable("id") long id) {
		logger.info("Analisando proposta de nr. {}", id);
		User user = userService.findById(id);
		if (user == null) {
			logger.error("Proposta de nr. {} não encontrada.", id);
			return new ResponseEntity(new CustomErrorType("Proposta de nr. " + id + " não encontrado"),
					HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	@ApiOperation(value = "Executa o motor para análise da proposta.")
	@RequestMapping(value = "/cliente/proposta/analisa/", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAnalisa() {
		logger.info("Analisando propostas");
		List<User> propostas = userService.findByEmAnalise();
		if (propostas.size() == 0) {
			logger.error("Não há propostas a serem analisadas");
			return new ResponseEntity(new CustomErrorType("Não há propostas a serem analisadas"), HttpStatus.NOT_FOUND);
		} else {
			for (User proposta : propostas) {

				// Valor Comprometido de 30% da Renda Mensal
				double rendaComprometida = (proposta.getRenda() * 30) / 100;
				double taxaConversao = 0d;
				double valorLimite;

				// Taxa de conversão cfm Faixa Salarial e Nr. de Dependentes

				if (proposta.getDependentes() == 0) {
					taxaConversao = 0.0;
				}

				if (proposta.getRenda() < 1000) {
					proposta.setResultadoAnalise("Negado");
					proposta.setLimite("0.0");
					proposta.setMotivo("renda baixa");
				} else if (proposta.getRenda() >= 1000 && proposta.getRenda() < 2000) {
					if (proposta.getIdade() >= 45 && proposta.getDependentes() > 0) {
						proposta.setResultadoAnalise("Negado");
						proposta.setLimite("0.0");
						proposta.setMotivo("reprovado pela política de crédito");
					} else {
						if (proposta.getDependentes() == 1) {
							taxaConversao = 0.6;
						} else if (proposta.getDependentes() == 2) {
							taxaConversao = 0.5;
						} else if (proposta.getDependentes() == 3) {
							taxaConversao = 0.3;
						} else if (proposta.getDependentes() > 3){
							taxaConversao = 0.1;
						}
					valorLimite = rendaComprometida * taxaConversao;
					proposta.setResultadoAnalise("Aprovado");
					if (taxaConversao != 0.0) {
						proposta.setLimite("" + valorLimite + "");
					} else {
						proposta.setLimite("" + rendaComprometida + "");
					}
					}

				} else if (proposta.getRenda() >= 2000 && proposta.getRenda() < 5000) {
					if (proposta.getIdade() >= 45 && proposta.getDependentes() > 0) {
						proposta.setResultadoAnalise("Negado");
						proposta.setLimite("0.0");
						proposta.setMotivo("reprovado pela política de crédito");
					} else {
						if (proposta.getDependentes() == 1) {
							taxaConversao = 0.8;
						} else if (proposta.getDependentes() == 2) {
							taxaConversao = 0.6;
						} else if (proposta.getDependentes() == 3) {
							taxaConversao = 0.4;
						} else if (proposta.getDependentes() > 3){
							taxaConversao = 0.2;
						}
						valorLimite = rendaComprometida * taxaConversao;
						proposta.setResultadoAnalise("Aprovado");
						if (taxaConversao != 0.0) {
							proposta.setLimite("" + valorLimite + "");
						} else {
							proposta.setLimite("" + rendaComprometida + "");
						}

					}

				} else if (proposta.getRenda() >= 5000 && proposta.getRenda() <= 8000) {
					if (proposta.getDependentes() == 1) {
						taxaConversao = 1.2;
					} else if (proposta.getDependentes() == 2) {
						taxaConversao = 1.0;
					} else if (proposta.getDependentes() == 3) {
						taxaConversao = 0.8;
					} else if (proposta.getDependentes() > 3){
						taxaConversao = 0.5;
					}
					valorLimite = rendaComprometida * taxaConversao;
					proposta.setResultadoAnalise("Aprovado");
					if (taxaConversao != 0.0) {
						proposta.setLimite("" + valorLimite + "");
					} else {
						proposta.setLimite("" + rendaComprometida + "");
					}
				} else if (proposta.getRenda() > 8000) {
					proposta.setResultadoAnalise("Aprovado");
					proposta.setLimite("" + rendaComprometida + "");
				}

				updateUser(proposta.getId(), proposta);

			}
		}

		return new ResponseEntity<List<User>>(propostas, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Criar cadastro do cliente e Proposta de crédito.")
	@RequestMapping(value = "/cliente/", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
		logger.info("Criando cadastro do cliente : {}", user);

		if (userService.isUserExist(user)) {
			logger.error("O Cliente {} já encontra-se cadastrado", user.getNome());
			return new ResponseEntity(
					new CustomErrorType("O Cliente " + user.getNome() + " já encontra-se cadastrado."),
					HttpStatus.CONFLICT);
		}
		if (user.getId() == null) {
			user.setResultadoAnalise("Em Análise");
			user.setLimite("0.0");
		}
		userService.saveUser(user);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Atualiza a proposta do cliente.")
	@RequestMapping(value = "/cliente/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody User user) {
		logger.info("Atualizando a proposta {}", id);

		User currentUser = userService.findById(id);

		if (currentUser == null) {
			logger.error("Não foi possível atualizar. Proposta de crédito {} não foi encontrado.", id);
			return new ResponseEntity(
					new CustomErrorType(
							"Não foi possível atualizar. Proposta de crédito  " + id + " não foi encontrado."),
					HttpStatus.NOT_FOUND);
		}

		currentUser.setNome(user.getNome());
		currentUser.setCpf(user.getCpf());
		currentUser.setIdade(user.getIdade());
		currentUser.setSexo(user.getSexo());
		currentUser.setEstadoCivil(user.getEstadoCivil());
		currentUser.setEstado(user.getEstado());
		currentUser.setDependentes(user.getDependentes());
		currentUser.setRenda(user.getRenda());
		currentUser.setResultadoAnalise(user.getResultadoAnalise());
		currentUser.setLimite(user.getLimite());
		currentUser.setMotivo(user.getMotivo());

		userService.updateUser(currentUser);
		return new ResponseEntity<User>(currentUser, HttpStatus.OK);
	}

}