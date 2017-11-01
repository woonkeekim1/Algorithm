public class AddBinary{
  public static void main(String[] args) {
    AddBinary sol = new AddBinary();
    System.out.println("Expected: 10 Result: " + sol.addBinary("1", "1"));
    System.out.println("Expected: 1101 Result: " + sol.addBinary("111", "110"));
  }

  public String addBinary(String a, String b) {
    StringBuilder sb = new StringBuilder();
    int aIndex = a.length() - 1;
    int bIndex = b.length() - 1;
    int carry = 0;
    while(aIndex >= 0 || bIndex >= 0) {
      int aValue = (aIndex >= 0) ? a.charAt(aIndex) - '0' : 0;
      int bValue = (bIndex >= 0) ? b.charAt(bIndex) - '0' : 0;
      int sum = carry + aValue + bValue;
      sb.insert(0, sum % 2);
      carry = sum / 2;
      aIndex--;
      bIndex--;
    }
    return carry == 1 ? "1" + sb.toString() : sb.toString();
  }
}
