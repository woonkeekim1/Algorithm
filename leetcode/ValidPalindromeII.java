public class ValidPalindromeII {
  public static void main(String[] args) {
      ValidPalindromeII sol = new ValidPalindromeII();
      System.out.println("Expected: true Result: " + sol.validPalindrome("aba"));
      System.out.println("Expected: true Result: " + sol.validPalindrome("abca"));
      System.out.println("Expected: false Result: " + sol.validPalindrome("abcda"));
  }

  public boolean validPalindrome(String s) {
    return validPalindrome(s, 0, s.length() - 1, false);
  }

  public boolean validPalindrome(String s, int from, int to, boolean deleted) {
    if(from >= to) {
      return true;
    }
    while(from < to) {
      if(s.charAt(from) != s.charAt(to)) {
        if(deleted) {
          return false;
        } else {
          return validPalindrome(s, from + 1, to, true) | validPalindrome(s, from, to-1, true);
        }
      }
      from++;
      to--;
    }
    return true;
  }
}
