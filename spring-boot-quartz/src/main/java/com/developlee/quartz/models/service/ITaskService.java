package com.developlee.quartz.models.service;

import com.developlee.quartz.models.domain.vo.TaskEntity;

import java.util.List;

/**
 * @author Lensen
 * @desc
 * @since 2018/8/8 13:38
 */
public interface ITaskService {
    /**
     * @param taskEntity
     * @return
     * @// TODO: 2018/6/1 查询定时任务队列
     */
    List<TaskEntity> findTaskList(TaskEntity taskEntity);


    /**
     * @param taskEntity
     * @// TODO: 2018/6/1 停止任务
     */
    Boolean pauseTask(TaskEntity taskEntity);

    /**
     * @param taskEntity
     * @// TODO: 2018/6/1 重建任务
     */
    Boolean updateTask(TaskEntity taskEntity);

    /**
     * @param taskEntity
     * @return
     * @// TODO: 2018/6/5 删除任务
     */
    Boolean deleteTask(TaskEntity taskEntity);


    Boolean addTask(TaskEntity taskEntity);

    /**
     * @param taskEntity
     * @return
     * @// TODO: 2018/6/8 恢复定时任务
     */
    Boolean resumeTask(TaskEntity taskEntity);
}
