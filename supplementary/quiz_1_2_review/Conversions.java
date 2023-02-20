class Conversions
{
	public static void main(String[] args)
	{
		int decimal_124	= 124; 			//100 (1) + 10 (2) + 1  (4)
		int binary_124	= 0b1111100; 	// 64 (1) + 32 (1) + 16 (1) + 8 (1) + 4 (1) + 2 (0) + 1 (0)
		int octal_124	= 0174; 		// 64 (1) + 8  (7) + 1  (4)
		int hex_124		= 0x7C; 		//  16(7) + 1 (C)

		System.out.println("decimal: " + decimal_124);
		System.out.println("binary:  " + binary_124);
		System.out.println("octal:   " + octal_124);
		System.out.println("hex:     " + hex_124);
	}
}