package numerosaleatorios_umg;

import java.io.BufferedWriter;
import java.util.Random;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Collections;


/**
 *
 * @author Diego
 */
public class Numerosaleatorios_umg {
    
    
    public static void guardar() {
        Random ran = new Random();
      
        int u = 0;
        try {
            String direccion = "numeroaleatorio.txt";
            File file = new File(direccion);
            String direccion2 = "numeroaleatorio2.txt";
            File fil2 = new File(direccion2);
            
            if (!file.exists()) {
            file.createNewFile();
            }

            FileWriter fw = new FileWriter(file);
            FileWriter fy = new FileWriter(fil2);
            int desde = -10000000, hasta = 10000000;
            int array[];
            array = new int[1000000];

            int numero[];
            numero = new int[1000000];
            try ( BufferedWriter bx = new BufferedWriter(fy)) {
                try ( BufferedWriter bw = new BufferedWriter(fw)) {

                    for (int i = 0; i <=999999; i++) {
                        u = ran.nextInt(hasta - desde + 1) + desde;
                        array[i] = u;
                        System.out.println(i+ ",  "+array[i]);
                        fw.write(u + "\n");
                        fy.write(u + ",  ");
                    } 
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
      public static void leer() {
          
        Scanner doc = null;
        ArrayList<Integer> list = new ArrayList<Integer>();
        
             try{
                 
             doc = new Scanner(new File("numeroaleatorio.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while(doc.hasNext()){
            if (doc.hasNextInt()) list.add(doc.nextInt());
            else doc.next();
        }

        Collections.sort(list);

        for (Integer i: list) System.out.println(i);    
   

        
    }

    public static void menu_umg() {
        Scanner in = new Scanner(System.in);
        int b;
        do {
            System.out.println("... Menu de numeros aleatorios umg ...");
            System.out.println(" 1. Generar numeros aleatorios ");
            System.out.println(" 2. leer y ordenar numeros ");
            System.out.println(" 3. Salir ");
            System.out.println(" Ingrese la opcion que desee: ");
            b = in.nextInt();

            switch (b) {
                case 1:
                    guardar();
                    break;

                case 2:
                  leer();
                    break;

            }
        } while (b != 3);
    }

    public static void main(String[] args) {
        // TODO code application logic here
            menu_umg();
       
            
    }
    
}
