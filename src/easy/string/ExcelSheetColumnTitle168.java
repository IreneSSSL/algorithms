package easy.string;

import java.util.LinkedList;
import java.util.List;

public class ExcelSheetColumnTitle168 {

    public static void main(String[] args) {
        new ExcelSheetColumnTitle168().convertToTitle(701);
    }
    public String convertToTitle(int n) {
        List<Integer> list1 = new LinkedList<>();
        StringBuilder b = new StringBuilder("");
        while(n>26){
            int s = n%26;
            if ( s== 0){
                s = 26;
            }
            n = (n-s)/26;
            list1.add(s);
        }
        list1.add(n);
        for (int i=list1.size()-1;i>=0;i--){
            int s = list1.get(i) -1;
            char c =(char) ('A' + s);
            b.append(c);
        }
        return b.toString();
    }

}
