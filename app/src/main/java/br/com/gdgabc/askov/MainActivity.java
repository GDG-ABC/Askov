package br.com.gdgabc.askov;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import br.com.gdgabc.askov.model.Group;
import br.com.gdgabc.askov.service.MeetupApi;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    TextView groupInfoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        groupInfoTextView = (TextView) this.findViewById(R.id.group_id_text);

        Callback<Group> callback = new Callback<Group>() {
            @Override
            public void success(Group group, Response response) {
                String nextEventName = group.getNextEventName();
                if(TextUtils.isEmpty(nextEventName)) {
                    nextEventName = getString(R.string.no_scheduled_meetup);
                }
                groupInfoTextView.setText("Próximo evento do GDG ABC:\n" + nextEventName);
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
            }
        };

        MeetupApi meetupApi = new MeetupApi();
        meetupApi.getGroup(callback);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
