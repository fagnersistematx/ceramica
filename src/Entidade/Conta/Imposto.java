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
@Table(name="imposto")
public class Imposto extends Fluxo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private float valor;
    private float aliquota;

    public Imposto() {
    }

    public Imposto(String nome, String obs, Calendar criacao, List<Lancamento> lancamentos, float valor, float aliquota) {
        this.valor = valor;
        this.aliquota = aliquota;
        super.setNome(nome);
        super.setObs(obs);
        super.setCriacao(criacao);
        super.setLancamentos(lancamentos);
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

    public float getAliquota() {
        return aliquota;
    }

    public void setAliquota(float aliquota) {
        this.aliquota = aliquota;
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
        if (!(object instanceof Imposto)) {
            return false;
        }
        Imposto other = (Imposto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidade.Conta.Imposto[ id=" + id + " ]";
    }

}
