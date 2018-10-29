/*

Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2
Example 2:

Input: [[7,10],[2,4]]
Output: 1

*/

public static int find(List<List<Integer>>list){
        if (list == null) return 0;


        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0) - o2.get(0);
            }
        });

        for (List<Integer> tempList : list){
            pq.add(tempList);
        }

        List<Integer> list1 = pq.poll();
        List<Integer> list2 = new ArrayList<>();
        int numRooms = 1;
        for (List<Integer> tempList : pq){
            list2 = pq.poll();
            if (list1.get(1) > list2.get(0))
                numRooms++;

            list1 = list2;
        }
        return numRooms;
    }
