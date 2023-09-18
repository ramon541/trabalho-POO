package Models;

import java.time.LocalDateTime;

public class Util {
    private static Pessoa pessoaLogada;
    private static final LocalDateTime dataAtual = LocalDateTime.now();

    public static Pessoa getPessoaLogada() {
        return pessoaLogada;
    }

    public static void setPessoaLogada(Pessoa pessoa) {
        Util.pessoaLogada = pessoa;
    }

    public static LocalDateTime getDataAtual() {
        return dataAtual;
    }
}
