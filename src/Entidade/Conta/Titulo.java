package Entidade.Conta;


import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Fagner Silva Martins, fagner.silva@dce.ufpb.br
 * @version 1.0
 */
@Entity
@Table(name="titulo")
public class Titulo extends Investimento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private float cblc;
    private float banco;
    private String tipo;

    public Titulo() {
    }

    public Titulo(float cblc, float banco, String tipo, float iof, float cpmf, float saldo_original, 
            float saldo_atualizado, String nm_conta, String nome, String obs, Calendar criacao, List<Lancamento> lancamentos) {
        
        this.cblc = cblc;
        this.banco = banco;
        this.tipo = tipo;
        this.setIof(iof);
        this.setCpmf(cpmf);
        this.setSaldo_original(saldo_original);
        this.setSaldo_atualizado(saldo_atualizado);
        this.setNm_conta(nm_conta);
        this.setNome(nome);
        this.setObs(obs);
        this.setCriacao(criacao);
        this.setLancamentos(lancamentos);
        
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getTx_custodia_cblc() {
        return cblc;
    }

    public void setTx_custodia_cblc(float tx_custodia_cblc) {
        this.cblc = tx_custodia_cblc;
    }

    public float getTx_custodia_banco() {
        return banco;
    }

    public void setTx_custodia_banco(float tx_custodia_banco) {
        this.banco = tx_custodia_banco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
        if (!(object instanceof Titulo)) {
            return false;
        }
        Titulo other = (Titulo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidade.Conta.titulo[ id=" + id + " ]";
    }

}
