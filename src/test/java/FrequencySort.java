import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
public class FrequencySort {
        public static List<Integer> frequencySort(int[] nums) {
            // Step 1: Count frequencies using groupingBy
            Map<Integer, Long> freqMap = Arrays.stream(nums)
                    .boxed()
                    .collect(Collectors.groupingBy(n -> n, Collectors.counting()));

            // Step 2: Convert array to list for sorting
            List<Integer> result = Arrays.stream(nums)
                    .boxed()
                    .collect(Collectors.toList());

            // Step 3: Sort by frequency asc, then value desc
            result.sort((a, b) -> {
                int freqCompare = freqMap.get(a).compareTo(freqMap.get(b));
                if (freqCompare == 0) {
                    return b - a; // same frequency → higher value first
                }
                return freqCompare; // lower frequency first
            });

            return result;
        }

        public static void main(String[] args) {
            int[] arr = {0, 1, 2, 2, 3, 3, 9, 5};
            System.out.println(frequencySort(arr));
        }
    }

