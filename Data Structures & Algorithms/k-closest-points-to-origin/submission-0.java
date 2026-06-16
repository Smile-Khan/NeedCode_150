
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Max-heap sorted by squared distance in descending order
        // (b's distance - a's distance) makes it a max-heap
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare((b[0] * b[0] + b[1] * b[1]), (a[0] * a[0] + a[1] * a[1]))
        );
        
        for (int[] point : points) {
            maxHeap.offer(point);
            // If the heap grows larger than k, remove the farthest point
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        
        // Gather the k closest points from the heap into the result array
        int[][] result = new int[k][2];
        while (k > 0) {
            result[--k] = maxHeap.poll();
        }
        
        return result;
    }
}