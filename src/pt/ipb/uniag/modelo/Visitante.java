package pt.ipb.uniag.modelo;// Ficheiro: src/pt.ipb.uniag.modelo.Visitante.java

/**
 * Representa um visitante de investigação, um tipo de membro da pt.ipb.uniag.app.UNIAG.
 * <p>
 * Esta subclasse, tal como {@link InvColaborador}, herda de {@link MembroInvestigador}
 * sem adicionar novos atributos.
 *
 * @author Luis Enrique
 * @version 1.7
 * @since 2025-06-09
 */
public class Visitante extends MembroInvestigador {

    // --- CONSTRUTORES ---
    /**
     * Constrói uma nova instância de um pt.ipb.uniag.modelo.Visitante.
     * O ID é gerado automaticamente pela superclasse.
     *
     * @param nome O nome do visitante de investigação.
     */
    public Visitante(String nome) {
        super(nome); // Invoca o construtor da superclasse
    }

    /**
     * Construtor de cópia para a classe pt.ipb.uniag.modelo.Visitante.
     *
     * @param original O objeto pt.ipb.uniag.modelo.Visitante a ser copiado.
     */
    public Visitante(Visitante original) {
        super(original); // Invoca o construtor de cópia da superclasse
    }

    // --- MÉTODOS SOBRESCRITOS (OVERRIDE) ---
    /**
     * Cria e devolve uma cópia desta instância de pt.ipb.uniag.modelo.Visitante.
     * Segue o padrão de invocar o construtor de cópia.
     *
     * @return um clone deste objeto.
     */
    @Override
    public Visitante clone() {
        return new Visitante(this);
    }

    /**
     * Devolve uma representação textual completa do pt.ipb.uniag.modelo.Visitante.
     * Reutiliza a implementação da superclasse e adiciona o seu tipo específico.
     *
     * @return Uma String formatada com os detalhes do visitante.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" | Tipo: pt.ipb.uniag.modelo.Visitante de Investigação");
        return sb.toString();
    }

    /**
     * Imprime os detalhes do pt.ipb.uniag.modelo.Visitante na consola.
     * Delega a responsabilidade de formatar a string para o método toString().
     */
    @Override
    public void print() {
        System.out.println("-------------------------------------");
        System.out.println(this.toString());
        System.out.println("-------------------------------------");
    }
}