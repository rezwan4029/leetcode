class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        if(n == 0) {
            return true;
        }
        if(len == 1) {
            if(flowerbed[0] == 0) return n <= 1 ? true : false;
            return false;
        }
        
        if(len == 2) {
            if(flowerbed[0] == 0 && flowerbed[1] == 0) {
                return n <= 1 ? true : false;
            }
            return false;
        }
       
        
        for(int i = 0; i < len; i++) {
            if(n == 0) return true;
            if(flowerbed[i] == 1) continue;
            
            // left most position
            if(i == 0 && i + 1 < len && flowerbed[i+1] == 0) {
                flowerbed[i] = 1;
                n--;
                continue;
            }
            
            // right most position
            if(i == len - 1 && flowerbed[i-1] == 0) {
                flowerbed[i] = 1;
                n--;
                continue;
            }
            
            // anywhere in middle
            if(i - 1 >= 0 && i + 1 < len && flowerbed[i-1] == 0 && flowerbed[i+1] == 0) {
                flowerbed[i] = 1;
                n--;
                continue;
            }
        }
        
        return (n == 0) ? true: false;
    }
}
