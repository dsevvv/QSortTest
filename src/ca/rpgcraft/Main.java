package ca.rpgcraft;

import java.util.Random;

//Devon Sevrens
//Testing java quick sort implementation

public class Main {

    private static final Random r = new Random();

    public static void main(String[] args) {
        // write your code here
        long start = System.currentTimeMillis();

        int [] numbers = new int[1000000000];

        System.out.println("Populating array...");
        for(int i = 0; i < numbers.length; i++){
            numbers[i] = r.nextInt();
        }

        //System.out.println("Before: ");
        //printIntArray(numbers);

        System.out.println("Starting sort...");
        quickSortInt(numbers);

        //System.out.println("After: ");
        //printIntArray(numbers);

        System.out.println("Runtime: " + (double) (System.currentTimeMillis() - start) / 1000 + " seconds.");
    }

    private static void quickSortInt(int[] array){
        quickSortInt(array, 0, array.length - 1);
    }

    public static void quickSortInt(int[] array, int lowIndex, int highIndex){

        if(lowIndex >= highIndex) return;

        int pivotIndex = r.nextInt(highIndex - lowIndex) + lowIndex;
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, highIndex);

        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while(leftPointer < rightPointer){

            while(array[leftPointer] <= pivot && leftPointer < rightPointer){
                leftPointer++;
            }
            while (array[rightPointer] >= pivot && leftPointer < rightPointer){
                rightPointer--;
            }

            swap(array, leftPointer, rightPointer);
        }

        swap(array, leftPointer, highIndex);

        quickSortInt(array, lowIndex, leftPointer - 1);

        quickSortInt(array, leftPointer + 1, highIndex);
    }

    private static void swap(int[] array, int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void printIntArray(int[] numbers){
        for(int i = 0; i < numbers.length; i++){
            System.out.println(numbers[i]);
        }
    }
}
