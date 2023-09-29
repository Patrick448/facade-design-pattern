package ConsultaCPF;

import java.util.HashMap;
import java.util.Map;

public class SistemaSerasa {
    private Map<String, Double> scores = new HashMap<>();
    private static SistemaSerasa instance = new SistemaSerasa();

    private SistemaSerasa() {
    }

    public static SistemaSerasa getInstance() {
        return instance;
    }

    public boolean scoreBaixo(String cpf) {

        if(!scores.containsKey(cpf)){
            throw new RuntimeException("CPF não encontrado");
        }

        return scores.get(cpf) < 500;
    }

    public void addRegistro(String cpf, Double score) {
        scores.put(cpf, score);
    }
}
