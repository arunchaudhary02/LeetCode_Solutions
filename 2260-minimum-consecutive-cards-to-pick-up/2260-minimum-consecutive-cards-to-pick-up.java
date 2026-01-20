class Solution {
    public int minimumCardPickup(int[] cards) {
        
        Map<Integer, Integer> lastIndex = new HashMap<>();
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < cards.length; i++) {
            int card = cards[i];

            if (lastIndex.containsKey(card)) {
                // calculate length of subarray between two same cards
                minLen = Math.min(minLen, i - lastIndex.get(card) + 1);
            }

            lastIndex.put(card, i); // update last index
        }

        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}