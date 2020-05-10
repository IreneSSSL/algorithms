package easy.greedy;

public class PlaceFlowers605 {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed.length == 0) return false;
        int cnt = 0;
        for(int i=0;i< flowerbed.length && cnt<n;i++){
            if (flowerbed[i] == 1) continue;

            int pre = i==0?0:flowerbed[i-1];
            int next = i== flowerbed.length-1?0:flowerbed[i+1];
            if (pre==0 && next==0){
                cnt++;
                flowerbed[i] =1;
            }
        }
        return cnt == n;
    }
}
