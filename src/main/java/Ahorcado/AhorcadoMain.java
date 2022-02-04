package Ahorcado;

import java.util.Random;
import java.util.Scanner;

public class AhorcadoMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        boolean flag = true;
        String[][] Palabra = {
            {"vaca", " Es un animal."},
            {"loco", " Hospital Psiquiatrico."}
        };
        int pos = rd.nextInt(Palabra.length);
        String leng = Palabra[pos][0];
        String[] tabla = new String[leng.length()];
        int cont = 0;

        System.out.println(Palabra[pos][0] + Palabra[pos][1]);

        System.out.println("¡Adivina la palabra!");
        for (int i = 0; i < leng.length(); i++) {
            tabla[i] = "_";
        }
        
        System.out.println(tabla[0]+ tabla[1]);
        
        for (String linea : tabla) {
            System.out.print(linea + " ");
        }
        System.out.println("");

        do {
            System.out.println("Introduce una Letra. Pista: " + Palabra[pos][1]);
            String let = sc.nextLine();

            for (int i = 0; i < leng.length(); i++) {
                if (leng.charAt(i) == let.charAt(0)) {
                    tabla[i] = let;
                }
            }
//            if (leng.indexOf(let) != 0) {
//                System.out.println("La letra " + let + " no se encuentra en la palabra.\n");
//            }
            for (String linea : tabla) {
                System.out.print(linea + " ");
            }

            cont++;
            int contT = 0;
            for (int i = 0; i < tabla.length; i++) {
                if (tabla[i].equals(leng.charAt(i))) {
                    contT++;
                }

            }
            if (contT == leng.length()) {
                flag = false;
                System.out.println("Felicitaciones! has ganado" + "\nCantidad de intentos: " + cont);
            }
            System.out.println("");
        } while (cont < 10 && flag == true);
        if (cont == 10) {
            System.out.println("¡Te has quedado sin intentos!" + " La palabra era: " + Palabra[pos][0]);
        }

    }

}
