
public class ConvertIntToNum{
    public static void main(String args[]){
        //int[] arr - intialization of an array
        //int[] arr=new int[5] - allocation of specified size
        //push using index
        //to intialize during array declaration -
       
        int[] arr1={67,68,69,70,71};
        int[] arr=new int[]{65,66,67,68,69};
        char ch;
        for(int i=0;i<arr.length;i++){
           ch=(char) arr[i];
           System.out.println(ch);
        }        
    }
}

