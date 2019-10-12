/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.PrintWriter;

/**
 *
 * @author thoma
 */
public class Free extends Subscription
{       
    @Override
    public void Get(String nume, Cache x, int dimensiune, int type, PrintWriter pw, Memory obiect) 
    {
        if (x.search(nume) == 1)   /// daca l-am gasit in cache
        {
            if (type == 2)
                  x.swap(nume);
            else if (type == 3)
                        { x.sort();
                          x.now(nume);
                        }
            //System.out.println("0 Free");
            pw.print("0 Free");
            pw.print("\n");
            return ;
        }
               
        //System.out.println("1 Free");   /// poate doar aici sa fie probleme
        pw.print("1 Free");
        pw.print("\n");
        x.add(this, dimensiune); /// l-am gasit in memorie dar nu in cache, asa ca il pun  
        return ;
    }

    @Override
    public int Add(String nume, int cnt1, int cnt2, Cache x, int dimensiune, Memory obiect) 
    {
        return 0;
    }
    
    @Override
    public void Print(PrintWriter pw, Cache x)
    {
             pw.println(this.name + " 0 0");
         return ;
    }
 
}
