/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prefija;

import java.util.Scanner;

/**
 *
 * @author RAGAd
 */
public class Prefija {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Introduzca operacion infija\n");
        String infija = in.next();
        String prefija = Convertidor.convertirAprefija(infija);

        String postfija = Convertidor.convertirApostfija(infija);
        System.out.print("Expresion en notación postfija: " + postfija + "\n");
        System.out.print("Expresion en notación prefija: " + prefija + "\n");

    }

}
