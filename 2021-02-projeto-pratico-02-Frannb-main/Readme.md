## Instruções para compilar e executar o projeto 
Após clonar o repositório, vá até o repositório do projeto, e no terminal digite `./gradlew bootRun`. Em seguida, a API pode ser consumida através dos comandos sugeridos abaixo.

## Consumindo o serviço

#### Lâmpada

- Comando para exibir todas as lâmpadas


    `curl http://localhost:8080/lampada`


- Comando para exibir lâmpada de acordo com *id*


    `curl http://localhost:8080/lampada/7`


- Comando para atualizar lâmpada de acordo com *id*


    `curl -L -X PUT 'http://localhost:8080/lampada/7' -H 'Content-Type: application/json' --data-raw '{"id":7,"status":true}'`


#### Ar-Condicionado 

- Comando para exibir todos os ar-condicionados


    `curl http://localhost:8080/ar-condicionado`


- Comando para exibir ar-condicionado de acordo com *id*


    `curl http://localhost:8080/ar-condicionado/17`


- Comando para atualizar ar-condicionado de acordo com *id*


    `curl -L -X PUT 'http://localhost:8080/ar-condicionado/18' -H 'Content-Type: application/json' --data-raw '{"id":18,"status":true, "modo": 1, "temperatura":17}'`


#### Cortina

- Comando para exibir todas as cortinas


    `curl http://localhost:8080/cortina`


- Comando para exibir cortina de acordo com *id*


    `curl http://localhost:8080/cortina/4`


- Comando para atualizar cortina de acordo com *id*


    `curl -L -X PUT 'http://localhost:8080/cortina/5' -H 'Content-Type: application/json' --data-raw '{"id":5,"status":true}'`


#### Portão

- Comando para exibir todos os portões


    `curl http://localhost:8080/portao`


- Comando para exibir portão de acordo com *id*


    `curl http://localhost:8080/portao/13`


- Comando para atualizar portão de acordo com *id*


   `curl -L -X PUT 'http://localhost:8080/portao/14' -H 'Content-Type: application/json' --data-raw '{"id":14,"status":true}'`


#### Som

- Comando para exibir todos os sons


    `curl http://localhost:8080/som`


- Comando para exibir som de acordo com *id*


    `curl http://localhost:8080/som/15`


- Comando para atualizar portão de acordo com *id*


    `curl -L -X PUT 'http://localhost:8080/som/16' -H 'Content-Type: application/json' --data-raw '{"id":16,"status":true,"volume":20,"modo":0}'`


#### Televisão

- Comando para exibir todas as televisões


    `curl http://localhost:8080/televisao`


- Comando para exibir televisão de acordo com *id*


    `curl http://localhost:8080/televisao/1`


- Comando para atualizar televisão de acordo com *id*


    `curl -L -X PUT 'http://localhost:8080/televisao/2' -H 'Content-Type: application/json' --data-raw '{"id":2,"status":true,"volume":25,"canal":12}'`


#### Ambiente

- Comando para exibir todos os ambientes

    
    `curl http://localhost:8080/ambiente`


- Comando para adicionar um ambiente


    `curl -L -X POST 'http://localhost:8080/ambiente' -H 'Content-Type: application/json' --data-raw '{"nome" : "Quarto"}'`


- Comando para deletar um ambiente


    `curl -L -X DELETE 'http://localhost:8080/ambiente' -H 'Content-Type: application/json' --data-raw '{"nome" : "Sala"}'`


- Comando para exibir todos os dispositivos da sala


    `curl http://localhost:8080/ambiente/sala`


- Comando para adicionar um dispositivo ao ambiente


    `curl -L -X POST 'http://localhost:8080/ambiente/sala' -H 'Content-Type: application/json' --data-raw '{"status":true, "modo": 1, "temperatura":17}'`

    `curl -L -X POST 'http://localhost:8080/ambiente/sala' -H 'Content-Type: application/json' --data-raw '{"status":false, "volume": 15, "canal":9}'`

- Comando para pegar um determinado dispositivo de um ambiente


    `curl http://localhost:8080/ambiente/sala/19`

- Comando para deletar um determinado dispositivo de um ambiente


    `curl -L -X DELETE http://localhost:8080/ambiente/sala/19`

#### Cenário

- Comando para exibir todos os cenarios


    `curl http://localhost:8080/cenario`


- Comando para adicionar um cenário


    `curl -L -X POST 'http://localhost:8080/cenario' -H 'Content-Type: application/json' --data-raw '{"nome" : "iluminacao"}'`


- Comando para deletar um cenário


    `curl -L -X DELETE 'http://localhost:8080/cenario' -H 'Content-Type: application/json' --data-raw '{"nome" : "amanhecer"}'`


- Comando para exibir todos os dispositivos do cenário  festa


    `curl http://localhost:8080/cenario/festa`


- Comando para adicionar um dispositivo ao cenário


    `curl -L -X POST 'http://localhost:8080/cenario/festa' -H 'Content-Type: application/json' --data-raw '{"status":true, "modo": 1, "temperatura":17}'`

    `curl -L -X POST 'http://localhost:8080/cenario/festa' -H 'Content-Type: application/json' --data-raw '{"status":false, "volume": 15, "canal":9}'`

- Comando para pegar um determinado dispositivo de um cenário


    `curl http://localhost:8080/cenario/festa/12`

- Comando para deletar um determinado dispositivo de um cenário


    `curl -L -X DELETE http://localhost:8080/ambiente/festa/16`

## Requisitos
Em meu ponto de vista, todos os requisitos e funcionalidades foram implementados.  
