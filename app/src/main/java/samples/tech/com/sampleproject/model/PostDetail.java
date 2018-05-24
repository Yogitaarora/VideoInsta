
package samples.tech.com.sampleproject.model;


import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class PostDetail {

    @SerializedName("caption")
    private String mCaption;
    @SerializedName("commentsCount")
    private String mCommentsCount;
    @SerializedName("created")
    private String mCreated;
    @SerializedName("file")
    private String mFile;
    @SerializedName("height")
    private String mHeight;
    @SerializedName("id")
    private String mId;
    @SerializedName("isLiked")
    private String mIsLiked;
    @SerializedName("likesCount")
    private String mLikesCount;
    @SerializedName("name")
    private String mName;
    @SerializedName("phoneNumber")
    private String mPhoneNumber;
    @SerializedName("photoURL")
    private String mPhotoURL;
    @SerializedName("thumbnail")
    private String mThumbnail;
    @SerializedName("type")
    private String mType;
    @SerializedName("user_id")
    private String mUserId;
    @SerializedName("width")
    private String mWidth;

    public String getCaption() {
        return mCaption;
    }

    public void setCaption(String caption) {
        mCaption = caption;
    }

    public String getCommentsCount() {
        return mCommentsCount;
    }

    public void setCommentsCount(String commentsCount) {
        mCommentsCount = commentsCount;
    }

    public String getCreated() {
        return mCreated;
    }

    public void setCreated(String created) {
        mCreated = created;
    }

    public String getFile() {
        return mFile;
    }

    public void setFile(String file) {
        mFile = file;
    }

    public String getHeight() {
        return mHeight;
    }

    public void setHeight(String height) {
        mHeight = height;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getIsLiked() {
        return mIsLiked;
    }

    public void setIsLiked(String isLiked) {
        mIsLiked = isLiked;
    }

    public String getLikesCount() {
        return mLikesCount;
    }

    public void setLikesCount(String likesCount) {
        mLikesCount = likesCount;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        mPhoneNumber = phoneNumber;
    }

    public String getPhotoURL() {
        return mPhotoURL;
    }

    public void setPhotoURL(String photoURL) {
        mPhotoURL = photoURL;
    }

    public String getThumbnail() {
        return mThumbnail;
    }

    public void setThumbnail(String thumbnail) {
        mThumbnail = thumbnail;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public String getUserId() {
        return mUserId;
    }

    public void setUserId(String userId) {
        mUserId = userId;
    }

    public String getWidth() {
        return mWidth;
    }

    public void setWidth(String width) {
        mWidth = width;
    }

}
