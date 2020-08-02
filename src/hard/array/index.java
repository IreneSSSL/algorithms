package hard.array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class index {

    public static void main(String[] args) {
        LinkedList<List<String>> lists = new LinkedList<>();
        LinkedList<String> a = new LinkedList<>();
        LinkedList<String> b = new LinkedList<>();
        LinkedList<String> c = new LinkedList<>();
        LinkedList<String> d = new LinkedList<>();
        LinkedList<String> e = new LinkedList<>();

        a.add("arrtztkotazhufrsfczr");
        a.add("knzgidixqgtnahamebxf");
        a.add("zibvccaoayyihidztflj");

        b.add("cffiqfviuwjowkppdajm");
        b.add("owqvnrhuzwqohquamvsz");

        c.add("knzgidixqgtnahamebxf");
        c.add("owqvnrhuzwqohquamvsz");
        c.add("qzeqyrgnbplsrgqnplnl");

        d.add("arrtztkotazhufrsfczr");
        d.add("cffiqfviuwjowkppdajm");

        e.add("arrtztkotazhufrsfczr");
        e.add("knzgidixqgtnahamebxf");
        e.add("owqvnrhuzwqohquamvsz");
        e.add("qzeqyrgnbplsrgqnplnl");
        e.add("zibvccaoayyihidztflj");


        lists.add(a);
        lists.add(b);
        lists.add(c);
        lists.add(d);
        lists.add(e);

        new index().peopleIndexes(lists);
    }

    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Integer> result = new LinkedList<Integer>();
        if (favoriteCompanies.size() == 0) {
            return result;
        }
        if (favoriteCompanies.size() == 1) {
            result.add(0);
            return result;
        }

        boolean[] added = new boolean[favoriteCompanies.size()];

        Iterator<List<String>> iter = favoriteCompanies.iterator();
        int i = 0;
        while (iter.hasNext()) {
            List<String> current = iter.next();
            if (added[i]) {
                i++;
                continue;
            }

            Iterator<List<String>> iter2 = favoriteCompanies.iterator();
            int j = 0;
            while (iter2.hasNext()) {
                List<String> checked = iter2.next();
                if (added[j]) {
                    j++;
                    continue;
                }
                if (current.size() == checked.size()) {
                    j++;
                    continue;
                }
                List<String> current_back = new ArrayList<>();
                current_back.addAll(current);
                List<String> check_back = new ArrayList<>();
                check_back.addAll(checked);
                if (current_back.size() < check_back.size()) {
                    current_back.removeAll(check_back);
                    if (current_back.size() == 0) {
                        added[i] = true;
                    }
                } else {
                    check_back.removeAll(current_back);
                    if (check_back.size() == 0) {
                        added[j] = true;
                    }
                }
                j++;

            }
            i++;

        }
        for (int j = 0; j < favoriteCompanies.size(); j++) {
            if (!added[j]) result.add(j);
        }
        return result;
    }



}
