var botaoAdicionar = document.querySelector("#adicionar-paciente");
 botaoAdicionar.addEventListener('click', function(event){ //aparentemente posso usar aspas duplas ou simples que não faz diferença
    event.preventDefault();

    //Salvando as informações preenchidas pelo usuário
    var form = document.querySelector("#form-adiciona");
   //  nome = form.nome.value;    //assim que era o codigo antigo, mantive ele comentado para eu entender a parte de baixo
   //  peso = form.peso.value;    
   //  altura = form.altura.value;
   //  gordura = form.gordura.value;
    var paciente = obtemPacienteDoFormulario(form);

    console.log(paciente); //exibindo o objeto criado
 
    //Criando a tr e td do paciente (linhas e colunas da nossa tabela) -      Comentei tudo pois será feito em função mais abaixo
    var pacienteTr = montaTr(paciente);
   //  var pacienteTr = document.createElement("tr");

   //  var nomeTd = document.createElement("td"); //cria os elementos da tabela "internamente"
   //  var pesoTd = document.createElement("td");
   //  var alturaTd = document.createElement("td");
   //  var gorduraTd = document.createElement("td");
   //  var imcTd = document.createElement("td");

   //  nomeTd.textContent = nome; //preenchendo a tabela
   //  pesoTd.textContent = peso;
   //  alturaTd.textContent = altura;
   //  gorduraTd.textContent = gordura;
   //  imcTd.textContent = calculaImc(peso, altura);;

   //  pacienteTr.appendChild(nomeTd); //montando a tabela (uma linha da tabela)
   //  pacienteTr.appendChild(pesoTd);
   //  pacienteTr.appendChild(alturaTd);
   //  pacienteTr.appendChild(gorduraTd);
   //  pacienteTr.appendChild(imcTd);

    //adicionando o paciente na tabela
    var tabela = document.querySelector("#tabela-pacientes");
    tabela.appendChild(pacienteTr);

    form.reset();

 });
 
 function obtemPacienteDoFormulario(form){

   var paciente = {
      nome: form.nome.value,    
      peso: form.peso.value,
      altura: form.altura.value,
      gordura: form.gordura.value,
      imc: calculaImc(form.peso.value, form.altura.value)
   }
   return paciente
 }

 function montaTr(paciente){
   var pacienteTr = document.createElement("tr");
   pacienteTr.classList.add("paciente");

   pacienteTr.appendChild(montaTd(paciente.nome, "info-nome")); //montando a tabela (uma linha da tabela)
   pacienteTr.appendChild(montaTd(paciente.peso, "info-peso"));
   pacienteTr.appendChild(montaTd(paciente.altura, "info-altura"));
   pacienteTr.appendChild(montaTd(paciente.gordura, "info-gordura"));
   pacienteTr.appendChild(montaTd(paciente.imc, "info-imc"));

   return pacienteTr
 }

 function montaTd(dado, classe){
    var td = document.createElement("td");
    td.textContent = dado;
    td.classList.add(classe);

    return td; 
 }