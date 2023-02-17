class Solution {
    int n = 0, m = 0;
    int maxArea = Integer.MIN_VALUE;
    int[][] visited;


    public int maxAreaOfIsland(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], -1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                findArea(grid, i, j);
            }
        }
        return (maxArea == Integer.MIN_VALUE) ? 0 : maxArea;
    }

    private int findArea(int[][] grid, int x, int y) {
        //Base Cases
        if (x < 0 || y < 0) { // Boundary Condition - Left Side
            return 0;
        }

        if (x >= n || y >= m) { // Boundary Condition - Right Side
            return 0;
        }

        if (grid[x][y] == 0) { // If Water - So not valid
            return 0;
        }

        if (visited[x][y] != -1) {
            return 0;
        }

        //Otherwise - Mark it visited, go to the left, right,top,bottom
        visited[x][y] = 1; //Visited
        int area = 1;

        //Left
        area += findArea(grid, x, y - 1);

        //Right
        area += findArea(grid, x, y + 1);

        //Top
        area += findArea(grid, x - 1, y);

        //Bottom
        area += findArea(grid, x + 1, y);

        maxArea = Math.max(area, maxArea);
        return area;
    }
}