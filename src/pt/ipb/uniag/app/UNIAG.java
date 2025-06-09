package pt.ipb.uniag.app;// Ficheiro: src/pt.ipb.uniag.app.UNIAG.java

import pt.ipb.uniag.modelo.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Representa a Unidade de Investigação (controlador principal).
 * <p>
 * Gere as coleções de membros e projetos usando estruturas de dados otimizadas (HashMap),
 * e orquestra todas as operações de criação, leitura, edição e remoção (CRUD).
 *
 * @author Luis Enrique
 * @version 1.7 // Versão final com CRUD completo e Javadoc
 * @since 2025-06-09
 */
public class UNIAG {

    private final Map<Integer, MembroInvestigador> membros;
    private final Map<Integer, Projeto> projetos;

    /**
     * Constrói a instância da pt.ipb.uniag.app.UNIAG, inicializando as coleções.
     */
    public UNIAG() {
        this.membros = new HashMap<>();
        this.projetos = new HashMap<>();
    }

    // --- MÉTODOS DE LEITURA (READ) ---

    /**
     * Encontra um projeto na coleção pelo seu ID.
     * @param id O ID do projeto a procurar.
     * @return O objeto {@link Projeto} se encontrado, ou {@code null} caso contrário.
     */
    public Projeto findProjeto(int id) {
        return this.projetos.get(id);
    }

    /**
     * Encontra um membro na coleção pelo seu ID.
     * @param id O ID do membro a procurar.
     * @return O objeto {@link MembroInvestigador} se encontrado, ou {@code null} caso contrário.
     */
    public MembroInvestigador findMembro(int id) {
        return this.membros.get(id);
    }

    /**
     * Mostra na consola a lista de todos os membros registados na pt.ipb.uniag.app.UNIAG.
     */
    public void mostrarMembros() {
        System.out.println("\n=== LISTA DE MEMBROS DA pt.ipb.uniag.app.UNIAG (" + this.membros.size() + ") ===");
        if (this.membros.isEmpty()) {
            System.out.println(" (Nenhum membro registado)");
            return;
        }
        for (MembroInvestigador membro : this.membros.values()) {
            membro.print();
        }
    }

    /**
     * Mostra na consola a lista de todos os projetos registados na pt.ipb.uniag.app.UNIAG.
     */
    public void mostrarProjetos() {
        System.out.println("\n=== LISTA DE PROJETOS DA pt.ipb.uniag.app.UNIAG (" + this.projetos.size() + ") ===");
        if (this.projetos.isEmpty()) {
            System.out.println(" (Nenhum projeto registado)");
            return;
        }
        for (Projeto projeto : this.projetos.values()) {
            projeto.printDetalhes();
        }
    }

    // --- MÉTODOS DE CRIAÇÃO (CREATE) ---

    /**
     * Cria e adiciona um novo projeto ao sistema.
     * @param titulo O título do novo projeto.
     * @param financiamento O financiamento do novo projeto.
     * @return O objeto {@link Projeto} recém-criado.
     */
    public Projeto addProjeto(String titulo, double financiamento) {
        Projeto novo = new Projeto(titulo, financiamento);
        this.projetos.put(novo.getId(), novo);
        return novo;
    }

    /**
     * Cria e adiciona um novo pt.ipb.uniag.modelo.Investigador ao sistema.
     * @param nome O nome do novo investigador.
     * @return O objeto {@link Investigador} recém-criado.
     */
    public Investigador addInvestigador(String nome) {
        Investigador novo = new Investigador(nome);
        this.membros.put(novo.getId(), novo);
        return novo;
    }

    /**
     * Cria e adiciona um novo pt.ipb.uniag.modelo.Investigador Colaborador ao sistema.
     * @param nome O nome do novo colaborador.
     * @return O objeto {@link InvColaborador} recém-criado.
     */
    public InvColaborador addInvColaborador(String nome) {
        InvColaborador novo = new InvColaborador(nome);
        this.membros.put(novo.getId(), novo);
        return novo;
    }

    /**
     * Cria e adiciona um novo pt.ipb.uniag.modelo.Visitante ao sistema.
     * @param nome O nome do novo visitante.
     * @return O objeto {@link Visitante} recém-criado.
     */
    public Visitante addVisitante(String nome) {
        Visitante novo = new Visitante(nome);
        this.membros.put(novo.getId(), novo);
        return novo;
    }

    // --- MÉTODOS DE EDIÇÃO (UPDATE) ---

