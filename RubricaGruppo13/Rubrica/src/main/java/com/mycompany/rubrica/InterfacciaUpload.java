package com.mycompany.rubrica;

import java.io.*;
import javafx.scene.control.*;
import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.input.*;
import javafx.stage.*;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import java.util.*;

/**
 * @class InterfacciaUpload
 * @brief Classe che rappresenta l'interfaccia per caricare e gestire file di contatti.
 *
 * Tramite questa interfaccia, l'utente potrà selezionare o trascinare un file da caricare nella rubrica.
 * 
 * 
 * 
 * @note Supporta solo file con estensione `.txt`.
 * 
 * @author Francesco, Antonio, Gennaro
 * 
 */
public class InterfacciaUpload extends VBox{
    ///Attributi
    Label file; ///< Etichetta che mostra il file selezionato e/o caricato.
    StackPane dragArea; ///< Area visiva in cui è possibile trascinare un file.
    Button sfogliaFile; ///< Pulsante per aprire il selettore di file.
    Button annulla; ///< Pulsante per annullare l'operazione.
    Label uploadFile; ///< Etichetta con il titolo della finestra di upload.

    ///Metodi
    /**
     * @brief Costruttore della classe InterfacciaUpload.
     *
     * Inizializza l'interfaccia con:
     * - Un titolo.
     * - Un'area drag-and-drop.
     * - Pulsanti per selezionare un file o annullare.
     */
    public InterfacciaUpload(){
        this.setAlignment(Pos.CENTER); ///< Centra tutti gli elementi.
        this.setSpacing(20); ///< Spaziatura tra gli elementi.
        uploadFile=new Label("Upload file"); ///< Titolo.
        uploadFile.setStyle("-fx-font-size: 24px;");
        this.getChildren().add(uploadFile);
        
        file=new Label(); ///< Etichetta per il file selezionato.
        this.getChildren().add(file);
        
        ///Area per il drag and drop.
        dragArea=new StackPane();
        dragArea.setStyle("-fx-border-color: black; -fx-border-style: dashed; -fx-padding: 20; -fx-background-color: #f9f9f9;");
        dragArea.setMinHeight(300);
        dragArea.setMaxWidth(400);

	Text label = new Text("+ Trascina qui il file"); ///< Istruzione per il drag and drop.
        label.setFont(Font.font("Arial", FontWeight.BOLD, 16));
	dragArea.getChildren().add(label);
        this.getChildren().add(dragArea);
        
        sfogliaFile=new Button("Sfoglia..."); ///< Pulsante per selezionare il file.
        
        annulla=new Button("Annulla"); ///< Pulsante per annullare l'operazione.
        
        HBox bottoni=new HBox(sfogliaFile,annulla);
        bottoni.setAlignment(Pos.CENTER);
        bottoni.setSpacing(200);
        this.getChildren().add(bottoni);
        
        
    }
    
    /**
     * @brief Verifica se il file selezionato è supportato.
     * 
     * @param file Il file da verificare.
     * @return `true` se il file ha estensione `.txt`, altrimenti `false`.
     */
    public boolean verificaSupportoFile(File file){
	String fileName = file.getName().toLowerCase();
	return fileName.endsWith(".txt");
    }
    
    /**
     * @brief Mostra un avviso se il file caricato non è supportato.
     *
     * Mostra un messaggio di errore che informa l'utente che solo i file `.txt` sono accettati.
     */
    public void fileNonSupportatoAlert() {
        Alert alert = new Alert(Alert.AlertType.WARNING, "Il file inserito è di un formato non supportato.\n(Inserire solo file in formato .txt)", ButtonType.OK);
        alert.setHeaderText(null); 
        alert.showAndWait(); 
    }
    
    /**
     * @brief Estrae i contatti da un file e li aggiunge alla rubrica.
     *
     * @param file Il file da cui estrarre i contatti.
     * @param controller Il controller della rubrica che gestirà i contatti estratti.
     *
     * @details
     * Il file deve essere in formato `.txt` con i contatti separati da `|`.
     * Se un contatto non presenta nome o cognome (campi obbligatori), viene ignorato con un messaggio di errore.
     */
    public void estraiContatti(File file,RubricaController controller){
        List<Contatto> estratti=new ArrayList<>(); ///< Lista per memorizzare i contatti estratti dal file.
        int cont=1;
        try(BufferedReader read=new BufferedReader(new FileReader(file))){
            String line;
            while ((line=read.readLine())!=null){ ///< Ciclo per leggere ogni riga del file.
                Contatto c=new Contatto(); ///< Nuovo contatto da popolare.
                Scanner i=new Scanner(line); ///< Scanner per analizzare i dati della riga.
                i.useDelimiter("\\|"); ///< Utilizza il delimitatore `|` per separare i campi
                
                ///Popolamento dei campi del contatto.
                c.setCognome(i.next());
                c.setNome(i.next());
                if(c.getNome().equals("")&&c.getCognome().equals("")){ ///< Verifica del nome e del cognome: non possono essere vuoti.
                    System.out.println("ERRORE! Il contatto numero "+cont+" non presenta un nome o un cognome: impossibile salvare il contatto!"); ///< Messaggio di errore per i contatti non validi.
                }else{
                
                ///Se nome e cognome sono validi, legge i numeri di telefono e le email.
                c.setNumeroTelefono1(i.next()); ///< Primo numero di telefono.
                c.setNumeroTelefono2(i.next()); ///< Secondo numero di telefono.
                c.setNumeroTelefono3(i.next()); ///< Terzo numero di telefono.
                c.setEmail1(i.next()); ///< Prima email.
                c.setEmail2(i.next()); ///< Seconda email.
                if(i.hasNext()) ///< Serve a non generare eccezioni.
                    c.setEmail3(i.next());///< Terza email.
                else
                    c.setEmail3("");
                cont++;
                
                i.close();
                estratti.add(c);///< Il contatto estratto viene aggiunto alla lista dei contatti da inserire in rubrica.
                }
            }
        } catch (IOException e){ ///< Gestione dell'errore in caso di problemi di lettura del file
            
        }
        ///Aggiunge tutti i contatti validi al controller della rubrica.
        for(Contatto c : estratti){
            controller.aggiungiContatto(c);
        }

    }

}
