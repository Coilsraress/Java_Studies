package cesar;

public class CifraDeCesar {
    private Chave chave;
    private String mensagemCifrada;
    public CifraDeCesar(Chave chave) {
        this.chave = chave;
        this.mensagemCifrada = mensagemCifrada;
    }

    public String getMensagemCifrada(){
        return mensagemCifrada;
    }

    public String cifrar (String mensagem){
        StringBuilder retorno = new StringBuilder();
                for (char caractere : mensagem.toCharArray()) {
            
            if (!Character.isLetter(caractere)) {
                retorno.append(caractere);
                continue;
            }
            char base = Character.isUpperCase(caractere) ? 'A' : 'a';
            char cifrado = (char) (((caractere - base + chave.getDeslocamento()) % 26) + base);
            retorno.append(cifrado);
        }
        
        mensagemCifrada = retorno.toString();
        return mensagemCifrada;
    }

    public String decifrar(){
 StringBuilder retorno = new StringBuilder();
        
        for (char caractere : mensagemCifrada.toCharArray()) {
            if (!Character.isLetter(caractere)) {
                retorno.append(caractere);
                continue;
            }
            
            char base = Character.isUpperCase(caractere) ? 'A' : 'a';
            
            char decifrado = (char) (((caractere - base - chave.getDeslocamento() + 26) % 26) + base);
            retorno.append(decifrado);
        }
        
        return retorno.toString();
    }
    public String verificarMensagem(String mensagem) throws DecifragemInvalidaException{
        if (mensagem.equals(decifrar())){
            return "Deu certo!";
        }
        else {
            throw new DecifragemInvalidaException();
        }
    }

}
