/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import db.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cero
 */
public class Transaksi {
    private int id;
    private String tanggal;
    private Pelanggan pelanggan;
    
    private Database database;
    private Connection connection;

    
    
    public boolean create(){
        String insertSQL = "INSERT INTO transaksi VALUES (NULL, ?, ?)";
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(insertSQL);
            preparedStatement.setInt(1, this.pelanggan.getId());
            preparedStatement.setString(2, this.tanggal);
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Pelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean delete(){
        String deleteSQL = "DELETE FROM transaksi WHERE id = ?";
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(deleteSQL);
            preparedStatement.setInt(1, this.id);
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Pelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public ArrayList<Transaksi> read(){
        ArrayList<Transaksi> list = new ArrayList<>();
        
        String selectSQL = "SELECT transaksi.*, pelanggan.namapelanggan FROM transaksi \n" +
"INNER JOIN Pelanggan ON transaksi.idpelanggan = pelanggan.id" ;
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try{
            PreparedStatement preparedStatement = this.connection.prepareStatement(selectSQL);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Transaksi tr = new Transaksi();
                
                tr.setId(rs.getInt("id"));
                tr.setTanggal(rs.getString("tanggal"));
                
                Pelanggan pg = new Pelanggan();
                pg.setId(rs.getInt("idpelanggan"));
                pg.setNamapelanggan(rs.getString("namapelanggan"));
                
                tr.setPelanggan(pg);
                
                list.add(tr);
            }
            
            return list;
            
        } catch (SQLException ex) {
            Logger.getLogger(Pelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public ArrayList<Transaksi> search(String keywords){
        keywords = "%" + keywords + "%";
        ArrayList<Transaksi> list = new ArrayList<>();
        
        String selectSQL = "SELECT transaksi.*, pelanggan.namapelanggan FROM transaksi \n" +
"INNER JOIN Pelanggan ON transaksi.idpelanggan = pelanggan.id "
                + "WHERE tanggal like ? OR namapelanggan like ?" ;
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try{
            PreparedStatement preparedStatement = this.connection.prepareStatement(selectSQL);
            preparedStatement.setString(1, keywords);
            preparedStatement.setString(2, keywords);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Transaksi tr = new Transaksi();
                
                tr.setId(rs.getInt("id"));
                tr.setTanggal(rs.getString("tanggal"));
                
                Pelanggan pg = new Pelanggan();
                pg.setId(rs.getInt("idpelanggan"));
                pg.setNamapelanggan(rs.getString("namapelanggan"));
                
                tr.setPelanggan(pg);
                
                list.add(tr);
                
            }
            
            return list;
            
        } catch (SQLException ex) {
            Logger.getLogger(Pelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public void find(){
        
        String selectSQL = "SELECT transaksi.*, pelanggan.namapelanggan FROM transaksi \n" +
"INNER JOIN Pelanggan ON transaksi.idpelanggan = pelanggan.id "
                + "WHERE transaksi.id = ?" ;
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try{
            PreparedStatement preparedStatement = this.connection.prepareStatement(selectSQL);
            preparedStatement.setInt(1, this.id);
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                
                setId(rs.getInt("id"));
                setTanggal(rs.getString("tanggal"));
                
                Pelanggan pg = new Pelanggan();
                pg.setId(rs.getInt("idpelanggan"));
                pg.setNamapelanggan(rs.getString("namapelanggan"));
                
                setPelanggan(pg);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Pelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public void setPelanggan(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }

    
    
    
}
