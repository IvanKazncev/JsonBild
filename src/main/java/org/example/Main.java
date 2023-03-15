  package org.example;
  import com.fasterxml.jackson.core.JsonProcessingException;
  import com.fasterxml.jackson.databind.ObjectMapper;
  import java.util.ArrayList;
  import java.util.Arrays;
  import java.util.List;
  import java.util.Random;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Random random = new Random();
        //
        //InnerClass innerClass = new InnerClass();
       Main main = new Main();
        final int min = 00001;
        int max = 99999;
        int rn = (int) (Math.random() * ++max) +min;
        ArrayList<Integer> myList = new ArrayList<>(Arrays.asList(10,15,20,30));
        ArrayList<InnerClass> innerClasses = new ArrayList<>();
        for (int i = 0; i < 3; i++) {

            innerClasses.add(new InnerClass(random.nextLong(9999999999L),0,main.getRandomElement(myList)));

        }
        Model model = new Model(rn,"Ivan","Kazancev",innerClasses,5);
        String result = objectMapper.writeValueAsString(model);
        System.out.println(result);

    }
    public int getRandomElement(List<Integer> list)
    {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }

}