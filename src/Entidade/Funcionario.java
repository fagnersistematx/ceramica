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
@Table(name = "funcionario")
public class Funcionario extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String login;
    private String senha;
    private String funcao;
    private float salario;

    public Funcionario() {
    }    
    
    public Funcionario(String nome, String login, String senha, String email, String cpf_cnpj, String rg, String data_nas, String tel_fixo,
            String cel1, String cel2, String sexo, String estado_civil, String funcao,
            float salario, boolean tipo, Endereco endereco) {

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
        this.funcao = funcao;
        this.salario = salario;
        this.login = login;
        this.senha = senha;
    }

    public void atualiarDadosFuncionario(String nome, String login, String senha, String email, String cpf_cnpj, String rg, String data_nas, String tel_fixo,
            String cel1, String cel2, String sexo, String estado_civil, String funcao,
            float salario, boolean tipo, Endereco endereco) {

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
        this.funcao = funcao;
        this.salario = salario;
        this.login = login;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
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
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidade.Usuario[ id=" + id + " ]";
    }
}
