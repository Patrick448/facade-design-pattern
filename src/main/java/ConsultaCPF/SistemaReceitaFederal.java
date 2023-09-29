package ConsultaCPF;

import java.util.ArrayList;
import java.util.List;

public class SistemaReceitaFederal {

    private List<String> listaIrregulares = new ArrayList<>();
    private static SistemaReceitaFederal instance = new SistemaReceitaFederal();

    private SistemaReceitaFederal() {
    }

    public static SistemaReceitaFederal getInstance() {
        return instance;
    }

    public List<String> getListaIrregulares() {
        return listaIrregulares;
    }

    public boolean isRegular(String cpf) {
        return !listaIrregulares.contains(cpf);
    }

    public void setListaIrregulares(List<String> listaIrregulares) {
        this.listaIrregulares = listaIrregulares;
    }

    public void addIrregular(String cpf){
        listaIrregulares.add(cpf);
    }
}
