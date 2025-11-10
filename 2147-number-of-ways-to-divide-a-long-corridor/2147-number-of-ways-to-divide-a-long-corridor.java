class Solution {
    public int numberOfWays(String corridor) {

        int mod = 1000000007;
        
        List<Integer> seatsPositions = new ArrayList<>();

        int countS = 0;
        int totalCountS = 0;

        for(int i = 0; i < corridor.length(); i++) {
            if(corridor.charAt(i) == 'S' && countS == 0) {
                seatsPositions.add(i);
                countS++;
                totalCountS++;
            }
            else if(corridor.charAt(i) == 'S' && countS == 1) {
                seatsPositions.add(i);
                countS = 0;
                totalCountS++;
            }
        }

        if(totalCountS % 2 != 0 || seatsPositions.isEmpty()) {
            return 0;
        }

        long result = 1;

        for(int i = 2; i < seatsPositions.size(); i += 2) {
            int length = seatsPositions.get(i) - seatsPositions.get(i - 1);

            result = (result * length) % mod;
        }

        return (int) result;
    }
}