public class Strings {

    static long bernsteinHash(String str){

        long h = 0;

        for(int i = 0; i < str.length(); i++){
            h = 33 * h + str.charAt(i);
        }

        return h;

    }

    static long javaStringHashCode(String str){

        long h = 0;

        for(int i = 0; i < str.length(); i++){
            h += str.charAt(i) * Math.pow(31, str.length() - (i + 1));
        }

        return h;
    }

    static String swap(String str, int from, int to){

        char[] charArr = str.toCharArray();

        char temp = charArr[to];

        charArr[to] = charArr[from];

        charArr[from] = temp;

        return new String(charArr);

    }


    public static void main(String[] args) {

        StringBuilder stringBuilder = new StringBuilder("Alperen");

        stringBuilder.append(" Ugus");

        System.out.println(stringBuilder);

    }

}
