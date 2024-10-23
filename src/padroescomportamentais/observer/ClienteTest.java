package padroescomportamentais.observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void deveNotificarUmCliente() {
        Restaurante restaurante = new Restaurante("Restaurante Gourmet", "Rua das Flores, 123");
        Cliente cliente = new Cliente("Carlos");
        cliente.inscrever(restaurante);
        restaurante.lancarPratoEspecial();
        assertEquals("Carlos, novo prato especial lançado no Restaurante{nome='Restaurante Gourmet', endereco='Rua das Flores, 123'}", cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClientes() {
        Restaurante restaurante = new Restaurante("Restaurante Gourmet", "Rua das Flores, 123");
        Cliente cliente1 = new Cliente("Carlos");
        Cliente cliente2 = new Cliente("Ana");
        cliente1.inscrever(restaurante);
        cliente2.inscrever(restaurante);
        restaurante.lancarPratoEspecial();
        assertEquals("Carlos, novo prato especial lançado no Restaurante{nome='Restaurante Gourmet', endereco='Rua das Flores, 123'}", cliente1.getUltimaNotificacao());
        assertEquals("Ana, novo prato especial lançado no Restaurante{nome='Restaurante Gourmet', endereco='Rua das Flores, 123'}", cliente2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarCliente() {
        Restaurante restaurante = new Restaurante("Restaurante Gourmet", "Rua das Flores, 123");
        Cliente cliente = new Cliente("Carlos");
        restaurante.lancarPratoEspecial();
        assertEquals(null, cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClienteRestauranteEspecifico() {
        Restaurante restauranteA = new Restaurante("Restaurante Gourmet", "Rua das Flores, 123");
        Restaurante restauranteB = new Restaurante("Restaurante Saboroso", "Av. Central, 456");
        Cliente cliente1 = new Cliente("Carlos");
        Cliente cliente2 = new Cliente("Ana");
        cliente1.inscrever(restauranteA);
        cliente2.inscrever(restauranteB);
        restauranteA.lancarPratoEspecial();
        assertEquals("Carlos, novo prato especial lançado no Restaurante{nome='Restaurante Gourmet', endereco='Rua das Flores, 123'}", cliente1.getUltimaNotificacao());
        assertEquals(null, cliente2.getUltimaNotificacao());
    }
}
