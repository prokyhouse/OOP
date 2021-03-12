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
        array.add(6997901);
        array.add(6997927);
        array.add(6997937);
        array.add(6997967);
        array.add(6998009);
        array.add(6998029);
        array.add(6998039);
        array.add(6998051);
        array.add(6998053);


        Optional<Integer> n = array
                .parallelStream()
                .filter(Validation::isPrime)
                .findFirst();

        if (n.isPresent()) {
            hasPrime = true;
        }

        System.out.println(!hasPrime);
    }

}
