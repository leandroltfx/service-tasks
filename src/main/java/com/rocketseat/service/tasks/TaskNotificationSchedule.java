package com.rocketseat.service.tasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskNotificationSchedule {

    private final TasksService tasksService;

    public TaskNotificationSchedule(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @Scheduled(fixedRate = 360000 * 24)
    public void checkAndNotifyTasks() {
        this.tasksService.sendNotificationForDueTasks();
    }

}
