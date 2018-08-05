// PotatoCurry
// This file contains several useful methods I often use in my own programs.

package MethodsDL;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MethodsDL {

    public static void Delay(int delayTime) {
        try {
            TimeUnit.MILLISECONDS.sleep(delayTime);
        } catch (InterruptedException ex) {
            Logger.getLogger(MethodsDL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void Load(String load) {
        Load(load, 200);
    }

    public static void Load(String load, int speed) {
        System.out.print(load);
        Delay(speed);
        System.out.print(".");
        Delay(speed);
        System.out.print(".");
        Delay(speed);
        System.out.println(".");
        Delay(speed);
    }

    public static void SlowReveal(String reveal) {
        SlowReveal(reveal, 20);
    }

    public static void SlowReveal(String reveal, int speed) {
        char[] split = reveal.toCharArray();
        for (char r : split) {
            System.out.print(r);
            Delay(speed);
        }
        System.out.println();
    }

    public static void SlowReveal(String reveal, int speed, boolean newLine) {
        if (!newLine) {
            char[] split = reveal.toCharArray();
            for (char r : split) {
                System.out.print(r);
                Delay(speed);
            }
        } else {
            SlowReveal(reveal, speed);
        }
    }

    public static void SlowReveal(String reveal, boolean newLine) {
        if (!newLine) {
            char[] split = reveal.toCharArray();
            for (char r : split) {
                System.out.print(r);
                Delay(20);
            }
        } else {
            SlowReveal(reveal);
        }
    }

    public static int Random(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    public static int ChooseRandom(int[] arr) {
        return arr[Random(0, arr.length - 1)];
    }

    public static double ChooseRandom(double[] arr) {
        return arr[Random(0, arr.length - 1)];
    }

    public static String ChooseRandom(String[] arr) {
        return arr[Random(0, arr.length - 1)];
    }
}