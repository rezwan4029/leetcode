// https://leetcode.com/problems/integer-to-english-words/

class Solution {
    
    Map<Integer, String> V = new HashMap<>();
    
    Solution() {
        V.put(0, "Zero");
        V.put(1, "One");
        V.put(2, "Two");
        V.put(3, "Three");
        V.put(4, "Four");
        V.put(5, "Five");
        V.put(6, "Six");
        V.put(7, "Seven");
        V.put(8, "Eight");
        V.put(9, "Nine");
        V.put(10, "Ten");
        V.put(11, "Eleven");
        V.put(12, "Twelve");
        V.put(13, "Thirteen");
        V.put(14, "Fourteen");
        V.put(15, "Fifteen");
        V.put(16, "Sixteen");
        V.put(17, "Seventeen");
        V.put(18, "Eighteen");
        V.put(19, "Nineteen");
        V.put(20, "Twenty");
        V.put(30, "Thirty");
        V.put(40, "Forty");
        V.put(50, "Fifty");
        V.put(60, "Sixty");
        V.put(70, "Seventy");
        V.put(80, "Eighty");
        V.put(90, "Ninety");
    }
    
    public String numberToWords(int num) {
        
        if(num >= 1000000000) {
            String t = V.get(num/1000000000) + " Billion";
            if(num % 1000000000 == 0) {
                return t;
            }
            return  t + " " + numberToWords(num % 1000000000);
        }
        
        if(num >= 1000000) {
            String t = V.get(num/1000000);
            if(t == null) {
                t = covertThreeDigitOrLess(num/1000000);
            }
            t += " Million";
            if(num % 1000000 == 0) return t;
            return  t + " " + numberToWords(num % 1000000);
        }
        
        if(num >= 1000) {
            String t = V.get(num/1000);
            if(t == null) {
                t = covertThreeDigitOrLess(num/1000);
            }
            t += " Thousand";
            if(num % 1000 == 0) return t;
            return  t + " " + numberToWords(num % 1000);
        }
        
        return covertThreeDigitOrLess(num);
    }
    
    String covertThreeDigitOrLess(int num) {
        
        if(num >= 100) {
            String t = V.get(num/100);
            t += " Hundred";
            if(num % 100 == 0) {
                return t;
            }
            return t + " " + covertThreeDigitOrLess(num % 100);
        }
        
        if(num >= 10 && !V.containsKey(num)) {
            int x = (String.valueOf(num).charAt(0) - '0') * 10;
            int y = (String.valueOf(num).charAt(1) - '0');
            return V.get(x) + " " + V.get(y);
        }
        return V.get(num);
    }
}
