package Examen_Package;


import java.util.Scanner;


import java.util.ArrayList;


import java.util.List;


public class Ejercicio4_Marcos_Gracia {


    public static void main(String[] args) {
        // TODO Auto-generated method stub


        Scanner sc = new Scanner(System.in);


        int saldo_inicial = 100;


        int opción;


        List<String> historial = new ArrayList<>();
        historial.add("Saldo inicial: " + saldo_inicial);


        do {


            System.out.println("--- CAJERO AUTOMÁTICO ---");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Ingresar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Ver historial");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opción = sc.nextInt();


            switch (opción) {


            case 1: {


                System.out.println("Saldo actual: " + saldo_inicial + "$");


                break;


            }


            case 2: {


                System.out.print("Cantidad a ingresar: ");
                int ingreso = sc.nextInt();


                saldo_inicial = saldo_inicial + ingreso;


                System.out.println("Ingreso realizado.");


                System.out.println("Nuevo saldo: " + saldo_inicial + "$");


                historial.add("Ingreso de " + ingreso + "$");


                break;


            }


            case 3: {


                System.out.print("Cantidad a retirar: ");
                int retiro = sc.nextInt();


                if ((saldo_inicial - retiro) < 0) {


                    System.out.println("Retirada no realizada.");


                    System.out.println("Saldo actual: " + saldo_inicial + "$");


                } else {


                    saldo_inicial = saldo_inicial - retiro;


                    System.out.println("Retirada realizada.");


                    System.out.println("Nuevo saldo: " + saldo_inicial + "$");


                    historial.add("Retirada de " + retiro + "$");


                }


                break;


            }


            case 4: {


                System.out.println("--- HISTORIAL ---");


                for (int i = 0; i < historial.size(); i++)
                    System.out.println(historial.get(i));


                break;


            }


            case 5: {


                System.out.println("Has finalizado tu sesión.");


                break;


            }


            }


            System.out.println();


        } while (opción != 5);


        sc.close();


    }


}
