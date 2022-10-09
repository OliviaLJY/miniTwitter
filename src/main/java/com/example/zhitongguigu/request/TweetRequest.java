package com.example.zhitongguigu.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class TweetRequest extends PageRequest{

    @NotNull(message = "author id can't be null")
    @Min(value = 1)
    private Long authorId;

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getTweetTitle() {
        return tweetTitle;
    }

    public void setTweetTitle(String tweetTitle) {
        this.tweetTitle = tweetTitle;
    }

    private String tweetTitle;
}
