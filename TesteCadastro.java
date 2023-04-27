import javax.swing.JOptionPane;

public class TesteCadastro {
  public static void main(String[] args){
    Pessoa p = new Pessoa();
    p.setNome("Ana");
    p.setFone("11223344");
    p.setEmail("ana@email.com");
    PessoaDAO dao = new PessoaDAO();
    try{
      dao.cadastrar(p); 
      JOptionPane.showMessageDialog(null, "Ok, cadastrado!");
    }
    catch(Exception e){
      e.printStackTrace();
      JOptionPane.showMessageDialog(null, "Tente novamente mais tarde");
    }
  }
  
}
