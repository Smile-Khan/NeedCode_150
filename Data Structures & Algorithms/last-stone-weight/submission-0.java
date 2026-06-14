class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int stone : stones)
        {
            pq.offer(stone);
        }

        while(pq.size() > 1)
        {
            int num1 = pq.poll();
            int num2 = pq.poll();

            int diff = num1 - num2;
            if(diff > 0)
            {
                pq.offer(diff);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
