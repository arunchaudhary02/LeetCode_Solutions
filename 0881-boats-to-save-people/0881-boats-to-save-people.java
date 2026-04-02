class Solution {
    public int numRescueBoats(int[] people, int limit) {
        
        Arrays.sort(people);
        int L = 0, R = people.length - 1;
        int countBoat = 0;

        while (L <= R) {
            if (people[L] + people[R] <= limit) {
                L++; // send the lighter person
            }
            R--; // send the heavier person
            countBoat++; // one boat used
        }

        return countBoat;
    }
}