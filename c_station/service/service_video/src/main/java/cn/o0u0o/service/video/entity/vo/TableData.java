package cn.o0u0o.service.video.entity.vo;

import lombok.Data;

/**
 * @author Caleb Chen
 * @create 2021-05-03 17:27
 */
@Data
public class TableData {
    //封面地址
    private String imgLocation;
    //视频标题
    private String videoTitle;
    //作者id
    private Integer authorId;
    //视频分类类型
    private String zoneType;
    //视频播放量
    private String playNub;
    //视频状态
    private Integer videoStatus;
}
