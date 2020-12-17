console.log("Fui carregado de um arquivo externo!");
var titulo = document.querySelector(".titulo");
console.log(titulo.textContent);
titulo.textContent = "Aparecida Nutricionista";

 var pacientes = document.querySelectorAll(".paciente");
 //console.log(pacientes);

 for (var i = 0; i < pacientes.length; i++){

    var paciente = pacientes[i];

    var tdPeso = paciente.querySelector(".info-peso");
    var peso = tdPeso.textContent;

    var tdAltura = paciente.querySelector(".info-altura");
    var altura = tdAltura.textContent;

    var tdImc = paciente.querySelector(".info-imc");

    var pesoEhValido = true;
    var alturaEhValida = true;

    if (peso < 0 || peso > 1000){
        console.log("Peso Invalido!");
        pesoEhValido = false;
        tdImc.textContent = "Peso Invalido!";
        paciente.classList.add("paciente-invalido")
        tdPeso.classList.add("elemento-invalido");
    }
    if (altura < 0 || altura > 3.00){
        console.log("Altura Invalida!");
        alturaEhValida = false;
        tdImc.textContent = "Altura Invalida!";
        paciente.style.backgroundColor = "lightcoral";
        tdAltura.style.color = "red";
    }

    if (alturaEhValida && pesoEhValido){
        var imc = peso / (altura * altura); //100 / 2.0 * 2.0 = 25
        tdImc.textContent = imc.toFixed(2);
    }
 }

 