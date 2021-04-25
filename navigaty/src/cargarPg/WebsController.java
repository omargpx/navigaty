/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cargarPg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 * FXML Controller class
 *
 * @author omar
 */
public class WebsController implements Initializable {

    @FXML
    private WebView webViewer;
    private WebEngine engine;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void cargarParametros(int url) {
        System.out.println("" + url);
        switch (url) {
            case 1:
                String facebook = "https://www.facebook.com/";
                engine = webViewer.getEngine();
                engine.load(facebook);
                break;
            case 2:
                String instagram = "http://www.google.com/";
                engine = webViewer.getEngine();
                engine.load(instagram);
                break;
            case 3:
                String linkedin = "http://www.youtube.com/";
                engine = webViewer.getEngine();
                engine.load(linkedin);
                break;
            default:
                String gmail = "http://www.amazon.com/";
                engine = webViewer.getEngine();
                engine.load(gmail);
                break;
        }
    }

    // refrescar pagina
    public void refres() {
        if (!engine.equals("")) {
            engine.reload();
        }else{
            System.out.println("cant reload");
        }

    }
    public void search(String url){
        engine=webViewer.getEngine();
        engine.load(url);
    }
    public void serachByName(String urls){
        engine=webViewer.getEngine();
        engine.load("https://www."+urls+".com");
        
    }
    public void AvanzarRegresar(){
        engine.getHistory(); //continiusss
        
    }
}
