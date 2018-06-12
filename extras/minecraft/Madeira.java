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
public class Madeira implements Bloco {

    @Override
    public Bloco destroi(String ferramenta) {
        return this;
    }
    @Override
    public String toString(){
        return "MADEIRA";
    }  
}
