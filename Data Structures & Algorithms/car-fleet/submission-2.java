class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] cars = new double[n][2];

        for(int i = 0; i < n; i++)
        {
            cars[i][0] = position[i];
            // Store the time required to reach the target
            cars[i][1] = (double)(target - position[i]) / speed[i];
        }

        // Sort cars by position in descending order(closest to target first)
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        int fleets = 0;
        double lastTime = 0;

        for(int i = 0; i < n; i++)
        {
            // If the current car takes more time than the fleet ahead, it forms a new fleet
            if(cars[i][1] > lastTime)
            {
                fleets++;
                lastTime = cars[i][1];
            }
        }
        return fleets;
    }
}
