// https://leetcode.com/problems/integer-to-english-words/

class Solution {
    
    private static final int BILLION = (int)1e9;
    private static final int MILLION = (int)1e6;
    private static final int THOUSAND = (int)1e3;
    
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
        
        if(num >= BILLION) {
            String t = covertThreeDigitOrLess(num / BILLION) + " Billion";
            if(num % BILLION == 0) return t;
            return  t + " " + numberToWords(num % BILLION);
        }
        
        if(num >= MILLION) {
            String t = covertThreeDigitOrLess(num / MILLION) + " Million";
            if(num % MILLION == 0) return t;
            return  t + " " + numberToWords(num % MILLION);
        }
        
        if(num >= THOUSAND) {
            String t = covertThreeDigitOrLess(num / THOUSAND) + " Thousand";
            if(num % THOUSAND == 0) return t;
            return  t + " " + numberToWords(num % THOUSAND);
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
