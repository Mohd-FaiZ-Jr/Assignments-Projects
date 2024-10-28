import java.util.Scanner;

public class Problem2_ConvertToAnyBase {
    public static String convertToAnyBase(int n,int b){
        switch (b){
            case 2:
                String store2 = "";
                while(n>0){
                    int remain = n%b;
                    store2 = remain+store2;
                    n = n/2;
                }
                return store2;
            case 8:
                String store8 = "";
                while(n>0){
                    int remain = n%b;
                    store8 = remain+store8;
                    n = n/8;
                }
                return store8;
            case 16:
                String store16 = "";
                while(n>0){
                    int remain = n%b;
                    String var = "";
                    boolean check = false;
                    if(remain>=10){
                        var = String.valueOf(remain);
                        switch (var){
                            case "10":
                                var = "A";
                                check = true;
                                break;
                            case "11":
                                var = "B";
                                check = true;
                                break;
                            case "12":
                                var = "C";
                                check = true;
                                break;
                            case "13":
                                var = "D";
                                check = true;
                                break;
                            case "14":
                                var = "E";
                                check = true;
                                break;
                            case "15":
                                var = "F";
                                check = true;
                                break;
                        }

                    }
                    if(check==true) store16 = var+store16;
                    else store16 = remain+store16;
                    n = n/16;
                }
                return store16;
            default: return "Invalid type convertion";
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter decimal integer: ");
        int x = sc.nextInt();
        System.out.print("Enter base value:");
        int y = sc.nextInt();
        String result = convertToAnyBase(x,y);
        if(y==2) System.out.println("The binary value of "+x+" is: "+result);
        else if(y==8) System.out.println("The octal value of "+x+" is: "+result);
        else if(y==16) System.out.println("The hexadecimal value of "+x+" is: "+result);


    }
}
