package servidor.model;

import java.util.Objects;

/**
 * Uma sessão de telefonia: o número do celular (chave) e os dados da sessão
 * (o JSON da linha do arquivo, guardado como texto).
 */
public class Sessao {
    private final String numeroCelular;
    private final String dadosSessao;

    public Sessao(String numeroCelular, String dadosSessao) {
        this.numeroCelular = numeroCelular;
        this.dadosSessao = dadosSessao;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public String getDadosSessao() {
        return dadosSessao;
    }

    @Override
    public String toString() {
        return "Sessao [numeroCelular=" + numeroCelular + ", dadosSessao=" + dadosSessao + "]";
    }

    /** Duas sessões são a mesma se o número do celular for o mesmo. */
    @Override
    public int hashCode() {
        return Objects.hashCode(numeroCelular);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Sessao other = (Sessao) obj;
        return Objects.equals(numeroCelular, other.numeroCelular);
    }
}
