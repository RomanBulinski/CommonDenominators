import java.util.*;
import java.util.stream.Collectors;

public class Main {


//    long[][] lst = new long[][] { {1, 2}, {1, 3}, {10, 40} };

    public static String convertFrac(long[][] lstIn) {

        long[][] lst = Arrays.stream(lstIn).map(n -> maxCommonDiviser(n)).collect(Collectors.toList()).toArray(new long[0][]);

        Map<Long, Long> denominatorsMap = new HashMap<>();

        long commonDenomintaro = 0;
        boolean flag = true;
        int multiplication = 1;
        int tempPair = 0;

        while (flag) {
            while (tempPair < lst.length) {
                long tempDenominator = lst[tempPair][1] * multiplication;
                if (!denominatorsMap.keySet().contains(tempDenominator)) {
                    denominatorsMap.put(tempDenominator, 1L);
                } else if (denominatorsMap.keySet().contains(tempDenominator)) {
                    long tempValue = denominatorsMap.get(tempDenominator);
                    denominatorsMap.put(tempDenominator, tempValue + 1L);
                    if ((tempValue + 1L) == lst.length) {
                        commonDenomintaro = tempDenominator;
                        flag = false;
                    }
                }
                tempPair++;
            }
            tempPair = 0;
            multiplication++;
        }

        final long commonDenomintaroFinal = commonDenomintaro;

        String resultStream = Arrays.stream(lst).map(n -> proces(n, commonDenomintaroFinal)).collect(Collectors.toList()).toString();
        String result = resultStream.replaceAll(", ", "").replaceAll("\\[", "").replaceAll("\\]", "");

        return result;
    }

    private static String proces(long[] input, long commonDenomintaro) {
        long multiplication = commonDenomintaro / input[1];
        return "(" + (input[0] * multiplication) + "," + commonDenomintaro + ")";
    }

    private static long[] maxCommonDiviser(long[] input) {

        long a = input[0];
        long b = input[1];
        Integer commonDiviser = 1;

        if (b % a == 0) {
            return new long[]{1, b / a};
        } else {
            List<Integer> commonNumbers = new ArrayList<>();
            Map<Integer, Integer> numbers = new HashMap<>();

            int dividerA = 2;
            while (a > 1) {
                if (a % dividerA == 0) {
                    if (numbers.keySet().contains(dividerA)) {
                        int tempInt = numbers.get(dividerA);
                        numbers.put(2, tempInt + 1);
                    } else if (!numbers.keySet().contains(dividerA)) {
                        numbers.put(dividerA, 1);
                    }
                    a = a / dividerA;
                } else if (a % dividerA != 0) {
                    dividerA = dividerA + 1;
                }
            }
            int dividerB = 2;
            while (b > 1) {
                if (b % dividerB == 0) {
                    if (numbers.keySet().contains(dividerB)) {
                        int tempInt = numbers.get(dividerB);
                        if (tempInt > 0) {
                            numbers.put(dividerB, tempInt - 1);
                            commonNumbers.add(dividerB);
                        }
                    }
                    b = b / dividerB;
                } else if (b % dividerB != 0) {
                    dividerB = dividerB + 1;
                }
            }
            for (int i = 0; i < commonNumbers.size(); i++) {
                commonDiviser = commonDiviser * commonNumbers.get(i);
            }
        }
        return new long[]{input[0] / commonDiviser, input[1] / commonDiviser};
    }


}

