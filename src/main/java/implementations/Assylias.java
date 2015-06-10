package implementations;

/**
 * @author assylias
 */
public class Assylias {

    private static final String[] suffixes = {"", "k", "m", "b", "t"};

    /**
     * Returns the value formatted using the following rules:
     * - if value is negative, apply the rules below to the positive number and prefix with -
     * - if value is between 0 and 999 returns as is
     * - otherwise:
     *    - the value is rescaled to be printed with the appropriate suffix
     *      (k for thousands, m for millions, b for billions and t for trillions)
     *    - the rescaled value is truncated to one decimal place if it's less than 10
     *      or to an integer otherwise
     *
     * Examples:
     * 1         -> "1"
     * 999       -> "999"
     * 1,000     -> 1k
     * 1,999     -> 1.9k
     * 10,000    -> 10k
     * 999,999   -> 999k
     * 1,000,000 -> 1m
     * -1,230    -> -1.2k
     */
    public static String format(long value) {
        if (value == Long.MIN_VALUE) return format(Long.MIN_VALUE + 1); //to prevent problem on next line
        long positiveValue = Math.abs(value); //works ok because value != MIN_VALUE
        long temp = positiveValue;
        int suffixIndex = 0;
        while ((temp /= 1000) > 0 && suffixIndex < suffixes.length - 1) suffixIndex++;
        double truncatedValue = truncate(positiveValue, suffixIndex);
        String suffix = suffixes[suffixIndex];
        boolean hasDecimal = truncatedValue != (long) truncatedValue;
        String positiveFormatted = hasDecimal ? truncatedValue + suffix : (long) truncatedValue + suffix;
        return (value < 0 ? "-" : "") + positiveFormatted;
    }

    /**
     * @return the number part of the output, truncated as required with the correct number of decimals
     */
    private static double truncate(long positiveValue, int range) {
        if (range == 0) return positiveValue;
        long divideBy = 100; //not 1000 to keep one decimal if needed
        for (int i = 0; i < range - 1; i++) divideBy *= 1000;
        //cast as double after division to avoid loss of precision!!
        double scaled = (positiveValue / divideBy) / 10d; //1000 for k, 1_000_000 for m etc.
        boolean hasDecimal = scaled < 10 && scaled != (long) scaled;
        return hasDecimal ? (long) (scaled * 10) / 10d : (long) scaled;
    }
}
