// https://leetcode.com/problems/accounts-merge

class Solution {
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        HashMap<String, Integer> emailToId = new HashMap<>();
        HashMap<String, String> emailToName = new HashMap<>();
        
        UnionFind unionFind = new UnionFind();
        int n = 0;
        for(List<String> account: accounts) {
            String name = "";
            for(int j = 0; j < account.size(); j++) {
                if(j == 0) {
                    name = account.get(j);
                    continue;
                }
                if(emailToId.get(account.get(j)) == null) {
                    emailToId.put(account.get(j), n++);  
                }
                emailToName.put(account.get(j), name);
                
                int x = emailToId.get(account.get(1));
                int y = emailToId.get(account.get(j));
                unionFind.makeUnion(x, y);
            }
        }
        
        Map<Integer, List<String>> ans = new HashMap<>();
        
        for(String email: emailToId.keySet()) {
            int groupId = unionFind.getParent(emailToId.get(email));
            List<String> cur = ans.getOrDefault(groupId, new ArrayList<>());
            cur.add(email);
            ans.put(groupId, cur);
        }
        
        List<List<String>> response = new ArrayList<>();
        
        for(List<String> emails: ans.values()) {
            Collections.sort(emails);
            emails.add(0, emailToName.get(emails.get(0)));
            response.add(emails);
        }
        return response;
    }
    
    class UnionFind {
        int par[];
        int n = 10000;
        UnionFind() {
            this.par = new int[n];
            init();
        }
        
        void init() {
            for(int i = 0; i < n; i++) {
                par[i] = i;
            }
        }
        
        void makeUnion(int x, int y) {
            int xP = getParent(x);
            int yP = getParent(y);
            par[xP] = yP;
        }
        
        int getParent(int i) {
            if(i == par[i]) {
                return i;
            }
            return par[i] = getParent(par[i]);
        }
    }
}
