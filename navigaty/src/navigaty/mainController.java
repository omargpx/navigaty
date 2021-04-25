package navigaty;

import com.jfoenix.controls.JFXToggleButton;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 *
 * @author omar
 */
public class mainController implements Initializable {

    private Label label;
    @FXML
    private ImageView imgFondo;
    @FXML
    private Pane paneDark;
    @FXML
    private JFXToggleButton togleDark;
    @FXML
    private ImageView imgMoon;
    @FXML
    private BorderPane bp;
    @FXML
    private AnchorPane apCenter;
    @FXML
    private Button btnPestana;
    @FXML
    private TextField txtSearch;
    @FXML
    private TextField txtSearchName;
    @FXML
    private Rectangle rectdark;

    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.paneDark.setVisible(false);
        Image jp = new Image("/img/julentto-photography-Yr1SCCRJXIY-unsplash.jpg");
        this.imgFondo.setImage(jp);
        rectdark.setFill(new ImagePattern(jp));
    }

    private void loadPage(String page) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(page + ".fxml"));
        } catch (IOException ex) {
            Logger.getLogger(mainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        bp.setCenter(root);
    }

    @FXML
    private void btnGoogle(MouseEvent event) throws IOException {
        this.btnPestana.setText("Google");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/cargarPg/webs.fxml"));
        Parent root = loader.load();
        cargarPg.WebsController controlador = loader.getController();
        controlador.cargarParametros(2);
        bp.setCenter(root);
    }

    @FXML
    private void btnYoutube(MouseEvent event) throws IOException {
        this.btnPestana.setText("Youtube");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/cargarPg/webs.fxml"));
        Parent root = loader.load();
        cargarPg.WebsController controlador = loader.getController();
        controlador.cargarParametros(3);
        bp.setCenter(root);
    }

    @FXML
    private void btnFacebook(MouseEvent event) throws IOException {
        this.btnPestana.setText("Facebook");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/cargarPg/webs.fxml"));
        Parent root = loader.load();
        cargarPg.WebsController controlador = loader.getController();
        controlador.cargarParametros(1);
        bp.setCenter(root);
    }

    @FXML
    private void btnAmazon(MouseEvent event) throws IOException {

    }

    @FXML
    private void togleDark(ActionEvent event) {
        if (togleDark.isSelected()) {
            try {
                Image fondo = new Image("/iconos/moon_light.png");
                imgMoon.setImage(fondo);
            } catch (Exception e) {
                System.out.println("erro -> " + e.getMessage());
            }
            this.paneDark.setVisible(true);
        } else {
            this.paneDark.setVisible(false);
            try {
                Image fondo = new Image("/iconos/moon.png");
                imgMoon.setImage(fondo);
            } catch (Exception e) {
                System.out.println("erro -> " + e.getMessage());
            }
        }
    }

    @FXML
    private void linkFondo(ActionEvent event) {
        FileChooser im = new FileChooser();
        im.setTitle("Cambiar imagen de perfil");
        Window ownerWindow = null;
        im.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.bmp", "*.png", "*.jpg", "*.gif"));
        File urls = im.showOpenDialog(ownerWindow);
        if (urls == null) {
            System.out.println("selleccionar imagen");
        } else {
            urls.getAbsoluteFile();
            System.out.println(urls);
            try {
                Image fondo = new Image(urls.toURL().toString());
                imgFondo.setImage(fondo);
            } catch (Exception e) {
                System.out.println("erro -> " + e.getMessage());
            }
        }
    }

    @FXML
    private void btnPestana(ActionEvent event) {

    }

    @FXML
    private void btnHome(ActionEvent event) {
        this.btnPestana.setText("Home");
        bp.setCenter(apCenter);
    }

    @FXML
    private void btnRefresh(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/cargarPg/webs.fxml"));
        cargarPg.WebsController controlador = loader.getController();
        controlador.refres();

    }

    @FXML
    private void btntxtSearch(ActionEvent event) throws IOException {
        String capS= txtSearch.getText();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/cargarPg/webs.fxml"));
        Parent root = loader.load();
        Node source = (Node) event.getSource();
        Stage ventanaACt = (Stage) source.getScene().getWindow();
        ventanaACt.setTitle(capS);
        cargarPg.WebsController controlador = loader.getController();
        controlador.search(capS);
        bp.setCenter(root);
    }

    @FXML
    private void btnSearchname(MouseEvent event) throws IOException {
        String cap= txtSearchName.getText();
        Node source = (Node) event.getSource();
        Stage ventanaACt = (Stage) source.getScene().getWindow();
        ventanaACt.setTitle(cap);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/cargarPg/webs.fxml"));
        Parent root = loader.load();
        cargarPg.WebsController controlador = loader.getController();
        controlador.search(cap);
        bp.setCenter(root);
    }

}
