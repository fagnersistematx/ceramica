package Entidade.Conta;

import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author fagner
 */
@MappedSuperclass
public abstract class Fluxo {

    private String nome;
    private String obs;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Calendar criacao;
    
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.DELETE})
    private List<Lancamento> lancamentos;

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

    public Calendar getCriacao() {
        return criacao;
    }

    public void setCriacao(Calendar criacao) {
        this.criacao = criacao;
    }

    public List<Lancamento> getLancamentos() {
        return lancamentos;
    }

    public void setLancamentos(List<Lancamento> lancamentos) {
        this.lancamentos = lancamentos;
    }
    
}
