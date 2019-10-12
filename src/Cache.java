/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/// package src;

/**
 *
 * @author thoma
 */
public interface Cache 
{
    void add (Subscription obiect, int dimension);
    int search (String nume);
    Subscription find (String nume);
    void remove (Subscription obiect);
    void swap (String nume);
    void sort (); /// mai vedem cu parametrii
    void now (String nume);
}
