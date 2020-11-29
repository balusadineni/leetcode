class Solution {
    public int tribonacci(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 1;
        
        int[] tris = new int[n+1];
        
        tris[0] = 0;
        tris[1] = 1;
        tris[2] = 1;
        
        if(n > 2) {
            for(int i = 3; i <= n; i++) {
                tris[i] = tris[i-1] + tris[i-2] + tris[i-3];
            }
        }
        
        return tris[n];
    }
}
