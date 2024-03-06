package com.cristianml.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Form {
    public JPanel panel;
    private JLabel lblWriteText;
    private JButton btnAdd;
    private JTextField textField1;
    private JTable table;
    private DefaultTableModel model = new DefaultTableModel();

    public Form() {
        // Added the colums on table
        model.addColumn("Task");
        model.addColumn("Complete");
        table.setModel(model);

        // Define the renderer and the editor of the column where you want to have the checkboxes.
        TableColumn checkboxColumn = table.getColumnModel().getColumn(1);
        checkboxColumn.setCellRenderer(table.getDefaultRenderer(Boolean.class));
        checkboxColumn.setCellEditor(table.getDefaultEditor(Boolean.class));

        model.addRow(new Object[]{"Tarea 1", false});
        model.addRow(new Object[]{"Tarea 2", true});
    }
}
