import java.util.*;
public class HeyIAlradyDidThat {
  public static void main(String[] args) {
    System.out.println("Expected: 1 " + answer("1211", 10));
    System.out.println("Expected: 3 " + answer("210022", 3));

  }
  public static int answer(String n, int b) {

        // Your code goes here.
        int length = n.length();
        int[] intValue = new int[length];
        for(int i = 0; i < length; i++) {
            intValue[i] = n.charAt(i) - '0';
        }
        Map<String, Integer> map = new HashMap<>();
        String key = convertToString(intValue);
        int count = 0;
        while(!map.containsKey(key)) {
            System.out.println(key);
            map.put(key, count);
            count++;
            int[] x = sort(intValue, false);
            int[] y = sort(intValue, true);
            subtract(x, y, b);
            intValue = x;
            key = convertToString(x);
        }
        System.out.println(key);
        return count - map.get(key);
    }
    public static String convertToString(int[] list) {
        StringBuilder sb = new StringBuilder();
        for(int value : list) {
            sb.append(value);
        }
        return sb.toString();
    }

    public static int[] sort(int[] input, boolean ascending) {
        int[] bucket = new int[10];
        int length = input.length;
        for(int index = 0; index < length; index++) {
            bucket[input[index]]++;
        }
        if(ascending) {
            return bucketAscending(bucket, length);
        }
        return bucketDescending(bucket, length);
    }

    public static int[] bucketAscending(int[] bucket, int length) {
        int[] res = new int[length];
        int index = 0;
        for(int i = 0; i < 10; i++) {
            for(int count = 0; count < bucket[i]; count++) {
                res[index++] = i;
            }
        }
        return res;
    }

    public static int[] bucketDescending(int[] bucket, int length) {
        int[] res = new int[length];
        int index = 0;
        for(int i = 9; i >= 0; i--) {
            for(int count = 0; count < bucket[i]; count++) {
                res[index++] = i;
            }
        }
        return res;
    }

    public static void subtract(int[] a, int[] b, int base) {
        int length = a.length;
        for(int index = a.length - 1; index >= 0; index--) {
            if(a[index] < b[index]) {
                a[index-1] = a[index-1] - 1;
                a[index] = base + a[index] - b[index];
            } else {
                a[index] = a[index] - b[index];
            }
        }
    }
}
