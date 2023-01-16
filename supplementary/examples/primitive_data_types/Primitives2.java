public class Primitives2 
{
  public static void main(String[] args) 
  {
    long intgrDec = 10_000_100;
    long intgrHex = 0x98_96_e4;
    long intgrOct = 0676_56_304;
    long intgrBin = 0b10011000_10010110_11100100;
    float floatDec = 10_000_100.00f; // f or F is required
    double doubleDec = 10_000_100.00;

    System.out.println("intgrDec = " + intgrDec);
    System.out.println("intgrHex = " + intgrHex);
    System.out.println("intgrOct = " + intgrOct);
    System.out.println("intgrBin = " + intgrBin);
    System.out.println("floatDec = " + floatDec);
    System.out.printf("floatDec = %.4f\n", floatDec);
    System.out.println("doubleDec = " + doubleDec);
    System.out.printf("doubleDec = %.1f\n", doubleDec);
  }
}