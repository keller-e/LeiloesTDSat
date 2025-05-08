package dao;

import classes.Produto;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProdutosDAO {

    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<Produto> listagem = new ArrayList<>();

    public void cadastrarProduto(Produto produto) {

        //conn = new conectaDAO().connectDB();
    }

    public ArrayList<Produto> listarProdutos() {

        return listagem;
    }

}
