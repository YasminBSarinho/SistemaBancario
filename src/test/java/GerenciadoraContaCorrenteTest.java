import com.yasminsarinho.ContaCorrente;
import com.yasminsarinho.GerenciadoraContas;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GerenciadoraContaCorrenteTest {
    @Test
    public void testTranfereValor(){
        ContaCorrente conta1 = new ContaCorrente(1,200,true);
        ContaCorrente conta2 = new ContaCorrente(2,0,true);

        List<ContaCorrente> contasDoBanco = new ArrayList<>();
        contasDoBanco.add(conta1);
        contasDoBanco.add(conta2);

        GerenciadoraContas gerenciadoraContas = new GerenciadoraContas(contasDoBanco);

        gerenciadoraContas.transfereValor(1, 100, 2);

        assertEquals(100.00, conta2.getSaldo());
        assertEquals(100.00, conta1.getSaldo());
    }
}
