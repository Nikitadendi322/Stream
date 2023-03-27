import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<T> list = stream.collect(Collectors.toList());
        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            list.sort(order);
            minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));
        }
    }

    public static void findCountEvenNums(List<Integer> list) {
        Stream<Integer> stream = list.stream();
        Predicate<Integer> predicate = (n) -> (n % 2) == 0;
        Stream<Integer> resStream = stream.filter(predicate);
        System.out.println("Количество четных чисел" + resStream.count());
    }

    public static void findCountEvenNums2(List<Integer> list) {
        int count = (int) (list.stream().filter((n) -> (n % 2) == 0)).count();
        System.out.println("Колличество четных чисел" + count);
    }


}



