package Controlador;

import Modelo.ModeloUsuario;
import Vista.Nuevo_Usuario;
import Vista.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Map;
import javax.swing.JFrame;

public class ControladorPrincipal implements ActionListener {

    Principal prin = new Principal();//Instancia(Llama) la ventana principal
    Nuevo_Usuario nuevo = new Nuevo_Usuario();//Instanca (Llama) la ventana(vista) Nuevo usuario
    ModeloUsuario usu = new ModeloUsuario();//Instancia el modelo de 
    ControladorUsuario contUsua= new ControladorUsuario();

    
    public ControladorPrincipal() {
        prin.getBtnNuevo().addActionListener(this);//Agrega el boton nuevo para que se escuche cuando se de clic
        nuevo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//Desactiva la x que cierrar el programa para que permita abrir o volver a la ventana principal
    }

    public void iniciar() {
        prin.setLocationRelativeTo(null);//Centra la ventana
        prin.setTitle("Principal");//Le da titulo a la ventana
        prin.setVisible(true);//Hace visible la ventana
    }
   
    @Override
    public void actionPerformed(ActionEvent e) { //Valida los eventos
        if (e.getSource().equals(prin.getBtnNuevo())) {//Se crea al acción cuando le damos clic en el boton nuevo de la vista princial
            prin.setVisible(false);
            contUsua.control();
        }

    }

}
