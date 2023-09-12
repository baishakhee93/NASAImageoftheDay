package com.baishakhee.nasaimageoftheday.model;
import java.util.Date;

import com.google.gson.annotations.SerializedName;
public class MainModelResponse {
        @SerializedName("copyright")
        String copyright;

        @SerializedName("date")
        String date;

        @SerializedName("explanation")
        String explanation;

        @SerializedName("hdurl")
        String hdurl;

        @SerializedName("media_type")
        String mediaType;

        @SerializedName("service_version")
        String serviceVersion;

        @SerializedName("title")
        String title;

        @SerializedName("url")
        String url;

    public MainModelResponse(String copyright, String date, String explanation, String hdurl, String mediaType, String serviceVersion, String title, String url) {
        this.copyright = copyright;
        this.date = date;
        this.explanation = explanation;
        this.hdurl = hdurl;
        this.mediaType = mediaType;
        this.serviceVersion = serviceVersion;
        this.title = title;
        this.url = url;
    }

    public void setCopyright(String copyright) {
            this.copyright = copyright;
        }
        public String getCopyright() {
            return copyright;
        }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setExplanation(String explanation) {
            this.explanation = explanation;
        }
        public String getExplanation() {
            return explanation;
        }

        public void setHdurl(String hdurl) {
            this.hdurl = hdurl;
        }
        public String getHdurl() {
            return hdurl;
        }

        public void setMediaType(String mediaType) {
            this.mediaType = mediaType;
        }
        public String getMediaType() {
            return mediaType;
        }

        public void setServiceVersion(String serviceVersion) {
            this.serviceVersion = serviceVersion;
        }
        public String getServiceVersion() {
            return serviceVersion;
        }

        public void setTitle(String title) {
            this.title = title;
        }
        public String getTitle() {
            return title;
        }

        public void setUrl(String url) {
            this.url = url;
        }
        public String getUrl() {
            return url;
        }


}
