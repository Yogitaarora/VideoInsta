package samples.tech.com.sampleproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import im.ene.toro.widget.Container;
import retrofit2.Call;
import retrofit2.Callback;
import samples.tech.com.sampleproject.model.DATA;
import samples.tech.com.sampleproject.model.PostDetail;
import samples.tech.com.sampleproject.rest.ApiClient;
import samples.tech.com.sampleproject.rest.ApiInterface;

public class MainActivity extends AppCompatActivity {
    Container container;
    SimpleAdapter adapter;
    ApiInterface apiService;
    List<PostDetail> dataDetails;
    public ArrayList<HashMap<String, String>> dataList = new ArrayList<HashMap<String, String>>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        container = findViewById(R.id.player_container);
        apiService = ApiClient.getClient().create(ApiInterface.class);
        dataDetails = new ArrayList<>();
        dataList = new ArrayList<HashMap<String, String>>();
        adapter = new SimpleAdapter(MainActivity.this, dataList);
        container.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        container.setAdapter(adapter);
        getDetails();


    }

    void getDetails() {
        Call<DATA> call = apiService.getDetails("GetPosts", 506, 15, 6);
        call.enqueue(new Callback<DATA>() {
            @Override
            public void onResponse(Call<DATA> call, retrofit2.Response<DATA> response) {
                if (response.code() == 200) {
                    Log.e("response", "" + response.toString());
                    dataDetails = response.body().getPostDetails();
                    for (int i = 0; i < dataDetails.size(); i++) {
                        HashMap<String, String> map = new HashMap<String, String>();
                        String file = dataDetails.get(i).getFile();
                        String photoUrl = dataDetails.get(i).getPhotoURL();
                        String type = dataDetails.get(i).getType();
                        map.put("file", String.valueOf(file));
                        map.put("photoUrl", photoUrl);
                        map.put("type", type);
                        dataList.add(map);

                    }
                    adapter.notifyDataSetChanged();

                } else {
                    try {
                        JSONObject object = new JSONObject(response.errorBody().string());
                        Log.e("response", "" + response);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<DATA> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                Log.e("response", t + "");
            }
        });
    }

}
