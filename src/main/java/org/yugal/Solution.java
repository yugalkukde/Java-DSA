package org.yugal;

import java.util.Arrays;

class Solution {


    public static void main(String[] args) {

        long startMillisTime = System.currentTimeMillis();

        int[] numbersIncrements = {2, 3, 5, 6, 8};
        int[] numbersIncrements2 = {1, 4, 7, 19};
        int[] numbersIncrements3 = {1, 2, 3, 4, 5, 7, 9, 65, 78, 79, 89, 90, 91, 92, 93, 100};
        int[] numbersNotSortedWithNegative = {-3, 4, 0, -2, 6, -1};
        int[] numbersNotSorted = {45, 55, 34, 678, 89, 9, 1, 5, 23, 456};
        int[] numbersNotSorted2 = {1, 34, 9};
        //System.out.println("ans : " + Arrays.toString(merge(numbers, numbers2)));
        //System.out.println("ans : " + mostDigitCount(numbersNotSorted));
        //System.out.println("hello".substring(0, "hello".length() - 1));
        //System.out.println(binarySearch(numbersArray, 79));
        //System.out.println(countUniqueValues(numbersArray1));
        System.out.println("ans : " + Arrays.toString(radixSort(numbersNotSorted)));
        //System.out.println(pivotHelper(numbersArray3));
        //System.out.println(Arrays.toString(insertionSort(Arrays.stream(numbersArray2).boxed().collect(Collectors.toList()))));

        long endMillisTime = System.currentTimeMillis();

        long durationMillis = endMillisTime - startMillisTime;
        double durationMillisInSec = (double) durationMillis / 1000.0;
        System.out.println("Execution time in milliseconds: " + durationMillis);
        System.out.println("Execution time in seconds: " + durationMillisInSec);
    }

    public static int[] radixSort(int[] arr) {
        for (int i = 0; i < mostDigitCount(arr); i++) {
            int[][] bucket = new int[10][arr.length];
            for (int j = 0; j < arr.length; j++) {
                int currentDigit = getDigit(arr[j], i), tempCounter = 0;
                while (bucket[currentDigit][tempCounter] > 0) {
                    tempCounter++;
                }
                bucket[currentDigit][tempCounter] = arr[j];
            }
            int arrCounter = 0;
            for (int j = 0; j < bucket.length; j++) {
                for (int k = 0; k < bucket[j].length; k++) {
                    if (bucket[j][k] == 0) break;
                    arr[arrCounter] = bucket[j][k];
                    arrCounter++;
                }
            }
        }
        return arr;
    }

    public static int getDigit(int number, int index) {
        /*String temp = String.valueOf(number);
        int result = -1, counter = 0;
        for (int i = temp.length() - 1; i >= 0; i--) {
            if (index == counter) {
                result = Integer.parseInt(String.valueOf(temp.charAt(i)));
                break;
            }
            counter++;
        }
        return result;*/
        return (int) Math.floor(Math.abs(number) / Math.pow(10, index)) % 10;
    }

    public static int countDigit(int number) {
        return String.valueOf(number).length();
    }

    public static int mostDigitCount(int[] arr) {
        int currentBiggest = 0;
        for (int i : arr) {
            currentBiggest = Math.max(currentBiggest, countDigit(i));
        }
        return currentBiggest;
    }

