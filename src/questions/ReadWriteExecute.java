package questions;

public class ReadWriteExecute {
    public static int symbolicToOctal(String permString) {

        if( permString == null) {
            throw new UnsupportedOperationException("Waiting to be implemented.");
        } else if( permString.length() != 9) {
            throw new UnsupportedOperationException("Waiting to be implemented.");
        }

        char[] permChars = permString.toCharArray();

        int sum = 0 ;
        int count = 0;
        String s = "";
        for(char ch : permChars){
            count++;
            sum+= getPermission(ch);
            if(count == 3){
                s = s + sum;
                count =0;
                sum = 0;
            }
        }
        System.out.println(s);

        return Integer.parseInt(s);
    }

    public static int getPermission(char ch) {
        if(ch == 'r') {
            return 4;
        } else if(ch == 'w') {
            return 2;
        } else if(ch == 'x') {
            return 1;
        } else {
            return 0;
        }

    }

    public static void main(String[] args) {
        // Should write 752
        System.out.println(ReadWriteExecute.symbolicToOctal("rwxr-x-w-"));
    }
}