package medium.dp;

import java.util.LinkedList;
import java.util.List;

public class WordBreak139 {
// 这个题，涉及到顿悟的dp新思路，可能内容较多，为了方便回顾，必须用中文了。
//    我们过去用的dp，通常是f(n)和之前的一个，最多是两个或者三个历史记录有关。
//    比如昨天做的题，一个堆形空间，（元素都int，代表从顶点走到这里的每一步的cost）从顶层跑到底层，怎么跑最省力。
//    这就意味着你不能单纯的记录从0到n-1层最省力的唯一记录。因为可能从0到n-1的最省力路径，不是从0到n的最省力路径
//    而是要记录从0到第n-1层每个节点的最低耗费，然后再计算已知0到n-1每个节点的最低耗费已定，那从0到n-1到n各个节点的最低耗费数组。

//    这个题也是类似，但是难点在于，怎么去定义f(n)
//    考虑到目标是问这个s能不能被拼成，那么就dp[n]就定义为substring（即s.substring(0,n+1) ）能不能被拼成。
//    第二个难点来了
//    dp[n]不是简单直接的和dp[n-1]或者dp[n-2]有关，而是可能和前面不知道“多少位”有关系，这个“多少位”和当前拿来检测的wordDict的element长度有关
//    所以要考虑几种情况
//    如果element能贴在substring尾巴上，并且substring去掉element之后，还是可以被segment组成起来，那么加上element自然也可以
//    如果element能贴在substring尾巴上，但是substring去掉element之后，不可以被segment组成起来了，说明中间出现了断层，那么加上element自然也不可以
//    如果element等于substring，那自然可以
//    如果element长度比substring还长，说啥都不可以

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        for(int i = 0;i< dp.length;i++){
            String current = s.substring(0, i+1);
            for(String seg : wordDict){
                if (current.endsWith(seg)){
                    if ( i- seg.length() == -1 || i- seg.length() > -1 && (dp[i- seg.length()])){
                        dp[i] = true;
                        break;
                    }

                }
            }
        }
        return dp[s.length()-1];
    }

    public static void main(String[] args) {
        String s = "catsandog";
        List<String> a = new LinkedList<>();
        a.add("ca");
        a.add("dog");
        a.add("ts");
        a.add("sand");
        a.add("and");
        new WordBreak139().wordBreak(s,a);
    }

}
