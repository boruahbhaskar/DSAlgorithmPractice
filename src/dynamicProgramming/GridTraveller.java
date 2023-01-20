package dynamicProgramming;

import java.util.HashMap;

public class GridTraveller {

    // m * n grid

    // Time O(row*column) || Space O(row + column)
    private HashMap<String,Long> map = new HashMap<>();

    public long possibleRoutes(int row, int column){
        String key = row+","+column;
        if(map.containsKey(key))
            return map.get(key);

        if(row == 1 && column == 1)
            return 1;
        else if(row == 0 || column == 0)
            return 0;
        else{
            long routes = possibleRoutes(row -1,column) + possibleRoutes(row,column-1);
            map.put(key,routes);
            return routes;
        }

    }

    public static void main(String[] args) {
        GridTraveller gd = new GridTraveller();
        System.out.println(" Possible Grid travles from top left to bottom right position for 3 by 3 grid is "+gd.possibleRoutes(18,18));
    }
}
