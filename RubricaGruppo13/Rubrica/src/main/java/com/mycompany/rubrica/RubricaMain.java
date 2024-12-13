package com.mycompany.rubrica;

import java.io.*;
import javafx.application.Application;
import javafx.scene.Scene;
import java.util.*;
import static javafx.application.Application.launch;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.stage.*;

/**
 * @class RubricaMain
 * @brief Classe principale dell'applicazione Rubrica.
 *
 * Questa classe avvia l'applicazione, gestisce l'interfaccia principale,
 * e include metodi per caricare, salvare e manipolare i contatti della rubrica.
 * Applicazione creata con JavaFX.
 *
 * @author Francesco, Antonio, Gennaro.
 */
public class RubricaMain extends Application {
    
    /**
     * Metodo di avvio dell'applicazione: configura la finestra principale e associa eventi ai componenti dell'interfaccia.
     * 
     * @param primaryStage Il principale contenitore della finestra dell'applicazione.
     */
    @Override
    public void start(Stage primaryStage) {
        InterfacciaRubrica view = new InterfacciaRubrica();///< Crea l'interfaccia principale.
        RubricaController controller=new RubricaController(view);///< Crea un controller per l'interfaccia, che viene passata come parametro.
        leggi(new File("Database.txt"),controller); ///< Carica i contatti salvati in precedenza dal file "Database.txt" e li aggiunge alla rubrica attraverso il controller
        
        
        ///Mostra i contatti caricati nella vista iniziale.
        controller.display(controller.lista);

        ///Associa il pulsante "Aggiungi Contatto" al metodo `aggiungi`.
        view.aggiungiContatto.setOnAction(e -> aggiungi(controller));

        ///Associa il pulsante "Ricerca" alla funzione di ricerca contatti del controller.
        view.ricercaButton.setOnAction(r -> controller.ricercaContatto());

        ///Configura il pulsante "Upload" per caricare nuovi contatti da file.
        view.upload.setOnAction(u -> upload(controller));

        ///Configura il pulsante "Download" per salvare i contatti in un file.
        view.download.setOnAction(d -> downloadContatti(controller));
        
        
        ///Configurazione della finestra principale.
        primaryStage.setTitle("Rubrica");
        primaryStage.setScene(new Scene(view, 900, 700));
        primaryStage.centerOnScreen();
        primaryStage.show();
        
    }
    
    /**
     * Apre una finestra per aggiungere un nuovo contatto alla rubrica.
     * 
     * @param controller Gestisce la logica per l'aggiunta di contatti.
     */
    public void aggiungi(RubricaController controller){
        Stage add=new Stage();
        InterfacciaAggiungi addview=new InterfacciaAggiungi();
        Scene nuovascena=new Scene(addview.addview,600,700);
        add.setTitle("aggiungi contatto");
        add.setScene(nuovascena);
        add.show();
        
        addview.annulla.setOnAction(e-> add.close()); ///< Pulsante "Annulla" che chiude la finestra senza salvare
        
        ///Pulsante "Conferma" salva i dati inseriti come nuovo contatto.
        addview.conferma.setOnAction(e-> {
            String cognome=addview.campi[0].getText(); ///< Legge il cognome inserito dall'utente.
            String nome=addview.campi[1].getText(); ///< Legge il nome inserito dall'utente.
            Contatto c = new Contatto(cognome,nome); ///< Crea un nuovo oggetto Contatto e aggiunge dati.
            c.setEmail1(addview.campi[5].getText());
            c.setEmail2(addview.campi[6].getText());
            c.setEmail3(addview.campi[7].getText());
            c.setNumeroTelefono1(addview.campi[2].getText());
            c.setNumeroTelefono2(addview.campi[3].getText());
            c.setNumeroTelefono3(addview.campi[4].getText());
            controller.aggiungiContatto(c); ///< Aggiunge il nuovo contatto al controller
            add.close();
        });
    }
    
