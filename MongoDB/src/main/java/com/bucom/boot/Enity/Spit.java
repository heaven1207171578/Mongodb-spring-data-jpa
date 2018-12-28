package com.bucom.boot.Enity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Spit {
    @Id
    private String id;
    private String content;
    private Date publishtime;
    private String userid;
    private String nickname;
    private Integer visits;
    private Integer thumbup;
    private Integer share;
    private Integer comment;
    private String state;
    private String parentid;

    public String getId() {
        return this.id;
    }

    public String getContent() {
        return this.content;
    }

    public Date getPublishtime() {
        return this.publishtime;
    }

    public String getUserid() {
        return this.userid;
    }

    public String getNickname() {
        return this.nickname;
    }

    public Integer getVisits() {
        return this.visits;
    }

    public Integer getThumbup() {
        return this.thumbup;
    }

    public Integer getShare() {
        return this.share;
    }

    public Integer getComment() {
        return this.comment;
    }

    public String getState() {
        return this.state;
    }

    public String getParentid() {
        return this.parentid;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setVisits(Integer visits) {
        this.visits = visits;
    }

    public void setThumbup(Integer thumbup) {
        this.thumbup = thumbup;
    }

    public void setShare(Integer share) {
        this.share = share;
    }

    public void setComment(Integer comment) {
        this.comment = comment;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Spit)) return false;
        final Spit other = (Spit) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$content = this.getContent();
        final Object other$content = other.getContent();
        if (this$content == null ? other$content != null : !this$content.equals(other$content)) return false;
        final Object this$publishtime = this.getPublishtime();
        final Object other$publishtime = other.getPublishtime();
        if (this$publishtime == null ? other$publishtime != null : !this$publishtime.equals(other$publishtime))
            return false;
        final Object this$userid = this.getUserid();
        final Object other$userid = other.getUserid();
        if (this$userid == null ? other$userid != null : !this$userid.equals(other$userid)) return false;
        final Object this$nickname = this.getNickname();
        final Object other$nickname = other.getNickname();
        if (this$nickname == null ? other$nickname != null : !this$nickname.equals(other$nickname)) return false;
        final Object this$visits = this.getVisits();
        final Object other$visits = other.getVisits();
        if (this$visits == null ? other$visits != null : !this$visits.equals(other$visits)) return false;
        final Object this$thumbup = this.getThumbup();
        final Object other$thumbup = other.getThumbup();
        if (this$thumbup == null ? other$thumbup != null : !this$thumbup.equals(other$thumbup)) return false;
        final Object this$share = this.getShare();
        final Object other$share = other.getShare();
        if (this$share == null ? other$share != null : !this$share.equals(other$share)) return false;
        final Object this$comment = this.getComment();
        final Object other$comment = other.getComment();
        if (this$comment == null ? other$comment != null : !this$comment.equals(other$comment)) return false;
        final Object this$state = this.getState();
        final Object other$state = other.getState();
        if (this$state == null ? other$state != null : !this$state.equals(other$state)) return false;
        final Object this$parentid = this.getParentid();
        final Object other$parentid = other.getParentid();
        if (this$parentid == null ? other$parentid != null : !this$parentid.equals(other$parentid)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Spit;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $content = this.getContent();
        result = result * PRIME + ($content == null ? 43 : $content.hashCode());
        final Object $publishtime = this.getPublishtime();
        result = result * PRIME + ($publishtime == null ? 43 : $publishtime.hashCode());
        final Object $userid = this.getUserid();
        result = result * PRIME + ($userid == null ? 43 : $userid.hashCode());
        final Object $nickname = this.getNickname();
        result = result * PRIME + ($nickname == null ? 43 : $nickname.hashCode());
        final Object $visits = this.getVisits();
        result = result * PRIME + ($visits == null ? 43 : $visits.hashCode());
        final Object $thumbup = this.getThumbup();
        result = result * PRIME + ($thumbup == null ? 43 : $thumbup.hashCode());
        final Object $share = this.getShare();
        result = result * PRIME + ($share == null ? 43 : $share.hashCode());
        final Object $comment = this.getComment();
        result = result * PRIME + ($comment == null ? 43 : $comment.hashCode());
        final Object $state = this.getState();
        result = result * PRIME + ($state == null ? 43 : $state.hashCode());
        final Object $parentid = this.getParentid();
        result = result * PRIME + ($parentid == null ? 43 : $parentid.hashCode());
        return result;
    }
}
