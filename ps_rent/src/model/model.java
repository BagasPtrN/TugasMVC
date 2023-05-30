/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.controller;
import koneksi.koneksi;
import view.view_rent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class model implements controller{
    String tp;

    @Override
    public void Simpan(view_rent sewa) throws SQLException {
         if(sewa.rbreg.isSelected()){
            tp = "Reguler";
        }
        else{
            tp = "VIP";
        }
        
        try {
           
            
            Connection con = koneksi.getKoneksi();
            String sql = "insert ps_rent values(?,?,?,?,?)";
            PreparedStatement prepare= con.prepareStatement(sql);
            
            prepare.setString(1, sewa.txtnama.getText());
            prepare.setString(2, tp);
            prepare.setString(3, (String) sewa.cbtipe.getSelectedItem());
            prepare.setString(4, sewa.txtlama.getText());
            prepare.setString(5, sewa.txtid.getText());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil di Simpan");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Masukan data dengan Benar!");
        }
        finally{
            Tampil(sewa);
            sewa.setLebarKolom();
            
        }
    }

    @Override
    public void Ubah(view_rent sewa) throws SQLException {
         if(sewa.rbreg.isSelected()){
            tp = "Reguler";
        }
        else{
            tp = "VIP";
        }
        
        try {
           
            
            Connection con = koneksi.getKoneksi();
            String sql = "update ps_rent set nama= ?, vip= ?, tipe= ?, lama= ? where id= ?";
            PreparedStatement prepare= con.prepareStatement(sql);
            
            prepare.setString(1, sewa.txtnama.getText());
            prepare.setString(2, tp);
            prepare.setString(3, (String) sewa.cbtipe.getSelectedItem());
            prepare.setString(4, sewa.txtlama.getText());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil di Ubah");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Masukan data dengan Benar!");
        }
        finally{
            Tampil(sewa);
            sewa.setLebarKolom();
            Baru(sewa);
        }
    }

    @Override
    public void Hapus(view_rent sewa) throws SQLException {
        try {
           
            
            Connection con = koneksi.getKoneksi();
            String sql = "delete from ps_rent where id= ?";
            PreparedStatement prepare= con.prepareStatement(sql);
            
            prepare.setString(1, sewa.txtid.getText());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil di Hapus");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        finally{
            Tampil(sewa);
            sewa.setLebarKolom();
            Baru(sewa);
        }
    }

    @Override
    public void Tampil(view_rent sewa) throws SQLException {
        sewa.tblmodel.getDataVector().removeAllElements();
      sewa.tblmodel.fireTableDataChanged();
      try {
          Connection con = koneksi.getKoneksi();
          Statement stt = con.createStatement();
          String sql = "select * from ps_rent order by id asc";
          ResultSet res = stt.executeQuery(sql);
          while(res.next())
          {
              Object[] ob= new Object[8];
              ob[0] = res.getString(1);
              ob[1] = res.getString(2);
              ob[2] = res.getString(3);
              ob[3] = res.getString(4);
              ob[4] = res.getString(5);
              sewa.tblmodel.addRow(ob);
          } 
      } catch (Exception e) {
          System.out.println(e);
      }
    }

    @Override
    public void Baru(view_rent sewa) {
        sewa.txtnama.setText("");
        sewa.txtid.setText("");
        sewa.rbreg.setSelected(true);
        sewa.cbtipe.setSelectedIndex(0);
        sewa.txtlama.setText("");
    }

    @Override
    public void KlikTabel(view_rent sewa) throws SQLException {
 try {
             int pilih = sewa.tabel.getSelectedRow();
             if (pilih == -1 ){    
                 return;
             }
             sewa.txtnama.setText(sewa.tblmodel.getValueAt(pilih, 0).toString());
             tp = String.valueOf(sewa.tblmodel.getValueAt(pilih, 1));
             sewa.cbtipe.setSelectedItem(sewa.tblmodel.getValueAt(pilih, 2).toString());
             sewa.txtlama.setText(sewa.tblmodel.getValueAt(pilih, 3).toString());
             sewa.txtid.setText(sewa.tblmodel.getValueAt(pilih, 4).toString());
             
             
             
             
                   
        } catch (Exception e) {
        }
        if(sewa.rbreg.getText().equals(tp)){
                  sewa.rbreg.setSelected(true);
             } 
        else{sewa.rbvip.setSelected(true);}
    }
    
}
