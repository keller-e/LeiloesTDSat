package dao;

import classes.Produto;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutosDAO {

    private Connection conn;
    private conectaDAO conexao;

    public ProdutosDAO() {
        this.conexao = new conectaDAO();
        this.conn = this.conexao.conectar();
    }

    public void cadastrarProduto(Produto produto) {

               String sql = "INSERT INTO produtos values(?,?,?,?)";

        try {

            PreparedStatement stmt = this.conn.prepareStatement(sql);

            stmt.setInt(1, produto.getId());
            stmt.setString(2, produto.getNome());
            stmt.setDouble(3, produto.getValor());
            stmt.setString(4, produto.getStatus());

            stmt.execute();

        } catch (SQLException ex) {
            System.out.println("Erro de conexão: " + ex.getMessage());
        }
    }

    /*
    ArrayList<Produto> listagem = new ArrayList<>();

    public ArrayList<Produto> listarProdutos() {

        return listagem;
    }
     */
}
