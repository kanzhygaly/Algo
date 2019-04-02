/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.ya.algo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author YERLAN
 */
public class ReplaceMultiToSingleSpace {

    public static void main(String[] args) {
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, new Locale("kk", "KZ"));
        System.out.println(df.format(new Date()));
        SimpleDateFormat sdf = new SimpleDateFormat("« dd » MMMM yyyy", new Locale("kk"));
        System.out.println(sdf.format( new Date() ) + " жыл");
        sdf.applyPattern("dd MMMM yyyy");
        System.out.println(sdf.format( new Date() ) + " жыл");
        
        // 1
        int a = 1;
        int b = a++;
        int c = ++b;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        // 2
        a = 1 << 2;
        System.out.println(a);

        // 3
        System.out.println(max(4, 5));

        // 4
        login();

        String str = "";
        System.out.println(str.trim().replaceAll(" +", " "));
    }

    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    private static final char SEPARATOR = 0x20;
    private static final int MESSAGE_TYPE = 1;

    static void login() {
        System.out.println(SEPARATOR + MESSAGE_TYPE + "=A");
    }

    // 5
    class Person implements Comparable<Person> {

        String m_firstName;
        String m_lastName;

        @Override
        public int compareTo(Person p) {
            return m_lastName.compareTo(p.m_lastName) + m_firstName.compareTo(p.m_firstName);
        }
    }

    // 6
    public abstract class Car {

        public Car(int numDoors) {
            myNumDoors = numDoors;
        }

        public abstract int maxNumPassengers();
        protected int myNumDoors;
    }

    public class Sedan extends Car {

        public Sedan(int numDoors) {
            super(numDoors);
        }

        public int maxNumPassengers() {
            return myNumDoors * 1;
        }
    }

    // 7
    class LongObj {

        private int m_length;

        LongObj(int length) {
            m_length = length;
        }
    }

    class LongAndWideObj extends LongObj {

        private int m_width;

        public LongAndWideObj(int m_width, int length) {
            super(length);
            this.m_width = m_width;
        }
    }

    // 10
    public static String concatStrings(List<String> strings) {
        String returnValue = "";
        for (String s : strings) {
            returnValue += s;
        }
        return returnValue;
    }

    // 11
    class SomeClass {

        void divide(int num, int den) throws Exception {
            if (den == 0) {
                throw new Exception("DivideByZeroException");
            }
            System.out.println("" + (num / den));
        }

        void fun() {
            try {
                divide(4, 2);
            } catch (Exception e) {
            }
        }
    }
}
