/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controller;

import java.sql.SQLException;
import view.view_rent;

/**
 *
 * @author USER
 */
public interface controller {
    public void Simpan(view_rent sewa) throws SQLException;         
    public void Ubah(view_rent sewa) throws SQLException;
    public void Hapus(view_rent sewa) throws SQLException;
    public void Tampil(view_rent sewa) throws SQLException;
    public void Baru(view_rent sewa);                               
    public void KlikTabel(view_rent sewa) throws SQLException;
}
