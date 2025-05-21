import com.yasminsarinho.Cliente;
import com.yasminsarinho.GerenciadoraClientes;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class GerenciadoraClienteTest {
    @Test
    public void testPesquisaCliente(){
        Cliente cliente1 = new Cliente(1, "Yasmin Sarinho", 21, "yasmiinsarinho@gmail.com", 1, true);
        Cliente cliente2 = new Cliente(2, "Yasmin Batista", 22, "yasmiinbatista@gmail.com", 1, true);

        List<Cliente> clientesDoBanco = new ArrayList<>();
        clientesDoBanco.add(cliente1);
        clientesDoBanco.add(cliente2);

        GerenciadoraClientes gerenciadoraClientes = new GerenciadoraClientes(clientesDoBanco);

        Cliente cliente = gerenciadoraClientes.pesquisaCliente(1);
        assertEquals(1,cliente.getId());
        assertEquals("yasmiinsarinho@gmail.com", cliente.getEmail());
    }

    @Test
    public void testRemoveCliente(){
        Cliente cliente1 = new Cliente(1, "Yasmin Sarinho", 21, "yasmiinsarinho@gmail.com", 1, true);
        Cliente cliente2 = new Cliente(2, "Yasmin Batista", 22, "yasmiinbatista@gmail.com", 1, true);

        List<Cliente> clientesDoBanco = new ArrayList<>();
        clientesDoBanco.add(cliente1);
        clientesDoBanco.add(cliente2);

        GerenciadoraClientes gerenciadoraClientes = new GerenciadoraClientes(clientesDoBanco);

        boolean clienteRemovido = gerenciadoraClientes.removeCliente(2);
        assertEquals(true, clienteRemovido);
        assertEquals(1, gerenciadoraClientes.getClientesDoBanco().size());
        assertNull(gerenciadoraClientes.pesquisaCliente(2));
    }
}
