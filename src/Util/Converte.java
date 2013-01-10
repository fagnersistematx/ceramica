
package Util;

/**
 * Classe criada para converte variaveis para outros tipos.
 * @author Fagner Silva Martins, fagner.silva@dce.ufpb.br
 * @version 1.0
 */
public class Converte {
    
    private static Converte converte;
    
    private Converte(){        
    }
    
    public float converteTextoNumero(String texto) throws NumberFormatException{
        float valor = Float.parseFloat(texto);
        return valor;
    }
    
    public static Converte getInstance(){
        if(converte == null){
            converte = new Converte();
        }
        return converte;
        
    }
    
}
