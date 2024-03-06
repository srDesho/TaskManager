package com.cristianml.logic;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CheckBoxTableExample extends JFrame {
    public CheckBoxTableExample() {
        // Crear los datos de ejemplo para la tabla
        Object[][] data = {
                {"Elemento 1", false},
                {"Elemento 2", false},
                {"Elemento 3", false}
        };

        // Crear los nombres de las columnas
        String[] columnNames = {"Nombre", "Seleccionado"};

        // Crear el modelo de la tabla con los datos y los nombres de las columnas
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Hacer que la primera columna no sea editable
                return column == 0;
            }
        };

        // Crear la tabla con el modelo
        JTable table = new JTable(model);

        // Configurar el MouseListener para la tabla
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) { // Verificar si se hizo clic con el botón izquierdo
                    int column = table.getColumnModel().getColumnIndexAtX(e.getX()); // Obtener la columna clicada
                    int row = e.getY() / table.getRowHeight(); // Obtener la fila clicada

                    // Si se hace clic en la columna de selección, cambiar el estado de la casilla de verificación
                    if (row < table.getRowCount() && column == 1) {
                        boolean currentValue = (boolean) table.getValueAt(row, column);
                        table.setValueAt(!currentValue, row, column);
                    }
                }
            }
        });

        // Desactivar la edición de la primera columna
        table.getColumnModel().getColumn(0).setCellEditor(null);
        // table.getColumnModel().getColumn(1).setCellEditor(null);

        // Agregar la tabla a un JScrollPane y añadirlo al contenido de la ventana
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);

        // Configurar la ventana
        setTitle("Tabla de Checkboxes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CheckBoxTableExample::new);
    }
}

