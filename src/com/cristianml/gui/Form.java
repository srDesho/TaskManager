package com.cristianml.gui;

import com.cristianml.logic.Task;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Form {
    public JPanel panel;
    private JLabel lblWriteText;
    private JButton btnAdd;
    private JTextField txtTask;
    private JTable table;
    List<Task> listTasks = new ArrayList<>();
    DefaultTableModel model = null;
    private Timer timer;

    public Form() {
        this.model = new DefaultTableModel();
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
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Task task = new Task(txtTask.getText());
                listTasks.add(task);
                model.addRow(new Object[]{task.getTxtTask(), task.getIsCkeck()});
                refreshList(model);
            }
        });

        // Initialize the timer
        timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic to remove the row from the table after 2 seconds
                if (table.getSelectedRow() != -1) {
                    listTasks.remove(table.getSelectedRow());
                    model.removeRow(table.getSelectedRow());
                }
                // Stop the timer after executing the action
                timer.stop();
            }
        });

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int columnaCheckbox = 1; // Índice de la columna de los checkboxes
                int filaSeleccionada = table.rowAtPoint(e.getPoint());
                int columnaSeleccionada = table.columnAtPoint(e.getPoint());

                // Obtener los límites del checkbox
                Rectangle checkboxBounds = table.getCellRect(filaSeleccionada, columnaCheckbox, true);

                // Verificar si el evento de clic ocurrió dentro de los límites del checkbox
                if (checkboxBounds.contains(e.getPoint())) {
                    boolean isChecked = (boolean) model.getValueAt(filaSeleccionada, columnaCheckbox);
                    if (isChecked) {
                        // Iniciar el temporizador
                        timer.restart();
                    }
                }
            }
        });
    }


    public void refreshList(DefaultTableModel model) {
        model.setRowCount(0); // This serves to empty the table
        // Add the task list to the table
        for (Task task : listTasks) {
            model.addRow(new Object[]{task.getTxtTask(), task.getIsCkeck()});
        }
    }

}
