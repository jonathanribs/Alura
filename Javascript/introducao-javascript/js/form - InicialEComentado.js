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

   var erros = validaPaciente(paciente);
   console.log(erros);
   
   if (erros.length > 0){
      exibeMensagensDeErro(erros);   
      return;
   }
    //adicionando o paciente na tabela
    var tabela = document.querySelector("#tabela-pacientes");
    tabela.appendChild(pacienteTr);

    form.reset();
    var ul = document.querySelector("#mensagens-erro");
    ul.innerHTML = "";

 });

//  function adicionaPacienteNaTabela(paciente){
//     var pacienteTr = montaTr(paciente);
//     var tabela = document.querySelector("#tabela-pacientes");
//     tabela.appendChild(pacienteTr);
//  }
 
 function exibeMensagensDeErro(erros){
    var ul = document.querySelector("#mensagens-erro");
    ul.innerHTML = ""; //preciso dessa linha aqui tbm, pois se houver erro, ele dá "return" assim que sai dessa função
                      //então ele não passaria na exclusão das mensagens feita na linha 50

    erros.forEach(function(erro){
       var li = document.createElement("li");
       li.textContent = erro;
       ul.appendChild(li);    
    });
 }

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

 function validaPaciente(paciente){

   var erros = [];

   if (paciente.nome.length == 0){
      erros.push("O nome não pode ser em branco");
   }

    if(!validaPeso(paciente.peso)){
      erros.push("O peso é Inválido!");
    }
    if(!validaAltura(paciente.altura)){
      erros.push("A altura é Inválida!");
    }

    if (paciente.gordura.length == 0){
      erros.push("A gordura não pode ser em branco");
    }
    if (paciente.peso.length == 0){
      erros.push("A peso não pode ser em branco");
    }
    if (paciente.altura.length == 0){
      erros.push("A altura não pode ser em branco");
    }

   return erros;
 }