package com.mycompany.rubrica;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * @class RubricaController
 * @brief Classe controller per la gestione dell'applicazione Rubrica.
 *
 * Questa classe gestisce l'interazione tra l'interfaccia utente e i dati dei contatti.
 * Permette di visualizzare, aggiungere, modificare, cercare ed eliminare contatti.
 * 
 *
 * @author Francesco, Antonio, Gennaro.
 * 
 */
public class RubricaController {
    final InterfacciaRubrica view;
    Set<Contatto> lista;

    /**
     * Costruttore della classe RubricaController.
     * Inizializza la vista e crea una nuova lista di contatti vuota.
     * 
     * @param view l'interfaccia utente della rubrica
     */    
    public RubricaController(InterfacciaRubrica view){
        this.view=view;
        this.lista=new TreeSet<>();
    }

    /**
     * Visualizza i contatti nella vista, aggiornando l'interfaccia utente.
     * Ogni contatto viene rappresentato da un {@link HBox} contenente le informazioni
     * del contatto e i pulsanti per modificarlo o eliminarlo.
     * 
     * @param elenco Set di contatti da visualizzare
     */
    public void display(Set<Contatto> elenco){
        view.listaContatti.getChildren().clear(); ///< Pulisce la lista visibile dei contatti.
        
        view.contatore.setText(""+lista.size()); ///< Aggiorna il contatore dei contatti.
        
        ///Ciclo per creare un'interfaccia che modifica o elimina ogni un contatto, per ogni contatto nell'elenco.
        for(Contatto c : elenco){
            
            
        ///Creazione di una riga per visualizzare il contatto.
        HBox contatto=new HBox();
        contatto.setSpacing(15);
        contatto.setAlignment(Pos.CENTER);
        contatto.setStyle("-fx-border-color: black; -fx-border-width: 1px 2px 1px 2px; -fx-padding: 10px;");
        contatto.setMaxWidth(1650.0);
        
        
        Button modifica=new Button("Modifica"); ///< Pulsante per modificare il contatto.
        modifica.setOnAction(event-> { ///< Crea una nuova finestra per modificare il contatto.
            Stage mod=new Stage();
            VBox modview=new VBox();
            Label modificalbl; 
            TextField[] campi = new TextField[8];  
            Label[] tags=new Label[8];
            Button conferma;              
            Button annulla;
            modview.setSpacing(10);
            modview.setAlignment(Pos.CENTER);
            modificalbl=new Label("Modifica contatto");
            modificalbl.setStyle("-fx-font-size: 24px;");
            modview.getChildren().add(modificalbl);
        
            ///Etichette per i campi.
            tags[0]=new Label("Cognome");
            tags[1]=new Label("Nome");
            for(int i=0;i<3;i++)
                tags[i+2]=new Label("Numero di telefono "+(i+1));
            for(int i=0;i<3;i++)
                tags[i+5]=new Label("Email "+(i+1));
            

            ///Campi di testo con i dati del contatto.
            campi[0]=new TextField(c.getCognome());
            campi[1]=new TextField(c.getNome());
            campi[2]=new TextField(c.getNumeroTelefono1());
            campi[3]=new TextField(c.getNumeroTelefono2());
            campi[4]=new TextField(c.getNumeroTelefono3());
            campi[5]=new TextField(c.getEmail());
            campi[6]=new TextField(c.getEmai2());
            campi[7]=new TextField(c.getEmai3());
            
            for(int i=0;i<8;i++){
                campi[i].setMaxWidth(400.0);
                campi[i].setAlignment(Pos.CENTER);
                modview.getChildren().addAll(tags[i],campi[i]);
            }
            HBox bottoni=new HBox();
            bottoni.setAlignment(Pos.BOTTOM_RIGHT);
            bottoni.setSpacing(20);
            bottoni.setPadding(new Insets(20));
            
            conferma=new Button("Conferma"); ///< Pulsante di conferma della modifica.
            conferma.setOnAction(evento-> { ///< Aggiorna i dati del contatto e salva.
                String cognome=campi[0].getText();
                String nome=campi[1].getText();
                
                c.setCognome(cognome);
                c.setNome(nome);
                c.setNumeroTelefono1(campi[2].getText());
                c.setNumeroTelefono2(campi[3].getText());
                c.setNumeroTelefono3(campi[4].getText());
                c.setEmail1(campi[5].getText());
                c.setEmail2(campi[6].getText());
                c.setEmail3(campi[7].getText());
                salvataggio();
                display(lista);
                mod.close();
            });
            
            annulla=new Button("Annulla"); ///< Pulsante per annullare la modifica.
            annulla.setOnAction(even-> mod.close());
            
            bottoni.getChildren().addAll(conferma,annulla);
            modview.getChildren().add(bottoni);
            Scene nuovascena=new Scene(modview,600,700);
            mod.setTitle("aggiungi contatto");
            mod.setScene(nuovascena);
            mod.show();
        
        });
        
        Button elimina=new Button("Elimina"); ///< Pulsante per eliminare il contatto.
        elimina.setOnAction(e-> { ///< Finestra di conferma per eliminare il contatto.
            Stage remove=new Stage();
            VBox removeview=new VBox();
            Label rimuovi;
            Button conferma;              
            Button annulla;
            removeview.setSpacing(10);
            removeview.setAlignment(Pos.CENTER);
            rimuovi=new Label("Sicuro di voler eliminare il contatto "+c.toString()+"?");
            rimuovi.setStyle("-fx-font-size: 20px;");
            removeview.getChildren().add(rimuovi);
            HBox bottoni=new HBox();
            bottoni.setAlignment(Pos.BOTTOM_RIGHT);
            bottoni.setSpacing(20);
            bottoni.setPadding(new Insets(20));
            conferma=new Button("Conferma");
            conferma.setOnAction(ev-> {
                view.listaContatti.getChildren().remove(contatto);
                remove.close();
                eliminaContatto(c);
            });
            annulla=new Button("Annulla");
            annulla.setOnAction(eve-> remove.close());
            
            bottoni.getChildren().addAll(conferma,annulla);
            removeview.getChildren().add(bottoni);
            Scene nuovascena=new Scene(removeview,600,200);
            remove.setTitle("rimuovi contatto");
            remove.setScene(nuovascena);
            remove.show();
        
            
        });
        ///Etichette per visualizzare i dettagli del contatto.
        Label numero1=new Label(c.getNumeroTelefono1());
        Label numero2=new Label(c.getNumeroTelefono2());
        Label numero3=new Label(c.getNumeroTelefono3());
        VBox numeri=new VBox();
        numeri.getChildren().addAll(numero1,numero2,numero3);
        Label surname=new Label(c.getCognome());
        surname.setPadding(new Insets(20));
        Label name=new Label(c.getNome());
        name.setPadding(new Insets(20));
        VBox mails=new VBox(new Label(c.getEmail()),new Label(c.getEmai2()),new Label(c.getEmai3()));
        
        ///Aggiunge tutti gli elementi all'HBox.
        contatto.getChildren().addAll(surname,name,numeri,mails,modifica,elimina);
        
        ///Aggiunge l'HBox alla vista.
        view.listaContatti.getChildren().add(contatto);
        }
        
    }
    
