/**
    Find the Town Judge
    -------------------
    In a town, there are N people labelled from 1 to N.  
    There is a rumor that one of these people is secretly the town judge.

    If the town judge exists, then:
        The town judge trusts nobody.
        Everybody (except for the town judge) trusts the town judge.
        There is exactly one person that satisfies properties 1 and 2.
        You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

    If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.

    Example 1:
        Input: N = 2, trust = [[1,2]]
        Output: 2

    Example 2:
        Input: N = 3, trust = [[1,3],[2,3]]
        Output: 3

    Example 3:
        Input: N = 3, trust = [[1,3],[2,3],[3,1]]
        Output: -1

    Example 4:
        Input: N = 3, trust = [[1,2],[2,3]]
        Output: -1

    Example 5:
        Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
        Output: 3
            
    Note:
        1 <= N <= 1000
        trust.length <= 10000
        trust[i] are all different
        trust[i][0] != trust[i][1]
        1 <= trust[i][0], trust[i][1] <= N
 */
 class FindTheTownJudgeSolution {
    public int findJudge(int N, int[][] trust) {
        if (N < 1 || N > 1000)
            return -1;
        if (trust.length == 0)
            return 1;
        if (trust.length > 10000)
            return -1;
        
        int[] arr = new int[N+1];
        
        // for each iteration of trust[i]
        for (int i = 0; i < trust.length; i++) {
            int a = trust[i][0];
            int b = trust[i][1];
            // check if trust[i, 0] && trust[i, 1] is between N range 
            if (a < 1 || a > N || b < 1 || b > N)
                return -1;
            // check if trust[i][1] in arr is 0 and increment by 1
            // take trust[i][0] and assign to -1 in arr
            arr[b] = arr[b] != -1 ? arr[b] + 1 : 0;
            arr[a] = -1;
        }
        // iterate over arr and find index where value == N and return
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == N-1)
                return i;
        }        
        return -1;
    }
}