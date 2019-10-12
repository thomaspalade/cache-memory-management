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
    public class FIFOCache implements Cache {

        /// int static dimension;
        public static ArrayList<Subscription> FIFOarray = new ArrayList<Subscription>();

        @Override
        public void add(Subscription obiect, int dimension) {
            /// System.out.println("Here");
            /// System.out.println(dimension);
            if (dimension == 0 || FIFOarray.size() < dimension) {
                FIFOarray.add(obiect);
            } else if (FIFOarray.size() == dimension) {
                FIFOarray.remove(0);
                FIFOarray.add(obiect);
            }
        }

        @Override
        public void remove(Subscription obiect) {
            for (Subscription i : FIFOarray) {
                if (i.name.equals(obiect.name)) {
                    FIFOarray.remove(i);
                    return;
                }
            }
        }

        @Override
        public int search(String nume) {
            for (Subscription i : FIFOarray) {
                if (i.name.equals(nume)) {
                    return 1;
                }
            }
            return 0;
        }

        @Override
        public Subscription find(String nume) {
            Subscription j = FIFOarray.get(0);
            for (Subscription i : FIFOarray) {
                if (i.name.equals(nume)) {
                    return i;
                }
            }
            return j; /// dar oricum nu se ajunge aici
        }

        @Override
        public void swap(String nume) {
            ;
        }

        @Override
        public void sort() {
            ;
        }

        @Override
        public void now(String nume) {
            ;
        }
    }
