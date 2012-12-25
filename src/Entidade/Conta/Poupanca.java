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
@Table(name="poupanca")
public class Poupanca extends Investimento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Poupanca() {
    }

    public Poupanca(float iof, float cpmf, float saldo_original, float saldo_atualizado, String nm_conta, String nome, String obs, Calendar criacao, List<Lancamento> lancamentos) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Poupanca)) {
            return false;
        }
        Poupanca other = (Poupanca) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidade.Conta.Poupanca[ id=" + id + " ]";
    }

}
