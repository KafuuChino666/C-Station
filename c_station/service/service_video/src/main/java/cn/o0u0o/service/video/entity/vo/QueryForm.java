package cn.o0u0o.service.video.entity.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author Caleb Chen
 * @create 2021-05-03 17:21
 */
@Data
public class QueryForm {
    //视频id
    private Integer id;
    //视频标题
    private String videoTitle;
    //uuid
    private Integer authorId;
    //开始时间
    private Date startTime;
    //结束时间
    private Date endTime;
    //播放量
    private String playNub;
    //视频状态
    private Integer videoStatus;

    @Override
    public String toString() {
        return "QueryForm{" +
                "id=" + id +
                ", videoTitle='" + videoTitle + '\'' +
                ", authorId=" + authorId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", playNub='" + playNub + '\'' +
                ", videoStatus=" + videoStatus +
                '}';
    }
}
