/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author thoma
 */
public class Main {
    public static void main(String[] args) throws IOException
    {
	Memory obiect = new Memory();
        /// File file = new File("out.txt");
        File file = new File(args[1]);    // DESPRE ASTA E VORBA
        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(file); 
        /// FileReader file1 = new FileReader("in.in");
        FileReader file1 = new FileReader(args[0]); /// BINE SI DESPRE ASTA
        BufferedReader reader = new BufferedReader(file1);
       
        int ok = 0, dimensiune = 0, nr_operatii = 0, type = 0;

        String line = reader.readLine();
        //System.out.println(line);
        String FIFO = "FIFO";
        String LRU = "LRU";
        
        Cache z = new FIFOCache();
        Cache y = new LRUCache();
        Cache w = new LFUCache();
        Cache x;
        
	if (line.equals(FIFO))
        {   x = z;  
            type = 1; 
        }
        else if (line.equals(LRU))
        {   x = y;  
            type = 2; 
        }
        else
        {
            x = w;
            type = 3;
        }
        
        line = reader.readLine();
        dimensiune = Integer.parseInt(line);
        line = reader.readLine();
        nr_operatii = Integer.parseInt(line); 
        
        for (int i = 0; i < nr_operatii; i++)
        {
            line = reader.readLine();
            //System.out.println(line);
       
            String adauga = "ADD";
            String ia = "GET";
            String comanda = new String();
            String nume = new String();
            String numar1 = new String();
            int Numar1 = 0;
            String numar2 = new String();
            int Numar2 = 0;
            numar2 = "-1";
            int cnt = 0;
       
            for (String val: line.split(" ", 4)) 
            {
                if (cnt == 0)
                    comanda = val;
                else if (cnt == 1)
                    nume = val;
                else if (cnt == 2)
                    numar1 = val;
                else if (cnt == 3)
                    numar2 = val;
                
                cnt++;
            }
            if (comanda.equals(adauga)) /// executam comanda adauga
            {
                if (!numar2.equals("-1"))
                {   
                    Numar1 = Integer.parseInt(numar1);
                    Numar2 = Integer.parseInt(numar2);
                } 
                else
                {
                     Numar1 = Integer.parseInt(numar1);
		     Numar2 = 0;
                }                
                if (Numar2 == 0)
                {
                   /// bag un obiect de tip Basic
                   Basic obiectnou = new Basic();
                   obiectnou.Add(nume, Numar1, Numar2, x, dimensiune, obiect);  
                } 
                else
                {
                   /// bag un obiect de tip Premium
                   Premium obiectnou = new Premium();
                   obiectnou.Add(nume, Numar1, Numar2, x, dimensiune, obiect);   
                }
            }
            else   //// e vorba de functia get
            {
                 ok = 0;
                 for (Subscription j: obiect.memory)
                        if (j.name.equals(nume))
                        {
                            ok = 1;
                            j.Get(nume, x, dimensiune, type, pw, obiect); /// se duce pe tipul lui specific      
                        }                             
                 if (ok == 0)
                 {
                    //System.out.println("2");
                    pw.println("2");
                 }
            }
        }
      pw.close();
    }
}

