var paciente = document.querySelectorAll(".paciente");

var tabela = document.querySelector("table"); //para  selecionar tags não precisa de passar nada além do nome da tag

tabela.addEventListener("dblclick", function(event){
    // o if abaixo foi adicionado para não apagar o cabeçalho que tem tag "th"
    if (event.target.tagName == "TD"){ //o nome da tag que se passa neste método deve estar em MAIUSCULO
        event.target.parentNode.classList.add("fadeOut");
        setTimeout(function(){
            event.target.parentNode.remove();
        },500);
    } //se eu tivesse usado o "tbody" na linha 3, ao invés da tabela, funcionaria da mesma forma e não precisaria do if

    //alvoEvento = event.target;
    //paiDoAlvo = alvoEvento.parentNode; //TR 
    //this = neste caso seria a própria tabela, pois é quem chama o método de escutar eventos
});