    /**
     * Edita o nome de um membro existente.
     * @param idMembro O ID do membro a editar.
     * @param novoNome O novo nome para o membro.
     * @return {@code true} se a edição foi bem-sucedida, {@code false} caso contrário.
     */
    public boolean editarNomeMembro(int idMembro, String novoNome) {
        MembroInvestigador membro = findMembro(idMembro);
        if (membro != null) {
            try {
                membro.setNome(novoNome);
                return true;
            } catch (IllegalArgumentException e) {
                System.out.println("Erro ao editar: " + e.getMessage());
                return false;
            }
        }
        return false;
    }

    /**
     * Edita o título de um projeto existente.
     * @param idProj O ID do projeto a editar.
     * @param novoTitulo O novo título para o projeto.
     * @return {@code true} se a edição foi bem-sucedida, {@code false} caso contrário.
     */
    public boolean editarTituloProjeto(int idProj, String novoTitulo) {
        Projeto projeto = findProjeto(idProj);
        if (projeto != null) {
            try {
                projeto.setTitulo(novoTitulo);
                return true;
            } catch (IllegalArgumentException e) {
                System.out.println("Erro ao editar: " + e.getMessage());
                return false;
            }
        }
        return false;
    }

    /**
     * Edita o financiamento de um projeto existente.
     * @param idProj O ID do projeto a editar.
     * @param novoFin O novo valor de financiamento para o projeto.
     * @return {@code true} se a edição foi bem-sucedida, {@code false} caso contrário.
     */
    public boolean editarFinanciamentoProjeto(int idProj, double novoFin) {
        Projeto projeto = findProjeto(idProj);
        if (projeto != null) {
            try {
                projeto.setFinanciamento(novoFin);
                return true;
            } catch (IllegalArgumentException e) {
                System.out.println("Erro ao editar: " + e.getMessage());
                return false;
            }
        }
        return false;
    }

    // --- MÉTODOS DE REMOÇÃO (DELETE) ---

    /**
     * Remove um projeto do sistema, garantindo a consistência das associações.
     * @param idProj O ID do projeto a ser removido.
     * @return {@code true} se o projeto foi encontrado e removido.
     */
    public boolean removerProjeto(int idProj) {
        Projeto projetoARemover = this.findProjeto(idProj);
        if (projetoARemover == null) return false;

        List<MembroInvestigador> membrosParaDesassociar = new ArrayList<>(projetoARemover.getMembrosParticipantes());
        for (MembroInvestigador membro : membrosParaDesassociar) {
            membro.removerAssociacaoProjeto(projetoARemover);
        }

        this.projetos.remove(idProj);
        return true;
    }

    /**
     * Remove um membro do sistema, garantindo a consistência das associações.
     * @param idMembro O ID do membro a ser removido.
     * @return {@code true} se o membro foi encontrado e removido.
     */
    public boolean removerMembro(int idMembro) {
        MembroInvestigador membroARemover = this.findMembro(idMembro);
        if (membroARemover == null) return false;

        List<Projeto> projetosParaDesassociar = new ArrayList<>(membroARemover.getProjetosAssociados());
        for (Projeto projeto : projetosParaDesassociar) {
            projeto.removerMembro(membroARemover);
        }

        this.membros.remove(idMembro);
        return true;
    }

    // --- OUTROS MÉTODOS DE GESTÃO ---

    /**
     * Associa um membro a um projeto, estabelecendo a ligação bidirecional.
     * @param idMembro O ID do membro a associar.
     * @param idProj O ID do projeto a associar.
     * @return {@code true} se a associação foi bem-sucedida, {@code false} caso contrário.
     */
    public boolean associaMembroProjeto(int idMembro, int idProj) {
        MembroInvestigador membro = findMembro(idMembro);
        Projeto projeto = findProjeto(idProj);
        if (membro != null && projeto != null) {
            boolean sucessoProjeto = projeto.adicionarMembro(membro);
            boolean sucessoMembro = membro.associarProjeto(projeto);
            return sucessoMembro && sucessoProjeto;
        }
        return false;
    }

    /**
     * Invoca a distribuição da verba de um projeto específico.
     * @param idProj O ID do projeto cuja verba será distribuída.
     * @return {@code true} se o projeto foi encontrado, {@code false} caso contrário.
     */
    public boolean distribuirVerbaPorInvestigador(int idProj) {
        Projeto projeto = findProjeto(idProj);
        if (projeto != null) {
            projeto.distribuirVerbaPorInvestigador();
            return true;
        }
        return false;
    }
}