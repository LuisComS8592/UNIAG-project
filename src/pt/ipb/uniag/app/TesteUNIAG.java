package pt.ipb.uniag.app;// Ficheiro: src/pt.ipb.uniag.app.TesteUNIAG.java

import pt.ipb.uniag.modelo.*;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe de teste e interface de consola para a aplicação de gestão da pt.ipb.uniag.app.UNIAG.
 * Contém o método main que inicia a aplicação e apresenta um menu interativo
 * para o utilizador manipular os dados do sistema.
 *
 * @author Luis Enrique
 * @version 1.7
 * @since 2025-06-09
 */
public class TesteUNIAG {

    private static final Scanner scanner = new Scanner(System.in);
    private static final UNIAG uniag = new UNIAG();

    /**
     * Construtor privado para prevenir a instanciação desta classe utilitária.
     */
    private TesteUNIAG() {
        // Esta classe não deve ser instanciada.
    }

    /**
     * Ponto de entrada principal da aplicação.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        popularDadosIniciais();

        System.out.println("Bem-vindo ao Sistema de Gestão da pt.ipb.uniag.app.UNIAG!");
        int opcao;
        do {
            mostrarMenu();
            opcao = lerOpcao();

            switch (opcao) {
                case 1: registarNovoMembro(); break;
                case 2: registarNovoProjeto(); break;
                case 3: associarMembroProjeto(); break;
                case 4: distribuirVerba(); break;
                case 5: uniag.mostrarMembros(); break;
                case 6: uniag.mostrarProjetos(); break;
                case 7: pesquisarProjeto(); break;
                case 8: editarMembro(); break;
                case 9: editarProjeto(); break;
                case 10: removerMembro(); break;
                case 11: removerProjeto(); break;
                case 0: System.out.println("\nA sair do sistema. Até breve!"); break;
                default: System.out.println("Opção inválida. Tente novamente."); break;
            }

            if (opcao != 0 && opcao != -1) {
                System.out.println("\nPressione ENTER para voltar ao menu...");
                scanner.nextLine();
            }
        } while (opcao != 0);

        scanner.close();
    }

    /**
     * Exibe o menu principal de opções na consola.
     */
    private static void mostrarMenu() {
        System.out.println("\n===== MENU PRINCIPAL =====");
        System.out.println("--- Criar (Create) ---");
        System.out.println("1. Registar Novo Membro");
        System.out.println("2. Registar Novo pt.ipb.uniag.modelo.Projeto");
        System.out.println("3. Associar Membro a pt.ipb.uniag.modelo.Projeto");
        System.out.println("4. Distribuir Verba de pt.ipb.uniag.modelo.Projeto");
        System.out.println("\n--- Ler (Read) ---");
        System.out.println("5. Listar Todos os Membros");
        System.out.println("6. Listar Todos os Projetos");
        System.out.println("7. Pesquisar Detalhes de um pt.ipb.uniag.modelo.Projeto");
        System.out.println("\n--- Editar (Update) ---");
        System.out.println("8. Editar Nome de Membro");
        System.out.println("9. Editar Dados de pt.ipb.uniag.modelo.Projeto");
        System.out.println("\n--- Remover (Delete) ---");
        System.out.println("10. Remover Membro");
        System.out.println("11. Remover pt.ipb.uniag.modelo.Projeto");
        System.out.println("\n--------------------------");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    /**
     * Lê e valida a opção numérica do utilizador.
     * @return O número da opção, ou -1 em caso de erro.
     */
    private static int lerOpcao() {
        try {
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consome a quebra de linha
            return opcao;
        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida. Por favor, insira um número.");
            scanner.nextLine(); // Limpa o buffer do scanner
            return -1;
        }
    }

    // --- MÉTODOS PARA AS OPÇÕES DO MENU ---

    private static void registarNovoMembro() {
        System.out.println("\n--- 1. Registar Novo Membro ---");
        System.out.print("Insira o nome do membro: ");
        String nome = scanner.nextLine();
        System.out.println("Qual o tipo? (1-pt.ipb.uniag.modelo.Investigador, 2-Colaborador, 3-pt.ipb.uniag.modelo.Visitante)");
        int tipo = lerOpcao();
        MembroInvestigador novoMembro = null;
        switch (tipo) {
            case 1: novoMembro = uniag.addInvestigador(nome); break;
            case 2: novoMembro = uniag.addInvColaborador(nome); break;
            case 3: novoMembro = uniag.addVisitante(nome); break;
            default: System.out.println("Tipo de membro inválido."); return;
        }
        System.out.println("Membro registado com sucesso! ID gerado: " + novoMembro.getId());
    }

    private static void registarNovoProjeto() {
        System.out.println("\n--- 2. Registar Novo pt.ipb.uniag.modelo.Projeto ---");
        System.out.print("Insira o título do projeto: ");
        String titulo = scanner.nextLine();
        System.out.print("Insira o financiamento do projeto: ");
        double fin;
        try {
            fin = scanner.nextDouble();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Valor de financiamento inválido.");
            scanner.nextLine(); return;
        }
        try {
            Projeto novoProjeto = uniag.addProjeto(titulo, fin);
            System.out.println("pt.ipb.uniag.modelo.Projeto registado com sucesso! ID gerado: " + novoProjeto.getId());
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar projeto: " + e.getMessage());
        }
    }

    private static void associarMembroProjeto() {
        System.out.println("\n--- 3. Associar Membro a pt.ipb.uniag.modelo.Projeto ---");
        System.out.print("Insira o ID do membro: ");
        int idMembro = lerOpcao();
        System.out.print("Insira o ID do projeto: ");
        int idProj = lerOpcao();
        if (uniag.associaMembroProjeto(idMembro, idProj)) {
            System.out.println("Associação realizada com sucesso!");
        } else {
            System.out.println("Falha na associação. Verifique se os IDs existem.");
        }
    }

    private static void distribuirVerba() {
        System.out.println("\n--- 4. Distribuir Verba de pt.ipb.uniag.modelo.Projeto ---");
        System.out.print("Insira o ID do projeto: ");
        int idProj = lerOpcao();
        if (!uniag.distribuirVerbaPorInvestigador(idProj)) {
            System.out.println("pt.ipb.uniag.modelo.Projeto com ID " + idProj + " não encontrado.");
        }
    }

    private static void pesquisarProjeto() {
        System.out.println("\n--- 7. Pesquisar Detalhes de pt.ipb.uniag.modelo.Projeto ---");
        System.out.print("Insira o ID do projeto: ");
        int idProj = lerOpcao();
        Projeto p = uniag.findProjeto(idProj);
        if (p != null) {
            p.printDetalhes();
        } else {
            System.out.println("pt.ipb.uniag.modelo.Projeto com ID " + idProj + " não encontrado.");
        }
    }

    private static void editarMembro() {
        System.out.println("\n--- 8. Editar Nome de Membro ---");
        System.out.print("Insira o ID do membro a editar: ");
        int idMembro = lerOpcao();
        if (uniag.findMembro(idMembro) == null) { System.out.println("Membro não encontrado."); return; }
        System.out.print("Insira o novo nome: ");
        String novoNome = scanner.nextLine();
        if (uniag.editarNomeMembro(idMembro, novoNome)) {
            System.out.println("Nome do membro atualizado com sucesso.");
        }
    }

    private static void editarProjeto() {
        System.out.println("\n--- 9. Editar Dados de pt.ipb.uniag.modelo.Projeto ---");
        System.out.print("Insira o ID do projeto a editar: ");
        int idProj = lerOpcao();
        if (uniag.findProjeto(idProj) == null) { System.out.println("pt.ipb.uniag.modelo.Projeto não encontrado."); return; }

        System.out.print("Novo título (deixe em branco para não alterar): ");
        String novoTitulo = scanner.nextLine();
        if (!novoTitulo.trim().isEmpty()) {
            uniag.editarTituloProjeto(idProj, novoTitulo);
        }

        System.out.print("Novo financiamento (insira um valor negativo para não alterar): ");
        try {
            double novoFin = scanner.nextDouble();
            scanner.nextLine();
            if (novoFin >= 0) {
                uniag.editarFinanciamentoProjeto(idProj, novoFin);
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. O financiamento não foi alterado.");
            scanner.nextLine();
        }
        System.out.println("pt.ipb.uniag.modelo.Projeto atualizado.");
    }

    private static void removerMembro() {
        System.out.println("\n--- 10. Remover Membro ---");
        System.out.print("Insira o ID do membro a remover: ");
        int idMembro = lerOpcao();
        if (uniag.removerMembro(idMembro)) {
            System.out.println("Membro com ID " + idMembro + " e todas as suas associações foram removidos.");
        } else {
            System.out.println("Falha ao remover. Membro com ID " + idMembro + " não encontrado.");
        }
    }

    private static void removerProjeto() {
        System.out.println("\n--- 11. Remover pt.ipb.uniag.modelo.Projeto ---");
        System.out.print("Insira o ID do projeto a remover: ");
        int idProj = lerOpcao();
        if (uniag.removerProjeto(idProj)) {
            System.out.println("pt.ipb.uniag.modelo.Projeto com ID " + idProj + " e todas as suas associações foram removidos.");
        } else {
            System.out.println("Falha ao remover. pt.ipb.uniag.modelo.Projeto com ID " + idProj + " não encontrado.");
        }
    }

    private static void popularDadosIniciais() {
        Investigador ana = uniag.addInvestigador("Prof. Ana Silva");
        Investigador rui = uniag.addInvestigador("Dr. Rui Costa");
        uniag.addInvColaborador("Eng. Carlos Lopes");
        uniag.addVisitante("Prof. John Doe");
        Projeto p1 = uniag.addProjeto("Sistema Inteligente de Gestão de Energia", 50000.0);
        uniag.addProjeto("Análise de Big Data em Redes Sociais", 75000.0);
        uniag.associaMembroProjeto(ana.getId(), p1.getId());
        uniag.associaMembroProjeto(rui.getId(), p1.getId());
    }
}