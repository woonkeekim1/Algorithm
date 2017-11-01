import java.util.*;
//number station codede Messages
public class NumberStationCodedMessages {

  public static void main(String[] args) {
    System.out.println("Expected: [2,3]" + Arrays.toString(answer(new int[]{4,3,10,2,8}, 12)));
    System.out.println("Expected: [-1, -1]" + Arrays.toString(answer(new int[]{1,2,3,4}, 15)));

    System.out.println("Expected: [4, 4]" + Arrays.toString(answer(new int[]{4,1,10,2,9}, 9)));
  }
  public static int[] answer(int[] l, int t) {
        // Your code goes here.
        int from = 0;
        int to = 0;
        int sum = 0;
        while(to < l.length) {
            if(sum + l[to] == t) {
                return new int[]{from, to};
            } else if(sum + l[to] > t) {
                sum -= l[from];
                from++;
            } else {
                sum += l[to];
                to++;
            }
        }
        return new int[]{-1, -1};
    }
}
