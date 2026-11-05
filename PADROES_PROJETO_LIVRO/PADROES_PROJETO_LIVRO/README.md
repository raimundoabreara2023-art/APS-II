
# Fábrica de Chocolate — Padrão Singleton

Projeto desenvolvido para a disciplina de Análise e Projeto de Sistemas II.

## Referência bibliográfica

FREEMAN, Elisabeth; FREEMAN, Eric.
Use a Cabeça! Padrões de Projetos.
2. ed. Rio de Janeiro: Alta Books, 2007.

## Objetivo

Implementar e demonstrar o padrão de projeto Singleton,
utilizando como exemplo uma fábrica de chocolate com
uma caldeira compartilhada.

## Tecnologias

- Java 21
- JavaFX 21
- Maven
- FXML
- CSS

## Estrutura

- model: representação da caldeira e implementação Singleton.
- service: operações da fábrica.
- controller: controle das interações.
- resources/fxml: interface gráfica.
- resources/css: estilos visuais.

## Funcionalidades

- Encher a caldeira.
- Aquecer o chocolate.
- Retirar o chocolate.
- Consultar o estado da caldeira.
- Compartilhar uma única instância entre os componentes.

## Padrão implementado

Singleton: garante que a classe CaldeiraChocolate
tenha uma única instância acessível globalmente.

A criação da instância e as operações da caldeira
utilizam sincronização para proteção contra concorrência.
