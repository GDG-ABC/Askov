package br.com.gdgabc.askov.model;

import java.util.List;

/**
 * Created by ecarrara on 22/08/2015.
 */
public class MeetupApiResults <T> {

    private List<T> results;

    public List<T> getResults() {
        return results;
    }
}
