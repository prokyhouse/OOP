import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPrimeCheck {

        //Our prime numbers "flag".
        static boolean hasPrime = false;

        public static void main(String[] args) throws Exception {

            List<Integer> array = new ArrayList<>();
            array.add(4);
            array.add(8);
            array.add(16);
            array.add(17);

            Optional<Integer> n = array
                    .parallelStream()
                    .filter(Validation::isPrime)
                    .findFirst();

            if (n.isPresent()){
                hasPrime =true;
            }

            System.out.println(hasPrime);
        }

}
