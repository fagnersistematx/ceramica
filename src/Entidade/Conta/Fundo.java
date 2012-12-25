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
@Table(name="fundo")
public class Fundo extends Investimento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tipo;
    private float administracao;
    private float performace;

    public Fundo() {
    }

    public Fundo(float administracao, float performace, String tipo, float iof, float cpmf, float saldo_original,
            float saldo_atualizado, String nm_conta, String nome, String obs, Calendar criacao, List<Lancamento> lancamentos) {
        
        this.tipo = tipo;
        this.administracao = administracao;
        this.performace = performace;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getTx_administracao() {
        return administracao;
    }

    public void setTx_administracao(float tx_administracao) {
        this.administracao = tx_administracao;
    }

    public float getTx_performace() {
        return performace;
    }

    public void setTx_performace(float tx_performace) {
        this.performace = tx_performace;
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
        if (!(object instanceof Fundo)) {
            return false;
        }
        Fundo other = (Fundo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidade.Conta.Fundo[ id=" + id + " ]";
    }

}
