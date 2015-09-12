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

    public NextEvent getNextEvent() {
        if(null == this.nextEvent) { this.nextEvent = new NextEvent(); }
        return this.nextEvent;
    }

    public String getNextEventId() {
        return getNextEvent().getId();
    }

    public String getNextEventName() { return getNextEvent().getName(); }
}
