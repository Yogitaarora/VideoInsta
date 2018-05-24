
package samples.tech.com.sampleproject.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class DATA {

    @SerializedName("msg")
    private String mMsg;
    @SerializedName("post_count")
    private Long mPostCount;
    @SerializedName("post_details")
    private List<PostDetail> mPostDetails;

    public String getMsg() {
        return mMsg;
    }

    public void setMsg(String msg) {
        mMsg = msg;
    }

    public Long getPostCount() {
        return mPostCount;
    }

    public void setPostCount(Long postCount) {
        mPostCount = postCount;
    }

    public List<PostDetail> getPostDetails() {
        return mPostDetails;
    }

    public void setPostDetails(List<PostDetail> postDetails) {
        mPostDetails = postDetails;
    }

}
