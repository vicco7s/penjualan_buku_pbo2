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
public class Penjualan {
    private int id;
    private double hargajual;
    private int jumlah;
    private Buku buku;
    private Pelanggan pelanggan;
    
    private Database database;
    private Connection connection;

     public boolean create(){
        String insertSQL = "INSERT INTO penjualan VALUES (NULL, ?, ?, ?, ?)";
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(insertSQL);
            preparedStatement.setInt(1, this.pelanggan.getId());
            preparedStatement.setInt(2, this.buku.getId());
            preparedStatement.setDouble(3, this.hargajual);
            preparedStatement.setInt(4, this.jumlah);
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Penjualan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
   
    
    public boolean delete(){
        String deleteSQL = "DELETE FROM penjualan WHERE id = ?";
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(deleteSQL);
            preparedStatement.setInt(1, this.id);
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Penjualan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public ArrayList<Penjualan> read(){
        ArrayList<Penjualan> list = new ArrayList<>();
        
        String selectSQL = "SELECT penjualan.*, pelanggan.namapelanggan, buku.namabuku FROM penjualan \n" +
"INNER JOIN pelanggan ON penjualan.idpelanggan = pelanggan.id INNER JOIN buku on penjualan.idbuku = buku.id" ;
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try{
            PreparedStatement preparedStatement = this.connection.prepareStatement(selectSQL);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Penjualan pj = new Penjualan();
                
                pj.setId(rs.getInt("id"));
                pj.setHargajual(rs.getDouble("hargajual"));
                pj.setJumlah(rs.getInt("jumlah"));
                
                Pelanggan pg = new Pelanggan();
                pg.setId(rs.getInt("idpelanggan"));
                pg.setNamapelanggan(rs.getString("namapelanggan"));
                
                pj.setPelanggan(pg);
                
                Buku bk = new  Buku();
                bk.setId(rs.getInt("idbuku"));
                bk.setNamaBuku(rs.getString("namabuku"));
                
                pj.setBuku(bk);
                
                list.add(pj);
            }
            
            return list;
            
        } catch (SQLException ex) {
            Logger.getLogger(Pelanggan.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(Buku.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public ArrayList<Penjualan> search(String keywords){
        keywords = "%" + keywords + "%";
        ArrayList<Penjualan> list = new ArrayList<>();
        
        String selectSQL = "SELECT penjualan.*, pelanggan.namapelanggan, buku.namabuku FROM penjualan \n" +
"INNER JOIN pelanggan ON penjualan.idpelanggan = pelanggan.id INNER JOIN buku on penjualan.idbuku = buku.id "
                + "WHERE hargajual like ? OR namapelanggan like ? OR namabuku like ?" ;
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try{
            PreparedStatement preparedStatement = this.connection.prepareStatement(selectSQL);
            preparedStatement.setString(1, keywords);
            preparedStatement.setString(2, keywords);
            preparedStatement.setString(3, keywords);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Penjualan pj = new Penjualan();
                
                pj.setId(rs.getInt("id"));
                pj.setHargajual(rs.getDouble("hargajual"));
                pj.setJumlah(rs.getInt("jumlah"));
                
                Pelanggan pg = new Pelanggan();
                pg.setId(rs.getInt("idpelanggan"));
                pg.setNamapelanggan(rs.getString("namapelanggan"));
                
                pj.setPelanggan(pg);
                
                Buku bk = new  Buku();
                bk.setId(rs.getInt("idbuku"));
                bk.setNamaBuku(rs.getString("namabuku"));
                
                pj.setBuku(bk);
                
                list.add(pj);
            }
            
            return list;
            
        } catch (SQLException ex) {
            Logger.getLogger(Pelanggan.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(Buku.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public void find(){
        
        String selectSQL = "SELECT penjualan.*, pelanggan.namapelanggan, buku.namabuku FROM penjualan \n" +
"INNER JOIN pelanggan ON penjualan.idpelanggan = pelanggan.id INNER JOIN buku on penjualan.idbuku = buku.id "
                + "WHERE penjualan.id = ?" ;
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try{
            PreparedStatement preparedStatement = this.connection.prepareStatement(selectSQL);
            preparedStatement.setInt(1, this.id);
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                
                setId(rs.getInt("id"));
                setHargajual(rs.getDouble("hargajual"));
                setJumlah(rs.getInt("jumlah"));
                
                Pelanggan pg = new Pelanggan();
                pg.setId(rs.getInt("idpelanggan"));
                pg.setNamapelanggan(rs.getString("namapelanggan"));
                
                setPelanggan(pg);
                
                Buku bk = new  Buku();
                bk.setId(rs.getInt("idbuku"));
                bk.setNamaBuku(rs.getString("namabuku"));
                
                setBuku(bk);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Pelanggan.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(Buku.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getHargajual() {
        return hargajual;
    }

    public void setHargajual(double hargajual) {
        this.hargajual = hargajual;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public Buku getBuku() {
        return buku;
    }

    public void setBuku(Buku buku) {
        this.buku = buku;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public void setPelanggan(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
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
//SELECT penjualan.*, pelanggan.namapelanggan, buku.namabuku FROM penjualan INNER JOIN pelanggan ON penjualan.idpelanggan= pelanggan.id INNER JOIN buku on penjualan.idbuku = buku.id;