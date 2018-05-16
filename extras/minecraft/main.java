/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minecraft;

public class main {

    public static void main(String[] args) {
        Bloco a= new Madeira();
        Bloco b= new Pedra();
        Bloco c= new Pedregulho();
        Bloco d= new Grama();
        Bloco e= new Terra();
        
        a = a.destroi("");
        b = b.destroi("toque suave");
        c = c.destroi("");
        d = d.destroi("");
        e = e.destroi("");
        
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
    }
    
}
