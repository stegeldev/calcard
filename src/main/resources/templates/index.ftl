<!DOCTYPE html>

<html lang="en" ng-app="crudApp">
    <head>
        <title>${title}</title>
        <link href="css/bootstrap.css" rel="stylesheet"/>
        <link href="css/app.css" rel="stylesheet"/>
        
		<script>
			function formatar(mascara, documento){
		   		var i = documento.value.length;
		   		var saida = mascara.substring(0,1);
		   		var texto = mascara.substring(i)
		  
		   		if (texto.substring(0,1) != saida){
		    		documento.value += texto.substring(0,1);
		   		}  
		  	}
		 </script>
    </head>
    <body>

        <div ui-view></div>
        <script src="js/lib/angular.min.js" ></script>
        <script src="js/lib/angular-ui-router.min.js" ></script>
        <script src="js/lib/localforage.min.js" ></script>
        <script src="js/lib/ngStorage.min.js"></script>
        <script src="js/app/app.js"></script>
        <script src="js/app/UserService.js"></script>
        <script src="js/app/UserController.js"></script>
    </body>
    <center><p>Desenvolvido por Felipe Stegel - Calcard Proposta de Crédito</p></center>
</html>