package cn.o0u0o.service.security.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import cn.o0u0o.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Guo Yangyang
 * @since 2021-04-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("acl_menu")
@ApiModel(value="Menu对象", description="")
public class Menu extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "父级ID")
    private String parentId;

    @ApiModelProperty(value = "组件名称")
    private String name;

    @ApiModelProperty(value = "前端名称")
    private String title;

    @ApiModelProperty(value = "前端图标")
    private String icon;

    @ApiModelProperty(value = "访问路径")
    private String path;

    @ApiModelProperty(value = "重定向")
    private String redirect;

    @ApiModelProperty(value = "组件路径")
    private String component;

    @ApiModelProperty(value = "是否有下一级")
    private Integer hasChildren;

    @ApiModelProperty(value = "菜单排序")
    private Integer sort;

    @ApiModelProperty(value = "前端隐藏")
    private Integer hidden;

    public Boolean getHidden() {
        if (hidden == null) return false;
        return hidden == 1;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden ? 1 : 0;
    }
}
