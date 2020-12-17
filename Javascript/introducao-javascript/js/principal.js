console.log("Fui carregado de um arquivo externo!");
var titulo = document.querySelector(".titulo");
console.log(titulo.textContent);
titulo.textContent = "Aparecida Nutricionista";

 var paciente = document.querySelector("#primeiro-paciente");

 var tdPeso = paciente.querySelector(".info-peso");
 var peso = tdPeso.textContent;

 var tdAltura = paciente.querySelector(".info-altura");
 var altura = tdAltura.textContent;

 console.log(paciente); //tr
 console.log(tdPeso); //td que tem o peso
 console.log(peso); //Obter 100

 console.log(tdAltura); 
 console.log(altura); 

 var imc = peso / (altura * altura); //100 / 2.0 * 2.0 = 25

 console.log(imc);