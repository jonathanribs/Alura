console.log("Fui carregado de um arquivo externo!");
var titulo = document.querySelector(".titulo");//selecionar classe usa-se ponto antes do nome
console.log(titulo.textContent); //exibe algo no terminal
titulo.textContent = "Aparecida Nutricionista"; //altera o conteúdo de "titulo"

 var pacientes = document.querySelectorAll(".paciente");//All para selecionar todas classe. Retorna um vetor.
 //var paciente = document.querySelector("#primeiro-paciente");//selecionar id (identificador), usa-se "#"

 for (var i = 0; i < pacientes.length; i++){

    var paciente = pacientes[i];

    var tdPeso = paciente.querySelector(".info-peso");
    var peso = tdPeso.textContent;

    var tdAltura = paciente.querySelector(".info-altura");
    var altura = tdAltura.textContent;

    var tdImc = paciente.querySelector(".info-imc");

    var pesoEhValido = validaPeso(peso);
    var alturaEhValida = validaAltura(altura);

    if (!pesoEhValido){
        console.log("Peso Invalido!");
        pesoEhValido = false;
        tdImc.textContent = "Peso Invalido!";
        paciente.classList.add("paciente-invalido") //adicionando uma nova classe pra linha paciente
        tdPeso.classList.add("elemento-invalido"); //passando uma nova classe pra coluna Peso, será modificado no CSS
        //classList acessa a lista de classes, e é através dela que temos a função de adicionar nova classe
        //indo no navegador, clicar com o botao direito e selecionar inspecionar, vemos como o código html fica ali
    }
    if (!alturaEhValida){
        console.log("Altura Invalida!");
        alturaEhValida = false;
        tdImc.textContent = "Altura Invalida!";
        paciente.style.backgroundColor = "lightcoral"; //alterando cor de fundo
        tdAltura.style.color = "red"; //alterando cor da linha
    }

    if (alturaEhValida && pesoEhValido){
        var imc = calculaImc(peso, altura); //100 / 2.0 * 2.0 = 25
        tdImc.textContent = imc; //Exibe 2 casas decimais
    }
 }

 //escutar evento
 titulo.addEventListener("click", function (){
     console.log("Chamando uma função anônima em um evento");
 });
 //a função também poderia ter sido criada a parte e chamada como:
 //titulo.addEventListener("click", mostraMensagem);
 //function mostraMensagem(){
 //   console.log("Chamando uma função anônima em um evento");
 //}       //A diferença é que passaria só o nome da função, e na anonima ela nem precisa de ter um nome

 function validaPeso(peso){
     if (peso >= 0 && peso < 1000){
         return true;
     } else {
         return false;
     }
 }
 function validaAltura(altura){
    if (altura >= 0 && altura <= 3.0){
        return true;
    } else {
        return false;
    }
}

 function calculaImc(peso, altura){
     var imc = 0;
     imc = peso / (altura * altura);
     return imc.toFixed(2);
 }