package com.cowboysmall.scratch.bionic.question1;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NameRepository {

    @LogExecution
    public List<String> getNames() {

        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Mary");
        return names;
    }
}
