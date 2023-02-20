import java.util.Random;
import java.util.Arrays;

class ItemCounter
{
	static final int FLOOR_COUNT = 4;
	static final int ROOM_COUNT = 23;
	static final int BOX_COUNT = 17;

	//Fill the building such that each box has no more than 20 items inside.
	public static void main(String[] args)
	{
		//PART A
 		int[][][] item_counts = new int[FLOOR_COUNT][ROOM_COUNT][BOX_COUNT];

 		//NOTE:
		//int num_items = item_counts[i][j][k]; 
		//item_counts[i][j][k] represents how many items are on the ith floor, in the jth room, within the kth box

		Random generator = new Random(1000);
		final int upperBound = 20;

		for(int f = 0; f < FLOOR_COUNT; ++f)
		{
			for(int r = 0; r < ROOM_COUNT; ++ r)
			{
				for(int b = 0; b < BOX_COUNT; ++ b)
				{
					item_counts[f][r][b] = generator.nextInt(upperBound) + 1; // 1 .. 20
				}
			}
		}

		//PART B
		System.out.println("Number of Floors:    " + item_counts.length);
		System.out.println("Rooms on each floor: " + item_counts[0].length);
		System.out.println("Boxes in each room:  " + item_counts[0][0].length);
		System.out.println("Total Boxes:         " + FLOOR_COUNT * ROOM_COUNT * BOX_COUNT);

		System.out.println("Building items: ");

		for(int f = 0; f < FLOOR_COUNT; ++f)
		{
			System.out.println("========= FLOOR " + f + "=========");
			for(int r = 0; r < ROOM_COUNT; ++ r)
			{
				for(int b = 0; b < BOX_COUNT; ++ b)
				{
					System.out.print(item_counts[f][r][b]);

					if(b != BOX_COUNT - 1) System.out.print(", ");
				}

				System.out.println();
			}
			System.out.println("==================================\n");
		}

		System.out.println("Items on each floor: " + Arrays.toString(itemsOnEachFloor(item_counts)));

		for(int f = 0; f < FLOOR_COUNT; ++f)
		{
			System.out.println("Floor " + f + " room counts :" + Arrays.toString(itemsInEachRoomOfGivenFloor(item_counts, f)));
		}

		System.out.println("Total items: " + totalItems(item_counts));

		double average = (totalItems(item_counts) * 1.0) / (FLOOR_COUNT * ROOM_COUNT * BOX_COUNT);
		System.out.println("Average number of items in each box: " + average);

		jagged_example();
	}

	//NOTE:
	//int num_items = item_counts[i][j][k]; 
	//item_counts[i][j][k] represents how many items are on the ith floor, in the jth room, within the kth box

	//Part C
	static int[] itemsOnEachFloor(int[][][] item_counts)
	{
		int[] floor_counts = new int[FLOOR_COUNT];

		for(int f = 0; f < FLOOR_COUNT; ++f)
		{
			for(int r = 0; r < ROOM_COUNT; ++ r)
			{
				for(int b = 0; b < BOX_COUNT; ++ b)
				{
					floor_counts[f] += item_counts[f][r][b];
				}
			}
		}

		return floor_counts;
	}

	//Part D
	static int[] itemsInEachRoomOfGivenFloor(int[][][] item_counts, int floor_idx)
	{
		int[] room_counts = new int[ROOM_COUNT];

		for(int r = 0; r < ROOM_COUNT; ++r)
		{
			for(int b = 0; b < BOX_COUNT; ++b)
			{
				room_counts[r] += item_counts[floor_idx][r][b];
			}
		}

		return room_counts;
	}

	//Part E
	static int totalItems(int[][][] item_counts)
	{
		int total = 0;

		for(int f = 0; f < FLOOR_COUNT; ++f)
		{
			for(int r = 0; r < ROOM_COUNT; ++ r)
			{
				for(int b = 0; b < BOX_COUNT; ++ b)
				{
					total += item_counts[f][r][b];
				}
			}
		}

		return total;
	}

	//Part F
	static void jagged_example()
	{
		int[][] jagged = new int[3][];

		jagged[0] = new int[10];
		jagged[1] = new int[20];
		jagged[2] = new int[30];

		int count = 0;
		for(int i = 0; i < 3; ++i)
		{
			System.out.println("Num elements in jagged[" + i + "] = " + jagged[i].length);
			count += jagged[i].length;
		}

		System.out.println("Num elements: " + count);
	}
}