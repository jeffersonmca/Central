package dao;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import modelo.Eleitor;
import conexao.Conexao;
import excecoes.IgualdadeDeObjetosException;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

public class EleitorDAO {
    
    /*Vetor de eleitores*/
    private ArrayList<Eleitor> eleitores;

    public EleitorDAO() {
        eleitores = new ArrayList();
    }
    
    /** Insere o eleitor na primeira posição vazia que achar do vetor.
     * @param eleitores É passado um obejto inteiro de eleitor para a inserção.
     */
    public void inserir(Eleitor eleitores) {
        this.eleitores.add(eleitores);
    }
    
    /**
     * Função utilizada com o intúido de retornar o vetor inteiro de eleitores.
     * @return Eleitor[] - Retorna o vetor de eleitores.
     */
    public ArrayList<Eleitor> getVetorEleitor(){
        return this.eleitores;
    }
    
    /**
     * Verifica se existe no vetor um eleitor idêntico ao passado por parâmetro.
     * @param e O Objeto inteiro do eleitor é passado para verificar no vetor se tem algum igual.
     * @throws IgualdadeDeObjetosException - Caso há um cadastro com o mesmo item de determinado campo.
     */
    public void igualdadeEleitor(Eleitor e) throws IgualdadeDeObjetosException {
        
        String campo = "";
        
        for (Eleitor eleitor : this.eleitores) {
            
            /*Trata o null pointer exception*/
            if (eleitor != null){
                
                /*Verifica se a imagem e igual*/
                if (eleitor.getImagem().equals(e.getImagem())){
                    campo = "IMAGEM";
                }
                
                /*Verifica se o titulo e igual*/
                if (eleitor.getNumeroTitulo().equals(e.getNumeroTitulo())){
                    campo = "TITULO";
                }
                
                /*Verifica se o cpf e igual*/
                if (eleitor.getCpf().equals(e.getCpf())){
                    campo = "CPF";
                }
            }
        }
        
        if (!campo.equals("")){
            throw new IgualdadeDeObjetosException("Há um cadastro com o mesmo item do campo " + campo + "...");            
        }
    }
    
    /**
     * Utilizada para baixar o Eleitor.json do Google Drive.
     * @throws IOException 
     */
    public void baixarEleitorJson() throws IOException{
        
        Gson gson = new Gson();
        
        /*Auxiliar para pegar o conteudo do arquivo*/
        String aux = null;        
        try {
            
            /*Verifica se a pasta existe*/
            String idPas = Conexao.existePasta("ArquivosJson"); 
            if (!(idPas.equals(""))){
                
                /*Verifica se o arquivo existe*/
                String idArq = Conexao.existeArquivo("Eleitor.json");            
                if (!(idArq.equals(""))){

                    /*Se existir o arquivo coloca nessa variavel o conteudo dele*/
                    aux = Conexao.printFile(idArq);
                }
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível baixar os dados dos eleitores, verifique sua conexão com a internet..", "Erro", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        
        /*Caso esta variavel esteja nula e porque nao ha o arquivo para baixar ou ele esta vazio*/
        if (aux != null){

            /*Exclui o .json que estava local*/
            File arq = new File("./ArquivosJson/Eleitor.json");
            arq.delete();
            
            /*Transforma cada linha do json em objeto do tipo eleitor e adiciona no vetor dinamico*/
            BufferedReader verifica = new BufferedReader(new StringReader(aux));        
            String linha;        
            while((linha = verifica.readLine()) != null){
                eleitores.add(gson.fromJson(linha, Eleitor.class)); 
                inserirJson(gson.fromJson(linha, Eleitor.class));
            }
        }
    }
    
    /**
     * Insere no arquivo Eleitor.json um objeto do tipo eleitor.
     * @param eleitor Insere um objeto inteiro do tipo eleitor no arquivo json.
     * @return boolean - Retorna true caso conseguiu realizar a inserção e false caso ocorreu algo de errado.
     */
    public boolean inserirJson(Eleitor eleitor){
        
        /*Verifica se a pasta local esta criada*/
        File dir = new File("ArquivosJson");
        
        /*Caso nao estiver entao cria*/
        dir.mkdirs();
        
        Gson gson = new Gson();
        
        FileWriter arq = null;
        try {
            arq = new FileWriter("./ArquivosJson/Eleitor.json", true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Houve algum erro ao salvar o eleitor no arquivo json", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        PrintWriter escreveArq = new PrintWriter(arq);
        escreveArq.printf("%s\n", gson.toJson(eleitor));
        
        try {
            arq.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Houve algum erro ao fechar o arquivo json", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
    
    /**
     * Envia o Eleitor.json local para o Google Drive.
     * @return boolean - Retorna true caso conseguiu realizar o envio e false caso ocorreu algo de errado.
     */
    public boolean enviaDrive(){
        
        try {
            
            /*Verifica se existe essa pasta no Google Drive*/
            String idPas = Conexao.existePasta("ArquivosJson");            
            if (idPas.equals("")){
                
                /*Se a pasta nao existir entao cria*/
                idPas = Conexao.criaPasta(Conexao.service(), "ArquivosJson");    
            }
            
            /*Verifica se existe esse arquivo no Google Drive*/
            String idArq = Conexao.existeArquivo("Eleitor.json");
            if (idArq.equals("")){                
                
                /*Se o arquivo nao existir entao cria*/
                idArq = Conexao.enviaArquivo(idPas, "Eleitor.json");
            }
            
            /*Remove o arquivo que esta no drive para nao criar varios dele mesmo*/
            Conexao.removeArquivo(idArq);
            
            /*Por fim, envia o json local para la*/
            Conexao.enviaArquivo(idPas, "Eleitor.json");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Houve erro ao conectar com o drive para salvar o arquivo..", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
}