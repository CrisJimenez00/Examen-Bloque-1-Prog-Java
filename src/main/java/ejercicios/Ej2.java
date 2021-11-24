/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios;

import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author cristina
 */
public class Ej2 {

    public static void main(String[] args) {
        //Variable que sirve para que pida datos por el try/catch
        boolean solicitarDatos = true;

        //Variables sin inicializar
        //Servirán para guardar los valores numéricos de a, b y c
        int valorA, valorB, valorC;

        //Servirán para guardar los valores de String de a, b y c
        //(JOption se introduce en String)
        String valorALetra, valorBLetra, valorCLetra;

        //Pedimos datos por pantalla y miramos 
        //si son válidos para nuestro programa o no
        JOptionPane.showMessageDialog(null, "Bienvenido a tu solucionario de ecuaciones");
        do {
            try {
                valorALetra = JOptionPane.showInputDialog("Por favor, introduzca el valor de a");
                valorA = Integer.parseInt(valorALetra);//Aquí puede dar error

                valorBLetra = JOptionPane.showInputDialog("A continuación introduzca el valor b");
                valorB = Integer.parseInt(valorBLetra);//Aquí puede dar error

                valorCLetra = JOptionPane.showInputDialog("Por último, introduzca el valor c");
                valorC = Integer.parseInt(valorCLetra);//Aquí puede dar error

                //Para controlar que los datos están correctamente introducidos.
                //Si es false no se repite el do/while
                solicitarDatos = false;

                if (valorA == 0 && valorB == 0) {

                    System.out.println("La ecuación no tiene solución");

                } else if (valorA == 0 && valorB != 0) {

                    JOptionPane.showMessageDialog(null, "Se procederá a hacer -c/b");

                    //Le hago conversión explícita a double para que así pueda 
                    //dar decimales y con ello una solución más exacta
                    double solución = (double) (-(valorC) / valorB);

                    System.out.println("La solución es: " + solución);

                } else {
                    //Declaro las variables para las dos posibles soluciones de x
                    double solucionX1, solucionX2;
                    //Solución sumando el -b
                    solucionX1 = ((-valorB) + Math.sqrt(Math.pow(valorB, 2) - (4 * valorA * valorC))) / (2 * valorA);
                    //Solución restando el -b
                    solucionX2 = ((-valorB) - Math.sqrt(Math.pow(valorB, 2) - (4 * valorA * valorC))) / (2 * valorA);

                    //Para controlar si el valor es negativo
                    if (Math.pow(valorB, 2) - (4 * valorA * valorC) < 0) {
                        System.out.println("Los valores suministrados no permiten "
                                + "calcular las soluciones de la ecuación");

                    } else {
                        System.out.println("La solución es"
                                + "\n----------------------------"
                                + "\nValor de x1 = " + solucionX1
                                + "\nValor de x2 = " + solucionX2);
                    }

                }
            } catch (NumberFormatException nme) {
                //Código para tratar el error
                System.out.println("Se ha introducido texto en lugar de números"
                        + "\nVuelva a introducir los datos");
            }
        } while (solicitarDatos);

    }

}
