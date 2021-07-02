# DESAFIO MURAL DE AVISOS CERS

Simples CRUD (create, read, update, delete) de avisos escrito em Angular e Spring Boot

## Objetivo

Codificar um sistema que deverá criar um CRUD (create, read, update, delete) de avisos.

## Sistema

Na listagem, os avisos devem vir paginados. Deve-se mostrar apenas o titulo do aviso e ao clicar mostrar as outras informações do aviso e marcar o mesmo como visualizado.

Cada aviso deverá ter:

id<br>
titulo<br>
descrição<br>
data de publicação<br>
data de visualização<br>

## Tecnologias

Será utilizado Angular e Spring Boot para concluir este desafio, sendo assim, será necessário criar 2 projetos.

O projeto que utilizará Spring servirá como API que receberá as requisições do projeto em Angular.<br>
O projeto em Angular será responsável por criar toda a parte visual e serviços que irão se comunicar com a API em Spring.

<h4>Obs.:</h4>

Versões das tecnologias à sua escolha.<br>
Não será avaliado layout e sim funcionalidade, porém é importante manter o mínimo apresentável para seguir o fluxo do CRUD.<br>
Não precisa se preocupar com autenticação

## Execução dos Projetos

Backend:
- Criar o Banco de dados com o nome `noticeboard`. 
- Alterar as informações de acesso ( Login e Senha ) do MYSQL, no arquivo `application.properties` dentro da pasta do projeto. 
- Para rodar o projeto, execute  o comando `./mvnw spring-boot:run`.

Frontend:
- Acessar a pasta `noticeboard-frontend`.
- Rodar o comando `npm install` para instalar os respectivos pacotes do projeto. 
- Após isso, rodar o comando `ng serve`, dentro da pasta, para executar a aplicação.

OBS: Rodar primeiro o Backend Spring, em seguida o Frontend Angular, necessariamente nessa ordem.
