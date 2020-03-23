package easy.string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BuzzFizz412 {


//    so brute and no other tricky method, but to check whether it can be divide by 3 and 5 with no remainder
//    this method is a litter slower, but more flexible when the constraints are expanded to more integers.
    public List<String> fizzBuzz(int n) {
        if(n<=0){
            return null;
        }
        Map<Integer, String> map= new HashMap<Integer, String>();
        map.put(3,"Fizz");
        map.put(5,"Buzz");
        List<String> result = new LinkedList<String>();
        for (int i=1;i<=n;i++){
            String str = "";
            for(Integer num: map.keySet()){
                if(i % num == 0){
                    str+=map.get(num);
                }
            }
            if (str.equals("")){
                str = String.valueOf(i);
            }
            result.add(str);
        }
        return result;

    }
}
