package easy.array;

public class YanghuiTriangle118 {

    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0){
            return new  ArrayList<List<Integer>>();
        }
        List<List<Integer>> result = new  ArrayList<List<Integer>>();
        List<Integer> last = new ArrayList<Integer>();
        last.add(1);
        result.add(last);
        for(int i=1; i< numRows;i++){
            List<Integer> currentList =  new ArrayList<Integer>();
            currentList.add(1);
            for (int j=1;j< i;j++){
                currentList.add( last.get(j)+last.get(j-1));
            }
            currentList.add(1);
            last = currentList;
            result.add(currentList);
        }
        return result;
    }
}
