package Bt6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> inputList = Arrays.asList("java", "lambda", "stream", "functional");
        List<String> processedList = new ArrayList<String>();
        StringProcessor processor = (input)->{
            return input.toUpperCase() + " - TECHNICAL";
        };
        for(String s : inputList){
            String result = processor.processString(s);
            processedList.add(result);
        }
        processor.printList(processedList);
    }
}
