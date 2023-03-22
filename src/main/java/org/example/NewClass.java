package org.example;

import java.util.ArrayList;

public class NewClass {

    public Long getNewId(ArrayList<InnerClass> innerClasses, int getStatus) {

        return innerClasses.stream().filter(x -> x.getStatus().equals(getStatus)).map(InnerClass::getNew_id).findFirst().orElseThrow(() -> new AssertionError("Беда"));
    }
}
