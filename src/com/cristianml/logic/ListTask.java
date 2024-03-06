package com.cristianml.logic;

import java.util.ArrayList;
import java.util.List;

public class ListTask {
    private List<Task> tasksList;

    public ListTask() {
        this.tasksList = new ArrayList<>();
    }

    // add task
    public void addTask(Task task) {
        tasksList.add(task);
    }

}
