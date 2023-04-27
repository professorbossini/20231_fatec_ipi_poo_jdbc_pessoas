import java.sql.Connection;
import java.sql.PreparedStatement;
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

}
