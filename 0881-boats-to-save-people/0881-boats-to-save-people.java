class Solution {
    public int numRescueBoats(int[] people, int limit) {
        
        Arrays.sort(people);

        int L = 0, R = people.length - 1;

        int countBoat = 0;

        while(L <= R) {
            int currentWeight = people[R];
            R--;
            if(R > 0 && currentWeight + people[R] <= limit) {
                currentWeight +=  people[R];
                R--;
            }
            else if(L <= R && currentWeight + people[L] <= limit){
                currentWeight += people[L];
                L++;
            }

            countBoat++;
            
        }

        return countBoat;
    }
}