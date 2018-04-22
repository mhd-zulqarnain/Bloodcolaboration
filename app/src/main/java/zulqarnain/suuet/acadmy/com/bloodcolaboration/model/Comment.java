package zulqarnain.suuet.acadmy.com.bloodcolaboration.model;

/**
 * Created by Zul Qarnain on 4/22/2018.
 */

public class Comment {
    String commenterId;
    String description;

    public Comment() {
    }

    public Comment(String commenterId, String description) {
        this.commenterId = commenterId;
        this.description = description;
    }

    public String getCommenterId() {
        return commenterId;
    }

    public void setCommenterId(String commenterId) {
        this.commenterId = commenterId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
