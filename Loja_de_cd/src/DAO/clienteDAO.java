/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import metodos.clie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Aluno
 */
public class clienteDAO {
Connection con;
    public clienteDAO() {
        con=Conexao.abrirConexao();
    }
    
    
    
    
    
    public void inserir_clie(clie c) {
    try {
        PreparedStatement ps=con.prepareStatement("insert into clie(nome,sobreNome,telefone,cpf,email,login,senha) values (?,?,?,?,?,?,?)");
        ps.setString(1,c.getNome());
        ps.setString(2,c.getSobreNome());
        ps.setString(3,c.getTelefone());
        ps.setString(4,c.getCpf());
        ps.setString(5,c.getEmail());
        ps.setString(6,c.getLogin());
        ps.setString(7,c.getSenha());
        ps.executeUpdate();
        
    }catch(SQLException ex){
        System.out.println(ex);
    }finally{
        Conexao.fecharConexao(con);
    }
}


    public List<clie> listar_Clie(){
        List<clie> listar = new ArrayList<>();
    try{
    PreparedStatement ps = con.prepareStatement(" SELECT * FROM cliente");
 ResultSet rs = ps.executeQuery();
 while(rs.next()){
     clie c = new clie();
     c.setNome(rs.getString("nome"));
     c.setSobreNome(rs.getString("sobreNome"));
     c.setTelefone(rs.getString("telefone"));
     c.setCpf(rs.getString("cpf"));
     c.setEmail(rs.getString("email"));
     c.setLogin(rs.getString("login"));
     c.setSenha(rs.getString("senha"));
     c.setId_cliente(rs.getInt("id_cliente"));
     listar.add(c);
 }
}catch (SQLException ex){
System.out.println(ex);
 }finally{
        Conexao.fecharConexao(con);
    }
    return listar;
    }
    
    
    public void excluir_clie (clie p){
        try{
        PreparedStatement ps = con.prepareStatement(" DELETE FROM cliente WHERE id_cliente=?");
        ps.setInt(1,p.getId_cliente());
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null, "Exluido com sucesso");
        }catch (SQLException ex){
System.out.println(ex);
 }finally{
        Conexao.fecharConexao(con);
    }
    }
    
    
    public void atualizar_clie(clie c){
    try {
        PreparedStatement ps=con.prepareStatement("UPDATE cliente SET nome=?,sbreNome=?,telefone=?,cpf=?,email=?,login=?,senha=?"
                + " WHERE id_cliente=?");
        ps.setString(1,c.getNome());
        ps.setString(2,c.getSobreNome());
        ps.setString(3,c.getTelefone());
        ps.setString(4,c.getCpf());
        ps.setString(5,c.getEmail());      
        ps.setString(6,c.getLogin());
        ps.setString(7,c.getSenha());
        ps.setInt(8,c.getId_cliente());
        ps.executeUpdate();
        
    }catch(SQLException ex){
        System.out.println(ex);
    }finally{
        Conexao.fecharConexao(con);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    }
    
}
