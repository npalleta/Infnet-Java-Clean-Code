import br.com.studies.Java01Exercises;
import br.com.studies.infnet.Cliente;
import br.com.studies.infnet.Pagamento;
import br.com.studies.infnet.Produto;

import java.math.BigDecimal;
import java.nio.file.Paths;
import java.time.LocalDate;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Java01Exercises("abc").getTextA().getTextB().text);

        System.out.println("--- Exercício 01 ---");

        Produto produtoA = new Produto("Cadeira Gamer", Paths.get("cadeiras/gamer"), new BigDecimal("1000.00"));
        Produto produtoB = new Produto("Notebook Avell", Paths.get("notebooks/avell"), new BigDecimal("4000.00"));
        Produto produtoC = new Produto("Livro Harry Potter", Paths.get("livros/harry_potter"), new BigDecimal("50.00"));
        Produto produtoD = new Produto("Pacote de Imagens - NFT", Paths.get("nfts/pacote_imagens"), new BigDecimal("6000.00"));

        Cliente maria = new Cliente();
        Cliente jonas = new Cliente();
        Cliente andre = new Cliente();
        Cliente camila = new Cliente();

        maria.setNome("Maria");
        jonas.setNome("Jonas");
        andre.setNome("André");
        camila.setNome("Camila");

        LocalDate hoje = LocalDate.now();
        LocalDate ontem = LocalDate.now().minusDays(1);
        LocalDate mesPassado = LocalDate.now().minusMonths(1);

        Pagamento pagamentoClienteA = new Pagamento(List.of(produtoA, produtoB), hoje, maria);
        Pagamento pagamentoClienteB = new Pagamento(List.of(produtoA, produtoB, produtoC, produtoD, produtoD), ontem, jonas);
        Pagamento pagamentoClienteC = new Pagamento(List.of(produtoA, produtoB, produtoC, produtoD), mesPassado, andre);

        List<Pagamento> pagamentos = Arrays.asList(pagamentoClienteA, pagamentoClienteB, pagamentoClienteC);
        pagamentos.forEach(p -> System.out.println(p.toString()));

        System.out.println("--- Exercício 02 ---");

        pagamentos.sort(Comparator.comparing(p -> p.getDataCompra()));
        Function<Pagamento, LocalDate> resgataDatasCompra = p -> p.getDataCompra();
        Comparator<Pagamento> comparator = Comparator.comparing(resgataDatasCompra);
        pagamentos.sort(comparator);
        System.out.println("--- Ordenação 01 ---");
        pagamentos.forEach(System.out::println);

        List<Pagamento> pagamentosOrdenadosPorDataCompra = pagamentos
            .stream()
            .sorted(
                Comparator.comparing(Pagamento::getDataCompra)
            )
            .toList();
        System.out.println("--- Ordenação 02 ---");
        pagamentosOrdenadosPorDataCompra.forEach(System.out::println);

        System.out.println("--- Exercício 03 ---");

        System.out.printf("Usando BigDecimal: %s%n", pagamentoClienteC.somaPrecosProdutosPagtoUsandoBigDecimal());
        System.out.printf("Usando Optional: %s%n", pagamentoClienteC.somaPrecosProdutosPagtoUsandoOptional());

        System.out.println("--- Exercício 04 ---");

        BigDecimal todosPagtosSomados = pagamentos.stream().map(Pagamento::somaPrecosProdutosPagtoUsandoBigDecimal).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.printf("Somando todos os pagtos: %s%n", todosPagtosSomados);

        System.out.println("--- Exercício 05 ---");
        System.out.printf("Contando produtos vendidos para o Cliente A : %s%n", pagamentoClienteA.getProdutos().size());
        System.out.printf("Contando produtos vendidos para o Cliente B : %s%n", pagamentoClienteB.getProdutos().size());
        System.out.printf("Contando produtos vendidos para o Cliente C : %s%n", pagamentoClienteC.getProdutos().size());

        OptionalInt contadorProdutosTotaisVendidos = pagamentos.stream().mapToInt(pagamento -> pagamento.getProdutos().size()).reduce(Integer::sum);
        System.out.printf("Contando total de produtos vendidos: %s%n", contadorProdutosTotaisVendidos.getAsInt());

        System.out.println("--- Exercício 06 ---");
        Cliente c1 = new Cliente();
        c1.setNome("Douglas Lima");
        Cliente c2 = new Cliente();
        c2.setNome("Lucas Santos");
        Produto cadeiraGamer = new Produto("Cadeira Gamer", Paths.get("cadeiras/gamer"), new BigDecimal("1000.00"));
        Produto pacoteDeImagens = new Produto("Pacote de Imagens - NFT", Paths.get("nfts/pacote_imagens"), new BigDecimal("6000.00"));
        HashMap<String, List<Produto>> clienteProdutos = new HashMap<>();
        clienteProdutos.put(c1.getNome(), List.of(cadeiraGamer, pacoteDeImagens));
        clienteProdutos.put(c2.getNome(), List.of(cadeiraGamer));
        clienteProdutos
            .entrySet()
            .stream()
            .map(
                e -> String.format(
                    "Nome do Cliente: %s | Item(ns): %s",
                    e.getKey(),
                    e.getValue()
                )
            )
            .forEach(System.out::println);
        //

        System.out.println("--- Exercício 07 ---");
        System.out.println("Sem ordenação - apenas impressão do map com as chaves e valores:");
        pagamentos.forEach(pagamento ->
            {
                HashMap<String, BigDecimal> mapClienteProdutos = new HashMap<>();
                BigDecimal somaProdutosComprados = pagamento.getProdutos().stream().map(Produto::getPreco).reduce(BigDecimal.ZERO, BigDecimal::add);
                mapClienteProdutos.put(pagamento.getCliente().getNome(), somaProdutosComprados);
                mapClienteProdutos
                    .entrySet()
                    .stream()
                    .map(
                        e -> String.format(
                                "Nome do Cliente: %s | Item(ns): %s",
                                e.getKey(),
                                e.getValue()
                        )
                    )
                    .forEach(System.out::println);
                //
            }
        );

        Map<String, BigDecimal> mapClienteProdutosSemOrdem = new HashMap<>();
        pagamentos.forEach((Pagamento pagamento) ->
            {
                BigDecimal somaProdutosComprados = pagamento.getProdutos().stream().map(Produto::getPreco).reduce(BigDecimal.ZERO, BigDecimal::add);
                mapClienteProdutosSemOrdem.put(pagamento.getCliente().getNome(), somaProdutosComprados);
            }
        );

        LinkedHashMap<String, BigDecimal> mapClienteProdutosOrdenado = mapClienteProdutosSemOrdem
            .entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .collect(
                Collectors.toMap(
                    Map.Entry::getKey,
                    Map.Entry::getValue,
                    (oldValue, newValue) -> oldValue, LinkedHashMap::new
                )
            );
        //
        System.out.printf("Ordenando pelo maior valor gasto em compras: %s%n", mapClienteProdutosOrdenado);

        System.out.println("Apresentando o cliente que gastou o maior valor em compras:");
        Map.Entry<String, BigDecimal> clienteQueGastouMais = mapClienteProdutosOrdenado.entrySet().stream().findFirst().get();
        System.out.printf(
            "Nome do Cliente: %s | Valor em Compra(s): %s%n",
            clienteQueGastouMais.getKey(),
            clienteQueGastouMais.getValue()
        );
    }
}