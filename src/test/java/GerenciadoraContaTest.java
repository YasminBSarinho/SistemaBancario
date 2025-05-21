import com.yasminsarinho.ContaCorrente;
import com.yasminsarinho.GerenciadoraContas;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Classe de testes para a classe {@link GerenciadoraContas}.
 * @author Yasmin Sarinho
 *
 * <p>Testa operações dos metodos da classe GerenciadoraContas.</p>
 */
public class GerenciadoraContaTest {

    /**
     * Testa se a transferência de dinheiro entre dois clientes funciona com sucesso.
     */
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

    /**
     * Testa se a tentativa de transferência de valor da conta de um cliente para o outro quando não há saldo suficiente.
     */
    @Test
    public void testTransfereValorSemSaldoSuficiente(){
        ContaCorrente conta1 = new ContaCorrente(1,100.00,true);
        ContaCorrente conta2 = new ContaCorrente(2,0,true);

        List<ContaCorrente> contasDoBanco = new ArrayList<>();
        contasDoBanco.add(conta1);
        contasDoBanco.add(conta2);

        GerenciadoraContas gerenciadoraContas = new GerenciadoraContas(contasDoBanco);

        boolean sucesso = gerenciadoraContas.transfereValor(1, 200, 2);

        assertEquals(false, sucesso);
        assertEquals(100.00, conta1.getSaldo());
        assertEquals(0.0, conta2.getSaldo());

    }

}
