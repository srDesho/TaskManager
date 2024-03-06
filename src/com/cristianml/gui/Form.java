package com.cristianml.gui;

import com.cristianml.logic.ListTask;
import com.cristianml.logic.Task;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Form {
    public JPanel panel;
    private JLabel lblWriteText;
    private JButton btnAdd;
    private JTextField textField1;
    private JTable table;
    List<Task> listTasks = new ArrayList<>();

    public Form() {
        DefaultTableModel model = new DefaultTableModel();
        // Added the colums on table
        model.addColumn("Task");
        model.addColumn("Complete");
        table.setModel(model);

        // Define the renderer and the editor of the column where you want to have the checkboxes.
        TableColumn checkboxColumn = table.getColumnModel().getColumn(1);
        checkboxColumn.setCellRenderer(table.getDefaultRenderer(Boolean.class));
        checkboxColumn.setCellEditor(table.getDefaultEditor(Boolean.class));

        Task task1 = new Task("Do school homework");
        Task task2 = new Task("Do school homework");
        Task task3 = new Task("Do school homework");
        Task task4 = new Task("Do school homework");
        Task task5 = new Task("Do school homework");
        listTasks.add(task1);
        listTasks.add(task2);
        listTasks.add(task3);
        listTasks.add(task4);
        listTasks.add(task5);
        refreshList(model);

        table.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
            }
        });

        // Disable editing of the first column
        table.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(new JTextField()) {
            @Override
            public boolean isCellEditable(java.util.EventObject e) {
                return false;
            }
        });
    }


    public void refreshList(DefaultTableModel model) {
        for (Task task : listTasks) {
            model.addRow(new Object[]{task.getTxtTask(), task.getIsCkeck()});
        }
    }

    public void setCheckTrue(DefaultTableModel model) {

    }


}
