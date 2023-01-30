public class Flow1 {
  public static void main(String[] args) {		
    int testValue = Integer.parseInt(args[0]);
    switch(testValue) {
    case 1:
      System.out.println("case with testValue is 1");
      System.out.println("here's a second line");
    case 2:
      System.out.println("case with testValue is 2");
    case 3:
      System.out.println("case with testValue is 3");
      System.out.println("here's a second line");
      System.out.println("here's a third line");
    default:
      System.out.println("default case");
    }
  }
}