import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.InnerClass;
import org.example.Model;
import org.example.NewClass;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;


public class Main {
    @Test
    public void test() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Random random = new Random();
        Main main = new Main();
        NewClass newClass = new NewClass();

        final int min = 00001;
        int max = 99999;
        int rn = (int) (Math.random() * ++max) + min;

        ArrayList<Integer> myList = new ArrayList<>(Arrays.asList(10, 15, 20, 30));
        ArrayList<InnerClass> innerClasses = new ArrayList<>();

        for (int i = 0; i < 3; i++) {

            innerClasses.add(new InnerClass(random.nextLong(9999999999L), i, main.getRandomElement(myList)));
        }

        Model model = new Model(rn, "Ivan", "Kazancev", innerClasses, 5);
        String result = objectMapper.writeValueAsString(model);
        System.out.println(result);
        // Long idNew = innerClasses.stream().filter(x -> x.getStatus().equals(0)).map(InnerClass::getNew_id).findFirst().orElse(0L);
        // Long idNew2 = innerClasses.stream().filter(x -> x.getStatus().equals(1)).map(InnerClass::getNew_id).findFirst().orElse(0L);

        Long idNew3 = newClass.getNewId(innerClasses, 0);
        Long idNew4 = newClass.getNewId(innerClasses, 1);
        assertThat(model.getList()).as("Проблема").isNotEmpty().allSatisfy(x->{
            assertThat(x.getNew_id()).as("Новая проблема").isNotEqualTo(0);
        });
        System.out.println(idNew3);
        System.out.print(idNew4);System.out.print(idNew4);

    }


    public int getRandomElement(List<Integer> list) {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }

}






