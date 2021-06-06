package cn.o0u0o.service.security.entity.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Guo Yangyang
 * @version 1.0
 * @date 2021/6/6 21:05
 */
@Data
public class HierarchyMenu {

    private String id;
    private String name;
    private String icon;
    private String path;
    private String component;
    private String hidden;
    private List<MenuVo> children = new ArrayList<>();
}
