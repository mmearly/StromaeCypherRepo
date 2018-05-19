/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stromaecypher;

/**
 *
 * @author Matthew
 */
public class StromaeCypher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //decode("TZUSXPHWTLFCBTJMFNIWTZARZIGRUXFKUUTWITKTXLBBZDDILMPBYPXXXLTQNDGPHHNCTSSCLQJZRNGYUYGFKT", "stanford");
        System.out.println();
        encode("wowthisisasecretmessage","key");
    }
    
    //INPUT MUST BE LOWERCASE OUTPUT WILL BE UPPERCASE
    public static void decode(String in, String key){
        in = in.toLowerCase();
        System.out.println(in);
        int[] initNums = charToInt(in);
        printArray(initNums);
        int[] offset = getOff(key, in.length());
        printArray(offset);
        int[] sum = subMatrices(initNums, offset);
        printArray(sum);
        for(int c=0; c<sum.length; c++){
            int get = sum[c];
            int replace = mod26(get);
            sum[c] = replace;
        }
        printArray(sum);
        intToChar(sum);
    }
    
        //INPUT MUST BE LOWERCASE OUTPUT WILL BE UPPERCASE
    public static String encode(String in, String key){
        System.out.println(in);
        int[] initNums = charToInt(in);
        printArray(initNums);
        int[] offset = getOff(key, in.length());
        printArray(offset);
        int[] sum = addMatrices(initNums, offset);
        printArray(sum);
        for(int c=0; c<sum.length; c++){
            int get = sum[c];
            int replace = mod26(get);
            sum[c] = replace;
        }
        printArray(sum);
        String fin = intToChar(sum);
        return fin;
    }
    
    public static int mod26(int in){
        if(in>26){
            while(in>26){
                in=in-26;
            }
            return in;
        }
        else if (in<1){
            while(in<1){
                in=in+26;
            }
            return in;
        }
        else{
            return in;
        }
    }
    
    public static int[] charToInt(String l){
        int[] ans = new int[l.length()];
        for(int c=0; c<l.length(); c++){
            int temp = (int)l.charAt(c);
            int temp_int = 96;
            ans[c]=temp-temp_int;
        }
        return ans;
    }
    
    public static int[] getOff(String key, int length){
        String off="";
        for(int c=0; c<length; c++){
            off = ""+off+key.charAt(c%key.length());
        }
        int[] numOff = charToInt(off);
        return numOff;
    }
    
    public static int[] subMatrices(int[] a, int[] b){
        int[] ans = new int[a.length];
        for(int c=0; c<a.length; c++){
            ans[c] = a[c]-b[c];
        }
        return ans;
    }
    
    public static int[] addMatrices(int[] a, int[] b){
        int[] ans = new int[a.length];
        for(int c=0; c<a.length; c++){
            ans[c] = a[c]+b[c];
        }
        return ans;
    }
    
    public static String intToChar(int[] in){
        String ans = "";
        for(int c=0; c<in.length; c++){
            char let = (char)(in[c]+64);
            ans+=let;
        }
        System.out.println(ans);
        return ans;
    }
    
    public static void printArray(int[] o){
        for(int c=0; c<o.length; c++){
            System.out.print(o[c]+" ");
        }
        System.out.println();
    }
    
    public static void printArray(String[] o){
        for(int c=0; c<o.length; c++){
            System.out.print(o[c]+" ");
        }
        System.out.println();
    }
}
