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
 * @author fagner
 */
@Entity
@Table(name="receita")
public class Receita extends Fluxo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;   
    private String tipo; 

    public Receita() {
    }  

    public Receita(String nomeConta,String obs, Calendar criacao, String tipo) {
        this.tipo = tipo;
        super.setNome(nomeConta);
        super.setObs(obs);
        super.setCriacao(criacao);
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
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Receita)) {
            return false;
        }
        Receita other = (Receita) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidade.Conta.Receita[ id=" + id + " ]";
    }
    
}
