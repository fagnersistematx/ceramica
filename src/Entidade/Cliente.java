
package Entidade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author Fagner
 */
@Entity
@Table(name = "cliente")
public class Cliente extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;    
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.DELETE})
    private List<Maquina> maquinas;

    public Cliente() {
    }

    //Cliente físico.
    public Cliente(String nome, String cpf_cnpj, String rg, String data_nas, String tel_fixo, String cel1, String cel2, String email, String sexo, String estado_civil, boolean tipo, Endereco endereco) {
        this.setNome(nome);
        this.setCpf_cnpj(cpf_cnpj);
        this.setRg(rg);
        this.setData_nas(data_nas);
        this.setTel_fixo(tel_fixo);
        this.setCel1(cel1);
        this.setCel2(cel2);
        this.setEmail(email);
        this.setSexo(sexo);
        this.setEstado_civil(estado_civil);
        this.setTipo(tipo);
        this.setEndereco(endereco);
    }

    //Cliente juridico.
    public Cliente(String nome, String cpf_cnpj, String tel_fixo, String cel1, String cel2, String email, boolean tipo, Endereco endereco,String site) {
        
        this.setNome(nome);
        this.setCpf_cnpj(cpf_cnpj);
        this.setTel_fixo(tel_fixo);
        this.setCel1(cel1);
        this.setCel2(cel2);
        this.setEmail(email);
        this.setTipo(tipo);
        this.setRg(site);
        this.setEndereco(endereco);
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   

    public List<Maquina> getMaquinas() {
        return maquinas;
    }

    public void setMaquinas(List<Maquina> maquinas) {
        this.maquinas = maquinas;
    }

    public void addMaquina(Maquina maquina) {
        this.maquinas.add(maquina);
    }

    public void atualizaCliente(String nome, String cpf_cnpj, String rg, String data_nas, String tel_fixo, String cel1, String cel2,
            String email, String sexo, String estado_civil, boolean tipo) {        
       
        this.setNome(nome);
        this.setCpf_cnpj(cpf_cnpj);
        this.setRg(rg);
        this.setData_nas(data_nas);
        this.setTel_fixo(tel_fixo);
        this.setCel1(cel1);
        this.setCel2(cel2);
        this.setEmail(email);
        this.setSexo(sexo);
        this.setEstado_civil(estado_civil);
        this.setTipo(tipo);
        
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
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
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
