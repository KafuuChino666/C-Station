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
        workFlowQueryWrapper.eq("is_delete",0);
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

    /**
     * 根据id修改视频默认审核工作流
     *
     * 注意：因为更新默认工作流会导致现有视频审核数据不一致，
     * 当更换默认工作流将默认未完成上一审核工作流的任务节点重新设置为当前要设置的默认工作流的第一个节点
     * @param id
     * @return
     */
    @Override
    public boolean upDateWordUsableById(Integer id) {

        // 修改默认工作流
        vVideoStatusMapper.updateUsable();
        vVideoStatusMapper.updateUsableById(1, id);
        // 将未完成的任务节点重置

        // 查询第一个节点
//        vVideoStatusMapp

        return false;
    }

    @Override
    public boolean validateWorkFlowName(String workFlowName) {
        Integer line = vVideoStatusMapper.selectByWorkFlowName(workFlowName);
        return line == 0;
    }

}
