class Solution {
	// to check whether a number is repeated or not
    public boolean Check(HashMap<Character, Integer> map, int n) {
        
        for(Character m: map.keySet()) {
            if(m != '.') {
                if(map.get(m) > 1) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public boolean isValidSudoku(char[][] matrix) {
         int n = matrix.length;
        
		// for columns and rows
        for(int i=0; i<n; i++) {
            HashMap<Character, Integer> rowMap = new HashMap<>();
            HashMap<Character, Integer> columnMap = new HashMap<>();
            for(int j=0; j<n; j++) {
                rowMap.put(matrix[i][j], rowMap.getOrDefault(matrix[i][j], 0)+1);
                columnMap.put(matrix[j][i], columnMap.getOrDefault(matrix[j][i], 0)+1);
            }
            if(Check(rowMap, n) == false) {
                return false;
            }
             if(Check(columnMap, n) == false) {
                return false;
            }
        }
        
	// for 3x3 block
    for (int i = 0; i < matrix.length; i += 3)
        {           
            for (int j = 0; j < matrix[i].length; j += 3)
            {
                int block = (((i / 3) * 3) + (j / 3));
                char[][] newArray = new char[3][3];
                HashMap<Character, Integer> blockMap = new HashMap<>();
                int newRow = 0;
                for (int k = i; k < (i + 3); k++) {
                    int newColumn = 0;
                    for (int l = j; l < (j + 3); l++)
                    {
                        blockMap.put(matrix[k][l], blockMap.getOrDefault(matrix[k][l], 0)+1);
                    }
                    if(Check(blockMap, n) == false) {
                    return false;
                    }   
                    newRow++;
                }
            }
        }
    
        return true;
    }
}