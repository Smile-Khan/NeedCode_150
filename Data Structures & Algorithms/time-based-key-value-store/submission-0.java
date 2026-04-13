class TimeMap {

    // Map : Key -> list of (timestamp, value) pairs
    private Map<String, List<Pair>> map;

    class Pair{
        int timestamp;
        String value;

        Pair(int timestamp, String value)
        {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";

        List<Pair> list = map.get(key);

        // Binary search to find the largest timestamp <= given timestamp

        int left = 0;
        int right = list.size() - 1;
        int result = -1;

        while(left <= right)
        {
            int mid = left + (right - left) / 2;
            
            if(list.get(mid).timestamp <= timestamp)
            {
                result = mid;
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }
        return result == -1 ? "" : list.get(result).value;
    }
}
