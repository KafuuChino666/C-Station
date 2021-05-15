package cn.o0u0o.service.video.entity.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Caleb Chen
 * @create 2021-05-03 17:31
 */
@Data
public class VideoInfoForm {
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
    //点踩数
    private String downNumber;
    //类型
    private List<String> zoneType;
    //视频状态
    private Integer videoStatus;
}
