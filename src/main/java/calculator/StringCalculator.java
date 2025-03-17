package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String DELIMITER = ",|:";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int calculate(String text) {
        String checkedText = emptyOrNullChecker(text);
        return getSum(checkedText);
    }

    /**
     * 합을 구하는 메서드
     */
    private static int getSum(String text) {
        String[] values = splitter(text);
        int result = 0;
        for (String value : values) {
            result += parsePositive(value.trim());
        }
        return result;
    }

    /**
     * 빈 문자열 또는 null 값 체크 메서드
     */
    private static String emptyOrNullChecker(String text){
        if (text == null || text.isEmpty()) {
            return "0";
        }
        return text;
    }

    /**
     * 배열 분리 메서드
     */
    private static String[] splitter(String text) {
        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (m.find()){
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split(DELIMITER);
    }

    /**
     * 숫자 파싱 메서드
     */
    private static int parsePositive(String text) {
        if (Integer.parseInt(text) < 0){
            throw new RuntimeException();
        }
        return Integer.parseInt(text);
    }
}
