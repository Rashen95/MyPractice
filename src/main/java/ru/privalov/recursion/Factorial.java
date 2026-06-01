package ru.privalov.recursion;

import java.math.BigInteger;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(BigInteger.valueOf(57)));
    }

    public static BigInteger factorial(BigInteger n) {
        if (n.equals(BigInteger.ONE)) {
            return BigInteger.ONE;
        }

        return n.multiply(factorial(n.subtract(BigInteger.ONE)));
    }
}
