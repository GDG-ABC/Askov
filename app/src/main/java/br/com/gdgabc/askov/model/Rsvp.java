package br.com.gdgabc.askov.model;

/**
 * Created by ecarrara on 12/09/2015.
 */
public class Rsvp {
    String response;
    Member member;

    public String getResponse() { return response; }

    public Member getMember() {
        if(null == this.member) {
            this.member = new Member();
        }
        return this.member;
    }

    public String getMemberName() {
        return this.getMember().getName();
    }
}
