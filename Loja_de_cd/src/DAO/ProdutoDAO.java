/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import metodos.pro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author witallo
 */
public class ProdutoDAO {
Connection con;
    public ProdutoDAO() {
        con=Conexao.abrirConexao();
    }
    
    
    
    
    
    public void inserir_Pro(pro p) {
    try {
        PreparedStatement ps=con.prepareStatement("INSERT INTO `cd` (`id_cd`, `id_genero`, `capa`, `titulo`, `preco`, `anoLancamento`, `disponibilidade`, `descricao`, `artista`, `musica`, `promocao`, `desconto`, `por`, `venda`) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
        ps.setInt(1,p.getId_genero());
        ps.setString(2,p.getTitulo());
        ps.setString(3,p.getCapa());
        ps.setString(4,p.getPreco());
        ps.setString(5,p.getAnoLancamento());
        ps.setString(6,p.getDisponibilidade());
        ps.setString(7,p.getDescricao());
        ps.setString(8,p.getArtista());
        ps.setString(9,p.getMusica());
        ps.setString(10,p.getPromocao());
        ps.setString(11,p.getDesconto());
        ps.setString(12,p.getPor());
        ps.setString(13,p.getVenda());
        ps.executeUpdate();
        
    }catch(SQLException ex){
        System.out.println(ex);
    }finally{
        Conexao.fecharConexao(con);
    }
}


    public List<pro> listar_Pro(){
        List<pro> listar = new ArrayList<>();
    try{
    PreparedStatement ps = con.prepareStatement(" SELECT * FROM cd");
    ResultSet rs = ps.executeQuery();
    while(rs.next()){
     pro p = new pro();
     p.setTitulo(rs.getString("titulo"));
     p.setCapa(rs.getString("capa"));
     p.setPreco(rs.getString("preco"));
     p.setAnoLancamento(rs.getString("anoLancamento"));
     p.setDisponibilidade(rs.getString("disponibilidade"));
     p.setDescricao(rs.getString("descricao"));
     p.setPromocao(rs.getString("promocao"));
     p.setDesconto(rs.getString("desconto"));
     p.setPor(rs.getString("por"));
     p.setArtista(rs.getString("artista"));
     p.setMusica(rs.getString("musica"));
     p.setVenda(rs.getString("venda"));
     p.setId_genero(rs.getInt("id_genero"));
     p.setId_cd(rs.getInt("id_cd"));
     listar.add(p);
 }
}catch (SQLException ex){
System.out.println(ex);
 }finally{
        Conexao.fecharConexao(con);
    }
    return listar;
    }
    
    
    public void excluir_pro (pro p){
        try{
        PreparedStatement ps = con.prepareStatement(" DELETE FROM cd WHERE id_cd=?");
        ps.setInt(1,p.getId_cd());
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null, "Exluido com sucesso");;
        }catch (SQLException ex){
System.out.println(ex);
 }finally{
        Conexao.fecharConexao(con);
    }
    }
    
    
    public void atualizar_Pro(pro p){
    try {
        PreparedStatement ps=con.prepareStatement("UPDATE `cd` SET `id_genero`=?,`capa`=?,`titulo`=?,`preco`=?,`anoLancamento`=?,`disponibilidade`=?,`descricao`=?,`artista`=?,`musica`=?,`promocao`=?,`desconto`=?  WHERE \n" +
"id_cd =?");
       
        
        ps.setInt(1,p.getId_genero());
        ps.setString(2,p.getCapa());
        ps.setString(3,p.getTitulo());
        ps.setString(4,p.getPreco());
        ps.setString(5,p.getAnoLancamento());
        ps.setString(6,p.getDisponibilidade());
        ps.setString(7,p.getDescricao());
        ps.setString(8,p.getArtista());
        ps.setString(9,p.getMusica());
        ps.setString(10,p.getPromocao());
        ps.setString(11,p.getDesconto());
        ps.setInt(12,p.getId_cd());
        ps.executeUpdate();
        
    }catch(SQLException ex){
        System.out.println(ex);
    }finally{
        Conexao.fecharConexao(con);
    }
    }
    }
    

