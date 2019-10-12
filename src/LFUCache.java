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
public class LFUCache implements Cache 
{
    /// int static dimension;
    public static ArrayList<Subscription> LFUarray = new ArrayList<Subscription>();
    public static ArrayList<Integer> contor = new ArrayList<Integer>();

    @Override
    public void add(Subscription obiect, int dimension) 
    {
        /// System.out.println("Here");
       /// System.out.println(dimension);
       if (dimension == 0 || LFUarray.size() < dimension)
       {   LFUarray.add(obiect);
           Integer val = 0;
           contor.add(val);
       }
       else
       if (LFUarray.size() == dimension)
       {
           LFUarray.remove(0);
           LFUarray.add(obiect);
           contor.remove(0);
           Integer val = 0;
           contor.add(val);
       }
    }
    
    @Override
    public void remove(Subscription obiect) 
    {
        int cnt = -1;
        for (Subscription i: LFUarray)
            if (i.name.equals(obiect.name))
            {
                cnt++;
                LFUarray.remove(i);
                contor.remove(cnt);
                return; 
            }
    }

    @Override
    public int search(String nume) 
    {
        for (Subscription i: LFUarray)
            if (i.name.equals(nume))
                return 1;
        return 0;
    }
    
    @Override
    public Subscription find (String nume)
    {
        Subscription j = LFUarray.get(0);
        for (Subscription i: LFUarray)
            if (i.name.equals(nume))
                return i;
        return j; /// dar oricum nu se ajunge aici
    }
    
    @Override
    public void swap(String nume)
    {
        ;
    }
    
    @Override
    public void sort()
    {
        int cnt1 = -1;
        for (cnt1 = 0; cnt1 < contor.size(); cnt1++)
        {
            int cnt2 = -1;
            for (cnt2 = 0; cnt2 < contor.size(); cnt2++)
            {
                /// System.out.println(contor.get(cnt1) + "IM HERE MOFACKERS" + contor.get(cnt2));
                /// System.out.println(cnt1 + "IM HERE MOFACKERS" + cnt2);
                if (cnt1 < cnt2 && contor.get(cnt1) > contor.get(cnt2))
                {
                    /// System.out.println(contor.get(cnt1) + "    " + contor.get(cnt2));
                    /// System.out.println("IM HERE MOFACKERS");
                    /// System.out.println(cnt1 + ", " + cnt2);
                    
                    Integer aux1;
                    aux1 = contor.get(cnt1);
                    contor.set(cnt1, contor.get(cnt2));
                    contor.set(cnt2, aux1);
                    
                    /// System.out.println(contor.get(cnt1) + "    " + contor.get(cnt2));
                    
                    /// aici interschimb swap (LFU(cnt1), LFU(cnt2))
                    /// System.out.println(LFUarray.get(cnt1).name + "   " + LFUarray.get(cnt2).name);
                    Subscription aux;
                    aux = LFUarray.get(cnt1);
                    
                    /// LFUarray.get(cnt1) = LFUarray.get(cnt2);
                    LFUarray.set(cnt1, LFUarray.get(cnt2));
                    LFUarray.set(cnt2, aux);
                    
                    /// System.out.println(LFUarray.get(cnt1).name + "   " + LFUarray.get(cnt2).name);
                }
            }
        }
    }
    
    @Override
    public void now (String nume)
    {
        int cnt = -1;
        for (Subscription i: LFUarray)
        {
            cnt++;
            if (i.name.equals(nume))
            { contor.set(cnt, contor.get(cnt) + 1);
              return ;
            }
        }
    }
}
