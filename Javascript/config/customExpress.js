//Essa é a configuração geral do servidor
const express = require('express') 
const consign = require('consign')
const bodyParser = require ('body-parser') //usada para configurar os dados que serão recebidos

module.exports = () =>{
    const app = express()

    app.use(bodyParser.urlencoded({extended: true}))
    app.use(bodyParser.json())

    consign()
        .include('controllers')
        .into(app)

    return app
}

    