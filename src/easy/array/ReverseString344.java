package easy.array;

public class ReverseString344 {
    public void reverseString(char[] s) {
        if (s == null || s.length == 1){
            return;
        }
        int head = 0;
        int tail = s.length-1;
        while(head < tail){
            char tmp = s[head];
            s[head] = s[tail];
            s[tail] = tmp;
            head++;
            tail --;
        }
        return;
    }

    public static void main(String[] args) {
        char[] s = { 'h','e','l','l','o'};
        System.out.println(-18/10);
        Math.pow(2,32);
    }

//    two pointers at head and tail, super easy.
}
