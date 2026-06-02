package ru.privalov.recursion;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class Factorial {
    public static void main(String[] args) {
        long start;
        long end;
        int number = 1000; // Меняем тут (при больших значениях надо расширять стек для рекурсии)
        boolean needPrintFactorial = false; // И тут если хотим вывести получившееся значение

        start = System.nanoTime();
        if (needPrintFactorial) {
            System.out.println(factorialRecursion(number));
        } else {
            factorialRecursion(number);
        }
        end = System.nanoTime();
        System.out.printf("Расчет факториала через рекурсию за: %sмс\n", (end - start) / 1_000_000);

        start = System.nanoTime();
        if (needPrintFactorial) {
            System.out.println(factorialCycle(number));
        } else {
            factorialCycle(number);
        }
        end = System.nanoTime();
        System.out.printf("Расчет факториала через цикл за: %sмс\n", (end - start) / 1_000_000);

        start = System.nanoTime();
        if (needPrintFactorial) {
            System.out.println(factorialParallelStream(number));
        } else {
            factorialParallelStream(number);
        }
        end = System.nanoTime();
        System.out.printf("Расчет факториала через параллельный поток за: %sмс\n", (end - start) / 1_000_000);
    }

    public static BigInteger factorialRecursion(int number) {
        if (number == 1) {
            return BigInteger.ONE;
        }

        return BigInteger.valueOf(number).multiply(factorialRecursion(number - 1));
    }

    public static BigInteger factorialCycle(int number) {
        BigInteger factorial = BigInteger.ONE;

        for (int i = 1; i <= number; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        return factorial;
    }

    public static BigInteger factorialParallelStream(int number) {
        return IntStream.rangeClosed(1, number)
                .parallel()
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger.ONE, BigInteger::multiply);
    }
}
