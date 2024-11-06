package backend;
public class Adm extends Pessoa{
    
    private String Cargo;
    
    public Adm(String Email, String Senha, String Cargo){
        super(Email, Senha);
        this.Cargo = Cargo;
    }

    public String getCargo(){
        return Cargo;
    }

}
