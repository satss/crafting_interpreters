package de.satadev;

import java.util.ArrayList;
import java.util.List;

public class Scanner {


    private final String source;

    private final List<Token> tokens = new ArrayList<>();

    public Scanner(String source) {
        this.source = source;
    }
}
