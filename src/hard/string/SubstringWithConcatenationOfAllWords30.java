package hard.string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords30 {


    public static void main(String[] args) {

        String s ="wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};
        new SubstringWithConcatenationOfAllWords30().findSubstring(s,words);
    }
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new LinkedList<>();
        if(s==null || words.length == 0){ return res; }
        if (s.length() == 0) return res;
        if (s.length()< words.length * words[0].length()) return res;

        HashMap<String, Integer> store = new HashMap<>();
        int target = 0;

        for (int i=0;i<words.length;i++){
            if (store.get(words[i]) ==null) store.put(words[i],1);
            else store.put(words[i], store.get(words[i])+1);
        }

        int len = words[0].length();

        List<Integer> re = new LinkedList<>();
        Map<String,Integer> current = new HashMap<>();

        int times = 0;
        for (int i = 0;i <= s.length()-len;i++){
            String sample = s.substring(i, i+len);
            if ( store.keySet().contains(sample) ){
                re.add(i);
                i += sample.length()-1;
                int count = current.getOrDefault(sample, 0) +1;
                times++;
                int or =store.get(sample);
                if ( count> or ){
                    i = re.get(0);
                    re.clear();
                    current.clear();
                    times=0;
                } else if ( count == or && times == words.length){
                    i = re.get(0);
                    res.add( i );
                    current.clear();
                    re.clear();
                    times=0;
                } else {
                    current.put(sample, count);
                }
            } else if(re.size()!=0) {
                i = re.get(0);
                current.clear();
                re.clear();
                times=0;
            }
        }
        return res;
    }

}
