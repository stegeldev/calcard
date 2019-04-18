<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Proposta de Crédito</span> <img src="https://calcard.com.br/images/logo.png" align="right"> </div>
		<div class="panel-body">
	        <div class="formcontainer">
	            <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
	            <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
	            <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
	                <input type="hidden" ng-model="ctrl.user.id" />
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="nome">Nome:</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.user.nome" id="uname" class="username form-control input-sm" placeholder="Nome Completo" required minlength="3" maxlength="30"/>
	                        </div>
	                    </div>
	                </div>

					<div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="cpf">CPF:</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.user.cpf" id="cpf" class="form-control input-sm" placeholder="CPF (somente números)" required maxlength="11"/>
	                        </div>
	                    </div>
	                </div>

	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="idade">Idade</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.user.idade" id="idade" class="form-control input-sm" placeholder="Idade" required maxlength="3" ng-pattern="ctrl.onlyIntegers"/>
	                        </div>
	                    </div>
	                </div>
	                
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="sexo">Sexo:</label>
	                        <div class="col-md-3">
	                            <select class="form-control" id="sexo" ng-model="ctrl.user.sexo">
								    <option value="M">Masculino</option>
								    <option value="F">Feminino</option>
							  	</select>
	                        </div>
	                    </div>
	                </div>
	                
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="estadoCivil">Estado Civil:</label>
	                        <div class="col-md-3">
	                            <select class="form-control" id="estadoCivil" ng-model="ctrl.user.estadoCivil">
								    <option value="solteiro">Solteiro</option>
								    <option value="casado">Casado</option>
								    <option value="divorciado">Divorciado</option>
								    <option value="viuva">Viuva</option>
							  	</select>
	                        </div>
	                    </div>
	                </div>
	                
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="estado">Estado:</label>
	                        <div class="col-md-3">
	                        	<select class="form-control" id="estado" ng-model="ctrl.user.estado">
	                            	<option value="AC">Acre</option>
									<option value="AL">Alagoas</option>
									<option value="AP">Amapá</option>
									<option value="AM">Amazonas</option>
									<option value="BA">Bahia</option>
									<option value="CE">Ceará</option>
									<option value="DF">Distrito Federal</option>
									<option value="ES">Espírito Santo</option>
									<option value="GO">Goiás</option>
									<option value="MA">Maranhão</option>
									<option value="MT">Mato Grosso</option>
									<option value="MS">Mato Grosso do Sul</option>
									<option value="MG">Minas Gerais</option>
									<option value="PA">Pará</option>
									<option value="PB">Paraíba</option>
									<option value="PR">Paraná</option>
									<option value="PE">Pernambuco</option>
									<option value="PI">Piauí</option>
									<option value="RJ">Rio de Janeiro</option>
									<option value="RN">Rio Grande do Norte</option>
									<option value="RS">Rio Grande do Sul</option>
									<option value="RO">Rondônia</option>
									<option value="RR">Roraima</option>
									<option value="SC">Santa Catarina</option>
									<option value="SP">São Paulo</option>
									<option value="SE">Sergipe</option>
									<option value="TO">Tocantins</option>
								</select>
	                        </div>
	                    </div>
	                </div>
	                
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="dependentes">Dependentes:</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.user.dependentes" id="dependentes" class="form-control input-sm" placeholder="Nr. de Dependentes" required maxlength="2" ng-pattern="ctrl.onlyIntegers"/>
	                        </div>
	                    </div>
	                </div>
	
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="renda">Renda Mensal: </label>
	                        <div class="col-md-7">
	                           <input type="text" ng-model="ctrl.user.renda" id="renda" class="form-control input-sm" placeholder="Renda Mensal" required/>
	                        </div>
	                    </div>
	                </div>

	                <div class="row">
	                    <div class="form-actions floatRight">
	                        <input type="submit"  value="{{!ctrl.user.id ? 'Salvar Proposta' : 'Editar Proposta'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid || myForm.$pristine">
	                        <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Limpar Proposta</button>
	                    </div>
	                </div>
	            </form>
    	    </div>
		</div>	
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Análise e Tomada de Decisão</span></div>
		<div class="panel-body">
			<div class="table-responsive">
		        <table class="table table-hover">
		            <thead>
		            <tr>
		            	<th>Nr. Proposta</th>
		                <th>Nome</th>
		                <th>Idade</th>
		                <th>Sexo</th>
		                <th>Estado Civil</th>
		                <th>Estado</th>
		                <th>Dependentes</th>
		                <th>Renda R$</th>
		                <th>Limite R$</th>
		                <th>Resultado Análise</th>
		                <th>Motivo</th>
		            </tr>
		            </thead>
		            <tbody>
		            <tr ng-repeat="u in ctrl.getAllUsers()">
		                <td>{{u.id}}</td>
		                <td>{{u.nome}}</td>
		                <td>{{u.idade}}</td>
		                <td>{{u.sexo}}</td>
		                <td>{{u.estadoCivil}}</td>
		                <td>{{u.estado}}</td>
		                <td>{{u.dependentes}}</td>
		                <td>{{u.renda | brlCurrency}}</td>
		                 <td>{{u.limite | brlCurrency}}</td>
		                <td ng-if="u.resultadoAnalise == 'Em Análise'"><p class="text-info">{{u.resultadoAnalise}}</p></td>
		                <td ng-if="u.resultadoAnalise == 'Negado'"><p class="text-danger">{{u.resultadoAnalise}}</p></td>
		                <td ng-if="u.resultadoAnalise == 'Aprovado'"><p class="text-success">{{u.resultadoAnalise}}</p></td>
		                <td ng-if="u.resultadoAnalise == 'Negado'"><p class="text-danger">{{u.motivo}}</p></td>
		                <td ng-if="u.resultadoAnalise != 'Negado'"><p>{{"-"}}</p></td>
		            </tr>
		            </tbody>
		        </table>
			</div>
		</div>
    </div>
</div>