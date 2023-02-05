public class ByteBufferSampleCode {
	// program to store a double and an int in a byte array using a ByteBuffer
	// then read the values back and see that the values were properly
	// stored and retrieved
	// copy the byte array to a new byte array, and retrieve the double and int
	// that were stored in the original byte array and see that they are once
	// again retieved from a copy of the byte array (wants to simulate saving the
	// first byte array to a file, and then reading it into the second byte array)
	public static void main(String[] args) {
		if(args.length != 2) {
			System.out.println("format is: ByteBufferSampleCode \"double value\" \"int value\"");
			System.exit(0);
		}
		// allocate two byte arrays to hold the binary data
		// byteArray is the byte array that we store the values in
		// byteArrayB wants to simulate a byte array that we read the content of byteArray
		// into after storing it in a file
		byte[] byteArray = new byte[12];
		byte[] byteArrayB = new byte[12];

		// output the initial values of the byte array
		System.out.println("initial byteArray = ");
		for( int i = 0; i < byteArray.length; i++ ) {
			System.out.println("byteArray[" + i + "] = " + byteArray[i]);
		}
		System.out.println();

		// create a ByteBuffer that is wrapped around byteArray
		java.nio.ByteBuffer byteBuffer = java.nio.ByteBuffer.wrap(byteArray);

		// convert the first commandline argument to a double
		double doubleValue = Double.parseDouble(args[0]);

		// convert the second commandline argument to an int
		int intValue = Integer.parseInt(args[1]);

		// print out the two values, this is mainly incase the double can't be represented correctly
		// and to compare to what we retrieve from the two byteArrays
		System.out.println("doubleValue = " + doubleValue);
		System.out.println("intValue = " + intValue);
		System.out.println();

		// store the double in byteArray starting at index 0 (uses bytes 0 - 7)
		// using the absolute put method
		byteBuffer.putDouble(0, doubleValue);

		// store the int in byteArray starting at index 8 (uses bytes 8 - 11)
		// using the absolute put method
		byteBuffer.putInt(8, intValue);

		// output the updated values of the byte array
		// we should see bytes 0 - 7 are completly different than they originally were
		// some of bytes 8 - 11 may still be 0, depending on how large of an int we entered
		System.out.println("filled in byteArray = ");
		for(int i = 0; i < byteArray.length; i++) {
			System.out.println("byteArray[" + i + "] = " + byteArray[i]);
		}
		System.out.println();

		// use the relative getDouble() to read the double value from byteArray 0 - 7
		double doubleValue2 = byteBuffer.position(0).getDouble();

		// use the absolute getDouble() to read the double value from byteArray 0 - 7
		double doubleValue3 = byteBuffer.getDouble(0);

		// use the relative getInt() to read the int value from byteArray 8 - 11
		int intValue2 = byteBuffer.position(8).getInt();

		// use the absolute getInt() to read the int value from byteArray 8 - 11
		int intValue3 = byteBuffer.getInt(8);

		System.out.println("the double and int values read back from byteArray");

		// print out the value read using relative getDouble()
		System.out.println("doubleValue2 = " + doubleValue2);

		// print out the value read using absolute getDouble()
		System.out.println("doubleValue3 = " + doubleValue3);

		// print out the value read using relative getInt()
		System.out.println("intValue2 = " + intValue2);

		// print out the value read using absolute getInt()
		System.out.println("intValue3 = " + intValue3);

		System.out.println();

		// copy byteArray into byteArrayB (simulates storing byteArray and
		// then reading it into byteArrayB
		for( int i = 0; i < byteArray.length; i++ ) {
			byteArrayB[i] = byteArray[i];
		}

		// create a ByteBuffer that is wrapped around byteArrayB
		java.nio.ByteBuffer byteBufferB = java.nio.ByteBuffer.wrap(byteArrayB);

		// use the relative and absolute versions of getDouble() to
		// get the double value from byteArrayB 0 - 7
		double doubleValue2B = byteBufferB.position(0).getDouble();
		double doubleValue3B = byteBufferB.getDouble(0);

		// use the relative and absolute versions of getInt() to
		// get the int value from byteArrayB 8 - 11
		int intValue2B = byteBufferB.position(8).getInt();
		int intValue3B = byteBufferB.getInt(8);

		System.out.println("the double and int values read from byteArrayB");

		// output the double values so that we see that they are the same
		System.out.println("doubleValue2B = " + doubleValue2B);
		System.out.println("doubleValue3B = " + doubleValue3B);

		// output the int values so that we see that they are the same
		System.out.println("intValue2B = " + intValue2B);
		System.out.println("intValue3B = " + intValue3B);
	}
}