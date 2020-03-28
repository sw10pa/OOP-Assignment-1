import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TabooTest {

    @Test
    void noFollow1(){
        List<String> rules = Arrays.asList("a", "c", "a", "b");
        Taboo<String> taboo = new Taboo<>(rules);

        HashSet<String> aNoFollow = new HashSet<>(Arrays.asList("c", "b"));
        HashSet<String> cNoFollow = new HashSet<>(Arrays.asList("a"));

        assertTrue(aNoFollow.equals(taboo.noFollow("a")));
        assertTrue(cNoFollow.equals(taboo.noFollow("c")));
    }

    @Test
    void noFollow2(){
        List<String> rules = Arrays.asList("a", "c", "b", "x", "c", "a");
        Taboo<String> taboo = new Taboo<>(rules);

        HashSet<String> aNoFollow = new HashSet<>(Arrays.asList("c"));
        HashSet<String> wNoFollow = new HashSet<>();

        assertTrue(aNoFollow.equals(taboo.noFollow("a")));
        assertTrue(wNoFollow.equals(taboo.noFollow("w")));
    }

    @Test
    void noFollow3(){
        List<String> rules = Arrays.asList("a", "b", null, "c", "d");
        Taboo<String> taboo = new Taboo<>(rules);

        HashSet<String> bNoFollow = new HashSet<>();
        HashSet<String> dNoFollow = new HashSet<>();
        HashSet<String> nullNoFollow = new HashSet<>();

        assertTrue(bNoFollow.equals(taboo.noFollow("b")));
        assertTrue(dNoFollow.equals(taboo.noFollow("d")));
        assertTrue(nullNoFollow.equals(taboo.noFollow(null)));
    }

    @Test
    void testReduce1() {
        List<String> rules = Arrays.asList("a", "c", "a", "b");
        Taboo<String> taboo = new Taboo<>(rules);

        List<String> toReduce = new ArrayList<>(Arrays.asList("a", "c", "b", "x", "c", "a"));
        taboo.reduce(toReduce);

        List<String> reduced = Arrays.asList("a", "x", "c");
        assertTrue(reduced.equals(toReduce));
    }

    @Test
    void reduceTest2() {
        List<String> rules = Arrays.asList("a", "b", null, "c", "d");
        Taboo<String> taboo = new Taboo<>(rules);

        List<String> toReduce = new ArrayList<>(Arrays.asList("a", "b", "b", "x", "b", "c", "d"));
        taboo.reduce(toReduce);

        List<String> reduced = Arrays.asList("a", "x", "b", "c");
        assertTrue(reduced.equals(toReduce));
    }

    @Test
    void reduceTest3() {
        List<String> rules = Arrays.asList();
        Taboo<String> taboo = new Taboo<>(rules);

        List<String> toReduce = new ArrayList<>();
        taboo.reduce(toReduce);

        List<String> reduced = Arrays.asList();
        assertTrue(reduced.equals(toReduce));
    }

}
