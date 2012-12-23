package Entidade.Conta;




import java.io.Serializable;
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
@Table(name="acoes")
public class Acoes extends Investimento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private float custodia;
    private float emolumentos;
    private float corretagem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getTx_custodia() {
        return custodia;
    }

    public void setTx_custodia(float tx_custodia) {
        this.custodia = tx_custodia;
    }

    public float getTx_emolumentos() {
        return emolumentos;
    }

    public void setTx_emolumentos(float tx_emolumentos) {
        this.emolumentos = tx_emolumentos;
    }

    public float getTx_corretagem() {
        return corretagem;
    }

    public void setTx_corretagem(float tx_corretagem) {
        this.corretagem = tx_corretagem;
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
        if (!(object instanceof Acoes)) {
            return false;
        }
        Acoes other = (Acoes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidade.Conta.Acoes[ id=" + id + " ]";
    }

}
