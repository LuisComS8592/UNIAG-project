# 🚀 Projeto UNIAG - Gestão de Investigadores em Java

[![Java](https://img.shields.io/badge/Linguagem-Java%2017%2B-DB413D.svg)](https://www.oracle.com/java/technologies/downloads/)
[![License: MIT](https://img.shields.io/badge/Licença-MIT-blue.svg)](https://opensource.org/licenses/MIT)
[![Style](https://img.shields.io/badge/Estilo-Criativo%20%26%20Robusto-green.svg)]()

### Um sistema de gestão académico que vai além do "Hello, World!".

Este projeto foi desenvolvido com ☕ e muito código no âmbito da Unidade Curricular de **Programação Orientada por Objetos (POO)**.

**Autor:** Luis Enrique
**Versão:** 1.7 (Final com CRUD completo!)
**[Javadoc](https://luiscoms8592.github.io/UNIAG-project/)**

---

## A Missão 🎯

Gerir uma unidade de investigação pode ser um caos: quem está em que projeto? Como se distribuem as verbas? Quem acabou de entrar?

É aqui que o **Projeto UNIAG** entra em cena! Esta não é apenas mais uma aplicação de consola. [cite_start]É uma demonstração robusta de como a Programação Orientada por Objetos pode ser usada para modelar um problema do mundo real, criando uma solução organizada, eficiente e, mais importante, fácil de expandir.

O sistema controla o ciclo de vida completo de investigadores e projetos, desde a sua criação até à sua remoção.

---

## O Arsenal de Funcionalidades ⚙️

Com uma interface de consola interativa, você pode:

* **➕ Criar:**
    * Registar novos membros (Investigadores, Colaboradores e Visitantes) com IDs gerados automaticamente.
    * Registar novos projetos de investigação com todos os detalhes.

* **🔎 Ler:**
    * Listar todos os membros e projetos existentes com informações detalhadas.
    * Pesquisar um projeto específico pelo seu ID para ver quem está a trabalhar nele.

* **✏️ Editar:**
    * Atualizar o nome de um membro ou os dados de um projeto (título e financiamento).

* **❌ Remover:**
    * Remover membros ou projetos do sistema, garantindo que todas as associações entre eles são desfeitas de forma consistente.

* **🔗 Gerir:**
    * Associar investigadores a projetos e distribuir as verbas de financiamento de forma justa.

---

## A "Magia" por Trás do Código ✨ (Conceitos de POO Aplicados)

Este projeto não é só sobre o que ele faz, mas *como* ele faz. Foi construído sobre os pilares da POO, ensinados em aula:

* **🛡️ Encapsulamento (O Cofre Forte):** Nenhum dado é exposto diretamente! [cite_start]Todos os atributos de instância são `private`. [cite_start]O acesso é rigorosamente controlado por uma API de métodos `public`. [cite_start]Para objetos e coleções, usamos **cópia defensiva** com `clone()` e `Collections.unmodifiableList` para que o estado interno dos nossos objetos seja impenetrável, como manda a regra de ouro.

* **👨‍👩‍👧‍👦 Herança (DNA de Código):** Criámos uma hierarquia clara com `MembroInvestigador` como a superclasse (`abstract`), e as subclasses `Investigador`, `InvColaborador` e `Visitante` a herdar (`extends`) o seu comportamento e estado base. [cite_start]É a relação "é-um-tipo-de" em ação.

* **🎭 Polimorfismo (O Mestre dos Disfarces):** A beleza da POO em exibição! Na classe `UNIAG`, uma única coleção `Map<Integer, MembroInvestigador>` armazena todos os tipos de membros. Quando o método `mostrarMembros()` chama `membro.print()`, o Java, em tempo de execução, sabe exatamente qual versão do método executar (`Investigador.print()`, `Visitante.print()`, etc.). [cite_start]Isto é a **procura dinâmica de métodos** (dynamic method lookup) a funcionar.

* [cite_start]**🧠 Abstração (Foco no Essencial):** A classe `MembroInvestigador` é `abstract` porque não existe um "membro genérico" no mundo real. [cite_start]Ela define um "contrato" com métodos `abstract` que forçam as subclasses a terem a sua própria implementação, garantindo consistência na hierarquia.

* **📜 Padrões de Mestre Java:**
    * [cite_start]**`equals()` & `hashCode()`:** Implementados para definir a igualdade lógica (baseada em ID) em vez da igualdade de referência (`==`), o que é crucial para o funcionamento de coleções como `HashMap`. 
    * [cite_start]**`clone()`:** Implementado usando o padrão do **construtor de cópia**, como enfatizado nas aulas, para garantir a duplicação segura e profunda dos objetos. 
    * [cite_start]**`toString()`:** Sobrescrito em todas as classes de modelo para fornecer uma representação textual útil para logging e depuração. 

* [cite_start]**🗂️ Organização com Packages:** O projeto está estruturado em `packages` (`pt.ipb.uniag.modelo` e `pt.ipb.uniag.app`) para separar as responsabilidades e evitar o "default package", uma prática profissional. 

---

## Como Ligar a Máquina 🚀

Pronto para ver a ação?

1.  **Clone o repositório:**
    ```bash
    git clone https://github.com/LuisComS8592/UNIAG-project.git
    ```
2.  **Abra no IntelliJ IDEA:** Abra a pasta do projeto no seu IDE de eleição.
3.  **Encontre a ignição:** Navegue até `src/pt/ipb/uniag/app/TesteUNIAG.java`.
4.  **Execute:** Clique com o botão direito e selecione **Run 'TesteUNIAG.main()'**. O menu interativo aparecerá na sua consola.

---

## Mapa do Tesouro 🗺️ (Estrutura de Ficheiros)

```
Projeto-UNIAG/
├── .git/
├── .gitignore
├── docs/
│   └── (Documentação Javadoc gerada)
├── out/
│   └── artifacts/
│       └── ProjetoUNIAG.jar
├── src/
│   └── pt/
│       └── ipb/
│           └── uniag/
│               ├── app/
│               │   ├── package-info.java
│               │   ├── UNIAG.java
│               │   └── TesteUNIAG.java
│               └── modelo/
│                   ├── package-info.java
│                   ├── MembroInvestigador.java
│                   ├── Investigador.java
│                   ├── InvColaborador.java
│                   ├── Visitante.java
│                   └── Projeto.java
├── LICENSE
└── README.md
```

---

## A "Papelada" 📄 (Licença)

Este projeto está licenciado sob a **MIT License**. Sinta-se à vontade para usar, estudar e adaptar o código.
