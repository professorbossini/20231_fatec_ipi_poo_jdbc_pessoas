import java.sql.DriverManager;
import java.sql.Connection;
public class TesteConexao{
  public static void main(String[] args) {
    try{
      Connection conexao = DriverManager.getConnection(
        "jdbc:postgresql://localhost:5432/20231_ipi_poo_pessoas",
        "postgres",
        "postgres"
      );
      System.out.println(conexao);
    }
    catch(Exception e){
      e.printStackTrace();  
    }
  }

  public int somar(int a, int b){
    return a + b;
  }
}