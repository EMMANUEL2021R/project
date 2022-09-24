import java.util.ArrayList;
import java.util.*;


public class Operation {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();

        list.add("TAKODJOU");
        list.add("MBOU");
        list.add("Emmanuel");
        list.add("Reeves");
        list.add("Franki");

//        for(int i=0;i<list.size();i++)
//        System.out.println( list.get(i));

        // refactorisons avec une expression lambda
       // list.forEach(System.out::println);

        list.forEach((n)->{System.out.println(n);
        });

//        List<String> fruits = Arrays.asList("melon", "abricot", "fraise", "cerise");
//        afficher(fruits, (fmt, arg) -> String.format(fmt, arg));

//    }
//    public static void afficher(List<String> liste, MonFormateur formateur) {
//        int i = 0;
//        for (String element : liste) {
//            i++;
//            System.out.print(formateur.formater("%3d %s%n", i, element));
//        }
    }



     //   Runnable monTraitement = () -> System.out.println("traitement");//
    }
