class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backtrack(candidates, target, 0, current, result);

        return result;
    }
    private void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result)
    {
        // Base case : Found a valid combination
        if(target == 0)
        {
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = start; i < candidates.length; i++)
        {
            // Skip duplicates
            if(i > start && candidates[i] == candidates[i-1]) continue;


            // If current number > target, break (since array is sorted)
            if(candidates[i] > target) break;

            // Choose : add current number
            current.add(candidates[i]);

            // Explore: recursively find combinations
            backtrack(candidates, target - candidates[i], i + 1, current, result);

            // Unchoose: remove current number
            current.remove(current.size() - 1);
        }
    }
}
