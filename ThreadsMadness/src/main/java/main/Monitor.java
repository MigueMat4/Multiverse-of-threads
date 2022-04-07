/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

     
/**
 *
 * @author Paolo_Veliz
 */
public class Monitor {
        String[][] sala_cine = new String[3][5]; // sala de cine con 5 asientos en cada fila
        int filas_llenas; // contador de filas que se van llenando
        int asientos_ocupados; // contador de posiciones para los asientos de una fila
    public Monitor(){
       this.filas_llenas = 0;
       this.asientos_ocupados = 0;
    }
    public synchronized void Mon(String nombreCliente, float dineroCliente, String asiento_obtenido){
         System.out.println("Proceso " + nombreCliente + " iniciado. Tengo Q " + dineroCliente);
            float dineroSobrante = dineroCliente;
            // Antes de escoger asiento debe comprar lo que pueda con el dinero que tenga
            if (dineroSobrante > 48){
                dineroSobrante = dineroCliente - 48;
                System.out.println("Pudo comprar su asiento");
                if(dineroSobrante > 30){
                    dineroSobrante = dineroSobrante - 30;
                    System.out.println("Pudo comprar 1 poporopo");
                    if (dineroSobrante > 5){
                        dineroSobrante = dineroSobrante - 30;
                        System.out.println("Pudo comprar un dulce");
                    }
                }
                System.out.println("-------------------------");
                System.out.println("Dinero sobrante => " + Math.ceil(dineroSobrante));
                System.out.println("-------------------------");
         // La entrada cuesta Q 48, los poporopos Q 30 y los dulces Q 5
                   sala_cine[filas_llenas][asientos_ocupados] = nombreCliente;
                    String fila = "";
                if (filas_llenas == 0){
                    System.out.println("Fila A llena");
                    fila = "A";
                }else if (filas_llenas == 1){
                System.out.println("Fila B llena");
                    fila = "B";
                }else if(filas_llenas == 2){
                    System.out.println("Fila C llena");
                    fila = "C";
                }
               
                    asiento_obtenido = "Fila " + fila + " Asiento " + String.valueOf(asientos_ocupados + 1);
                    asientos_ocupados++;
                    if(asientos_ocupados == 5){
                        asientos_ocupados = 0;
                        filas_llenas++;
                    }  
                 
                
            // el cliente debe indicarle al portero que asiento tiene
            // también debe mostrar cuanto le quedo de dinero para el próximo estreno
            System.out.println(nombreCliente + " finalizado con status: 0");    
            }else{
                System.out.println("No puede comprar boleto por ende no puede pasar");
            }
    }
}
