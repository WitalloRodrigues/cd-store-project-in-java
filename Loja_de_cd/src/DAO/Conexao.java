/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
/**
 *
 * @author aluno
 */
public class Conexao {
    private static String url = "jdbc:mysql://localhost/loja_de_cd V2";  // Atributo responsável por armzana a enderço do servidor
    private static String login = "root"; // Atributo responsável por armazena o login do banco
    private static String senha = ""; // Atributo responsável por armaena a senha do banco
    
    public static Connection  abrirConexao(){
        Connection conn = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");  // Carrega o drive
            System.out.println("\nDriver carregado com sucesso!\n");
            conn = DriverManager.getConnection(url, login, senha);// Abri uma conexão com o banco
        } catch (Exception e){
           JOptionPane.showMessageDialog(null, "Erro de conexão");
        }
        return conn;
    }
    
    public static void fecharConexao(Connection conn){
        try {
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
