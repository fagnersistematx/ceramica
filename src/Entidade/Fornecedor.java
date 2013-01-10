
package Entidade;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Fagner
 */
@Entity
@Table(name = "fornecedor")
public class Fornecedor extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String empresa_razao;
    private String site;
    private String inscricao_estadual;    

    public Fornecedor() {
    }

    //Fisico
    public Fornecedor(String nome, String empresa, String site, String email,
            String cpf_cnpj, String rg, String data_nas, String tel_fixo, String cel1, String cel2,
            String sexo, Endereco endereco) {
        
        this.setNome(nome);
        this.site = site;
        this.empresa_razao = empresa;
        this.setNome(nome);
        this.setCpf_cnpj(cpf_cnpj);
        this.setRg(rg);
        this.setData_nas(data_nas);
        this.setTel_fixo(tel_fixo);
        this.setCel1(cel1);
        this.setCel2(cel2);
        this.setEmail(email);
        this.setSexo(sexo);
        this.setTipo(false);
        this.setEndereco(endereco);
        
    }
    
    //Juridico
    public Fornecedor(String nome, String razao_social, String site, String email,
            String cpf_cnpj, String inscricao_estadual, String tel_fixo, String cel1, String cel2,
            Endereco endereco) {
        
        this.setNome(nome);
        this.site = site;
        this.empresa_razao = razao_social;
        this.site = site;
        this.inscricao_estadual = inscricao_estadual;
        this.setNome(nome);
        this.setCpf_cnpj(cpf_cnpj);     
        this.setTel_fixo(tel_fixo);
        this.setCel1(cel1);
        this.setCel2(cel2);
        this.setEmail(email);       
        this.setTipo(true);
        this.setEndereco(endereco);
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmpresa_razao() {
        return empresa_razao;
    }

    public void setEmpresa_razao(String empresa_razao) {
        this.empresa_razao = empresa_razao;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getInscricao_estadual() {
        return inscricao_estadual;
    }

    public void setInscricao_estadual(String inscricao_estadual) {
        this.inscricao_estadual = inscricao_estadual;
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
        if (!(object instanceof Fornecedor)) {
            return false;
        }
        Fornecedor other = (Fornecedor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidade.Cliente[ id=" + id + " ]";
    }
}
