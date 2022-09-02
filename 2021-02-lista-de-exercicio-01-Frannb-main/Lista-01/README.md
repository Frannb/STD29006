

## Credenciais para autenticação
| Matrícula  |   Senha   | 
| :--------: | :-------: |
| 1910066330 |    m321   |
| 1920030407 |   jose23  |
| 1810017999 |   livi1   |
| 2020045962 |  debian8  |

## Manual de compilação:
- Para compilar a imagem é necessário executar o comando:

` docker build -t server . `

` docker build -t client . `

- Criar uma rede para os contêineres

` docker network create --driver bridge rede-l1 `

- Iniciar o contêiner que será o servidor

` docker run -it (NOME DO CONTÊINER) /bin/bash `

- Adicionar o contêiner a Rede

` Em outro terminal execute: docker ps -a para pegar o ID do contêiner
  docker network connect rede-l1 (ID ou NOME DO CONTÊINER) `
  
OBS: Fazer este passo para Cliente e Servidor 

- Rodando o projeto

` Após iniciar o server e client, é necessário em cada contêiner rodar o projeto para isso,
  no servidor executar: javac Servidor.java e depois java Servidor 127.0.0.1 5002
 no client executar: javac Cliente.java e depois java Cliente 127.0.0.1 5002 `


## Não implementado:
Nesta lista 1, de acordo com a especificação apenas a parte de retorno do cliente ao servidor que não foi implementada. 


