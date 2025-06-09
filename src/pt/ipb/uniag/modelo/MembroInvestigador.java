package pt.ipb.uniag.modelo;// Ficheiro: src/pt.ipb.uniag.modelo.MembroInvestigador.java

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Representa um membro investigador genérico da unidade de investigação pt.ipb.uniag.app.UNIAG.
 * <p>
 * Esta é uma classe abstrata que serve como base para os tipos específicos de
 * investigadores. A classe gere um sistema de IDs auto-incrementados para
 * garantir que cada membro, independentemente do seu tipo, tenha um
 * identificador único.
 *
 * @author Luis Enrique
 * @version 1.7
 * @since 2025-06-09
 */
public abstract class MembroInvestigador implements Cloneable {

    private static final AtomicInteger contadorId = new AtomicInteger(1);
    private final int id;
    private String nome;
    private final List<Projeto> projetosAssociados;

    /**
     * Constrói uma nova instância de um membro investigador com um ID gerado automaticamente.
     *
     * @param nome O nome do membro investigador. Não pode ser nulo ou vazio.
     * @throws IllegalArgumentException se o nome for nulo ou vazio.
     */
    public MembroInvestigador(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do membro não pode ser nulo ou vazio.");
        }
        this.id = contadorId.getAndIncrement();
        this.nome = nome;
        this.projetosAssociados = new ArrayList<>();
    }

    /**
     * Construtor de cópia (copy constructor), um padrão enfatizado nas aulas.
     *
     * @param original O pt.ipb.uniag.modelo.MembroInvestigador a ser copiado.
     */
    protected MembroInvestigador(MembroInvestigador original) {
        this.id = original.id;
        this.nome = original.nome;
        this.projetosAssociados = new ArrayList<>(original.projetosAssociados);
    }

    // --- Métodos de Leitura e Escrita (Getters e Setters) ---

    /**
     * Obtém o ID do membro investigador.
     * @return O ID do membro.
     */
    public int getId() { return id; }

    /**
     * Obtém o nome do membro investigador.
     * @return O nome do membro.
     */
    public String getNome() { return nome; }

    /**
     * Altera o nome do membro investigador.
     *
     * @param novoNome O novo nome para o membro.
     * @throws IllegalArgumentException se o novo nome for nulo ou vazio.
     */
    public void setNome(String novoNome) {
        if (novoNome == null || novoNome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser nulo ou vazio.");
        }
        this.nome = novoNome;
    }

    /**
     * Retorna uma vista não modificável da lista de projetos associados.
     *
     * @return Uma lista não modificável de projetos.
     */
    public List<Projeto> getProjetosAssociados() {
        return Collections.unmodifiableList(projetosAssociados);
    }

    // --- Métodos de Associação ---

    /**
     * Associa este membro a um projeto de investigação.
     *
     * @param p O projeto a ser associado.
     * @return {@code true} se a associação for bem-sucedida; {@code false} caso contrário.
     */
    public boolean associarProjeto(Projeto p) {
        if (p != null && !this.projetosAssociados.contains(p)) {
            this.projetosAssociados.add(p);
            return true;
        }
        return false;
    }

    /**
     * Remove a associação deste membro com um projeto específico.
     *
     * @param p O projeto a ser desassociado.
     * @return {@code true} se o projeto estava na lista e foi removido; {@code false} caso contrário.
     */
    public boolean removerAssociacaoProjeto(Projeto p) {
        return this.projetosAssociados.remove(p);
    }

    // --- Métodos Abstratos e de Object ---

    /** Método abstrato para imprimir os detalhes do membro.  */
    public abstract void print();

    /**
     * Cria e devolve uma cópia deste objeto.
     * @return um clone desta instância.
     */
    @Override public abstract MembroInvestigador clone();

    /**
     * Retorna uma representação do objeto em formato String.
     * @return Uma String com o ID e o nome do membro.
     */
    @Override
    public String toString() {
        return "ID: " + this.id + " | Nome: " + this.nome;
    }

    /**
     * Compara este membro com outro objeto para verificar a igualdade lógica,
     * que é determinada unicamente pelo ID.
     *
     * @param o O objeto a ser comparado.
     * @return {@code true} se os objetos forem do mesmo tipo e tiverem o mesmo ID.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MembroInvestigador that = (MembroInvestigador) o;
        return id == that.id;
    }

    /**
     * Retorna um código de hash para o objeto, consistente com o método equals.
     * @return O código de hash do objeto.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}