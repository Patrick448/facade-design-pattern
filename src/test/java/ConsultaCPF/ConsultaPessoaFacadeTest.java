package ConsultaCPF;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConsultaPessoaFacadeTest {

    SistemaReceitaFederal srf = SistemaReceitaFederal.getInstance();
    SistemaSerasa ss = SistemaSerasa.getInstance();
    @BeforeEach
    void init(){



    }

    @Test
    void deveRetornarRegularScoreAlto(){
        ss.addRegistro("111113", 500.0);

        Pessoa pessoa = new Pessoa("João", "111113");
        assertEquals("João está regular e com score alto", ConsultaPessoaFacade.consultar(pessoa));
    }

    @Test
    void deveRetornarIrregularScoreAlto(){
        srf.addIrregular("111114");
        ss.addRegistro("111114", 600.0);

        Pessoa pessoa = new Pessoa("Maria", "111114");
        assertEquals("Maria está irregular e com score alto", ConsultaPessoaFacade.consultar(pessoa));
    }

    @Test
    void deveRetornarRegularScoreBaixo(){
        ss.addRegistro("111112", 499.0);

        Pessoa pessoa = new Pessoa("José", "111112");
        assertEquals("José está regular e com score baixo", ConsultaPessoaFacade.consultar(pessoa));
    }

    @Test
    void deveRetornarIrregularScoreBaixo(){

        srf.addIrregular("111111");
        ss.addRegistro("111111", 100.0);


        Pessoa pessoa = new Pessoa("Ana", "111111");
        assertEquals("Ana está irregular e com score baixo", ConsultaPessoaFacade.consultar(pessoa));
    }

    @Test
    void deveRetornarIrregularSemScore(){
        srf.addIrregular("111116");

        Pessoa pessoa = new Pessoa("Fernando", "111116");
        assertEquals("Fernando está irregular e não possui score", ConsultaPessoaFacade.consultar(pessoa));
    }

    @Test
    void deveRetornarRegularSemScore(){

        Pessoa pessoa = new Pessoa("Francisco", "111117");
        assertEquals("Francisco está regular e não possui score", ConsultaPessoaFacade.consultar(pessoa));
    }

}