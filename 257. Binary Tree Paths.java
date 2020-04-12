// https://leetcode.com/problems/binary-tree-paths/

class Solution1 {
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> allPath = new ArrayList<>();
        if(root == null) {
            return allPath;
        }
        dfs(root, "", allPath);
        return allPath;
    }
    
    public void dfs(TreeNode now, String currentPath, List<String> allPath) {
        currentPath += now.val;
        if(now.left == null && now.right == null) {
            allPath.add(currentPath);
            return;
        }
        if(now.left != null) {
            dfs(now.left, currentPath + "->", allPath);
        }
        if(now.right != null) {
            dfs(now.right, currentPath + "->", allPath);
        }
    }
    
}


class Solution2 {
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> allPath = new ArrayList<>();
        if(root == null) {
            return allPath;
        }
        Stack<Path> stk = new Stack<>();
        stk.add(new Path(root, new StringBuilder()));
        while(stk.size() != 0) {
            Path p = stk.pop();
            p.currentPath.append(p.now.val);
            if(p.now.left == null && p.now.right == null) {
                allPath.add(p.currentPath.toString());
            }
            if(p.now.left != null) {
                stk.add(new Path(p.now.left, p.currentPath.append("->")));
            }
            if(p.now.right != null) {
                stk.add(new Path(p.now.right, p.currentPath.append("->")));
            }
        }
        return allPath;
    }
    
    class Path {
        StringBuilder currentPath;
        TreeNode now;
        Path(){}
        Path(TreeNode _now, StringBuilder _path) {
            now = _now;
            currentPath = _path;
        }
    }
    
}
