package Entidade.Conta;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author fagner
 * @version 
 */
@Entity
@Table(name="lancamento")
public class Lancamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private float valor;
    private String tipo_pag_conta;
    private String obs;
    private float juros;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Calendar criacao;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar vencimento;    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Calendar quitacao;

    public Lancamento() {
    }

    public Lancamento(float valor, String obs, Calendar criacao, Calendar vencimento) {
        this.valor = valor;
        this.obs = obs;
        this.criacao = criacao;
        this.vencimento = vencimento;
    }   
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getTipo_pag_conta() {
        return tipo_pag_conta;
    }

    public void setTipo_pag_conta(String tipo_pag_conta) {
        this.tipo_pag_conta = tipo_pag_conta;
    }

    public float getJuros() {
        return juros;
    }

    public void setJuros(float juros) {
        this.juros = juros;
    }

    public Calendar getVencimento() {
        return vencimento;
    }

    public void setVencimento(Calendar vencimento) {
        this.vencimento = vencimento;
    }

    public Calendar getQuitacao() {
        return quitacao;
    }

    public void setQuitacao(Calendar quitacao) {
        this.quitacao = quitacao;
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
       

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lancamento)) {
            return false;
        }
        Lancamento other = (Lancamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidade.Conta.Lancamento[ id=" + id + " ]";
    }
    
}
