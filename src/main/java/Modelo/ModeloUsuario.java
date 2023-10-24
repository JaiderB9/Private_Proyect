package Modelo;

import Controlador.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class ModeloUsuario {

    /* Creamos los atributos o variables  que necesita para realizar los procesos de base de datos*/
    private int doc, sex, rol;
    private String nom, dir, tel, cor, lo, cl;
    private Date fec;

    /*Creamos los getter y setter*/
    public int getDoc() {
        return doc;
    }

    public void setDoc(int doc) {
        this.doc = doc;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getLo() {
        return lo;
    }

    public void setLo(String lo) {
        this.lo = lo;
    }

    public String getCl() {
        return cl;
    }

    public void setCl(String cl) {
        this.cl = cl;
    }

    public Date getFec() {
        return fec;
    }

    public void setFec(Date fec) {
        this.fec = fec;
    }

    /*Creamos el metodo para llenar los combos a través de Map o diccionario*/
    public Map<String, Integer> llenarCombo(String valor) {
        //Llamamos a la clase conexión
        Conexion conect = new Conexion();
        Connection cn = conect.iniciarConexion();//Instanciamos la conexion
        String sql = "Select * from mostrar_" + valor;

        Map<String, Integer> llenar_combo = new HashMap<>();
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                llenar_combo.put(rs.getString(2), rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return llenar_combo;
    }

    public void insertarUsuario() {
        //Llamamos a la clase conexión
        Conexion conect = new Conexion();
        Connection cn = conect.iniciarConexion();//Instanciamos la conexion
        
        String sql="Call ins_usuario(?,?,?,?,?,?,?,?,?,?)";//Consulta a realizar a la base de datos
        try {
            PreparedStatement ps= cn.prepareStatement(sql);
            ps.setInt(1,getDoc());
            ps.setString(2, getNom());
            ps.setString(3, getTel());
            ps.setString(4, getCor());
            ps.setString(5, getDir());
            ps.setDate(6, getFec());
            ps.setInt(7, getSex());
            ps.setInt(8, getRol());
            ps.setString(9, getLo());
            ps.setString(10, getCl());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro Almacenado");
            cn.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar", "Error", JOptionPane.ERROR_MESSAGE);
        }
        conect.cerrarConexion();
    }

}
