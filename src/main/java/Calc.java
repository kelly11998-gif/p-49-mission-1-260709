public class Calc {

    public static int run(String str) {
        int start = 0;
        int last = 0;

        if(str.contains("-(")){

            String str4 = "";
            str = str.replaceFirst("-\\(", "( ");
            str = str.replace(")", " )");
            String[] num2 = str.split("\\s+");
            for (int j = 0; j < num2.length; j++){
                if (num2[j].equals("(")){
                    start = j;
                }else if (num2[j].equals(")")){
                    last = j;
                    break;
                }
            }
            for (int s = start + 1; s < last; s++) {
                str4 = str4 + " " + num2[s];
                num2[s] = "";
            }
            num2[last] = "";
            int value = run(str4);
            value = -value;
            num2[start] = Integer.toString(value);
            String str5 = String.join(" ", num2);
            return run(str5);
        }



        if (str.contains("(")) {

            String str3 = "";

            str = str.replace("(", "( ");
            str = str.replace(")", " )");
            String[] num = str.split("\\s+");
            for (int j = 0; j < num.length; j++) {
                if (num[j].equals("(")) {
                    start = j;
                } else if (num[j].equals(")")) {
                    last = j;
                    break;
                }
            }
            for (int s = start + 1; s < last; s++) {
                str3 = str3 + " " + num[s];
                num[s] = "";
            }
            num[last] = "";
            int value = run(str3);
            num[start] = Integer.toString(value);
            String str4 = String.join(" ", num);
            return run(str4);
        }

        str = str.trim();
        String[] num = str.split("\\s+");

        for (int j = 0; j < num.length; j++) {
            if (num[j].equals("*")) {
                int result1 = Integer.parseInt(num[j - 1]) * Integer.parseInt(num[j + 1]);
                num[j] = Integer.toString(result1);
                num[j - 1] = "";
                num[j + 1] = "";

                String str1 = String.join(" ", num);
                return run(str1);
                // 1 + 1 * 5 - 3 == 1 + 5 - 3
            }
        }

        int result = Integer.parseInt(num[0]);

        for (int k = 0; k < num.length; k++) {
            if (num[k].equals("+")) {
                result = result + Integer.parseInt(num[k + 1]);

            } else if (num[k].equals("-")) {
                result = result - Integer.parseInt(num[k + 1]);
            }

        }
        return result;
    }
}
