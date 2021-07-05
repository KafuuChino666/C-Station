package cn.o0u0o.service.video.entity.vo;

import lombok.Data;

import java.util.ArrayList;

/**
 * @author Guo Yangyang
 * @version 1.0
 * @date 2021/7/5 16:54
 */
@Data
public class ZoneHierarchy {
    private Integer id;
    private String title;
    private Integer sort;
    private ArrayList<ZoneHierarchy> children = new ArrayList<>();
}
