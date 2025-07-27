public class Atoi {
    public static int atoi(String number) {
        // steps
        // 1. Remove leading and trailing spaces and find sign
        // 2. Remove leading 0
        // 3. conversion
        String dataAfter = number.trim();
        char sign = dataAfter.charAt(0);
        if (sign == '-') {
            sign = '-';
        }
        if (!dataAfter.isEmpty()) {
            dataAfter = dataAfter.substring(1);
        }

        int index = 0;
        while (index < dataAfter.length()) {
            if (dataAfter.charAt(index) != '0') {
                break;
            }
            dataAfter = dataAfter.substring(index++);
        }



        // conversion

        long value = Long.parseLong(dataAfter);
        int finalValue;

        // handling overflows

        if(value<Integer.MIN_VALUE || value>Integer.MAX_VALUE){
            return -1;
        }else{
            finalValue = (int) value;
            return finalValue;
        }

    }

    public static void main(String[] args) {
        System.out.println(atoi("--6187"));
    }
}