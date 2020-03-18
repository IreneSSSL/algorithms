package easy.string;

public class isPalindrome125 {
//    good job. one time submission accepted.
//    Points:
//    1 Character.isDigit(); instead of {char}.isDigit()
    public boolean isPalindrome(String s) {
        if (s == null){
            return false;
        }
        s = s.trim();
        if (s.length() <1 ){
            return true;
        }
        int start = 0;
        int end = s.length()-1;
        while (start< end){
            while (start<end && !Character.isDigit(s.charAt(start)) && !Character.isLetter(s.charAt(start))){
                start++;
            }
            while (start<end && !Character.isDigit(s.charAt(end)) && !Character.isLetter(s.charAt(end))){
                end--;
            }
            Character a = Character.toLowerCase(s.charAt(start));
            Character b = Character.toLowerCase(s.charAt(end));
            if(a.equals(b)){
                start++;
                end--;
            }else{
                return false;
            }
        }
        return true;

    }

}
