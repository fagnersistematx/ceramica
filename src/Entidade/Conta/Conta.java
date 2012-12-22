package Entidade.Conta;

/**
 *
 * @author fagner
 */
public abstract class Conta {

    private String nome;
    private String obs;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
}
