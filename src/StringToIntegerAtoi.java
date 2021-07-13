public class StringToIntegerAtoi {
    public static void main(String[] args) {
        System.out.println(myAtoi("  42"));
    }

    public static int myAtoi(String s) {
        int multiplier = 1;
        String[] charArray = s.split("");
        String intReadIn = "";
        if (s != null) {
            for (int x = 0; x < s.length(); x++) {
                if (!charArray[x].equals(" ")) {
                    s = s.substring(x);
                    break;
                }
            }
        }
        charArray = s.split("");
        if (s.length() < 1) {
            return 0;
        }
        int x = 0;
        if (String.valueOf(charArray[0]).equals("-")) {
            multiplier = -1;
            x++;
        } else if (String.valueOf(charArray[0]).equals("+")) {
            x++;
        }
        boolean nonIntFound = false;
        while (!nonIntFound) {
            if (x >= charArray.length || !charArray[x].matches("-?\\d+(\\.\\d+)?")) {
                nonIntFound = true;
            } else {
                intReadIn += String.valueOf(charArray[x]);
            }
            x++;
        }
        if (intReadIn.equals("")) {
            intReadIn = "0";
        }
        Integer finalDouble;
        try {
            finalDouble = Integer.valueOf(intReadIn);
        } catch (NumberFormatException e) {
            if (multiplier == -1) {
                return -2147483648;
            } else {
                return 2147483647;
            }
        }
        return (int) finalDouble * multiplier;
    }
}
