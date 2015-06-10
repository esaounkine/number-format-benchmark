package implementations;

/**
 * @author EduardoAviles
 */
public class EduardoAviles {

    public static String format(Integer number){
        String[] suffix = new String[]{"k","m","b","t"};
        int size = (number.intValue() != 0) ? (int) Math.log10(number) : 0;
        if (size >= 3){
            while (size % 3 != 0) {
                size = size - 1;
            }
        }
        double notation = Math.pow(10, size);
        String result = (size >= 3) ? + (Math.round((number / notation) * 100) / 100.0d)+suffix[(size/3) - 1] : + number + "";
        return result;
    }
}
