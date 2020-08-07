package medium.dp;

public class UniqueSubStringInWraparoundString467 {
    public int findSubstringInWraproundString(String p) {
        if(p.length() == 0) return 0;

        char[] seq = p.toCharArray();
        int len = seq.length;
        int[] dic = new int[len];
        int[] map = new int[26];
        map[seq[0]-'a']= 1;
        dic[0] = 1;
        for(int i=1;i<len;i++){
            dic[i] = 1;
            if( seq[i]-seq[i-1] == 1 || seq[i]-seq[i-1]==-25 ){
                dic[i] += dic[i-1];
            }

            if ( map[seq[i]-'a'] < dic[i] ) map[seq[i]-'a']= dic[i];
        }
        int count = 0;
        for(Integer key: map){
            count+= key;
        }



        return count;
    }
}
