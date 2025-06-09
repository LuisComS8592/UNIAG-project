package pt.ipb.uniag.modelo;// Ficheiro: src/pt.ipb.uniag.modelo.Investigador.java

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Representa um investigador integrado, um tipo de membro da pt.ipb.uniag.app.UNIAG.
 * <p>
 * Um investigador integrado herda de pt.ipb.uniag.modelo.MembroInvestigador e possui adicionalmente uma verba (saldo).
 *
 * @author Luis Enrique
 * @version 1.7
 * @since 2025-06-09
 */
public class Investigador extends MembroInvestigador {

    private double saldo;

    // --- CONSTRUTORES ---
    /**
     * Constrói uma nova instância de um pt.ipb.uniag.modelo.Investigador.
     * O ID é gerado automaticamente pela superclasse. O saldo é inicializado a zero.
     *
     * @param nome O nome do investigador.
     */
    public Investigador(String nome) {
        super(nome); // Chama o construtor da classe pai
        this.saldo = 0.0;
    }

    /**
     * Construtor de cópia para a classe pt.ipb.uniag.modelo.Investigador.
     * Este padrão é ensinado como fundamental para a clonagem correta.
     *
     * @param original O objeto pt.ipb.uniag.modelo.Investigador a ser copiado.
     */
    public Investigador(Investigador original) {
        super(original); // Chama o construtor de cópia da superclasse
        this.saldo = original.saldo;
    }

    // --- MÉTODOS PÚBLICOS ---
    /**
     * Adiciona um determinado valor ao saldo do investigador.
     * O valor a ser adicionado deve ser positivo.
     *
     * @param valor O valor monetário a ser adicionado ao saldo.
     * @return      {@code true} se o valor foi adicionado com sucesso (se for positivo),
     * {@code false} caso contrário.
     */
    public boolean adicionarSaldo(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            return true;
        }
        return false;
    }

    /**
     * Obtém o saldo atual do investigador.
     *
     * @return O valor do saldo.
     */
    public double getSaldo() {
        return saldo;
    }

    // --- MÉTODOS SOBRESCRITOS (OVERRIDE) ---
    /**
     * Cria e devolve uma cópia desta instância de pt.ipb.uniag.modelo.Investigador.
     * Segue o padrão de invocar o construtor de cópia.
     *
     * @return um clone deste objeto.
     */
    @Override
    public Investigador clone() {
        return new Investigador(this);
    }

    /**
     * Devolve uma representação textual completa do pt.ipb.uniag.modelo.Investigador.
     * Reutiliza a implementação da superclasse e adiciona os seus próprios detalhes.
     *
     * @return Uma String formatada com os detalhes do investigador.
     */
    @Override
    public String toString() {
        NumberFormat formatadorMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "PT"));

        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" | Tipo: pt.ipb.uniag.modelo.Investigador Integrado");
        sb.append(" | Saldo: ").append(formatadorMoeda.format(this.saldo));
        return sb.toString();
    }

    /**
     * Imprime os detalhes do pt.ipb.uniag.modelo.Investigador na consola.
     * Delega a responsabilidade de formatar a string para o método toString().
     */
    @Override
    public void print() {
        System.out.println("-------------------------------------");
        System.out.println(this.toString());
        System.out.println("-------------------------------------");
    }
}