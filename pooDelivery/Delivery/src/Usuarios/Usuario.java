package Usuarios;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.Console;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Locale; 

public class Usuario{
    public Scanner scan = new Scanner(System.in);
    private String nome;
    private String senha;
    private String email;
    private String endereco;
    private String cidade;
    private int cep;
    private int cpf;
    private int rg;
    private int telefone;   
    private String ip;

   
    /**
     * @param name
     * @param pass
     * @return
     */
    public boolean logar(String name, String pass){
        if(name.equalsIgnoreCase(this.nome) && pass.equals(this.senha)) return true;
        return false;
    }
    public char[] readPassword(String string) {
        return readPassword("");
    }
    /**
     * @param novo
     * @return 
     */
    public void cadastraUsuario(){
        //Usuario this = new Usuario();
        System.out.println("Digite o nome: ");
        this.nome = scan.next();
        System.out.println("Digite a senha: ");
        Console console = System.console();
        this.senha =  new String(console.readPassword());
        System.out.println("Digite o E-mail: ");
        this.email =  scan.next();
        System.out.println("Digite o endereço: ");
        this.endereco =  scan.next();
        System.out.println("Digite a cidade: ");
        this.cidade = scan.next();
        try{
            System.out.println("Digite o CEP: ");
            this.cep = scan.nextInt();
        }
        catch(InputMismatchException e){
            scan.nextLine();
            System.out.println("Digite apenas valores numericos!");
            this.cep = scan.nextInt();
        }
        try {
            System.out.println("Digite o CPF:");
            this.cpf = scan.nextInt();
        }
        catch(InputMismatchException e){
            scan.nextLine();
            System.out.println("Digite apenas valores numericos!");
            this.cpf = scan.nextInt();
        } 
        try {
            System.out.println("Digite o RG:");
            this.rg = scan.nextInt();
        }
        catch(InputMismatchException e){
            scan.nextLine();
            System.out.println("Digite apenas valores numericos!");
            this.rg= scan.nextInt();
        } 
        try {
            System.out.println("Digite o telefone:");
            this.telefone = scan.nextInt();
        }
        catch(InputMismatchException e){
            scan.nextLine();
            System.out.println("Digite apenas valores numericos!");
            this.telefone = scan.nextInt();
        }
                
       
        
        
    }
    
    public void alterardadospessoais(){
        System.out.println("Qual dado deseja atualizar?\nDigite o valor corespondente\nNome     - 1\nSenha    - 2\nE-mail   - 3\nEndereço - 4\nCPF      - 5\nRG       - 6\nTelefone - 7");
        int var = scan.nextInt();
        System.out.println("\n");
        switch(var){
            case 1:
               System.out.println("Digite o novo nome: ");
               this.nome = scan.next();
               break;
            case 2:
               System.out.println("Digite a nova senha: ");
               this.senha =  scan.next();
               break;
            case 3:
               System.out.println("Digite o novo E-mail: ");
               this.email =  scan.next();
               break;
            case 4:
               System.out.println("Digite o novo endereço: ");
               this.endereco =  scan.next();
               System.out.println("É na mesma cidade?\nSim - 1, Não - 0");
               int v = scan.nextInt();
               if(v == 1){
                   break;
               }
               System.out.println("Digite a nova cidade: ");
               this.cidade = scan.next();
               System.out.println("Digite o novo CEP: ");
               this.cep = scan.nextInt();
               break;
            case 5:
               System.out.println("Digite o novo CPF:");
               this.cpf = scan.nextInt();
               break;
            case 6:
               System.out.println("Digite o novo RG:");
               this.rg = scan.nextInt();
               break;
            case 7:
               System.out.println("Digite o novo telefone:");
               this.telefone = scan.nextInt();
               break;
        }
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIp(){
        return this.ip;
    }

    public boolean Altenticar(String Nome, String Senha){
       if(Nome.equals(this.nome) && Senha.equals(this.senha)){
        return true;
       }
       return false;
    }
}