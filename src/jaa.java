public class jaa {
    public static void main(String[] args) {
        builder("h",3);
    }

    public static void builder(String my_string, int n){
        StringBuilder builder = new StringBuilder();

        for ( int i = 0; i < my_string.length(); i++){
                char c = my_string.charAt(i);
                for(int j = 0; j < n; j++){
                    builder.append(c);
                }
        }
        System.out.println(builder.toString());
    }
}
