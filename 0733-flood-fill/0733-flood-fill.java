class Solution {
    int currentColor = 0;
    int m = 0;
    int n = 0;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        currentColor = image[sr][sc];
        m = image.length;
        n = image[0].length;

        if (currentColor == color) return image;
        
        fill(image, sr, sc, color);
        return image;
    }

    private void fill(int[][] image, int x, int y, int color) {
        //Base Case

        if (x < 0 || y < 0) {
            return;
        }

        if (x == m || y == n) {
            return;
        }

        if (image[x][y] != currentColor) {
            return;
        }

        image[x][y] = color;

        //Top
        fill(image, x - 1, y, color);

        //Left
        fill(image, x, y - 1, color);

        //Right
        fill(image, x, y + 1, color);

        //Bottom
        fill(image, x + 1, y, color);
    }
}