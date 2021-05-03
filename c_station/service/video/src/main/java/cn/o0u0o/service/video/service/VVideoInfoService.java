package cn.o0u0o.service.video.service;

import cn.o0u0o.service.video.entity.VVideoInfo;
import cn.o0u0o.service.video.entity.vo.QueryForm;
import cn.o0u0o.service.video.entity.vo.TableData;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Caleb Chen
 * @since 2021-04-20
 */
public interface VVideoInfoService extends IService<VVideoInfo> {

    TableData selectVideoByTerm(QueryForm queryForm);

}
