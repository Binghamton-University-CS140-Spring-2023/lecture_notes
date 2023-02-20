import java.nio.ByteBuffer;
import java.util.Arrays;

class Datum_Packet
{
	public int     a;					//4 bytes
	public double  b;					//8 bytes
	public float   c;					//4 bytes
	public short   hop_count;			//2 bytes
	public char    domain_identifier;	//2 bytes

	@Override
	public String toString()
	{
		return 	"a:                 " + a + "\n" +
				"b:                 " + b + "\n" +
				"c:                 " + c + "\n" +
				"hop_count:         " + hop_count + "\n" +
				"domain_identifier: " + domain_identifier; 
	}

	@Override
	public boolean equals(Object other)
	{
		if(other == this)
		{
			return true;
		}
		if(!(other instanceof Datum_Packet))
		{
			return false;
		}

		Datum_Packet o = (Datum_Packet) other;

		return 	this.a == o.a && 
				this.b == o.b &&
				this.c == o.c &&
				this.hop_count == o.hop_count &&
				this.domain_identifier == o.domain_identifier;
	}

}

class DataConverter
{
	//Part A
	static final int byte_len = 22; 

	//Part B
	static byte[] encrpyt_to_send(Datum_Packet packet)
	{
		byte[] byte_arr = new byte[byte_len];

		ByteBuffer bb = ByteBuffer.wrap(byte_arr);

		bb.putInt(packet.a);
		bb.putDouble(packet.b);
		bb.putFloat(packet.c);
		bb.putShort(packet.hop_count);
		bb.putChar(packet.domain_identifier);

		return byte_arr;
	}

	//Part C
	static Datum_Packet decrypt_received(byte[] byte_arr)
	{
		Datum_Packet packet = new Datum_Packet();

		ByteBuffer bb = ByteBuffer.wrap(byte_arr);

		packet.a = bb.getInt();
		packet.b = bb.getDouble();
		packet.c = bb.getFloat();
		packet.hop_count = bb.getShort();
		packet.domain_identifier = bb.getChar();

		return packet;
	}

	public static void main(String[] args)
	{
		Datum_Packet dp = new Datum_Packet();

		dp.a = 1;
		dp.b = 2.0;
		dp.c = 3.0f;
		dp.hop_count = 4;
		dp.domain_identifier = 'g';

		System.out.println("Starting datum packet: \n" + dp);

		//Encyption to send
		byte[] byte_arr = encrpyt_to_send(dp);
		System.out.println("\nEncrypted byte array: " + Arrays.toString(byte_arr));

		//Decryption upon receival
		Datum_Packet other = decrypt_received(byte_arr);
		System.out.println("\nDecrpyted datum packet: \n" + other);

		System.out.println("\nConversion results in equality: " + dp.equals(other));
	}
}