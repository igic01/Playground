// link: https://www.codewars.com/kata/52742f58faf5485cae000b9a/train/java
public class TimeFormatter {

    public static String formatDuration(int seconds) {
        if (seconds == 0)
            return "now";

        int[] values = { seconds / (365 * 24 * 3600), (seconds % (365 * 24 * 3600)) / (24 * 3600),
                (seconds % (24 * 3600)) / 3600, (seconds % 3600) / 60, seconds % 60 };

        String[] units = { "year", "day", "hour", "minute", "second" };
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            if (values[i] != 0) {
                sb.append(String.format("%d %s, ", values[i], values[i] == 1 ? units[i] : units[i] + "s"));
            }
        }

        String input = sb.toString();
        input = input.substring(0, input.length() - 2);

        System.out.println("First:" + input);
        int lastIndex = input.lastIndexOf(',');
        if (lastIndex >= 0) {
            return input.substring(0, lastIndex) + " and" + input.substring(lastIndex + 1);
        } else {
            return input;
        }
    }


    public static void main(String[] args) {
        System.out.println(formatDuration(30661));
    }
}