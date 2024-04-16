package calcularpotencia;

import java.util.*;
public class CalcularPotencia{
    public static void main(String[] args){
        int num, pot;
        Scanner scan = new Scanner(System.in);
        Potencia p = new Potencia();

        //Se asegura de que se solo halla numeros enteros
        try{
            //Se capturan los datos
            System.out.println("Digite el numero que se quiere elevar");
            num = scan.nextInt();
            System.out.println("Digite el numero al que se quiere elevar");
            pot = scan.nextInt();

            //Si la potencia es positiva se hara un procedimiento, si es negativa se hara otro
            if(pot>=0) System.out.println("El resultado es "+p.Power(num,pot));
            else  System.out.println("El resultado es "+p.Powerneg(num,pot));
        }catch(Exception e){
            System.out.println("Solo se aceptan numeros");
        }
    }
}