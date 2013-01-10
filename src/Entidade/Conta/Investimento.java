
package Entidade.Conta;

import javax.persistence.MappedSuperclass;

/**
 *
 * @author Fagner Silva Martins, fagner.silva@dce.ufpb.br
 * @version 1.0
 */
@MappedSuperclass
public abstract class Investimento extends Fluxo{
    
    private float iof;
    private float cpmf;
    private float saldo_original;
    private float saldo_atualizado;
    private String nm_conta;

    public float getIof() {
        return iof;
    }

    public void setIof(float iof) {
        this.iof = iof;
    }

    public float getCpmf() {
        return cpmf;
    }

    public void setCpmf(float cpmf) {
        this.cpmf = cpmf;
    }

    public float getSaldo_original() {
        return saldo_original;
    }

    public void setSaldo_original(float saldo_original) {
        this.saldo_original = saldo_original;
    }

    public float getSaldo_atualizado() {
        return saldo_atualizado;
    }

    public void setSaldo_atualizado(float saldo_atualizado) {
        this.saldo_atualizado = saldo_atualizado;
    }

    public String getNm_conta() {
        return nm_conta;
    }

    public void setNm_conta(String nm_conta) {
        this.nm_conta = nm_conta;
    }    
    
}
