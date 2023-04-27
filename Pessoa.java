public class Pessoa {
  private int codigo;
  private String nome;
  private String fone;
  private String email;

  public Pessoa(String nome, String fone, String email){
    setNome(nome);
    setFone(fone);
    setEmail(email);
  }
  
  public int getCodigo() {
    return codigo;
  }

  public String getEmail() {
    return email;
  }

  public String getFone() {
    return fone;
  }
  public String getNome() {
    return nome;
  }
  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  public void setFone(String fone) {
    this.fone = fone;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}
