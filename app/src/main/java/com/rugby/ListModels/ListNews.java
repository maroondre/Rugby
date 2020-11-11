package com.rugby.ListModels;

import com.google.gson.annotations.SerializedName;

public class ListNews {

        @SerializedName("Source")
        private String source;

        @SerializedName("Updated")
        private String updated;

        @SerializedName("Title")
        private String title;

        @SerializedName("Content")
        private String content;

        @SerializedName("Url")
        private String url;

        @SerializedName("TermsOfUse")
        private String termsOfUse;

        @SerializedName("OriginalSource")
        private String originalSource;

        public ListNews( String source, String updated, String title, String content, String url, String termsOfUse, String originalSource) {
            super();

            this.source = source;
            this.updated = updated;
            this.title = title;
            this.content = content;
            this.url = url;
            this.termsOfUse = termsOfUse;
            this.originalSource = originalSource;

        }
    
        public String getSource() {
            return source;
        }
    
        public void setSource(String source) {
            this.source = source;
        }
    
        public String getUpdated() {
            return updated;
        }
    
        public void setUpdated(String updated) {
            this.updated = updated;
        }
    
        public String getTitle() {
            return title;
        }
    
        public void setTitle(String title) {
            this.title = title;
        }
    
        public String getContent() {
            return content;
        }
    
        public void setContent(String content) {
            this.content = content;
        }
    
        public String getUrl() {
            return url;
        }
    
        public void setUrl(String url) {
            this.url = url;
        }
    
        public String getTermsOfUse() {
            return termsOfUse;
        }
    
        public void setTermsOfUse(String termsOfUse) {
            this.termsOfUse = termsOfUse;
        }

    public String getOriginalSource() {
        return originalSource;
    }

    public void setOriginalSource(String originalSource) {
        this.originalSource = originalSource;
    }
}
