/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.viccodwi.penjualan_buku;

import frame.Login;
import frame.kasir.MainKasir;
import frame.owner.MainOwner;
import libs.Pref;
import model.Pengguna;

/**
 *
 * @author cero
 */
public class Main {
    public static void main(String[] args) {
        Pref pref = new Pref();
        Pengguna pengguna = pref.ambil();
        
        if (pengguna.getId() == 0) {
            Login login = new Login();
            login.setVisible(true);
        }else{
            if (pengguna.isIsAdmin()) {
                MainOwner mainowner = new MainOwner();
                mainowner.setVisible(true);
            }else {
                MainKasir mainkasir = new MainKasir();
                mainkasir.setVisible(true);
            }
        }
//        BarangViewFrame barangViewFrame = new BarangViewFrame();
//        barangViewFrame.setVisible(true);
    }
}
