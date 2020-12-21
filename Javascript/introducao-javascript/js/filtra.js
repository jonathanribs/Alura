var campoFiltro = document.querySelector("#filtra-tabela");

campoFiltro.addEventListener("input", function(){
    var pacientes = document.querySelectorAll(".paciente");
     if (this.value.length>0){
        for (var i = 0; i < pacientes.length; i++){
            var paciente = pacientes[i];
            var tdNome = paciente.querySelector(".info-nome");
            var nome = tdNome.textContent; 
            var expressao = new RegExp(this.value, "s"); //"i" é case insensitive e "s" é case sensitive
            if (!expressao.test(nome)){
                paciente.classList.add("invisivel");
            } else {
                paciente.classList.remove("invisivel");
            }
        }
     } else {
         pacientes.forEach(function(paciente){
             paciente.classList.remove("invisivel");
         });
     }
});

/*outra forma de comparar as strings conforme se digita é com a função substring:*/
// var comparavel = nome.substr(0, this.value.length); //começa com o caracter da posição 0
// var comparavelMinusculo = comparavel.toLowerCase();
// var valorDigitadoMinusculo = this.value.toLowerCase();

// if (!(valorDigitadoMinusculo == comparavelMinusculo)) {
//     paciente.classList.add("invisivel");
// } else{
//     paciente.classList.remove("invisivel");
// }
