package br.com.restaurantefactory.presentation.controller;

import br.com.restaurantefactory.application.service.MontagemRefeicaoService;
import br.com.restaurantefactory.domain.factory.FabricaRefeicao;
import br.com.restaurantefactory.domain.pedido.Pedido;
import br.com.restaurantefactory.infrastructure.factory.FabricaFitness;
import br.com.restaurantefactory.infrastructure.factory.FabricaTradicional;
import br.com.restaurantefactory.infrastructure.factory.FabricaVegetariana;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class RestauranteController {

    @FXML private BorderPane rootPane;
    @FXML private ComboBox<String> comboTipoCardapio;
    @FXML private Label lblValorTotal;

    // Banner
    @FXML private StackPane painelBanner;
    @FXML private ImageView imgRefeicao;
    @FXML private VBox bannerApresentacao;
    @FXML private VBox bannerBadge;

    // Rótulos de Categoria dos Cards Inferiores
    @FXML private Label lblCat1;
    @FXML private Label lblCat2;
    @FXML private Label lblCat3;

    // Cartão 1 (Esquerda)
    @FXML private ImageView imgPrato;
    @FXML private Label iconePrato;
    @FXML private Label lblPratoNome;
    @FXML private Label lblPratoPreco;
    @FXML private Label lblPratoDesc;

    // Cartão 2 (Centro)
    @FXML private ImageView imgBebida;
    @FXML private Label iconeBebida;
    @FXML private Label lblBebidaNome;
    @FXML private Label lblBebidaPreco;
    @FXML private Label lblBebidaDesc;

    // Cartão 3 (Direita)
    @FXML private ImageView imgSobremesa;
    @FXML private Label iconeSobremesa;
    @FXML private Label lblSobremesaNome;
    @FXML private Label lblSobremesaPreco;
    @FXML private Label lblSobremesaDesc;

    private final Map<ImageView, ImageView> fundos = new HashMap<>();
    private final MontagemRefeicaoService montagemService = new MontagemRefeicaoService();

    @FXML
    public void initialize() {
        // Garante que o tema inicial (azul marinho e âmbar) seja aplicado na abertura
        rootPane.getStyleClass().removeAll(
            "theme-inicial", "theme-vegetariana", "theme-fitness", "theme-tradicional"
        );
        rootPane.getStyleClass().add("theme-inicial");

        comboTipoCardapio.setItems(
            FXCollections.observableArrayList("Fitness", "Tradicional", "Vegetariana")
        );
        
        comboTipoCardapio.setItems(
            FXCollections.observableArrayList("Fitness", "Tradicional", "Vegetariana")
        );

        // Torna o banner 100% responsivo: altura vinculada proporcionalmente à largura
        painelBanner.prefHeightProperty().bind(painelBanner.widthProperty().divide(2.4));

        // Prepara imagens com efeito de fundo desfocado
        prepararImagemInteira(imgRefeicao, 30, 35, 24);
        prepararImagemInteira(imgPrato, 20, 20, 10);
        prepararImagemInteira(imgBebida, 20, 20, 10);
        prepararImagemInteira(imgSobremesa, 20, 20, 10);

        // 1. Carrega a imagem da mesa no banner inicial (ocultando o texto duplicado do FXML)
        carregarImagemBannerInicial("/br/com/restaurantefactory/images/banner_mesa.png");

        // 2. Carrega os 3 estilos nos cards inferiores com badges coloridas individualmente
        carregarEstiloInicial(
            imgPrato, iconePrato, "/br/com/restaurantefactory/images/fitness.jpeg",
            lblCat1, "Fitness", "-fx-background-color: #d9ebfa; -fx-text-fill: #0754a1;",
            lblPratoNome, "Leveza e Nutrição",
            lblPratoPreco,
            lblPratoDesc, "Refeições leves e nutritivas para uma vida saudável."
        );

        carregarEstiloInicial(
            imgBebida, iconeBebida, "/br/com/restaurantefactory/images/tradicional.png",
            lblCat2, "Tradicional", "-fx-background-color: #f2dfd1; -fx-text-fill: #842513;",
            lblBebidaNome, "O Clássico Brasileiro",
            lblBebidaPreco,
            lblBebidaDesc, "O sabor clássico que você já conhece e ama."
        );

        carregarEstiloInicial(
            imgSobremesa, iconeSobremesa, "/br/com/restaurantefactory/images/vegetariana.png",
            lblCat3, "Vegetariano", "-fx-background-color: #dfedda; -fx-text-fill: #17632b;",
            lblSobremesaNome, "Sabor e Bem-estar",
            lblSobremesaPreco,
            lblSobremesaDesc, "Sabor e bem-estar em perfeita harmonia."
        );

        // Mantém o ComboBox sem seleção inicial para exibir o promptText "Selecione seu estilo"
        comboTipoCardapio.valueProperty().addListener(
            (observable, anterior, novo) -> atualizarTema(novo)
        );
    }

    private void atualizarTema(String selecao) {
        if (selecao == null) {
            return;
        }

        // Remove o tema inicial e qualquer tema anterior antes de aplicar o novo
        rootPane.getStyleClass().removeAll(
            "theme-inicial", "theme-vegetariana", "theme-fitness", "theme-tradicional"
        );

        switch (selecao) {
            case "Vegetariana" -> rootPane.getStyleClass().add("theme-vegetariana");
            case "Fitness" -> rootPane.getStyleClass().add("theme-fitness");
            case "Tradicional" -> rootPane.getStyleClass().add("theme-tradicional");
            default -> System.err.println("Tema desconhecido: " + selecao);
        }
    }

    @FXML
    protected void onMontarRefeicaoClick() {
        String selecao = comboTipoCardapio.getValue();

        if (selecao == null) {
            System.err.println("Por favor, selecione um estilo no cardápio antes de montar a refeição.");
            return;
        }

        FabricaRefeicao fabrica = switch (selecao) {
            case "Fitness" -> new FabricaFitness();
            case "Tradicional" -> new FabricaTradicional();
            case "Vegetariana" -> new FabricaVegetariana();
            default -> throw new IllegalStateException("Categoria desconhecida: " + selecao);
        };

        Pedido pedido = montagemService.montarRefeicao(fabrica);

        // Restaura os rótulos de categoria e limpa os estilos inline da tela inicial
        lblCat1.setText("Prato Principal");
        lblCat1.setStyle("");

        lblCat2.setText("Bebida");
        lblCat2.setStyle("");

        lblCat3.setText("Sobremesa");
        lblCat3.setStyle("");

        // Reativa a visibilidade dos campos de preço nos cards
        restaurarVisibilidadePreco(lblPratoPreco);
        restaurarVisibilidadePreco(lblBebidaPreco);
        restaurarVisibilidadePreco(lblSobremesaPreco);

        // PRATO PRINCIPAL
        lblPratoNome.setText(pedido.getPratoPrincipal().getNome());
        lblPratoPreco.setText(formatarMoeda(pedido.getPratoPrincipal().getPreco()));
        lblPratoDesc.setText(pedido.getPratoPrincipal().getDescricao());
        carregarImagemItem(imgPrato, iconePrato, pedido.getPratoPrincipal().getImagem());

        // BEBIDA
        lblBebidaNome.setText(pedido.getBebida().getNome());
        lblBebidaPreco.setText(formatarMoeda(pedido.getBebida().getPreco()));
        lblBebidaDesc.setText(pedido.getBebida().getDescricao());
        carregarImagemItem(imgBebida, iconeBebida, pedido.getBebida().getImagem());

        // SOBREMESA
        lblSobremesaNome.setText(pedido.getSobremesa().getNome());
        lblSobremesaPreco.setText(formatarMoeda(pedido.getSobremesa().getPreco()));
        lblSobremesaDesc.setText(pedido.getSobremesa().getDescricao());
        carregarImagemItem(imgSobremesa, iconeSobremesa, pedido.getSobremesa().getImagem());

        // TOTAL
        lblValorTotal.setText(formatarMoeda(pedido.getValorTotal()));

        // BANNER (substitui a imagem da mesa pelo combo completo selecionado)
        String nomeImagem = switch (selecao) {
            case "Tradicional" -> "/br/com/restaurantefactory/images/tradicional.png";
            case "Fitness" -> "/br/com/restaurantefactory/images/fitness.jpeg";
            case "Vegetariana" -> "/br/com/restaurantefactory/images/vegetariana.png";
            default -> "";
        };

        carregarImagemBanner(nomeImagem);
    }

    private void restaurarVisibilidadePreco(Label lblPreco) {
        lblPreco.setVisible(true);
        lblPreco.setManaged(true);
    }

    private String formatarMoeda(double valor) {
        return String.format(Locale.forLanguageTag("pt-BR"), "R$ %.2f", valor);
    }

    private void carregarImagemBannerInicial(String caminho) {
        var recurso = getClass().getResource(caminho);
        if (recurso != null) {
            Image imagem = new Image(recurso.toExternalForm());
            if (!imagem.isError()) {
                definirImagem(imgRefeicao, imagem);
                bannerApresentacao.setVisible(false);
                bannerApresentacao.setManaged(false);
                bannerBadge.setVisible(true);
                bannerBadge.setManaged(true);
                return;
            }
        }
        System.err.println("Arquivo de imagem inicial do banner não encontrado: " + caminho);
    }

    private void carregarEstiloInicial(ImageView view, Label icone, String caminhoImg,
                                       Label lblCat, String nomeCat, String estiloBadge,
                                       Label lblNome, String textoNome,
                                       Label lblPreco,
                                       Label lblDesc, String textoDesc) {
        var recurso = getClass().getResource(caminhoImg);
        if (recurso != null) {
            Image imagem = new Image(recurso.toExternalForm());
            if (!imagem.isError()) {
                definirImagem(view, imagem);
                icone.setVisible(false);
            }
        }
        lblCat.setText(nomeCat);
        lblCat.setStyle(estiloBadge);

        lblNome.setText(textoNome);

        // Oculta o espaço do preço na tela inicial para manter o card compacto
        lblPreco.setVisible(false);
        lblPreco.setManaged(false);

        lblDesc.setText(textoDesc);
    }

    private void carregarImagemBanner(String caminho) {
        var recurso = getClass().getResource(caminho);

        if (recurso == null) {
            System.err.println("Arquivo de imagem não encontrado: " + caminho);
            return;
        }

        Image imagem = new Image(recurso.toExternalForm());

        if (imagem.isError()) {
            System.err.println("Não foi possível carregar a imagem: " + caminho);
            return;
        }

        definirImagem(imgRefeicao, imagem);

        bannerApresentacao.setVisible(false);
        bannerApresentacao.setManaged(false);
        bannerBadge.setVisible(false);
        bannerBadge.setManaged(false);
    }

    private void carregarImagemItem(ImageView view, Label icone, String caminho) {
        var recurso = (caminho == null) ? null : getClass().getResource(caminho);

        if (recurso != null) {
            Image imagem = new Image(recurso.toExternalForm());
            if (!imagem.isError()) {
                definirImagem(view, imagem);
                icone.setVisible(false);
                return;
            }
        }

        definirImagem(view, null);
        icone.setVisible(true);
    }

    private void prepararImagemInteira(ImageView frente, double arredondamento,
                                       double desfoque, double sombra) {
        StackPane conteiner = (StackPane) frente.getParent();

        Rectangle recorte = new Rectangle();
        recorte.widthProperty().bind(conteiner.widthProperty());
        recorte.heightProperty().bind(conteiner.heightProperty());
        recorte.setArcWidth(arredondamento);
        recorte.setArcHeight(arredondamento);
        conteiner.setClip(recorte);

        ImageView fundo = new ImageView();
        fundo.setPreserveRatio(false);
        fundo.setManaged(false);
        fundo.setEffect(new GaussianBlur(desfoque));
        fundo.setScaleX(1.15);
        fundo.setScaleY(1.15);
        conteiner.getChildren().add(0, fundo);
        fundos.put(frente, fundo);

        frente.setManaged(false);
        frente.setPreserveRatio(true);
        frente.setEffect(new DropShadow(sombra, Color.rgb(0, 0, 0, 0.35)));

        conteiner.widthProperty().addListener((o, a, n) -> ajustarImagemInteira(frente));
        conteiner.heightProperty().addListener((o, a, n) -> ajustarImagemInteira(frente));
    }

    private void definirImagem(ImageView frente, Image imagem) {
        fundos.get(frente).setImage(imagem);
        frente.setImage(imagem);
        ajustarImagemInteira(frente);
    }

    private void ajustarImagemInteira(ImageView frente) {
        Image imagem = frente.getImage();
        Region conteiner = (Region) frente.getParent();
        double largura = conteiner.getWidth();
        double altura = conteiner.getHeight();

        if (imagem == null || largura <= 0 || altura <= 0) {
            return;
        }

        ImageView fundo = fundos.get(frente);
        double escalaFundo = Math.max(largura / imagem.getWidth(), altura / imagem.getHeight());
        double recorteLargura = largura / escalaFundo;
        double recorteAltura = altura / escalaFundo;
        fundo.setViewport(new Rectangle2D(
            (imagem.getWidth() - recorteLargura) / 2,
            (imagem.getHeight() - recorteAltura) / 2,
            recorteLargura,
            recorteAltura
        ));
        fundo.setFitWidth(largura);
        fundo.setFitHeight(altura);
        fundo.relocate(0, 0);

        double escala = Math.min(largura / imagem.getWidth(), altura / imagem.getHeight());
        double larguraImagem = imagem.getWidth() * escala;
        double alturaImagem = imagem.getHeight() * escala;

        frente.setViewport(null);
        frente.setFitWidth(larguraImagem);
        frente.setFitHeight(alturaImagem);
        frente.relocate((largura - larguraImagem) / 2, (altura - alturaImagem) / 2);
    }
}