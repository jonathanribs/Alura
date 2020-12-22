class Tabelas{
    init(conexao){
        this.conexao = conexao

        this.criarAtendimentos()
    }

    criarAtendimentos(){
        const sql = 'CREATE TABLE IF NOT EXISTS Atendimentos (id int NOT NULL AUTO_INCREMENT, cliente varchar(50) NOT NULL, pet varchar(20), servico varchar(20) NOT NULL, data datetime NOT NULL, dataCriacao datetime NOT NULL, status varchar(20) NOT NULL, observacoes text, PRIMARY KEY(id))'
        
        this.conexao.query(sql, erro => { //query é um método disponibilizado pela biblioteca do mysql que salva os dados na base de dados (aqui teve 2 parametros[sendo o segundo a função], em atendimentos.js do models, teve 3 parametros[2º foi dados e 3º foi função])
            if(erro){
                console.log(erro)
            } else {
                console.log('Tabela Atendimentos criada com sucesso')
            }
        })
    }
}

module.exports = new Tabelas