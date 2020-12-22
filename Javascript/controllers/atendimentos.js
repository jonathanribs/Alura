const Atendimento = require('../models/atendimentos')

module.exports = app => {
    //enviar algo
    app.get('/atendimentos', (req, res) => {    
        //res.send('Você está na rota de atendimentos e está realizando um GET')
        Atendimento.lista(res)
    })

    app.get('/atendimentos/:id', (req, res) => {
        console.log(req.params)

        const id = parseInt(req.params.id) //convertendo para inteiro   

        Atendimento.buscaPorId(id, res) 
    })
    
    //receber algo
    app.post('/atendimentos', (req, res) => {
        console.log('Atendimento enviado')
        console.log(req.body)
        const atendimento = req.body

        Atendimento.adiciona(atendimento, res)
        //res.send('Você está na rota de atendimentos e está realizando um POST') //passou o res para linha de cima [e teve que adicinoar no atendimentos.js do models tambem]
    })

    app.patch('/atendimentos/:id', (req, res) => {
        const id = parseInt(req.params.id)
        const valores = req.body

        Atendimento.altera(id, valores, res)
    })

    app.delete('/atendimentos/:id', (req, res) => {
        const id = parseInt(req.params.id)

        Atendimento.deleta(id, res)
    })
}
