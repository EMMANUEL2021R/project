import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class StreamManagment {

    public static void main(String[] arges){

        Stream<String> streamEmpty = Stream.empty();// cree un stream vide

        Collection<String> collection = Arrays.asList("a","b","c");
        Stream<String> streamOfCollection = collection.stream();       // Stream of collection

        Stream<String> StreamOfArray = Stream.of("a","f","p"); // Stream of array

        String[] arr = new String[]{"d","k","r"};
        Stream<String> StreamOfArrayFull = Arrays.stream(arr)
        Stream<String> StreamOfArrayPart = Arrays.stream(arr,1,3);

        // en utilisant le Stream Builder
        Stream<String> streamBuilder =
                Stream.<String>builder().add("a").add("b").add("3").build();

         Stream generate
        Stream<String> streamGenerated = Stream.generate(()->"element").limit(10);// genere une sequences de 10 String avec le mot elemennt

System.out.println(streamGenerated.toString());
    }

    public Stream<String> streamOf(List<String> list){
        return list == null || list.isEmpty() ? Stream.empty() : list.stream();
    }
}
