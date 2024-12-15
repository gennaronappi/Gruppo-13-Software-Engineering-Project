package com.mycompany.rubrica;


import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;


/**
 * @class InterfacciaRubrica
 * @brief Questa classe rappresenta l'interfaccia princiale della rubrica
 *
 * Tramite questa interfaccia, l'utente potrà gestire l'intera rubrica
 * grazie agli appositi tasti per aggiungere, modificare ed eliminare contatti,
 * alla casella di ricerca dei contatti e ai tasti per scaricare e caricare i contatti.
 * 
 * 
 * 
 * @author Francesco, Antonio, Gennaro
 * 
 */
public class InterfacciaRubrica extends VBox {
    
    ///Attributi
    public final Button aggiungiContatto; ///< Pulsante per aggiungere un nuovo contatto alla rubrica.
    public final TextField ricerca; ///< Casella di testo dove inserire il nome o il cognome del contatto da ricercare.
    public final Button ricercaButton; ///< Pulsante con cui avviare la ricerca del contatto, in base alla stringa inserita nella casella di ricerca.
    public final VBox listaContatti; ///< Contenitore con tutti i contatti presenti nella rubrica, in ordine alfabetico.
    public final Button upload; ///< Pulsante per caricare un file dal quale estrarre i contatti da aggiungere alla rubrica.
    public final Button download; ///< Pulsante con cui scaricare su un file tutti i contatti della rubrica.
    public Label contatore; ///< Etichetta per mostrare il numero totale di contatti.

    /**
     * @brief Costruttore della classe InterfacciaRubrica.
     * 
     * Inizializza l'interfaccia principale della rubrica con i seguenti elementi:
     * - Un'intestazione con il titolo della rubrica, un contatore di contatti, un tasto per aggiungere i contatti e una barra di ricerca.
     * - Una lista centrale per visualizzare i contatti.
     * - Un footer con pulsanti per caricare e scaricare i contatti.
     */
    public InterfacciaRubrica(){
        super();
        this.setSpacing(10); ///< Spaziatura tra gli elementi.
        this.setAlignment(Pos.CENTER); ///< Centra gli elementi nel contenitore
        this.setStyle("-fx-background-color: white;");
        
        this.aggiungiContatto=new Button("+ Aggiungi Contatto"); ///< Pulsante per aggiungere un nuovo contatto.
        this.aggiungiContatto.setPadding(new Insets(10));///< Un padding maggiore fa risaltare il tasto.
        Label rubricalbl=new Label("Rubrica"); ///< Titolo dell'interfaccia.
        rubricalbl.styleProperty().set("-fx-font-size: 30px;");
        contatore=new Label();///< Contatore dei contatti in rubrica, viene gestito dalla classe RubricaController.
        HBox cont=new HBox(new Label("Numero di contatti in rubrica: "),contatore); 
        VBox title=new VBox(rubricalbl,cont);
        this.ricerca=new TextField(); ///< Casella di testo per la ricerca.
        this.ricercaButton=new Button("🔍 Cerca"); ///< Pulsante per avviare la ricerca.
        HBox header=new HBox();
        header.setPadding(new Insets(20));///< Per separare meglio l'intestazione dalla lista dei contatti.
        header.getChildren().addAll(title,aggiungiContatto, new HBox(10,ricerca,ricercaButton));
        header.setSpacing(30);
        header.setAlignment(Pos.CENTER);
        this.getChildren().add(header);
        
        this.listaContatti=new VBox(); ///< Contenitore per la lista dei contatti.
        listaContatti.setAlignment(Pos.CENTER);
        this.getChildren().add(listaContatti);
        
        this.upload=new Button("Upload file"); ///< Pulsante per caricare i contatti da file.
        this.download=new Button("Download contatti"); ///< Pulsante per salvare i contatti su file.
        HBox footer=new HBox();
        footer.setSpacing(10);
        footer.setAlignment(Pos.CENTER_RIGHT);
        footer.setPadding(new Insets(50));
        footer.getChildren().addAll(upload,download);
        this.getChildren().add(footer);
        
    }
}
