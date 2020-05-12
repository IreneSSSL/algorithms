package medium.dfs;

public class FriendCircles547 {
    public int findCircleNum(int[][] M) {
        if(M.length<1) return 0;
        if(M.length == 1) return 1;

        int[] visited = new int[M.length];
        int group=0;
        for(int i=0;i<M.length;i++){
//            如果第i个人已经被标记过，说明这个人之前属于过某个圈子了，那它的朋友也都属于之前那个圈子，没有必要在检查一遍
            if(visited[i]==0){
                group++;
                findCircle(M,i,visited);
            }
        }
        return group;
    }


    // 从i开始，看和谁是朋友，并且这个朋友之前没有被标记过
    public void findCircle(int[][] M, int i, int[] visited){
        visited[i] = 1;
        for(int j=0;j<M.length;j++){
            if(M[i][j] == 0 || visited[j]==1) continue;
            // 如果i和j是朋友，并且j没有被标记过，那么可以接下去看谁是j的朋友，一并标记了，都是一个圈子的
            findCircle(M,j,visited);
        }
    }
}
