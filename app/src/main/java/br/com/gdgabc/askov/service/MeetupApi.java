package br.com.gdgabc.askov.service;

import android.util.Log;

import java.util.List;

import br.com.gdgabc.askov.model.Group;
import br.com.gdgabc.askov.model.MeetupApiResults;
import br.com.gdgabc.askov.model.Rsvp;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by ecarrara on 22/08/2015.
 */
public class MeetupApi {

    //gdg-abc
    public static final int GDG_ABC_GROUP_ID = 14638992;
    public static final String MEETUP_API_BASE_URL = "https://api.meetup.com";
    public static final String MEETUP_API_KEY = "7e7c721b7841511e7f706cbf342913";
    private final RestAdapter mRestAdapter;

    public MeetupApi() {
        this.mRestAdapter = new RestAdapter.Builder()
                .setEndpoint(MEETUP_API_BASE_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
    }

    public void getGroup(final Callback<Group> callback) {
        MeetupAPIService meetupService = this.mRestAdapter.create(MeetupAPIService.class);
        meetupService.getGroup(GDG_ABC_GROUP_ID,  MEETUP_API_KEY,true, "next_event", new Callback<MeetupApiResults<Group>>() {
            @Override
            public void success(MeetupApiResults<Group> results, Response response) {
                callback.success(results.getResults().get(0) ,response);
            }

            @Override
            public void failure(RetrofitError error) {
                callback.failure(error);
            }
        });
    }

    public void getRsvp(String eventId, final Callback<List<Rsvp>> callback) {
        MeetupAPIService meetupAPIService = this.mRestAdapter.create(MeetupAPIService.class);
        meetupAPIService.getRsvps(MEETUP_API_KEY, eventId, new Callback<MeetupApiResults<Rsvp>>() {
            @Override
            public void success(MeetupApiResults<Rsvp> rsvpMeetupApiResults, Response response) {
                callback.success(rsvpMeetupApiResults.getResults(), response);
            }

            @Override
            public void failure(RetrofitError error) {
                callback.failure(error);
            }
        });
    }

}
