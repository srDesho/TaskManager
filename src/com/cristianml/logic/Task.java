package com.cristianml.logic;

public class Task {
    private String txtTask;
    private boolean isCkeck;

    public Task(String txtTask, boolean isCkeck) {
        this.txtTask = txtTask;
        this.isCkeck = isCkeck;
    }

    public String getTxtTask() {
        return txtTask;
    }

    public void setTxtTask(String txtTask) {
        this.txtTask = txtTask;
    }

    public boolean isCkeck() {
        return isCkeck;
    }

    public void setCkeck(boolean ckeck) {
        isCkeck = ckeck;
    }
}
