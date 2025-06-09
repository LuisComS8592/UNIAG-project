package pt.ipb.uniag.modelo;// Ficheiro: src/pt.ipb.uniag.modelo.Projeto.java

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Representa um projeto de investigação financiado na pt.ipb.uniag.app.UNIAG.
 * A classe gere um ID único e automático para cada projeto.
 *
 * @author Luis Enrique
 * @version 1.7
 * @since 2025-06-09
 */
public class Projeto implements Cloneable {

    private static final AtomicInteger contadorId = new AtomicInteger(1);

    private final int id;
    private String titulo;
    private double financiamento;
    private final List<MembroInvestigador> membrosParticipantes;

    /**
     * Constrói um novo pt.ipb.uniag.modelo.Projeto com um ID gerado automaticamente.
     * @param titulo O título do projeto (não pode ser nulo/vazio).
     * @param financiamento O valor do financiamento (não pode ser negativo).
     * @throws IllegalArgumentException Se os parâmetros forem inválidos.
     */
    public Projeto(String titulo, double financiamento) {
        if (titulo == null || titulo.trim().isEmpty()) throw new IllegalArgumentException("O título não pode ser nulo ou vazio.");
        if (financiamento < 0) throw new IllegalArgumentException("O financiamento não pode ser negativo.");
        this.id = contadorId.getAndIncrement();
        this.titulo = titulo;
        this.financiamento = financiamento;
        this.membrosParticipantes = new ArrayList<>();
    }

    /**
     * Construtor de cópia que realiza uma "deep copy" do projeto.
     * @param original O projeto a ser copiado.
     */
    public Projeto(Projeto original) {
        this.id = original.id;
        this.titulo = original.titulo;
        this.financiamento = original.financiamento;
        this.membrosParticipantes = new ArrayList<>();
        // Deep Copy da lista de membros, clonando cada um.
        for (MembroInvestigador membro : original.membrosParticipantes) {
            this.membrosParticipantes.add(membro.clone());
        }
    }

    // --- GETTERS E SETTERS ---
    /** * Obtém o ID único do projeto.
     * @return O ID único do projeto.
     */
    public int getId() { return id; }

    /** * Obtém o título atual do projeto.
     * @return O título atual do projeto.
     */
    public String getTitulo() { return titulo; }

    /** * Obtém o valor de financiamento do projeto.
     * @return O valor de financiamento do projeto.
     */
    public double getFinanciamento() { return financiamento; }

    /**
     * Devolve uma vista não modificável da lista de membros participantes.
     * @return Uma lista não modificável de MembroInvestigador.
     */
    public List<MembroInvestigador> getMembrosParticipantes() { return Collections.unmodifiableList(membrosParticipantes); }

    /**
     * Altera o título do projeto.
     * @param novoTitulo O novo título para o projeto.
     * @throws IllegalArgumentException Se o novo título for inválido.
     */
    public void setTitulo(String novoTitulo) {
        if (novoTitulo == null || novoTitulo.trim().isEmpty()) throw new IllegalArgumentException("O título não pode ser nulo ou vazio.");
        this.titulo = novoTitulo;
    }

    /**
     * Altera o financiamento do projeto.
     * @param novoFinanciamento O novo valor de financiamento.
     * @throws IllegalArgumentException Se o novo financiamento for negativo.
     */
    public void setFinanciamento(double novoFinanciamento) {
        if (novoFinanciamento < 0) throw new IllegalArgumentException("O financiamento não pode ser negativo.");
        this.financiamento = novoFinanciamento;
    }

    // --- MÉTODOS DE GESTÃO DE MEMBROS ---
    /**
     * Adiciona um membro à lista de participantes do projeto.
     * @param membro O membro a ser adicionado.
     * @return {@code true} se o membro foi adicionado com sucesso.
     */
    public boolean adicionarMembro(MembroInvestigador membro) { if (membro != null && !this.membrosParticipantes.contains(membro)) { this.membrosParticipantes.add(membro); return true; } return false; }

    /**
     * Remove um membro da lista de participantes do projeto.
     * @param membro O membro a ser removido.
     * @return {@code true} se o membro foi removido com sucesso.
     */
    public boolean removerMembro(MembroInvestigador membro) { return this.membrosParticipantes.remove(membro); }

    /**
     * Distribui o financiamento do projeto pelos investigadores integrados participantes.
     */
    public void distribuirVerbaPorInvestigador() {
        // 1. Filtrar apenas os membros que são Investigadores
        List<Investigador> investigadoresNoProjeto = new ArrayList<>();
        for (MembroInvestigador membro : this.membrosParticipantes) {
            if (membro instanceof Investigador) {
                investigadoresNoProjeto.add((Investigador) membro);
            }
        }

        // 2. Se existirem investigadores, calcular e distribuir a verba
        if (!investigadoresNoProjeto.isEmpty()) {
            double verbaPorInvestigador = this.financiamento / investigadoresNoProjeto.size();
            for (Investigador inv : investigadoresNoProjeto) {
                inv.adicionarSaldo(verbaPorInvestigador);
            }
            System.out.println("Verba de " + String.format("%.2f", this.financiamento) + "€ distribuída por " + investigadoresNoProjeto.size() + " investigadores.");
        } else {
            System.out.println("Aviso: pt.ipb.uniag.modelo.Projeto ID " + this.id + " não possui Investigadores integrados para distribuir a verba.");
        }
    }

    /**
     * Imprime na consola todos os detalhes do projeto, incluindo a lista de participantes.
     */
    public void printDetalhes() {
        StringBuilder sb = new StringBuilder();
        sb.append("------------------------------------------\n");
        sb.append("Detalhes do pt.ipb.uniag.modelo.Projeto ID: ").append(this.id).append("\n");
        sb.append("------------------------------------------\n");
        sb.append("Título: ").append(this.titulo).append("\n");
        sb.append("Financiamento: ").append(String.format("%.2f", this.financiamento)).append("€\n");
        sb.append("--- Membros Participantes (").append(this.membrosParticipantes.size()).append(") ---\n");

        if (this.membrosParticipantes.isEmpty()) {
            sb.append("(Nenhum membro associado a este projeto ainda)\n");
        } else {
            for (MembroInvestigador membro : this.membrosParticipantes) {
                sb.append("  -> ").append(membro.toString()).append("\n");
            }
        }
        sb.append("------------------------------------------");
        System.out.println(sb.toString());
    }

    // --- MÉTODOS DE OBJECT ---
    /** @return Um clone deste projeto. */
    @Override public Projeto clone() { return new Projeto(this); }
    /** @return Uma representação textual concisa do projeto. */
    @Override public String toString() { return "pt.ipb.uniag.modelo.Projeto " + id + ": " + titulo + " (" + String.format("%.2f", financiamento) + "€)"; }
    /** @return {@code true} se os projetos tiverem o mesmo ID. */
    @Override public boolean equals(Object o) { if (this == o) return true; if (o == null || getClass() != o.getClass()) return false; Projeto projeto = (Projeto) o; return id == projeto.id; }
    /** @return Um código de hash baseado no ID do projeto. */
    @Override public int hashCode() { return Objects.hash(id); }
}