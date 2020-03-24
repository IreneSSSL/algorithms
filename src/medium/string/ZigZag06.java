package medium.string;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class ZigZag06 {
    public static void main(String[] args) {
        new ZigZag06().convert2("PAYPAL", 10);
    }
    public String convert(String s, int numRows) {
        if (s == null || s.trim().equals("") || numRows ==1){
            return s;
        }
        int row = numRows;
        int column = 0;
        if(s.length() % (2*row-2) == 0 ){
            column =  s.length() / (2*row-2) *(row-1) ;
        } else {
            if (s.length()%(2*row-2) <=row){
                column =  s.length() / (2*row-2)*(row-1) +1;
            } else {
                column =  s.length() / (2*row-2) * (row-1) +1 + s.length() % (2*row-2) - row;
            }
        }
        char[][] re = new char[row][column];
        System.out.println(re[0][0]);
        for (int i=0;i< s.length();i++){
            int iter = i/(2*row -2);
            if ( i- iter*(2*row -2) <row ){
                re[ i- iter*(2*row -2)][ iter * (row-1) ] = s.charAt(i);
            } else {
                System.out.println(2*row-2 -i + iter*(2*row -2));
                System.out.println(iter * (row-1) + row-1 -(2*row-2 -i + iter*(2*row -2)) );
                re[ 2*row-2 -i + iter*(2*row -2)][iter * (row-1) + row-1 -(2*row-2 -i + iter*(2*row -2)) ]= s.charAt(i);
            }
        }
        StringBuilder str = new StringBuilder("");
        char t = 0;
        for (int i=0;i<row;i++){
            System.out.println();
            for(int j=0;j<column;j++){
                System.out.print(re[i][j] );
                if (re[i][j] !=  t ){
                    str.append(re[i][j]);
                }
            }
        }
        System.out.println();
        System.out.println(str.toString() );
        return str.toString();

    }



//    this way is much faster, since it doesnt build a char array
//    the key point of this algorithm is figuring out the partern, the whole new 'thing' consists of n triangles and a rest partly-triangle. like this shape ‘ |/ ’
//    if I try to read from the top line to the bottom line
//    it is kind of like reading the the first triangle in ith line, then the second triangle in ith line.... the last one in ith line; line by line
//    each triangle has the same shape
//    so the index could be replaced with (iteration * (2row-2) + i ( i means the ith char in a single triangle )
//    for instance, for the first triangel (iteration 0), ith and (2row-2-i)th at the same line
//    then for the s+1 triangle(iteration s), (2row-2)*s +i, (2row-2)*s +(2row-2-i) are at the same line with above two char.
    public String convert2(String s, int numRows) {
        if (s == null || s.trim().equals("") || numRows ==1){
            return s;
        }
        int iter = s.length()/(2*numRows-2);
        StringBuilder str = new StringBuilder("");
        for(int i=0;i< numRows;i++){
            if (i == 0 || i == numRows-1){

                for(int j=0;j<=iter;j++ ) {
                    if ( (2*numRows-2)*j + i >=s.length() ){
                        continue;
                    }
                    str.append( s.charAt((2*numRows-2)*j + i));
                }
            } else {
                for(int j=0;j<=iter;j++ ) {
                    if ((2*numRows-2)*j + i <s.length() ){
                        str.append( s.charAt((2*numRows-2)*j + i));

                    }
                    if ((2*numRows-2)*j + 2*numRows-2 -i < s.length()){
                        str.append( s.charAt((2*numRows-2)*j + 2*numRows-2 -i));
                    }

                }
            }
        }
        System.out.println(str.toString() );
        return str.toString();
    }

}
