package padroescomportamentais.observer;

public class Main {
    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante("Restaurante Gourmet", "Rua das Flores, 123");

        Cliente cliente1 = new Cliente("Carlos");
        Cliente cliente2 = new Cliente("Ana");

        cliente1.inscrever(restaurante);
        cliente2.inscrever(restaurante);

        restaurante.lancarPratoEspecial();

        System.out.println(cliente1.getUltimaNotificacao());
        System.out.println(cliente2.getUltimaNotificacao());
    }
}
