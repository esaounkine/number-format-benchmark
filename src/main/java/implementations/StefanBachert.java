package implementations;

/**
 * @author Stefan Bachert
 */
public class StefanBachert {
    private static String[] unit = {"u", "k", "m", "g", "t"};

    public static String myFormat(int pN) {
        String str = Integer.toString(pN);
        int len = str.length ()-1;
        if (len <= 3) return str;
        int level = len / 3;
        int mode = len % 3;
        switch (mode) {
            case 0: return str.substring(0, 1) + "." + str.substring(1, 2) + unit[level];
            case 1: return str.substring(0, 2) + unit[level];
            case 2: return str.substring(0, 3) + unit[level];
        }
        return "how that?";
    }
    private static String trim1 (String pVal) {
        if (pVal.equals("0")) return "";
        return pVal;
    }
    private static String trim2 (String pVal) {
        if (pVal.equals("00")) return "";
        return pVal.substring(0, 1) + trim1(pVal.substring(1,2));
    }
    private static String myFormat2(int pN) {
        String str = Integer.toString(pN);
        int len = str.length () - 1;
        if (len <= 3) return str;
        int level = len / 3;
        int mode = len % 3;
        switch (mode) {
            case 0: return str.substring(0, 1) + unit[level] + trim2(str.substring(1, 3));
            case 2: return str.substring(0, 3) + unit[level];
            case 1: return str.substring(0, 2) + unit[level] + trim1(str.substring(2, 3));
        }
        return "how that?";
    }
}