
package Entidade.Estoque;

import Entidade.Fornecedor;
import Entidade.Funcionario;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Fagner Silva Martins, fagner.silva@dce.ufpb.br
 * @version 1.0
 */
@Entity
@Table(name="lote")
public class Lote implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String numero;
    private float quant;
    private float valor;
    private float preco;
    @OneToOne(cascade = {CascadeType.MERGE})
    private Produto produto;
    @OneToOne(cascade = {CascadeType.MERGE})
    private Fornecedor fornecedor;
    @OneToOne(cascade = {CascadeType.MERGE})
    private Funcionario funcionario;

    public Lote() {
    }

    public Lote(String numero, float quant, float valor, float preco, Produto produto, Fornecedor fornecedor, Funcionario funcionario) {
        this.numero = numero;
        this.quant = quant;
        this.valor = valor;
        this.preco = preco;
        this.produto = produto;
        this.funcionario = funcionario;
        this.fornecedor = fornecedor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public float getQuant() {
        return quant;
    }

    public void setQuant(float quant) {
        this.quant = quant;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco_saco) {
        this.preco = preco_saco;
    }   

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
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
        if (!(object instanceof Lote)) {
            return false;
        }
        Lote other = (Lote) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Lote{" + "id=" + id + ", numero=" + numero + ", quant=" + quant + ", valor=" + valor + ", preco=" + preco + '}';
    }    

}
