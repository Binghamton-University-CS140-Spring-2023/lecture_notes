import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;
public class TestTreesAndDeque1 {
    public static void main(String[] args) {
        double[] ref = {115, 120, 122, 118, 117, 16, 120, 118, 122, 14, 11, 110, 10,
                119, 12, 112, 13, 115, 17, 16, 115, 15, 124, 18, 15, 17,
                23, 17, 23, 1, 18, 23, 13, 17, 22, 6,
                123, 117, 123, 11, 118, 123, 113, 117, 122, 16,
                115, 111, 15, 122, 16, 123, 19, 13, 15, 119, 110, 10, 14, 18,
                15, 11, 5, 22, 6, 23, 9, 3, 5, 19, 10, 0, 4, 8,
                15, 20, 22, 18, 17, 6, 20, 18, 22, 4, 1, 10, 0,
                19, 2, 12, 3, 15, 7, 6, 15, 5, 24, 8, 5, 7};
        double[] reverse = new double[ref.length];
        for(int i = 0; i < ref.length; i++) reverse[i] = ref[ref.length - i - 1];

        HashSet<Double> hashSet = new HashSet<>();
        TreeSet<Double> treeSet = new TreeSet<>();
        ArrayDeque<Double> queue = new ArrayDeque<>();
        ArrayDeque<Double> stack = new ArrayDeque<>();

        System.out.println("input");
        System.out.println(Arrays.toString(ref));
        System.out.println("reverse");
        System.out.println(Arrays.toString(reverse));

        for(int i = 0; i < ref.length; i++) {
            hashSet.add(ref[i]);
            treeSet.add(ref[i]);
            queue.add(ref[i]);
            stack.add(ref[i]);
        }

        // output the HashSet
        System.out.println("HashSet");
        for(Double v : hashSet) {
            System.out.print(v + " ");
        }
        System.out.println();

        // output the TreeSet
        System.out.println("TreeSet");
        for(Double v : treeSet) {
            System.out.print(v + " ");
        }
        System.out.println();

        // output the ArrayDeque as a queue (FIFO)
        System.out.println("ArrayDeque as queue");
        while(queue.size() > 0) {
            Double v = queue.pollFirst();
            System.out.print(v + " ");
        }
        System.out.println();

        // output the ArrayDeque as a stack (LIFO)
        System.out.println("ArrayDeque as stack");
        while(stack.size() > 0) {
            Double v = stack.pollLast();
            System.out.print(v + " ");
        }
        System.out.println();
    }
}
