package org.yugal;

import java.util.Arrays;

class Solution {


    public static void main(String[] args) {

        int[] numbers = {2, 3, 5, 6};
        int[] numbers2 = {1, 4, 7, 19};
        System.out.println("ans : " + Arrays.toString(merge(numbers, numbers2)));
        //System.out.println("ans : " + stringSearch("please help me i need help and also help her", "help"));
        //System.out.println("hello".substring(0, "hello".length() - 1));
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int[] mergedArr = new int[arr1.length + arr2.length];
        int pointer1 = 0, pointer2 = 0, mergedPointer = 0;
        while (mergedPointer != mergedArr.length - 1) {
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
        if (pointer1 < arr1.length) {
            mergedArr[mergedPointer] = arr1[pointer1];
        } else if (pointer2 < arr2.length) {
            mergedArr[mergedPointer] = arr2[pointer2];
        }
        return mergedArr;
    }

    public static int stringSearch(String inp, String target) {

        int totalCount = 0;
        if (inp.length() < target.length()) return totalCount;

        for (int i = 0; i < inp.length(); i++) {
            if (inp.charAt(i) == target.charAt(0)) {
                for (int j = 1; j < target.length(); j++) {
                    if (!(i + j >= inp.length() - 1) && inp.charAt(i + j) == target.charAt(j) && j == target.length() - 1)
                        totalCount++;
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
