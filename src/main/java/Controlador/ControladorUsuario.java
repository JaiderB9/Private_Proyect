/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ModeloUsuario;
import Vista.Nuevo_Usuario;
import Vista.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class ControladorUsuario implements ActionListener {

    Nuevo_Usuario nuevo = new Nuevo_Usuario();
    Principal prin = new Principal();
    ModeloUsuario usu = new ModeloUsuario();

    public ControladorUsuario() {
        nuevo.getBtnGuardar().addActionListener(this);
    }

    public void control() {
        /*Al cerrar la ventana nuevo no cierra el programa sino que abre la ventana principal*/
        nuevo.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                prin.setVisible(true);
            }
        });
        prin.setVisible(false);//Cierra la ventana principal para a que solo se visualice la ventana de nuevo usuario
        nuevo.setLocationRelativeTo(null);//Centra la vista
        nuevo.setVisible(true);

        //Lleno el combobox de sexo
        nuevo.getJcvsexo().addItem("Seleccione...");
        Map<String, Integer> dato = usu.llenarCombo("sexo");
        for (String sexo : dato.keySet()) {
            nuevo.getJcvsexo().addItem(sexo);
        }
        //Lleno el combobox de rol
        nuevo.getCbxCargo().addItem("Seleccione...");
        Map<String, Integer> datos = usu.llenarCombo("rol");
        for (String rol : datos.keySet()) {
            nuevo.getCbxCargo().addItem(rol);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(nuevo.getBtnGuardar())) {
            if (nuevo.getTxtDocumento().getText().isEmpty() || nuevo.getTxtNombre().getText().isEmpty() || nuevo.getTxtCorreo().getText().isEmpty()
                    || nuevo.getTxtDireccion().getText().isEmpty() || nuevo.getTxtLogin().getText().isEmpty() || nuevo.getTxtTelefono().getText().isEmpty()
                    || nuevo.getJcvsexo().getSelectedItem().equals("Seleccione...") || nuevo.getCbxCargo().getSelectedItem().equals("Seleccione...")
                    || nuevo.getJdFecha().getDate() == null) {
                JOptionPane.showMessageDialog(null, "Debe completar los campos requeridos...");
            } else {
                String valorSexo = nuevo.getJcvsexo().getSelectedItem().toString();
                int sexo = usu.llenarCombo("sexo").get(valorSexo);
            }

        }

    }

}
