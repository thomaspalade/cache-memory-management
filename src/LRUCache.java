/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 *
 * @author thoma
 */
public class LRUCache implements Cache {
    /// int dimension;
     public static ArrayList<Subscription> LRUarray = new ArrayList<Subscription>();

    @Override
    public void add(Subscription obiect, int dimension) 
    {
       /// System.out.println(obiect.name);
       /// System.out.println(dimension);
       if (dimension == 0 || LRUarray.size() < dimension)
           LRUarray.add(obiect);
       else
       if (LRUarray.size() == dimension)
       {
           LRUarray.remove(0);
           LRUarray.add(obiect);
       }
    }
    
    @Override
    public void remove(Subscription obiect) 
    {
        for (Subscription i: LRUarray)
            if (i.name.equals(obiect.name))
            {
                LRUarray.remove(i);
                return; 
            }
    }

    @Override
    public int search(String nume) 
    {
        for (Subscription i: LRUarray)
            if (i.name.equals(nume))
                return 1;
        return 0;
    }
    
    @Override
    public Subscription find (String nume)
    {
        Subscription j = LRUarray.get(0);
        for (Subscription i: LRUarray)
            if (i.name.equals(nume))
                return i;
        return j; /// dar oricum nu se ajunge aici
    }
    
    
    @Override
    public void swap(String nume)
    {
        Subscription temp;
        for (Subscription i: LRUarray)
            if (i.name.equals(nume))
            {    
                temp = i;
                LRUarray.remove(i);
                LRUarray.add(temp);
                return ;
            }
    }
    @Override
    public void sort()
    {
        ;
    }
    
    @Override
    public void now (String nume)
    {
        ;
    }
}
