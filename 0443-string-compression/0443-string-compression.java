class Solution {
    public int compress(char[] chars) {
        
        int n = chars.length;

        int i = 0;
        int index = 0;

        while(i < n) {
            char curr = chars[i];
            int count = 0;

            // Find count of duplicates
            while(i < n && curr == chars[i]) {
                i++;
                count++;
            }

            chars[index] = curr;
            index++;

            // Add the count
            if(count > 1) {
                String countStr = Integer.toString(count);
                for(char ch : countStr.toCharArray()) {
                    chars[index] = ch;
                    index++;
                }
            }
        }

        return index;
    }
}