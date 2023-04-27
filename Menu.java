import javax.swing.JOptionPane;

public class Menu {
  public static void main(String[] args) {
    //1. Cadastrar
    //2. Atualizar
    //3. Remover
    //4. Visualizar dados de uma pessoa
    //5. Visualizar todas as pessoas
    //6. Sair
    String opcoes = "1-Cadastrar\n2-Atualizar\n3-Remover\n4-Visualizar uma pessoa\n5-Visualizar todas as pessoas\n6-Sair";
    int op = 6;
    var dao = new PessoaDAO();
    do{
      try{
        op = Integer.parseInt(JOptionPane.showInputDialog(opcoes));
        switch(op){
          case 1:
            String nome = JOptionPane.showInputDialog("Nome?");
            String fone = JOptionPane.showInputDialog("Fone?");
            String email = JOptionPane.showInputDialog("Email?");
            dao.cadastrar(new Pessoa(nome, fone, email));
            JOptionPane.showMessageDialog(null, "Cadastro ok!");
          break;  
        }
      }
      catch (Exception e){
        e.printStackTrace();
      }
    }while (op != 6);
  }
}
