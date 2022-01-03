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
public class Buku {
     private int id;
    private String namaBuku;
    private double harga;
    private JenisBuku jenisBuku;
    
    private Database database;
    private Connection connection;

    @Override
    public String toString() {
        return namaBuku;
    }
    
    
    
    public boolean create(){
        String insertSQL = "INSERT INTO buku VALUES (NULL, ?, ?, ?)";
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(insertSQL);
            preparedStatement.setInt(1, this.jenisBuku.getId());
            preparedStatement.setString(2, this.namaBuku);
            preparedStatement.setDouble(3, this.harga);
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(JenisBuku.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean update(){
        String updateSQL = "UPDATE buku SET idjenisbuku=?, namabuku=?, harga=? WHERE id = ?";
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(updateSQL);
            preparedStatement.setInt(1, this.jenisBuku.getId());
            preparedStatement.setString(2, this.namaBuku);
            preparedStatement.setDouble(3, this.harga);
            preparedStatement.setInt(4, this.id);
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(JenisBuku.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean delete(){
        String deleteSQL = "DELETE FROM buku WHERE id = ?";
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(deleteSQL);
            preparedStatement.setInt(1, this.id);
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Buku.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public ArrayList<Buku> read(){
        ArrayList<Buku> list = new ArrayList<>();
        
        String selectSQL = "SELECT buku.*, jenisbuku.namajenisbuku FROM buku \n" +
"INNER JOIN jenisbuku ON buku.idjenisbuku = jenisbuku.id" ;
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try{
            PreparedStatement preparedStatement = this.connection.prepareStatement(selectSQL);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Buku b = new Buku();
                
                b.setId(rs.getInt("id"));
                b.setNamaBuku(rs.getString("namabuku"));
                b.setHarga(rs.getDouble("harga"));
                
                JenisBuku jb = new JenisBuku();
                jb.setId(rs.getInt("idjenisbuku"));
                jb.setNamajenisbuku(rs.getString("namajenisbuku"));
                
                b.setJenisBuku(jb);
                
                list.add(b);
            }
            
            return list;
            
        } catch (SQLException ex) {
            Logger.getLogger(JenisBuku.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public ArrayList<Buku> search(String keywords){
        keywords = "%" + keywords + "%";
        ArrayList<Buku> list = new ArrayList<>();
        
        String selectSQL = "SELECT buku.*, jenisbuku.namajenisbuku FROM buku \n" +
"INNER JOIN jenisbuku ON buku.idjenisbuku = jenisbuku.id "
                + "WHERE namabuku like ? OR namajenisbuku like ?" ;
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try{
            PreparedStatement preparedStatement = this.connection.prepareStatement(selectSQL);
            preparedStatement.setString(1, keywords);
            preparedStatement.setString(2, keywords);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Buku b = new Buku();
                
                b.setId(rs.getInt("id"));
                b.setNamaBuku(rs.getString("namabuku"));
                b.setHarga(rs.getDouble("harga"));
                
                JenisBuku jb = new JenisBuku();
                jb.setId(rs.getInt("idjenisbuku"));
                jb.setNamajenisbuku(rs.getString("namajenisbuku"));
                
                b.setJenisBuku(jb);
                
                list.add(b);
            }
            
            return list;
            
        } catch (SQLException ex) {
            Logger.getLogger(JenisBuku.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public void find(){
        
        String selectSQL = "SELECT buku.*, jenisbuku.namajenisbuku FROM buku \n" +
"INNER JOIN jenisbuku ON buku.idjenisbuku= jenisbuku.id "
                + "WHERE buku.id = ?" ;
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try{
            PreparedStatement preparedStatement = this.connection.prepareStatement(selectSQL);
            preparedStatement.setInt(1, this.id);
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                
                setId(rs.getInt("id"));
                setNamaBuku(rs.getString("namabuku"));
                setHarga(rs.getDouble("harga"));
                
                JenisBuku jb = new JenisBuku();
                jb.setId(rs.getInt("idjenisbuku"));
                jb.setNamajenisbuku(rs.getString("namajenisbuku"));
                
                setJenisBuku(jb);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(JenisBuku.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaBuku() {
        return namaBuku;
    }

    public void setNamaBuku(String namaBuku) {
        this.namaBuku = namaBuku;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public JenisBuku getJenisBuku() {
        return jenisBuku;
    }

    public void setJenisBuku(JenisBuku jenisBuku) {
        this.jenisBuku = jenisBuku;
    }

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    
}
