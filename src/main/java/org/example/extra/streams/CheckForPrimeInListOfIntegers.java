package org.example.extra.streams;

import java.util.List;

public class CheckForPrimeInListOfIntegers {

    public boolean isPrime(int n){
        if(n<=1) return false;
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i==0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        CheckForPrimeInListOfIntegers obj = new CheckForPrimeInListOfIntegers();
        List<Integer> numbers = List.of(2, 3, 4, 5, 6, 7, 8, 9, 10);
        boolean containsPrime = numbers.stream().anyMatch(obj::isPrime);
        if (containsPrime) {
            System.out.println("The list contains at least one prime number.");
        } else {
            System.out.println("The list does not contain any prime numbers.");
        }
    }

}
