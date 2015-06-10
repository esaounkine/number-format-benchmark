package implementations;

/**
 * @author maraca
 */
public class Maraca {
    private static final char[] magnitudes = {'k', 'M', 'G', 'T', 'P', 'E'}; // enough for long

    public static String convert(long number) {
        String ret;
        if (number >= 0) {
            ret = "";
        } else if (number <= -9200000000000000000L) {
            return "-9.2E";
        } else {
            ret = "-";
            number = -number;
        }
        if (number < 1000)
            return ret + number;
        for (int i = 0; ; i++) {
            if (number < 10000 && number % 1000 >= 100)
                return ret + (number / 1000) + '.' + ((number % 1000) / 100) + magnitudes[i];
            number /= 1000;
            if (number < 1000)
                return ret + number + magnitudes[i];
        }
    }
}
