package cn.o0u0o.service.video.service.impl;

import cn.o0u0o.service.video.entity.WorkFlow;
import cn.o0u0o.service.video.mapper.VVideoStatusMapper;
import cn.o0u0o.service.video.mapper.WorkFlowMapper;
import cn.o0u0o.service.video.service.WorkFlowService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Guo Yangyang
 * @since 2021-06-02
 */
@Service
public class WorkFlowServiceImpl extends ServiceImpl<WorkFlowMapper, WorkFlow> implements WorkFlowService {

    @Autowired
    private WorkFlowMapper workFlowMapper;

    @Autowired
    private VVideoStatusMapper vVideoStatusMapper;
    
    @Override
    public IPage<WorkFlow> getVideoAuditWork(Integer page, Integer limit) {
        Page<WorkFlow> flowPage = new Page<>(page, limit);
        QueryWrapper<WorkFlow> workFlowQueryWrapper = new QueryWrapper<>();
        workFlowQueryWrapper.eq("status",1);
        workFlowQueryWrapper.eq("sign", "video_audit_flow");

        return workFlowMapper.selectPage(flowPage, workFlowQueryWrapper);
    }

    @Override
    public Boolean removeVideoAuditWork(Integer id) {

        Integer line = vVideoStatusMapper.getLineNumByFlowId(id);
        if (line == 0) {
            this.removeById(id);// 删除
            return true;
        }
        return false;
    }
}