    /**
     * Apre una finestra per caricare un file di contatti con drag-and-drop o selezione manuale, rappresentata dalla classe InterfacciaUpload.
     * 
     * @param controller Gestisce i contatti caricati dal file.
     */
    public void upload(RubricaController controller){
        Stage uploadStage=new Stage();
        InterfacciaUpload up=new InterfacciaUpload();
        Scene scene = new Scene(up, 600, 480);
        
        uploadStage.setTitle("Upload file");
        uploadStage.setScene(scene);
        uploadStage.show();
        
        up.annulla.setOnAction(e -> uploadStage.close());

	///Quando un file passa sulla drag area, quest'ultima indica all'utente che il file viene accettato e copiato.
        up.dragArea.setOnDragOver((DragEvent event) -> {
        	Dragboard db = event.getDragboard();
        	if (db.hasFiles()) {
        		event.acceptTransferModes(TransferMode.COPY);
        	}
        });

	///Quando il tasto sinistro del mouse viene rilasciato sulla drag area, il file trasportato viene copiato e acquisito dal programma.
        up.dragArea.setOnDragDropped((DragEvent event) -> {
            Dragboard db = event.getDragboard();
            boolean success = false;
            if (db.hasFiles()) {
                success = true;
                List<File> files = db.getFiles();
                File draggedFile = files.get(0); 
                if (!up.verificaSupportoFile(draggedFile)) {///< Verifica che il file sia di un formato accettato.
                    up.fileNonSupportatoAlert();
                } else {
                    up.file.setText("File selezionato: " + draggedFile.getName());
                    up.estraiContatti(draggedFile, controller);///< Se il file è di un formato accettato, inizia l'estrazione dei contatti dal file.
                    uploadStage.close();
                }
            }
            event.setDropCompleted(success);
            event.consume();
        });
        
        ///In alternativa al drag and drop, si può usare la modalità di navigazione tra le varie cartelle del pc, perr giungere al file desiderato dall'utente.
        up.sfogliaFile.setOnAction(e -> {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Seleziona un file");
		fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("File di testo", "*.txt"));
		File fileSelezionato = fileChooser.showOpenDialog(uploadStage);
                if (fileSelezionato != null) {///< Verifica che il file sia di un formato accettato.
                	if (!up.verificaSupportoFile(fileSelezionato)) {
                    up.fileNonSupportatoAlert();
                    }else {
                    up.file.setText("File selezionato: " + fileSelezionato.getAbsolutePath());
                    up.estraiContatti(fileSelezionato, controller);///< Se il file è di un formato accettato, inizia l'estrazione dei contatti dal file.
                    uploadStage.close();
                    }
                }
                
        });
    }
    
    /**
     * Salva tutti i contatti della rubrica in un file scelto dall'utente.
     * 
     * @param controller Contiene i contatti da salvare.
     */
    public void downloadContatti(RubricaController controller){
	///L'utente effettua la navigazione verso il file che andrà a contenere i contatti.
	FileChooser fileChooser = new FileChooser();
	fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File file = fileChooser.showSaveDialog(controller.view.getScene().getWindow());

	try (FileWriter writer = new FileWriter(file)) { 
        for (Contatto c : controller.lista) {
	///Viene creata una riga per ogni contatto, in base alle loro info, dopodichè ogni riga viene scritta nel file dal writer.
            String line = c.getCognome()+"|"+c.getNome()+"|"
                        +c.getNumeroTelefono1()+"|"+c.getNumeroTelefono2()+"|"
                        +c.getNumeroTelefono3()+"|"+c.getEmail()+"|"
                       +c.getEmai2()+"|"+c.getEmai3();
            writer.write(line+System.lineSeparator());
        }
    } catch (IOException e) {
    }
    downloadCompletatoAlert();
    }
    

    /**
     * @brief Mostra un avviso una volta completato il download.
     *
     * Mostra un messaggio che informa della riuscita del download.
     */
    private void downloadCompletatoAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Download completato.", ButtonType.OK);
        alert.setHeaderText(null); 
        alert.showAndWait(); 
        }
    

    /**
     * Legge un file di testo contenente informazioni sui contatti, estrae i dati per ogni riga, li converte in oggetti di tipo Contatto e li aggiunge alla lista di contatti.
     * 
     * @param file Il file da cui leggere i contatti.
     * @param controller Il controller della rubrica che gestirà i contatti letti.
     */
    public void leggi(File file,RubricaController controller){
        List<Contatto> estratti=new ArrayList<>();
        int cont=1;
        try(BufferedReader read=new BufferedReader(new FileReader(file))){
            String line;
            while ((line=read.readLine())!=null){
                Contatto c=new Contatto();
                Scanner i=new Scanner(line);
                i.useDelimiter("\\|");
                
                c.setCognome(i.next());
                c.setNome(i.next());
                if(c.getNome().equals("")&&c.getCognome().equals("")){
                    System.out.println("ERRORE! Il contatto numero "+cont+" non presenta un nome o un cognome: impossibile salvare il contatto!");
                }else{
                
                
                c.setNumeroTelefono1(i.next());
                c.setNumeroTelefono2(i.next());
                c.setNumeroTelefono3(i.next());
                c.setEmail1(i.next());
                c.setEmail2(i.next());
                if(i.hasNext())
                    c.setEmail3(i.next());
                else
                    c.setEmail3("");
                cont++;
                
                i.close();
                estratti.add(c);
                }
            }
        } catch (IOException e){
            
        }
        for(Contatto c : estratti){
            controller.aggiungiContatto(c);
        }
    }
    

    public static void main(String[] args) {
        launch(args);
    }
    
}
