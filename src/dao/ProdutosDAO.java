package dao;

import classes.Produto;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Produto> getProduto() {

        String sql = "SELECT * FROM produtos";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            List<Produto> listaFilmes = new ArrayList<>();

            while (rs.next()) {

                Produto produto = new Produto();

                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setValor(rs.getDouble("valor"));
                produto.setStatus(rs.getNString("status"));

                listaFilmes.add(produto);
            }

            return listaFilmes;

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }

    }

    public void venderProduto(Produto produto) {

        String sql = "UPDATE produtos SET status = ? WHERE id=?";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            stmt.setString(1, produto.getStatus());
            stmt.setInt(2, produto.getId());

            stmt.execute();

        } catch (Exception e) {
            System.out.println("Erro ao editar o filme: " + e.getMessage());
        }

    }

    public List<Produto> listarProdutosVendidos(){

        String sql = "SELECT * FROM produtos where status = 'Vendido'";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            List<Produto> listaFilmes = new ArrayList<>();

            while (rs.next()) {

                Produto produto = new Produto();

                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setValor(rs.getDouble("valor"));
                produto.setStatus(rs.getNString("status"));

                listaFilmes.add(produto);
            }

            return listaFilmes;

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }

    }

}
