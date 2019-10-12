/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Main;
//import Cache;

import java.io.PrintWriter;

/**
 *
 * @author thoma
 */
public abstract class Subscription {
    String name;
    public Subscription()
    {
        
    }
    public Subscription(String name)
    {
        this.name = name;
    }
    /// public abstract void Add(Subscription obiect);
    /// public abstract int Get(Subscription obiect);
    public abstract void Get(String nume, Cache x, int dimensiune, int type, PrintWriter pw, Memory obiect); /// nu cred ca are parametri sau in cel mai rau caz are un string 
    public abstract int Add(String nume, int cnt1, int cnt2, Cache x, int dimensiune, Memory obiect); /// in cel mai rau caz un string si niste numere acolo
    public abstract void Print(PrintWriter pw, Cache x);
}
