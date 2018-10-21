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
     * @// TODO: 2018/6/1 查询定时任务队列
     * @param taskEntity
     * @return
     */
    List<TaskEntity> findTaskList(TaskEntity taskEntity);


    /**
     * @// TODO: 2018/6/1 停止任务
     * @param taskEntity
     */
    Boolean pauseTask(TaskEntity taskEntity);

    /**
     * @// TODO: 2018/6/1 重建任务
     * @param taskEntity
     */
    Boolean updateTask(TaskEntity taskEntity);

    /**
     * @// TODO: 2018/6/5 删除任务
     * @param taskEntity
     * @return
     */
    Boolean deleteTask(TaskEntity taskEntity);


    Boolean addTask(TaskEntity taskEntity);

    /**
     * @// TODO: 2018/6/8 恢复定时任务
     * @param taskEntity
     * @return
     */
    Boolean resumeTask(TaskEntity taskEntity);
}
