package cn.o0u0o.service.security.entity.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MenuVo {
    private String id;
    private String name;
    private List<MenuVo> children = new ArrayList<>();

    public void setChildren(List<MenuVo> children) {
        this.children = children;
    }

    public List<MenuVo> getChildren() {
        return children.size() == 0 ? null : children;
    }
}
