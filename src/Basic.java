/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Main;
import java.io.*;
//import static Memory.memory;

/**
 *
 * @author thoma
 */
public class Basic extends Free
{       
    int how_many_b; 
        
    @Override
    public void Get(String nume, Cache x, int dimensiune, int type, PrintWriter pw, Memory obiect) 
    {
        if (how_many_b == 0)
        {
            super.Get(nume, x, dimensiune, type, pw, obiect);
            return ;
        }   
        
        how_many_b--;
      
        if (x.search(nume) == 1)   /// daca l-am gasit in cache
            {
                  if (type == 2)
                        x.swap(nume);
                  else if (type == 3)
                        { x.sort();
                          x.now(nume);
                        }
                  //System.out.println("0 Basic");
                  pw.print("0 Basic");
                  pw.print("\n");
                return ;
            }
         //System.out.println("1 Basic");
         pw.print("1 Basic");
         pw.print("\n");
         x.add(this, dimensiune); /// l-am gasit in memorie dar nu in cache, asa ca il pun
            
         return ;
    }

    @Override
    public int Add(String nume, int cnt1, int cnt2, Cache x, int dimensiune, Memory obiect)
    {
        for (Subscription i:obiect.memory)
            if (nume.equals(i.name))
            {
                obiect.memory.remove(i);
                /// l-am gasit si treaba-i buna
                this.how_many_b = cnt1;
                this.name = nume;
                obiect.memory.add(this);
                if (x.search(nume) == 1)
                       x.remove(i);
                return 0;
            }
        this.name = nume;
        this.how_many_b = cnt1;
        obiect.memory.add(this);
        return 0;
    }
    
    @Override
    public void Print(PrintWriter pw, Cache x)
    {
        if (this.how_many_b == 0)
        {
            super.Print(pw, x);
            return ;
        }
        pw.println(this.name + " " + this.how_many_b + " 0");
    }
    
}
