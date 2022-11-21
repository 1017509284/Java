package graph.LeetCode0752;

import java.util.*;

/**
 * @author: zhaomeng
 * @Date: 2022/11/5 22:21
 */
// !752. Open the Lock
class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));

        if (deadSet.contains(target)) return -1;
        if (deadSet.contains("0000")) return -1;
        if ("0000".equals(target)) return 0;

        //! BFS
        Queue<String> q = new LinkedList<>();
        q.add("0000");

        Map<String, Integer> visited = new HashMap<>();
        visited.put("0000", 0);
        while (!q.isEmpty()) {
            String curs = q.remove();
            List<String> nexts = new ArrayList<>();
            char[] curarray = curs.toCharArray();
            for (int i = 0; i < 4; i++) {
                char o = curarray[i];
                curarray[i] = Character.forDigit((curarray[i] - '0' + 1) % 10, 10);
                nexts.add(new String(curarray));
                curarray[i] = o;

                curarray[i] = Character.forDigit((curarray[i] - '0' + 9) % 10, 10);
                nexts.add(new String(curarray));
                curarray[i] = o;
            }

            for (String next : nexts) {
                if (!deadSet.contains(next) && !visited.containsKey(next)) {
                    q.add(next);
                    visited.put(next, visited.get(curs) + 1);
                    if (next.equals(target)) {
                        return visited.get(next);
                    }
                }
            }
        }
        return -1;
    }
}