    public static int[] quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int swapIndex = pivotHelper(arr, start, end);
            quickSort(arr, start + 0, swapIndex - 1);
            quickSort(arr, swapIndex + 1, end + 0);
        }
        return arr;
    }

    public static int pivotHelper(int[] arr, int start, int end) {
        int swapIndex = start, pivot = arr[start];
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] < pivot) {
                swapIndex++;
                swap(arr, swapIndex, i);
            }
        }
        swap(arr, start, swapIndex);
        return swapIndex;
    }

    public static int[] quickSort(int[] arr) {
        int start = 0, end = arr.length - 1;
        return quickSort(arr, start, end);
    }

   /* public static int pivotHelper(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        return pivotHelper(arr, start, end);
    }*/

    public static int[] mergeSort(int[] arr) {

        if (arr.length <= 1) return arr;
        int mid = (int) Math.floor(arr.length / 2);
        int[] leftArr = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] rightArr = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(leftArr, rightArr);
        // return arr;
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int[] mergedArr = new int[arr1.length + arr2.length];
        int pointer1 = 0, pointer2 = 0, mergedPointer = 0;
        while (mergedPointer != mergedArr.length) {
            if (pointer1 < arr1.length && pointer2 < arr2.length) {
                if (arr1[pointer1] < arr2[pointer2]) {
                    mergedArr[mergedPointer] = arr1[pointer1];
                    pointer1++;
                } else if (arr1[pointer1] > arr2[pointer2]) {
                    mergedArr[mergedPointer] = arr2[pointer2];
                    pointer2++;
                }
            } else if (pointer1 < arr1.length) {
                mergedArr[mergedPointer] = arr1[pointer1];
                pointer1++;
            } else if (pointer2 < arr2.length) {
                mergedArr[mergedPointer] = arr2[pointer2];
                pointer2++;
            }
            mergedPointer++;
        }
        return mergedArr;
    }

    public static int stringSearch(String inp, String target) {

        int totalCount = 0, targetPointer = 0;
        if (inp.length() < target.length()) return totalCount;

        for (int i = 0; i < inp.length(); i++) {
            if (inp.charAt(i) == target.charAt(targetPointer)) {
                targetPointer++;
                if (targetPointer == target.length() - 1) {
                    totalCount++;
                    targetPointer = 0;
                }
            }
        }
        return totalCount;
    }

    public static boolean palindrome(String str) {
        class ReverseClass {
            public static String reverse(String str) {
                StringBuilder temp = new StringBuilder();
                if (str.length() == 0) return "";
                temp.append(str.charAt(str.length() - 1));
                temp.append(reverse(str.substring(0, str.length() - 1)));
                return temp.toString();
            }
        }
        return str.equals(ReverseClass.reverse(str));
    }

    public static String reverse(String str) {
        StringBuilder temp = new StringBuilder();
        if (str.length() == 0) return "";
        temp.append(str.charAt(str.length() - 1));
        temp.append(reverse(str.substring(0, str.length() - 1)));
        return temp.toString();
    }

    public static int power(int num1, int num2) {
        if (num2 == 1) {
            return num1;
        }
        if (num2 == 0) {
            return 1;
        }
        num2--;
        return num1 * power(num1, num2);
    }

    public static int[] insertionSort(int[] arrInp) {
        for (int i = 1; i < arrInp.length; i++) {
            int curr = arrInp[i], j;
            for (j = i - 1; j >= 0 && arrInp[j] > curr; j--) {
                arrInp[j + 1] = arrInp[j];
            }
            arrInp[j + 1] = curr;
        }

        return arrInp;
    }

    public static int[] selectionSort(int[] arrInp) {
        int currSmallest;
        for (int i = 0; i < arrInp.length; i++) {
            currSmallest = i;
            for (int j = i + 1; j < arrInp.length; j++) {
                if (arrInp[j] < arrInp[currSmallest]) {
                    currSmallest = j;
                }
            }
            if (i != currSmallest) {
                arrInp = swap(arrInp, currSmallest, i);
            }
        }
        return arrInp;
    }

    public static int[] bubbleSort(int[] arrInp) {
        boolean noSwap;
        for (int i = arrInp.length; i > 0; i--) {
            noSwap = true;
            for (int j = 0; j < i - 1; j++) {
                if (arrInp[j] > arrInp[j + 1]) {
                    arrInp = swap(arrInp, j, j + 1);
                    noSwap = false;
                }
            }
            if (noSwap) break;
        }
        return arrInp;
    }

    public static int[] swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        return array;
    }

    public static int maxSubarraySum(int[] arr, int len) {
        if (arr.length == 0 || arr.length < len) return -1;
        int maxCount = 0, temp;
        for (int i = 0; i < len; i++) {
            maxCount += arr[i];
        }
        temp = maxCount;
        for (int j = len; j < arr.length; j++) {
            temp = (temp - arr[j - len]) + arr[j];
            if (temp > maxCount) maxCount = temp;
        }
        return maxCount;
    }

    public static boolean isSubsequence(String st1, String st2) {
        int st1Pointer = 0, st2Pointer;
        StringBuilder st1Copy = new StringBuilder();
        for (st2Pointer = 0; st2Pointer < st2.length(); st2Pointer++) {
            if (st1Pointer == st1.length()) break;
            if (st1.charAt(st1Pointer) == st2.charAt(st2Pointer)) {
                st1Copy.append(st1.charAt(st1Pointer));
                st1Pointer++;
            }
        }
        return st1Copy.length() == st1.length();
    }

    public static boolean averagePair(int[] numsArray, double target) {

        if (numsArray.length < 2) return false;

        int left = 0, right;
        for (right = 1; right < numsArray.length; right++) {
            System.out.println(numsArray[left] + " : " + numsArray[right]);
            System.out.println("Average : " + (double) (numsArray[left] + numsArray[right]) / 2);
            if ((double) (numsArray[left] + numsArray[right]) / 2 == target) return true;
            else left++;
        }

        return false;
    }

    public static boolean areThereDuplicates(String... inp) {
        if (inp.length == 0) return false;
        Arrays.sort(inp);
        int left = 0, right;
        for (right = 1; right < inp.length; right++) {
            if (inp[left].equals(inp[right])) left++;
            else return true;
        }
        return false;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target)
                return mid;
            if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    public static int findFirstPositive(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= 0) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
}
