// Approach 1 Best 

class Solution {
    public int[] plusOne(int[] digits) {
        
        for(int i = digits.length - 1; i >= 0; i--) {

            // If digit is less than 9, just add 1 and return
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            // If digit is 9, make it 0 (carry forward)
            digits[i] = 0;
        }

        // If all digits were 9 (like 999 -> 1000)
        int[] result = new int[digits.length + 1];
       
        result[0] = 1;
        return result;

    }
}

// Approach 2 

/*
class Solution {
    public int[] plusOne(int[] digits) {
        
        boolean isOverflow = false;
        int n = digits.length;

        for(int i = n - 1; i >= 0; i--) {
            if(digits[i] == 9) {
                isOverflow = true;
                digits[i] = 0;
            }
            else{
                isOverflow = false;
                digits[i] += 1;
                break;
            }
        }

        if(isOverflow) {
            int[] result = new int[n + 1]; 
            result[0] = 1;
            for(int i = 1; i < n + 1; i++) {
                result[i] = digits[i - 1];
            }
            

            return result;
        }

        return digits;
    }
}
*/