package com.leetcode.leetcode.dfs.graph.courseSchedule2;

import java.util.*;

/**
 * Author: Sajal Gupta
 * Date: 2/11/26 10:03 PM
 */
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {


        Map<Integer, Set<Integer>> coursePreRequisiteMap = new HashMap<>(); // key being course id and value being list of pre requisites
        for(int i = 0; i < numCourses; i++){
            coursePreRequisiteMap.put(i, new HashSet<>());
        }
        Set<Integer> canBeCompleted = new LinkedHashSet<>(); //using linkedHashSet to maintain order
        Set<Integer> cycleDetector = new HashSet<>();

        for(int[] pair : prerequisites){
            int course = pair[0];
            int preReq = pair[1];
            coursePreRequisiteMap.get(course).add(preReq);
        }

        //call dfs on all the courses
        for(int course = 0; course < numCourses; course++){
            if(!dfs(coursePreRequisiteMap, canBeCompleted, cycleDetector, course)){
                return new int[0];
            }
        }

        return canBeCompleted.stream()
                .mapToInt(Integer::intValue)
                .toArray();

    }




    //recursive dfs method
    private boolean dfs(Map<Integer, Set<Integer>> map, Set<Integer> canBeCompleted, Set<Integer> cycleDetector, int courseNum){
        //base case
        if(canBeCompleted.contains(courseNum)){
            return true;
        }
        if(cycleDetector.contains(courseNum)){
            return false; //cycle detected, same course twice
        }
        cycleDetector.add(courseNum);
        //loop through pre reqs
        for(int preReq : map.get(courseNum)){
            if (!dfs(map, canBeCompleted, cycleDetector, preReq)){
                return false;
            }
        }

        cycleDetector.remove(courseNum);
        canBeCompleted.add(courseNum);
        return true;
    }
}