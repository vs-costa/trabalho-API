# Trabalho-API: Cadastro de Veículos para Acesso ao Estabelecimento

Este é um projeto individual desenvolvido como parte da aula de Desenvolvimento de API Restful para a Residência Serratec.

## Visão Geral

**Título:** Cadastro de Veículos para Acesso ao Estabelecimento

**Cenário:**
Este programa foi criado para atender à necessidade de um estabelecimento privado, como uma empresa, shopping ou qualquer local específico, de manter um registro dos veículos que frequentam o local. Para isso, os usuários (Pessoas) podem criar uma conta e registrar seus veículos para uso dentro do estabelecimento, como em um pátio de uma empresa ou estacionamento.

## Funcionalidades Principais

- Cadastro de usuário (Pessoa) com confirmação por e-mail e geração de token para login.
- Login seguro usando JSON Web Token (JWT).
- Possibilidade de listar, atualizar, desativar e reativar a conta do usuário.
- Registro de veículos associados aos usuários (limite de 1 veículo por pessoa) com opções para atualizar, listar, remover e reativar veículos.

## Tecnologias Utilizadas

- **Spring Tools Suite 4**
- **Java 11**
- **Maven Apache 4.0**
- **Spring Boot 2.7.16**
- **Swagger 3.0**
- **JSON Web Token (JWT) 3.19.2**
- **Via CEP**

## Instruções de Uso

1. **Cadastro e Login:**
   - Cadastre-se no sistema e confirme seu e-mail.
   - Após o cadastro, obtenha um token de autenticação.
  
2. **Operações de Conta:**
   - Utilize o token para acessar e gerenciar sua conta: listar, atualizar, desativar ou reativar.

3. **Registro e Gerenciamento de Veículos:**
   - Registre seu veículo no sistema.
   - Gerencie as informações do veículo: atualize, liste, remova ou reative conforme necessário.

**Observação:** Todas as operações relacionadas a veículos e informações pessoais requerem autenticação do usuário. As operações de cadastro e login são abertas.

## Autor

**Autor:** Victor Soares da Costa
