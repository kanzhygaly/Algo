/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.ya.algo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author YERLAN
 */
public class DeadLock {

    static class Person {

        private final String name;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public synchronized void askName(Person other) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(DeadLock.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(other.getName() + " asks my name " + this.getName());
            other.askNameBack(this);
        }

        public synchronized void askNameBack(Person other) {
            System.out.println(other.getName() + " asks my name back");
        }
    }

//    final static Object obj1 = new Object();
//    final static Object obj2 = new Object();
//    
//    public static void method1() {
//        synchronized (obj1) {
//            synchronized (obj2) {
//            }
//        }
//    }
    public static void main(String[] args) {
        final Person p1 = new Person("Person 1");
        final Person p2 = new Person("Person 2");
        new Thread(new Runnable() {
            public void run() {
                synchronized (p1) {
                    try {
                        Thread.sleep(500);
                        synchronized (p2) {
                            p1.askName(p2);
                        }
                    } catch (InterruptedException ex) {
                        Logger.getLogger(DeadLock.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                synchronized (p1) {
                    synchronized (p2) {
                        p2.askName(p1);
                    }
                }
            }
        }).start();
    }
}
