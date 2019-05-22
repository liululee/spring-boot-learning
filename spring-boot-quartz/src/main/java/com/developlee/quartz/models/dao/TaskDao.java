package com.developlee.quartz.models.dao;

import com.developlee.quartz.models.domain.vo.TaskEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskDao {
    /**
     * @return
     * @// TODO: 2018/6/5 查询任务
     */
    List<TaskEntity> findTaskList(TaskEntity taskEntity);
}
