package engtelecom.std.projeto2.exceptions;

public class ObjetoNaoEncontradoException extends RuntimeException {
    public ObjetoNaoEncontradoException(long id) {
        super("Não foi possível encontrar objeto com o id: " + id);
    }

    public ObjetoNaoEncontradoException(String nome) {
        super("Não foi possível encontrar objeto com o id: " + nome);
    }

}