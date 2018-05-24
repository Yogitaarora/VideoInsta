package samples.tech.com.sampleproject.rest;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import samples.tech.com.sampleproject.model.DATA;

/**
 * Created by android on 9/11/17.
 */

public interface ApiInterface {

    //http://18.220.29.159/salniazi-app/api.php?action=GetPosts&user_id=506&limit=15&PageNo=6
    @FormUrlEncoded
    @POST("api.php")
    Call<DATA> getDetails
    (@Field("action") String action, @Field("user_id") int user_id, @Field("limit") int limit, @Field("PageNo") int pageNo);

}
