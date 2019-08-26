package cn.itcast.service.system.impl;

import cn.itcast.dao.system.SysLogDao;
import cn.itcast.domain.system.SysLog;
import cn.itcast.service.system.SysLogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * 日志service接口实现类
 */
@Service
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private SysLogDao sysLogDao;


    @Override
    public PageInfo<SysLog> findByPage(String companyId, int pageNum, int pageSize) {

        // 开启分页
        PageHelper.startPage(pageNum,pageSize);
        // 查询全部日志列表
        List<SysLog> list = sysLogDao.findAll(companyId);
        // 构造 pagebeen
        return new PageInfo<>(list);
    }

    @Override
    public void save(SysLog sysLog) {
        sysLog.setId(UUID.randomUUID().toString());
        sysLogDao.save(sysLog);
    }
}
