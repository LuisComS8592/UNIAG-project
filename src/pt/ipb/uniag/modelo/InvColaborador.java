package pt.ipb.uniag.modelo;// Ficheiro: src/pt.ipb.uniag.modelo.InvColaborador.java

/**
 * Representa um investigador colaborador.
 * <p>
 * Esta subclasse herda de {@link MembroInvestigador} mas não adiciona novos atributos,
 * apenas especializa o comportamento.
 *
 * @author Luis Enrique
 * @version 1.7
 * @since 2025-06-09
 */
public class InvColaborador extends MembroInvestigador {

    // --- CONSTRUTORES ---
    /**
     * Constrói uma nova instância de um pt.ipb.uniag.modelo.InvColaborador.
     * O ID é gerado automaticamente pela superclasse.
     *
     * @param nome O nome do investigador colaborador.
     */
    public InvColaborador(String nome) {
        super(nome); // Invoca o construtor da superclasse
    }

    /**
     * Construtor de cópia para a classe pt.ipb.uniag.modelo.InvColaborador.
     *
     * @param original O objeto pt.ipb.uniag.modelo.InvColaborador a ser copiado.
     */
    public InvColaborador(InvColaborador original) {
        super(original); // Invoca o construtor de cópia da superclasse
    }

    // --- MÉTODOS SOBRESCRITOS (OVERRIDE) ---
    /**
     * Cria e devolve uma cópia desta instância de pt.ipb.uniag.modelo.InvColaborador.
     * Segue o padrão de invocar o construtor de cópia.
     *
     * @return um clone deste objeto.
     */
    @Override
    public InvColaborador clone() {
        return new InvColaborador(this);
    }

    /**
     * Devolve uma representação textual completa do pt.ipb.uniag.modelo.InvColaborador.
     * Reutiliza a implementação da superclasse e adiciona o seu tipo específico.
     *
     * @return Uma String formatada com os detalhes do investigador colaborador.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" | Tipo: pt.ipb.uniag.modelo.Investigador Colaborador");
        return sb.toString();
    }

    /**
     * Imprime os detalhes do pt.ipb.uniag.modelo.InvColaborador na consola.
     * Delega a responsabilidade de formatar a string para o método toString().
     */
    @Override
    public void print() {
        System.out.println("-------------------------------------");
        System.out.println(this.toString());
        System.out.println("-------------------------------------");
    }
}