package br.com.alura.adopet.api.excption;

public class ValidacaoExcption extends RuntimeException {
    public ValidacaoExcption(String message) {
        super(message);
    }
}
