class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        
        for (int i = 0; i < accounts.length; i++) {
            int currentCustomerWealth = 0;
            
            for (int j = 0; j < accounts[i].length; j++) {
                currentCustomerWealth += accounts[i][j];
            }
            if (currentCustomerWealth > maxWealth) {
                maxWealth = currentCustomerWealth;
            }
        }  
        return maxWealth;
    }
}
