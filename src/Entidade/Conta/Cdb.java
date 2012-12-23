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
 * @author Fagner Silva Martins, fagner.silva@dce.ufpb.br
 * @version 1.0
 */
@Entity
@Table(name="cdb")
public class Cdb  extends Investimento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private float contratacao;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar investimento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getTx_contratacao() {
        return contratacao;
    }

    public void setTx_contratacao(float tx_contratacao) {
        this.contratacao = tx_contratacao;
    }

    public Calendar getData_investimento() {
        return investimento;
    }

    public void setData_investimento(Calendar data_investimento) {
        this.investimento = data_investimento;
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
        if (!(object instanceof Cdb)) {
            return false;
        }
        Cdb other = (Cdb) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidade.Conta.Cdb[ id=" + id + " ]";
    }

}
