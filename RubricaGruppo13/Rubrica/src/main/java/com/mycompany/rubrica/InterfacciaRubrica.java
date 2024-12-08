package com.mycompany.rubrica;

import javafx.application.Application;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * @class InterfacciaRubrica
 * @brief Questa classe rappresenta l'interfaccia princiale della rubrica
 *
 * Tramite questa interfaccia, l'utente potrà gestire l'intera rubrica,
 * grazie agli appositi tasti per aggiungere, modificare ed eliminare contatti,
 * la casella di ricerca dei contatti, i tasti per scaricare e caricare i contatti.
 * L'interfaccia è stata implementata come applicazione in JavaFX
 * 
 * 
 */
public class InterfacciaRubrica extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        ///Attributi
        Button aggiungiContatto=new Button("+ Aggiungi Contatto");///< Tasto per aggiungere un nuovo contatto alla rubrica
        TextField ricerca=new TextField();///< Casella di testo dove inserire il nome o il cognome del contatto da ricercare
        Button ricercaButton=new Button("Cerca");///< Tasto con cui avviare la ricerca del contatto, in base alla stringa inserita nella casella di ricerca
        TableView listaContatti=new TableView();///< Una tabella che mostrerà tutti i contatti presenti nella rubrica, in ordine alfabetico
        Button modificaContatto=new Button("Modifica");///< Tasto per modificare un contatto
        Button eliminaContatto=new Button("Elimina");///< Tasto per eliminare un contatto
        Button upload=new Button("Upload file");///< Tasto per caricare un file dal quale estrarre i contatti da aggiungere alla rubrica
        Button download=new Button("Download contatti");///< Tasto con cui scaricare su un file tutti i contatti della rubrica
        
        /** 
         * Interfaccia che si aprirà quando l'utente clicca sul tasto "Aggiungi contatto" oppure "Modifica",
         * nel primo caso i campi delle info del contatto risulteranno vuoti,
         * nel secondo caso saranno precompilati in base alle vecchie info.
         */
        InterfacciaAggiungiModifica addOrModify;
        
        /**
         * Interaccia che si aprirà quando l'utente clicca sul tasto "Elimina",
         * l'interfaccia chiederà conferma prima di eliminare il contatto dalla rubrica.
        */
        InterfacciaElimina delete;
        
        /**
         * Interaccia che si aprirà quando l'utente clicca sul tasto "Upload file",
         * l'interfaccia chiederà all'utente di inserire un file (o un percorso di un file) contenente una lista di contatti.
         */
        InterfacciaUpload uploadInt;
        
        VBox root=new VBox();
        root.getChildren().addAll(aggiungiContatto,ricerca,ricercaButton,listaContatti,modificaContatto,eliminaContatto,upload,download);
        
       
        
        Scene scene = new Scene(root, 300, 250);
        
        
        
        primaryStage.setTitle("Rubrica");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    public static void main(String[] args) {
        launch(args);
        
         /**
          * @brief Metodo per ottenere il nome del contatto
          * @return Nome del contatto
          * */
        public String getNome(){
            return "nome contatto";
        }
        
        /**
          * @brief Metodo per ottenere il cognome del contatto
          * @return Cognome del contatto
          * */
        public String getCogome(){
            return "cognome contatto";
        }
        
        /**
          * @brief Metodo per ottenere i numeri di telefono del contatto
          * @return Numeri di telefono del contatto
          * */
        public int[] getNumeroTelefono(){
            int numeroTelefonoContatto=0123456789;
            return numeroTelefonoContatto;
        }
        
        /**
          * @brief Metodo per ottenere le email del contatto
          * @return Email del contatto
          * */
        public String[] getEmail(){
            return "email contatto";
        }
    }
    
}
