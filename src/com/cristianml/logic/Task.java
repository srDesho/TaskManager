package com.cristianml.logic;

public class Task {
    private String txtTask;
    private boolean isCkeck;

    public Task() {
        this.isCkeck = false;
    }

    public Task(String txtTask) {
        this();
        this.txtTask = txtTask;
    }

    public String getTxtTask() {
        return txtTask;
    }

    public void setTxtTask(String txtTask) {
        this.txtTask = txtTask;
    }

    public boolean getIsCkeck() {
        return isCkeck;
    }

    public void setCkeck(boolean ckeck) {
        isCkeck = ckeck;
    }
}
