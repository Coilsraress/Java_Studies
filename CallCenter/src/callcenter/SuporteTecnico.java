package callcenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class SuporteTecnico {
    private HashMap<String, String> bancoSolucao;
    private ArrayList<String> respostaPadrao;
    private Random gerador;

    public SuporteTecnico() {
        bancoSolucao = new HashMap<>();
        respostaPadrao = new ArrayList<>();
        gerador = new Random();
        iniciadorBanco();
    }

    public SuporteTecnico(HashMap<String, String> bancoSolucao, ArrayList<String> respostaPadrao) {
        this.bancoSolucao = bancoSolucao;
        this.respostaPadrao = respostaPadrao;
    }

    private void iniciadorBanco() {
        this.bancoSolucao.put("lento", "Penso que o problema está relacionado com o hardware. Fazer um upgrade\ndo seu processador deve resolver o problema de performance. Você tem algum\nproblema com o software?");
        this.bancoSolucao.put("performance", "A performance está próxima do esperado nos testes que realizamos. Você está\nexecutando algum outro processo em paralelo?");
        this.bancoSolucao.put("bug", "Bom, você sabe, todo software pode ter algum problema. Mas nossos engenheiros de software\njá estão atuando no problema para solucioná-lo. Você poderia descrever seu problema\ncom mais detalhes?");
        this.bancoSolucao.put("buggy", "Bom, você sabe, todo software pode ter algum problema. Mas nossos engenheiros de software\njá estão atuando no problema para solucioná-lo. Você poderia descrever seu problema\ncom mais detalhes?");
        this.bancoSolucao.put("windows", "Este é um problema do sistema operacional Windows. Por favor, \nentre em contato com a Microsoft. Não há nada que possamos fazer neste caso.");
        this.bancoSolucao.put("macintosh", "Este é um problema do sistema operacional Mac. Por favor, \nentre em contato com a Apple. Não há nada que possamos fazer neste caso.");
        this.bancoSolucao.put("caro", "O preço do nosso produto é competitivo. Você já fez uma pesquisa de mercado\ne comparou todas as características do nosso software com outras ofertas de mercado?");
        this.bancoSolucao.put("instalação", "A instalação é simples e direta. Nós temos programas de instalação previamente configurados\nque farão todo o trabalho para você. Você já leu as instruções\nde instalação?");
        this.bancoSolucao.put("memória", "Se você observar detalhadamente os requisitos mínimos de sistema, você verá que\na memória requerida é 1.5 giga byte. Você deverá adquirir\nmais memória. Mais alguma coisa que deseja saber?");
        this.bancoSolucao.put("linux", "Nós consideramos seriamente o suporte Linux. Mas existem muitos problemas.\nMuitos deles dizem respeito a versões incompatíveis. Você poderia ser\nmais preciso?");
        this.bancoSolucao.put("danificaram", "Bom, nosso software não danificaria seu sistema. Deve ser algo específico\nno seu sistema. Diga-me sobre sua configuração.");
        this.bancoSolucao.put("danificou", "Bom, nosso software não danificaria seu sistema. Deve ser algo específico\nno seu sistema. Diga-me sobre sua configuração.");

        this.respostaPadrao.add("Isso soa estranho. Você poderia descrever o problema com mais detalhes?");
        this.respostaPadrao.add("Nenhum outro cliente detalhou um problema parecido com este. \nQual é a sua configuração de sistema?");
        this.respostaPadrao.add("Isso parece interessante. Diga-me mais a respeito...");
        this.respostaPadrao.add("Preciso de maiores informações a respeito.");
        this.respostaPadrao.add("Você já verificou se existe algum conflito de DLL?");
        this.respostaPadrao.add("Isso está descrito no manual. Você já deu uma lida no manual que veio junto do seu software?");
        this.respostaPadrao.add("Sua descrição não foi satisfatória. Você já procurou um técnico\n que poderia detalhar melhor este problema?");
        this.respostaPadrao.add("Isso não é um problema, é apenas uma característica do software!");
        this.respostaPadrao.add("Você poderia explicar melhor?");
    }

    public String buscaSolucao(String palavraChave){
        if (bancoSolucao.get(palavraChave)==null) {
            return buscaRespostaPadrao();
        }
        return bancoSolucao.get(palavraChave);
    }

    private String buscaRespostaPadrao(){
        return respostaPadrao.get(gerador.nextInt(respostaPadrao.size()));
    }

    public void addAoBancoSolucao(String chave, String mensagem) {
        this.bancoSolucao.put(chave, mensagem);
    }

    public void removerDoBancodeSolucao(String chave, String mensagem) {
        this.bancoSolucao.remove(chave);
    }

    public void buscaSolucaoFrase(HashSet<String> palavras){
        boolean resposta = false;
        for(String palavra : palavras){
            if(bancoSolucao.get(palavra.toLowerCase())!=null){
                System.out.println(palavra.toUpperCase()+":");
                System.out.println(buscaSolucao(palavra)+"\n");
                resposta = true;
            }
        }
        if(!resposta){
            System.out.println(buscaRespostaPadrao());
        }
    }
}
