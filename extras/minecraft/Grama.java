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
public class Grama implements Bloco {

    @Override
    public Bloco destroi(String ferramenta) {
        if(ferramenta.equals("toque suave")){
            return this;
        }
        else{
            return new Terra();
        }
    }
    @Override
    public String toString(){
        return "GRAMA";
    }
}
