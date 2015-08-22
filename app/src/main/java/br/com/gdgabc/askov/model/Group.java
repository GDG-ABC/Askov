package br.com.gdgabc.askov.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ecarrara on 22/08/2015.
 */
public class Group {

    @SerializedName("next_event")
    private NextEvent nextEvent;

    public void setNextEvent(NextEvent nextEvent) {
        this.nextEvent = nextEvent;
    }

    public String getNextEventId() {
        return nextEvent.getId();
    }

    public String getNextEventName() {
        return nextEvent.getName();
    }
}
