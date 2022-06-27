//do it again
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]!=color) {
            floodFillHelper(image, sr, sc, image[sr][sc], color);
        }
        return image;
    }
    
    public void floodFillHelper(int[][] image, int row, int col, int startingColor, int newColor) {
        if(image[row][col]!=newColor) {
            image[row][col]=newColor;
            if(row+1<image.length && image[row+1][col]==startingColor) {
                floodFillHelper(image, row+1, col, startingColor, newColor);
            }
            if(col+1<image[0].length && image[row][col+1]==startingColor) {
                floodFillHelper(image, row, col+1, startingColor, newColor);
            }
            if(row-1>=0 && image[row-1][col]==startingColor) {
                floodFillHelper(image, row-1, col, startingColor, newColor);
            }
            if(col-1>=0 && image[row][col-1]==startingColor) {
                floodFillHelper(image, row, col-1, startingColor, newColor);
            }
        }
        return;
    }
}