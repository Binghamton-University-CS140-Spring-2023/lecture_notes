public class Primitives3 
{
  public static void main(String[] args) 
  {
    int intValue = Integer.parseInt(args[0]);
    Integer intgrValue = Integer.valueOf(intValue);
    Integer intgrValue1 = Integer.valueOf(args[0]);

    System.out.println("intValue = " + intValue);
    System.out.println("intgrValue.toString() = " + intgrValue.toString());
    System.out.println("intgrValue1.toString() = " + intgrValue1.toString());
    System.out.println("intgrValue.intValue() = " + intgrValue.intValue());
    System.out.println("intgrValue1.intValue() = " + intgrValue1.intValue());
    System.out.println("Integer.toHexString(intValue) = " + Integer.toHexString(intValue));
    System.out.println("Integer.toOctalString(intValue) = " + Integer.toOctalString(intValue));
    System.out.println("Integer.toBinaryString(intValue) = " + Integer.toBinaryString(intValue));
  }
}