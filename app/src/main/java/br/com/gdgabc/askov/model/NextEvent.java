package br.com.gdgabc.askov.model;

/**
 * Created by ecarrara on 22/08/2015.
 */
public class NextEvent {
    private String id;
    private String name;

    public NextEvent() {
        this.id = "";
        this.name = "";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
