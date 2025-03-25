package Bt6;

import java.util.List;

public interface StringProcessor {
    public abstract String processString(String input);
    default void printList(List<String> list){
        for(String s: list){
            System.out.println(s);
        }
    }
}
