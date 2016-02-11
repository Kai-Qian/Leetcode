/*
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Ensure that numbers within the set are sorted in ascending order.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]
*/
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(k > 9 || k < 1) {
            return new ArrayList<List<Integer>>();
        } 
        //因为k个数字不能重复，所以会有这些限制
        int[] min = {1 ,3 ,6 ,10 ,15 ,21 ,28 ,36 ,45};
        int[] max = {9, 17, 24, 30, 35, 39, 42, 44, 45};
        if(n > max[k - 1] || n < min[k - 1]) {
            return new ArrayList<List<Integer>>();
        }
        ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();
        ArrayList<Integer> cur = new ArrayList<Integer>();
        int sum = 0;
        int level = 1;
        dfs(ans, cur, k, n, sum, level);
        return ans;
    }
    //这里的dfs写法值得注意，很好
    public void dfs(ArrayList<List<Integer>> ans, ArrayList<Integer> cur, int k, int n, int sum, int level) {
        if(sum == n && k == 0) {
            ans.add(new ArrayList<Integer>(cur));//注意要new一下
            return;
        } else if(sum > n || k < 0) {
            return;
        }
        //因为不像树有左右结点（要写两个dfs递归），所以这里用for循环来遍历各个结点（实际有多个dfs递归）
        for(int i = level; i <= 9; i++) {
            cur.add(i);
            dfs(ans, cur, k - 1, n, sum + i, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(k > 9 || k < 1) {
            return new ArrayList<List<Integer>>();
        } 
        //因为k个数字不能重复，所以会有这些限制
        int[] min = {1 ,3 ,6 ,10 ,15 ,21 ,28 ,36 ,45};
        int[] max = {9, 17, 24, 30, 35, 39, 42, 44, 45};
        if(n > max[k - 1] || n < min[k - 1]) {
            return new ArrayList<List<Integer>>();
        }
        ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();
        ArrayList<Integer> cur = new ArrayList<Integer>();
        int sum = 0;
        int level = 1;
        dfs(ans, cur, k, n, sum, level);
        return ans;
    }
    //这里的dfs写法值得注意，很好
    public void dfs(ArrayList<List<Integer>> ans, ArrayList<Integer> cur, int k, int n, int sum, int level) {
        if(sum == n && k == 0) {
            ans.add(new ArrayList<Integer>(cur));//注意要new一下
            return;
        } else if(sum > n || k < 0) {
            return;
        }
        for(int i = level; i <= 9; i++) {
            cur.add(i);
            dfs(ans, cur, k - 1, n, sum + i, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}

bfs
public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int size1 = grid.length;
        int size2 = grid[0].length;
        int ans = 0;
        Queue<Pair> queue = new LinkedList<Pair>();
        for(int i = 0; i < size1; i++) {
             for(int j = 0; j < size2; j++) {
                 if(grid[i][j] != '1') {
                    continue;
                } else {
                    ans++;
                    Pair pair = new Pair(i, j);
                    queue.offer(pair);
                    grid[pair.getX()][pair.getY()] = '2';
                    while(!queue.isEmpty()) {
                        Pair p = queue.poll();
                        //不能在这里赋值，不然会重复放到队列里，如[[1,1,1,0],[1,1,0,0],[0,0,1,0],[0,0,0,0]]这种情况时，会把(1, 1)这个位置的元素放到队列里两次
                        if(p.getX() - 1 >= 0 && grid[p.getX() - 1][p.getY()] == '1') {
                            queue.offer(new Pair(p.getX() - 1, p.getY()));
                            grid[p.getX() - 1][p.getY()] = '2';//一定要先赋值，不能后赋值
                        }
                        if(p.getX() + 1 < size1 && grid[p.getX() + 1][p.getY()] == '1') {
                            queue.offer(new Pair(p.getX() + 1, p.getY()));
                            grid[p.getX() + 1][p.getY()] = '2';
                        }
                        if(p.getY() - 1 >= 0 && grid[p.getX()][p.getY() - 1] == '1') {
                            queue.offer(new Pair(p.getX(), p.getY() - 1));
                            grid[p.getX()][p.getY() - 1] = '2';
                        }
                        if(p.getY() + 1 < size2 && grid[p.getX()][p.getY() + 1] == '1') {
                            queue.offer(new Pair(p.getX(), p.getY() + 1));
                            grid[p.getX()][p.getY() + 1] = '2';
                        }
                    }
                }
             }
        }
        return ans;
    }
    class Pair {
        private int x;
        private int y;
        public Pair(int a, int b) {
            x = a;
            y = b;
        }
        public void setX(int a) {
            this.x = a;
        }
        public void setY(int b) {
            this.y = b;
        }
        public int getX() {
            return x;
        }
        public int getY() {
            return y;
        }
    }