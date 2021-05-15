package cn.o0u0o.service.video.entity.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author Caleb Chen
 * @create 2021-05-03 17:31
 */
@Data
public class VideoInfoResult {
    //视频id
    private Integer videoId;
    //作者ID
    private Integer authorId;
    //作者昵称
    private String userName;
    //视频标题
    private String videoTitle;
    //视频简介
    private String videoBrief;
    //创建时间
    private Date gmtCreate;
    //播放量
    private String playNub;
    //分享数
    private String videoPnumb;
    //投币数
    private String videoCoin;
    //点赞数
    private String likeNumber;
    //类型
    private List<String> zoneType;
    //视频状态
    private Integer videoStatus;

    public VideoInfoResult() {
    }

    public VideoInfoResult(Integer videoId, Integer authorId, String userName, String videoTitle, String videoBrief, Date gmtCreate, String playNub, String videoPnumb, String videoCoin, String likeNumber, List<String> zoneType, Integer videoStatus) {
        this.videoId = videoId;
        this.authorId = authorId;
        this.userName = userName;
        this.videoTitle = videoTitle;
        this.videoBrief = videoBrief;
        this.gmtCreate = gmtCreate;
        this.playNub = playNub;
        this.videoPnumb = videoPnumb;
        this.videoCoin = videoCoin;
        this.likeNumber = likeNumber;
        this.zoneType = zoneType;
        this.videoStatus = videoStatus;
    }
}
