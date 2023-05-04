import java.sql.*;
import java.util.*;
//data access object
public class PessoaDAO {
  //CRUD: CREATE, READ, UPDATE, DELETE
  public void cadastrar(Pessoa pessoa) throws Exception{
    //1. Especificar o comando SQL
    String sql = "INSERT INTO tb_pessoa (nome, fone, email) VALUES (?, ?, ?)";
    //2. Abrir uma conexão com o banco
    // var factory = new ConnectionFactory();
    Connection conexao = ConnectionFactory.obterConexao();
    //3. Preparar o comando SQL
    PreparedStatement ps = conexao.prepareStatement(sql);
    //4. Substituir os eventuais placeholders
    ps.setString(1, pessoa.getNome());
    ps.setString(2, pessoa.getFone());
    ps.setString(3, pessoa.getEmail());
    //5. Executar o comando
    ps.execute();
    //6. fecha as coisas  
    ps.close();
    conexao.close();
  }

  public void apagar (Pessoa p) throws Exception{
    //1. Especificar o comando SQL
    String sql = "DELETE FROM tb_pessoa WHERE cod_pessoa = ?";
    //2. Abrir uma conexão
    Connection conexao = ConnectionFactory.obterConexao();
    //3. Preparar o comando
    PreparedStatement ps = conexao.prepareStatement(sql);
    //4. Substituir os eventuais placeholders
    ps.setInt(1, p.getCodigo());
    //5. Executar
    ps.execute();
    //6. Fechar as coisas
    ps.close();
    conexao.close();    
  }

  Pessoa buscarPeloCodigo(int codigo) throws Exception{
    String sql = "SELECT nome, fone, email FROM tb_pessoa WHERE cod_pessoa = ?";
    //try-with-resources
    try(
      Connection conexao = ConnectionFactory.obterConexao();
      PreparedStatement ps = conexao.prepareStatement(sql);
    ){
      ps.setInt(1, codigo);
      ResultSet rs = ps.executeQuery();
      return rs.next() ? new Pessoa(rs.getString("nome"), rs.getString("fone"), rs.getString("email")) : null;
    }
  }

  List <Pessoa> listar() throws Exception{
    List <Pessoa> pessoas = new LinkedList <>();
    //1. Especificar o comando SQL (SELECT)
    String sql = "SELECT * FROM tb_pessoa";
    //2. Abrir uma conexão com o PostgreSQL
    //3. Preparar o comando
    //4. Substituir os eventuais placeholders
    //5. Executar
    try(Connection conexao = ConnectionFactory.obterConexao();
          PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
        //6. Manipular os dados da tabela
        while(rs.next()){
          int codigo = rs.getInt("cod_pessoa");
          String nome = rs.getString("nome");
          String fone = rs.getString("fone");
          String email = rs.getString("email");
          Pessoa p = new Pessoa(codigo, nome, fone, email);
          pessoas.add(p);
        }
        //7. Fechar os recursos
        // já foi feito pelo try-with-resources
        return pessoas;
    }
  }

}
