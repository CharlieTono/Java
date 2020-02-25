package com.company.handler;

public interface Operation {
    /**
     * takes input, process it and returns the result
     * @param input string to process
     * @return result string
     */

    String operate (String input);

    String getName ();

}
