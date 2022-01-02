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
public class Pelanggan {
    private int id;
    private String namapelanggan;
    
    private Database database;
    private Connection connection;

    @Override
    public String toString() {
        return namapelanggan;
    }

    public boolean create() {
        String insertSQL = "INSERT INTO pelanggan VALUES (NULL, ?)";
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(insertSQL);
            preparedStatement.setString(1, this.namapelanggan);
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Pelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
     public boolean update() {
        String updateSQL = "UPDATE pelanggan SET namapelanggan = ? WHERE id = ?";
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(updateSQL);
            preparedStatement.setString(1, this.namapelanggan);
            preparedStatement.setInt(2, this.id);
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
             Logger.getLogger(Pelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean delete() {
        String deleteSQL = "DELETE FROM pelanggan WHERE id = ?";
        
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
    
    public ArrayList<Pelanggan> read() {
        ArrayList<Pelanggan> list = new ArrayList<>();
        
        String selectSQL = "SELECT * FROM pelanggan" ;
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try{
            PreparedStatement preparedStatement = this.connection.prepareStatement(selectSQL);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Pelanggan pg = new Pelanggan();
                pg.setId(rs.getInt("id"));
                pg.setNamapelanggan(rs.getString("namapelanggan"));
                
                list.add(pg);
            }
            
            return list;
            
        } catch (SQLException ex) {
            Logger.getLogger(Pelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public boolean find() {
     String findSQL = "SELECT * FROM pelanggan WHERE id = ?";
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(findSQL);
            preparedStatement.setInt(1, this.id);
            
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                this.setNamapelanggan(rs.getString("namapelanggan"));
                return true;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Pelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    
    }
    
    public ArrayList<Pelanggan> search(String keyword){
    ArrayList<Pelanggan> list = new ArrayList<>();
        
        String searchSQL = "SELECT * FROM pelanggan WHERE namapelanggan like ?" ;
        
        keyword = "%" + keyword + "%";
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try{
            PreparedStatement preparedStatement = this.connection.prepareStatement(searchSQL);
            preparedStatement.setString(1, keyword);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Pelanggan pg = new Pelanggan();
                pg.setId(rs.getInt("id"));
                pg.setNamapelanggan(rs.getString("namapelanggan"));
                
                list.add(pg);
            }
            
            return list;
            
        } catch (SQLException ex) {
            Logger.getLogger(Pelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamapelanggan() {
        return namapelanggan;
    }

    public void setNamapelanggan(String namapelanggan) {
        this.namapelanggan = namapelanggan;
    }
    
    
}
