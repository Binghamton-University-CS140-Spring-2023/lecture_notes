public class Primitives1 
{
  public static void main(String[] args) 
  {
    long longDec = 10;
    long longHex = 0xa;
    long longOct = 012;
    long longBin = 0b00001010;

    int intDec = -10;
    int intHex = -0xa;
    int intOct = -012;
    int intBin = -0b00001010;

    short shortDec = 10;
    short shortHex = 0xa;
    short shortOct = 012;
    short shortBin = 0b00001010;

    byte byteDec = -10;
    byte byteHex = -0xa;
    byte byteOct = -012;
    byte byteBin = -0b00001010;

    System.out.println("longDec = " + longDec);
    System.out.println("longHex = " + longHex);
    System.out.println("longOct = " + longOct);
    System.out.println("longBin = " + longBin);

    System.out.println("intDec = " + intDec);
    System.out.println("intHex = " + intHex);
    System.out.println("intOct = " + intOct);
    System.out.println("intBin = " + intBin);

    System.out.println("shortDec = " + shortDec);
    System.out.println("shortHex = " + shortHex);
    System.out.println("shortOct = " + shortOct);
    System.out.println("shortBin = " + shortBin);

    System.out.println("byteDec = " + byteDec);
    System.out.println("byteHex = " + byteHex);
    System.out.println("byteOct = " + byteOct);
    System.out.println("byteBin = " + byteBin);
  }
}