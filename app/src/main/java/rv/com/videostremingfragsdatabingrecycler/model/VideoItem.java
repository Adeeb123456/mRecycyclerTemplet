package rv.com.videostremingfragsdatabingrecycler.model;




public class VideoItem {

   // @SerializedName("CompanyNumber")
   // @Expose
    private String id;

   // @SerializedName("Title_en")
   // @Expose
    private String titleEn;
   // @SerializedName("Title_ar")
   // @Expose
    private String titleAr;

   // @SerializedName("Video_URL")
   // @Expose
    private String videoUrl;

   // @SerializedName("ThumbURL")
   // @Expose
    private String thumbnailUrl;

    private String videoURL;
   // @SerializedName("Video_or_Logo")
   // @Expose
    private String videoOrLogo;

    public VideoItem() {
    }

    public VideoItem(String title) {
        this.titleEn = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitleEn() {
        return titleEn;
    }

    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getVideoOrLogo() {
        return videoOrLogo;
    }

    public void setVideoOrLogo(String videoOrLogo) {
        this.videoOrLogo = videoOrLogo;
    }

    public String getTitleAr() {
        return titleAr;
    }

    public void setTitleAr(String titleAr) {
        this.titleAr = titleAr;
    }
}
