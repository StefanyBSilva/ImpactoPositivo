package backend;
import java.util.regex.Pattern;

abstract class Pessoa {
    protected String Nome;
    protected String Senha;
    protected String Email;

    /* regex de validação da senha
     * caractere: minimo 8 maximo 14
     * uma lestra maiuscula e letra minuscula
     *1 numero
    */
    private static final String Senha_Regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z]{8,14}$";
    //regex de validação de email simples
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    //Construtor
    protected Pessoa(String Email, String Senha){
        if (!validarEmail(Email)){
            throw new IllegalArgumentException("Email inválido.");
        }
        if(!validarSenha(Senha)){
            throw new IllegalArgumentException("Senha invalida. A senha deve ter entre 8 e 14 caracteres, com pelo menos uma letra maiúscula e um número.");
        }
        this.Email = Email;
        this.Senha = Senha;
    }
    //Métodos de acesso
    public String getEmail(){
        return Email;
    }
    public String getSenha(){
        return Senha;
    }
    //metodo das validações com base nos regex
    private boolean validarSenha(String senha){
        return Pattern.matches(Senha_Regex, senha);
    }
    private boolean validarEmail(String email){
        return Pattern.matches(EMAIL_REGEX, email);
    }
    
}
