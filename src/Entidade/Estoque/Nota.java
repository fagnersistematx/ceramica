/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidade.Estoque;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author FM
 */
@Entity
@Table(name="nota")
public class Nota implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private List<Lote> lotes;
    private float desconto;
    private float total;
    private String numero;
    private String obs;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar data_entrada;

    public Nota() {
    }

    public Nota(List<Lote> lotes, float desconto, float total, String numero, String obs, Calendar data_entrada) {
        this.lotes = lotes;
        this.desconto = desconto;
        this.total = total;
        this.numero = numero;
        this.obs = obs;
        this.data_entrada = data_entrada;
    }   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    public List<Lote> getLotes() {
        return lotes;
    }

    public void setLotes(List<Lote> lotes) {
        this.lotes = lotes;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }   

    public Calendar getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(Calendar data_entrada) {
        this.data_entrada = data_entrada;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
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
        if (!(object instanceof Nota)) {
            return false;
        }
        Nota other = (Nota) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Nota{" + "id=" + id + ", desconto=" + desconto + ", total=" + total + ", numero=" + numero + ", obs=" + obs + ", data_entrada=" + data_entrada + '}';
    }   
    
}
