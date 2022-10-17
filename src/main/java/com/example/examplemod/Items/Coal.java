package com.example.examplemod.Items;

public class Coal {
    static int Counter = 0;

    public static void increase_counter(int amount) {
        Counter+=amount;
    }

    public static int get_counter() {
        return Counter;
    }

    public static void reset_counter() {
        Counter = 0;
    }
}
