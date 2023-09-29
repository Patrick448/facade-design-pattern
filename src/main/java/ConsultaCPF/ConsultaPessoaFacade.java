package ConsultaCPF;

public class ConsultaPessoaFacade {

    public static String consultar(Pessoa pessoa){
        String result = pessoa.getNome() + " está ";
        boolean regular = SistemaReceitaFederal.getInstance().isRegular(pessoa.getCpf());
        boolean scoreBaixo = false;
        boolean scoreInexistente = false;

        try{
            scoreBaixo = SistemaSerasa.getInstance().scoreBaixo(pessoa.getCpf());
        }catch (Exception e){
            scoreInexistente = true;
        }

        if(regular){
            result += "regular";
        } else {
            result += "irregular";
        }

        if(scoreInexistente) {
            result += " e não possui score";
        }else if(scoreBaixo){
            result += " e com score baixo";
        }else{
            result += " e com score alto";
        }

        return result;

    }
}
