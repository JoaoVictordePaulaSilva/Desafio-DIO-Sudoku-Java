# 🧩 Sudoku Dinâmico em Java

Um jogo de Sudoku interativo desenvolvido em **Java 21**, utilizando **JavaFX** para a interface gráfica e **Maven** para gerenciamento de dependências. O projeto foca em lógica de programação orientada a objetos (POO) e experiência de usuário dinâmica.

## 🚀 Funcionalidades

* **Geração Dinâmica:** Tabuleiros gerados aleatoriamente a cada início de jogo.
* **Sistema de Vidas:** O jogador possui 3 vidas. Erros na inserção de números descontam vidas em tempo real.
* **Interface Moderna:** Desenvolvida com JavaFX, com campos auto-ajustáveis e validação visual.
* **Validação de Regras:** Verificação automática de linha, coluna e quadrante 3x3.
* **Modularização:** Projeto configurado com o sistema de módulos do Java (`module-info.java`).

## 🛠️ Tecnologias Utilizadas

* **Java 21:** Versão mais recente do JDK com suporte a longo prazo (LTS).
* **JavaFX 21:** Para a criação da interface gráfica (GUI).
* **Maven:** Para automação de builds e controle de dependências.
* **IntelliJ IDEA:** IDE utilizada no desenvolvimento.

## 📦 Estrutura do Projeto

O projeto segue a separação de responsabilidades (MVC simplificado):

* `model`: Contém a representação do tabuleiro e o estado do jogo.
* `service`: Responsável pela lógica de validação e geração dos desafios.
* `ui`: Camada de interface visual e controle de eventos do usuário.

## ⚙️ Como Executar

1. **Pré-requisitos:**
    * Ter o JDK 21 ou superior instalado.
    * Ter o Maven configurado.

2. **Clonar o repositório:**
   ```bash
   git clone [https://github.com/JoaoVictordePaulaSilva/Sudoku-Java.git](https://github.com/JoaoVictordePaulaSilva/Sudoku-Java.git)