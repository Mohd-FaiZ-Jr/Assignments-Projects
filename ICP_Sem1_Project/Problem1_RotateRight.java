public class Problem1_RotateRight {
    public static void rotateRightBy2Bits(int s[]){

        System.out.println("\n------Original array showing 32 bits binary-------");
        String [] a = new String[4];
        for(int j=0;j<=3;j++){
            String result = Integer.toBinaryString( s[j]);
            result = String.format("%32s", result).replaceAll(" ", "0");  // 32-bit Integer
            System.out.print(result+" ");
            a[j] = result.substring(30);
        }

    
        int updateArr [] = new int[4];
        String storeVal [] = new String[4];
        for(int i=0;i<=3;i++){
            int rightShift = s[i]>>2;
            updateArr[i] = rightShift;
            String resultx = Integer.toBinaryString( updateArr[i]);
            resultx = String.format("%32s", resultx).replaceAll(" ", "0");  // 32-bit Integer
            storeVal[i] = resultx;
        }

        storeVal[0] = a[3]+(storeVal[0].substring(2));
        storeVal[1] = a[0]+(storeVal[1].substring(2));
        storeVal[2] = a[1]+(storeVal[2].substring(2));
        storeVal[3] = a[2]+(storeVal[3].substring(2));

        System.out.println("\n---After rotation array showing 32 bits binary---");
        for(int n=0;n<=3;n++){
            System.out.print(storeVal[n]+" ");
        }

        System.out.println("\n----------------After rotation array-----------------");
        for(int k=0;k<=3;k++){
            long num = Long.parseLong(storeVal[k],2);
            int n = (int) num;
            System.out.print(n+" ");
        }
    }
    public static void main(String[] args) {
        int [] arr = new int[4];
        arr[0] = 10;arr[1] = 11;arr[2] = 12;arr[3] = 13;
        System.out.println("---------------------Original Array---------------------");
        System.out.print(arr[0]+" "+arr[1]+" "+arr[2]+" "+arr[3]);
        rotateRightBy2Bits(arr);
    }
}
