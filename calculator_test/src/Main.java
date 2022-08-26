import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static Boolean isRomul = false;
    public static void main(String[] args) {
        String input="";
        Boolean check=false;
        try {
            input = getInput();
            check = validate(input);
        }catch (Exception e){
            System.err.printf(e.getMessage());
        }
        String[] arr;
        if(check){

            arr = stringToArr(input);
            String out = calculate(arr,input);
            if(isRomul){
                try {
                    System.out.printf(input+"="+romulOut(out));
                }catch (Exception e){
                    System.err.printf(e.toString());
                }
            }else{
                System.out.printf(input+"="+out);
            }
        }

    }
    public static String getInput() throws Exception{

        System.out.print("Insert expression: ");
        String input = scan.next();
        if(input.length()>6){
            throw new Exception("Ti vvel chto-to ne to");
        }
        return input;
    }
    public static Boolean validate (String str)throws Exception{
        if(!(str.contains("+")||str.contains("-")||str.contains("*")||str.contains("/"))){
            throw new Exception("Tyt chto-to ne to");
        }
        String romulStr = "I II III IV V VI VII VIII IX X";
        String[] output = str.split("[+-/*]",2);

        Boolean check = false;
        for (String it:output) {

            if(!(romulStr.contains(it)&&(romulStr.contains(output[0])|romulStr.contains(output[1])))) {
                try {
                    int num = Integer.parseInt(it);
                    if(num<10&&num>0){
                        check = true;
                        isRomul = false;
                    }

                    else throw new NumberFormatException();
                } catch (NumberFormatException e) {
                    System.err.println("Hmm, ne to");
                }
            } else if (romulStr.contains(it)) {
                check=true;
                isRomul = true;
            }else{
                throw new Exception("Error");
            }
        }

        return check;
    }
    public static  String[] stringToArr(String str){
        String[] exchangeArr = str.split("[+-/*]",2);
        for (int i=0;i<exchangeArr.length;i++) {
            if(isRomul) {
                String log = baza.valueOf(exchangeArr[i]).getNum();
                exchangeArr[i] = log;
            }
        }
        return exchangeArr;
    }
    public static String calculate(String[] arr, String input){
        if(input.contains("/")){
            int op = osnova.DE.action(arr[0],arr[1]);
            return Integer.toString(op);
        } else if (input.contains("*")) {
            int op = osnova.UM.action(arr[0],arr[1]);
            return Integer.toString(op);
        } else if (input.contains("+")) {
            int op = osnova.PL.action(arr[0],arr[1]);
            return Integer.toString(op);
        } else if (input.contains("-")) {
            int op = osnova.MI.action(arr[0],arr[1]);
            return Integer.toString(op);
        }
        return "Oshibka";
    }
    public static  String romulOut(String num) throws Exception{
        int lock = Integer.parseInt(num);
        if(lock<0) throw new Exception("Rimskie ne mogyt bit menshe 1");
        String[] romanNumbers = { "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] arab = { 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (lock > 0 || arab.length == (i - 1)) {
            while ((lock - arab[i]) >= 0) {
                lock -= arab[i];
                result.append(romanNumbers[i]);
            }
            i++;
        }
        return result.toString();
    }
}