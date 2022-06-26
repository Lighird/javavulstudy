package com.example.springdemo.Runtime;

import java.io.IOException;

public class Runtest {
    public static void main(String[] args) throws IOException {
        Runtime.getRuntime().exec("open /System/Applications/Calculator.app");
    }
}
