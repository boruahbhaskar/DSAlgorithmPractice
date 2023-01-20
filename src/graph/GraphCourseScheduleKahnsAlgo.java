package graph;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GraphCourseScheduleKahnsAlgo {

    public int[] findOrders(int numCourses, int[][] preRequisites){

        int[] inDegree = new int[numCourses];

        for(int[] preQ:preRequisites ){
            inDegree[preQ[0]]++;
        }

        Set<Integer> zeroDegree = new HashSet<>();

        for(int i = 0 ; i < numCourses; i++){

            if(inDegree[i] == 0)
                zeroDegree.add(i);

        }

        if(zeroDegree.isEmpty()){
            return new int[]{}; // return false;
        }

        int[] courseOrder = new int[numCourses];
        int i = 0;

        while(!zeroDegree.isEmpty()){

            Iterator<Integer> it = zeroDegree.iterator();

            int course = it.next();

            courseOrder[i++] = course;

            zeroDegree.remove(course);

            for(int[] pre : preRequisites){

                if(course == inDegree[pre[1]]){

                    inDegree[pre[0]]--;

                    if(inDegree[pre[0]] == 0){
                        zeroDegree.add(pre[0]);
                    }

                }

            }


        }

        for(int n: inDegree){

            if (n != 0)
                return new int[]{}; //false
        }

        return courseOrder; //True


    }

    public static void main(String[] args) {

          GraphCourseScheduleKahnsAlgo gr = new GraphCourseScheduleKahnsAlgo();
          int numCourse = 4;
          int[][] preRequisite = {{1,0},{2,0},{3,1},{3,2}};


          System.out.println(gr.findOrders(numCourse,preRequisite).length);

    }
}
