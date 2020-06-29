/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Aluno
 */
public class AcessoDAO {
    Connection con;
    
    public AcessoDAO() {
    con=Conexao.abrirConexao();
}
     public boolean LogarAdm(String login, String senha){
    boolean finalResult= false;
    try{
    String consulta= "select login, senha from adm where login='" + login + "' and senha ='" + senha + "'";
    PreparedStatement ps= con.prepareStatement(consulta);
    ResultSet rs = ps.executeQuery();
    if(rs != null){
    while(rs.next()){
    finalResult= true;
    }//final do while
    }//final do if
    }catch (SQLException ex){
    ex.getMessage();
    }//final do catch
    return finalResult;
    }//final do logar
    public boolean LogarClie(String login, String senha){
    boolean finalResult= false;
    try{
    String consulta= "select email, senha from cliente where login='" + login + "' and senha ='" + senha + "'";
    PreparedStatement ps= con.prepareStatement(consulta);
    ResultSet rs = ps.executeQuery();
    if(rs != null){
    while(rs.next()){
    finalResult= true;
    }//final do while
    }//final do if
    }catch (SQLException ex){
    ex.getMessage();
    }//final do catch
    return finalResult;
    
    }//final do logar
    
}
