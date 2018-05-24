package samples.tech.com.sampleproject.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by android on 9/11/17.
 */

public class ApiClient {
    public static final String BASE_URL = " http://18.220.29.159/salniazi-app/";
    private static Retrofit retrofit = null;
    private static HttpLoggingInterceptor loggingInterceptor;
    private static OkHttpClient.Builder clientBuilder;
    static Gson gson;

    public static Retrofit getClient() {
        if (retrofit == null) {
            gson = new GsonBuilder()
                    .setLenient()
                    .create();
            loggingInterceptor = new HttpLoggingInterceptor();
            clientBuilder = new OkHttpClient.Builder();
            //this is to check full response of api
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            clientBuilder.addInterceptor(loggingInterceptor);

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(clientBuilder.build())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }
}
