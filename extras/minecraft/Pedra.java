/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minecraft;

/**
 *
 * @author hp36
 */
public class Pedra implements Bloco{

    @Override
    public Bloco destroi(String ferramenta) {
        if(ferramenta.equals("toque suave")){
            return this;
        }
        else if(ferramenta.equals("picareta")){
            return new Pedregulho();
        }
        else{
            return null;
        }
    }
    @Override
    public String toString(){
        return "PEDRA";
    }
}
