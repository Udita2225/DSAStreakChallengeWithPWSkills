import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Day5KthSmallestElement {
    static void main() {
//      Method 1
//      Sort the array and pick the k-th element.
//      Time Complexity: O(n log n)
//      Space Complexity: O(1)
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;

        Arrays.sort(arr);
        System.out.println(arr[k - 1]); // kth smallest

//      Method 2
//      Insert all elements into a min heap and remove k times.
//      Time Complexity: O(n + k log n)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : arr) {
            pq.add(num);
        }

        for (int i = 0; i < k - 1; i++) {
            pq.poll();
        }

        System.out.println(pq.peek());

//      Method 3
//      Maintain a max heap of size k.
//      Time Complexity: O(n log k)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : arr) {
            maxHeap.add(num);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        System.out.println(maxHeap.peek());

    }
}