    /**
     * Aggiunge un nuovo contatto alla rubrica.
     * Dopo l'aggiunta, i dati vengono salvati e la vista aggiornata.
     * 
     * @param c il contatto da aggiungere
     */
    public void aggiungiContatto(Contatto c){
        lista.add(c);
        salvataggio();
        this.display(lista);
    }

    /**
     * Esegue una ricerca nella rubrica in base al testo inserito dall'utente.
     * I contatti vengono filtrati in base al cognome o al nome.
     */
    public void ricercaContatto(){
        
        Set<Contatto> ricercati=new TreeSet<>();
        String s=this.view.ricerca.getText().toUpperCase();
        if(s==null){
            this.display(lista);
        }else{
            for(Contatto c : lista){
                if(c.getCognome().contains(s)||c.getNome().contains(s))
                    ricercati.add(c);
            }
        }
        this.display(ricercati);
    }
    
    /**
     * Elimina un contatto dalla rubrica.
     * Dopo l'eliminazione, i dati vengono salvati e la vista aggiornata.
     * 
     * @param c il contatto da eliminare
     */
    public void eliminaContatto(Contatto c){
        lista.remove(c);
        salvataggio();
        this.display(lista);
    }
    
    /**
     * Salva la lista dei contatti su un file di testo.
     * Ogni contatto viene salvato in formato '.txt', con i campi separati da una barra verticale.
     */
    public void salvataggio(){
        try (FileWriter writer = new FileWriter("Database.txt")) { 
        for (Contatto c : lista) {
            String line = safeValue(c.getCognome())+"|"+safeValue(c.getNome())+"|"
                        +safeValue(c.getNumeroTelefono1())+"|"+safeValue(c.getNumeroTelefono2())+"|"
                        +safeValue(c.getNumeroTelefono3())+"|"+safeValue(c.getEmail())+"|"
                        +safeValue(c.getEmai2())+"|"+safeValue(c.getEmai3());
            writer.write(line+System.lineSeparator());
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
    
    /**
     * Restituisce un safe value per una stringa, sostituendo i valori nulli con una stringa vuota.
     * 
     * @param s la stringa da verificare
     * @return una stringa vuota se il valore è null, altrimenti la stessa stringa
     */
    public String safeValue(String s){
        if(s==null) return "";
        else return s;
    }
    
}
