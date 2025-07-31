package org.example.Activities;

public class Activity2 {
    public static void main(String[] args) {

        int[] Array1 = {10, 77, 10, 54, -11, 10};
        int findNumber = 10;
        int sum = 30;
        System.out.println("Result: " + result(Array1, findNumber, sum));
    }
        public static boolean result(int[] numbers, int findNumber, int sum) {
            int temp_sum = 0;
            for (int number : numbers) {
                //If value is 10
                if (number == findNumber) {
                    //Add them
                    temp_sum += findNumber;
                }

                if (temp_sum > sum) {
                    break;
                }
            }

            return temp_sum == sum;
        }
    }