package padroescomportamentais.observer;

import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void inscrever(Restaurante restaurante) {
        restaurante.addObserver(this);
    }

    @Override
    public void update(Observable restaurante, Object arg1) {
        this.ultimaNotificacao = this.nome + ", novo prato especial lançado no " + restaurante.toString();

    }
}
