package com.mycompany.rubrica;

import javafx.beans.binding.Bindings;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

/**
 * @class InterfacciaAggiungi
 * @brief Classe che rappresenta l'interfaccia grafica per aggiungere un nuovo contatto.
 * 
 * InterfacciaAggiungi gestisce l'interfaccia grafica che permette all'utente di inserire tutti i dettagli relativi ad un contatto.
 * 
 * 
 *
 * @author Francesco, Antonio, Gennaro
 * 
 */
public class InterfacciaAggiungi {
    VBox addview; ///< Contenitore principale per gli elementi dell'interfaccia.
    Label aggiungi; ///< Etichetta principale dell'interfaccia.
    TextField[] campi; ///< Array di campi di testo per l'inserimento dei dati (nome, cognome, 3x numeri di telefono, 3x email).
    Label[] tags; ///< Array di etichette descrittive per i campi di input.
    Button conferma; ///< Pulsante di conferma dell'inserimento del contatto.
    Button annulla; ///< Pulsante per annullare l'operazione.
    
    
    public InterfacciaAggiungi(){
        /// Layout principale
        addview=new VBox();
        campi = new TextField[8];
        tags=new Label[8];
        addview.setSpacing(10); ///< Imposta la spaziatura tra gli elementi
        addview.setAlignment(Pos.CENTER); ///< Centra gli elementi all'interno del contenitore.
        aggiungi=new Label("Aggiungi contatto"); ///< Etichetta principale
        aggiungi.setStyle("-fx-font-size: 24px;");
        addview.getChildren().add(aggiungi);

        ///Creazione e aggiunta delle etichette per i campi di input
        tags[0]=new Label("Cognome");
        tags[1]=new Label("Nome");
        for(int i=0;i<3;i++)
            tags[i+2]=new Label("Numero di telefono "+(i+1));
        for(int i=0;i<3;i++)
            tags[i+5]=new Label("Email "+(i+1));
    
        ///Creazione e aggiunta dei campi di input
        for(int i=0;i<8;i++){
            campi[i]=new TextField();
            campi[i].setMaxWidth(400.0);
            campi[i].setAlignment(Pos.CENTER);
            addview.getChildren().addAll(tags[i],campi[i]);
        }
        
        ///Configurazione layout dei pulsanti
        HBox bottoni=new HBox();
        bottoni.setAlignment(Pos.BOTTOM_RIGHT);
        bottoni.setSpacing(20);
        bottoni.setPadding(new Insets(20));
        conferma=new Button("Conferma"); ///<Pulsante "Conferma"
        /// Il pulsante conferma sfrutta il binding per impedire il salvataggio del contatto se esso non presenta né nome né cognome.
        conferma.disableProperty().bind(
            Bindings.createBooleanBinding(
                () -> campi[0].getText().isEmpty()&&campi[1].getText().isEmpty(),
                campi[0].textProperty(),
                campi[1].textProperty()
            )
        );
        
        annulla=new Button("Annulla");///<Pulsante "Annulla"
        bottoni.getChildren().addAll(conferma,annulla);
        addview.getChildren().add(bottoni);
    }
    
}
