const express = require('express')
const app = express()
//const bodyParser = require('body-parser')

//Definir json como padrão para nossa api
//app.use(bodyParser.json()) //bodyParser ficou como deprecated, então foi substituido pelas 2 linhas abaixo
app.use(express.json())
app.use(express.urlencoded({ extended: true }))

app.listen(3000, () => console.log('A API está funcionando!'))