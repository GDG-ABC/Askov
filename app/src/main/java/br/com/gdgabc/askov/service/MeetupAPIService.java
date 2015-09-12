package br.com.gdgabc.askov.service;

import br.com.gdgabc.askov.model.Group;
import br.com.gdgabc.askov.model.MeetupApiResults;
import br.com.gdgabc.askov.model.Rsvp;
import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by ecarrara on 22/08/2015.
 */
public interface MeetupAPIService {

    @GET("/2/groups")
    void getGroup(@Query("group_id") int groupId,
                  @Query("key") String accessToken,
                  @Query("sign") boolean sign,
                  @Query("fields") String optionalFields,
                  Callback<MeetupApiResults<Group>> callback);

    @GET("/2/rsvps")
    void getRsvps(@Query("key") String accessToken,
                  @Query("event_id") String eventId,
                  Callback<MeetupApiResults<Rsvp>> callback);
}