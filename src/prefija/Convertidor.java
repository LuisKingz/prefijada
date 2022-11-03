/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prefija;

/**
 *
 * @author lfern
 */
class Convertidor {

    public static String convertirApostfija(String infija) {
        String postfija = "";
        Pila pila = new Pila();

        for (int i = 0; i < infija.length(); i++) {
            char letra = infija.charAt(i);
            if (esOperador(letra)) {
                if (letra == ')') {

                    while (!pila.getTop().equals('(')) {
                        postfija += pila.pop();
                    }
                    if (pila.getTop().equals('(')) {
                        pila.pop();
                    }
                }

                if (pila.isEmpty()) {
                    if (letra != ')') {
                        pila.push(letra);
                    }
                } else {
                    if (letra != ')') {
                        int pe = prioridadExp(letra);
                        int pp = prioridadPila((char) pila.getTop());
                        if (pe > pp) {
                            pila.push(letra);
                        } else {
                            postfija += pila.pop();
                            pila.push(letra);
                        }
                    }

                }

            } else {
                postfija += letra;
            }

        }

        while (!pila.isEmpty()) {
            postfija += pila.pop();
        }
        return postfija;
    }

    public static String convertirAprefija(String infija) {
        String prefija = "";
        String invertida = "";
        Pila pila = new Pila();

        for (int i = infija.length() - 1; i > -1; i--) {
            char letra = infija.charAt(i);
            if (esOperador(letra)) {
                if (letra == '(') {

                    while (!pila.getTop().equals(')')) {
                        prefija += pila.pop();
                    }
                    if (pila.getTop().equals(')')) {
                        pila.pop();
                    }
                }

                if (pila.isEmpty()) {
                    if (letra != '(') {
                        pila.push(letra);
                    }
                } else {
                    if (letra != '(') {
                        int pe = prioridadExp(letra);
                        int pp = prioridadPila((char) pila.getTop());
                        if (pe > pp) {
                            pila.push(letra);
                        } else {
                            prefija += pila.pop();
                            pila.push(letra);
                        }
                    }

                }

            } else {
                prefija += letra;
            }

        }

        while (!pila.isEmpty()) {
            prefija += pila.pop();
        }

        for (int r =0; r < prefija.length(); r++) {
            invertida += prefija.charAt(r);
        }
        return invertida;
    }

    public static int prioridadExp(char x) {
        if (x == '^') {
            return 4;
        }
        if (x == '*' || x == '/') {
            return 2;
        }
        if (x == '+' || x == '-') {
            return 1;
        }
        if (x == '(') {
            return 5;
        }
        if (x == ')') {
            return 5;
        }
        return 0;
    }

    public static int prioridadPila(char x) {
        if (x == '^') {
            return 3;
        }
        if (x == '*' || x == '/') {
            return 2;
        }
        if (x == '+' || x == '-') {
            return 1;
        }
        if (x == '(') {
            return 0;
        }
        if (x == ')') {
            return 0;
        }
        return 0;
    }

    public static boolean esOperador(char letra) {
        if (letra == '*' || letra == '/' || letra == '+' || letra == '-' || letra == '^' || letra == '(' || letra == ')') {
            return true;
        } else {
            return false;
        }
    }
}
