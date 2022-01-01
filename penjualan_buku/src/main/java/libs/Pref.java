/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libs;

import model.Pengguna;
import java.util.prefs.Preferences;
/**
 *
 * @author cero
 */
public class Pref {
     public void simpan(Pengguna pengguna){
        Preferences preferences = Preferences.userNodeForPackage(Pref.class);
        preferences.putInt("5D_id", pengguna.getId());
        preferences.put("5D_username", pengguna.getUsername());
        preferences.put("5D_nama_lengkap", pengguna.getNamaLengkap());
        preferences.putBoolean("5D_is_admin", pengguna.isIsAdmin());
    }
    
    public Pengguna ambil(){
        Preferences preferences = Preferences.userNodeForPackage(Pref.class);
        
        Pengguna pengguna = new Pengguna();
        
        pengguna.setId(preferences.getInt("5D_id",0));
        pengguna.setUsername(preferences.get("5D_username", ""));
        pengguna.setNamaLengkap(preferences.get("5D_nama_lengkap", ""));
        pengguna.setIsAdmin(preferences.getBoolean("5D_is_admin", false));
        
        return pengguna;
        
    }
    
    public void hapus(){
        Preferences preferences = Preferences.userNodeForPackage(Pref.class);
        preferences.putInt("5D_id", 0);
        preferences.put("5D_username", "");
        preferences.put("5D_nama_lengkap", "");
        preferences.putBoolean("5D_is_admin", false);
    }
}
