package padroescomportamentais.observer;

import java.util.Observable;

public class Restaurante extends Observable {

    private String nome;
    private String endereco;

    public Restaurante(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public void lancarPratoEspecial() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Restaurante{" +
                "nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}
