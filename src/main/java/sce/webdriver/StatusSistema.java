package sce.webdriver;

public enum StatusSistema {
	
    Esperando_Login(0, "Sistema aguarda usuário confirmar o login"),
    Login_Invalido(1, "Sistema apresenta mensagem de usuário inválido"),	
    Esperando_Acao(2, "Sistema aguarda uma ação do usuário"),
    Esperando_Acao_Usuario(3, "Sistema aguarda uma ação no objeto usuário"),
    Esperando_Acao_Empresa(4, "Sistema aguarda uma ação no objeto empresa"),
    Esperando_Acao_Estagio(5, "Sistema aguarda uma ação no objeto estagio"),
    Esperando_Acao_Relatorio(6, "Sistema aguarda uma ação no objeto relatorio"),
    Esperando_Acao_Convenio(7, "Sistema aguarda uma ação no objeto convenio"),
    Esperando_Acao_EstagioSuper(8, "Sistema aguarda uma ação no objeto estagio supervisionado"),
    Esperando_Acao_Upload(9, "Sistema aguarda uma ação no objeto Upload"),
    Esperando_Acao_Backup(10, "Sistema aguarda uma ação no objeto backup");
	
    private int codigo;
    private String descricao;
    
    StatusSistema(int codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo(){
        return this.codigo;
    }
    
    public String getDescricao(){
        return this.descricao;
    }		        

}
