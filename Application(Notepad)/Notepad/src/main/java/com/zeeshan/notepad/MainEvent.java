package com.zeeshan.notepad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ResourceBundle;

public class MainEvent implements Initializable {

    String o=null;
    FileChooser fileChooser;
    @FXML
    private TextArea textField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    // * * * * * * * * * * Menu File * * * * * * * * *
    public void NewFile(ActionEvent e){
        Main m=new Main();
        try {
            m.start1();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    public void OpenFile(ActionEvent e){
        fileChooser=new FileChooser();
        fileChooser.setTitle("Open file");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        File f=fileChooser.showOpenDialog(null);

        Path p=Path.of(String.valueOf(f));

        try {
            o= Files.readString(p);
            textField.setText(o);
        }
        catch(IOException ex){
            throw new RuntimeException(ex);
        }

        System.out.println(p);
    }
    public void Save(ActionEvent e){

        fileChooser=new FileChooser();
        fileChooser.setTitle("Save");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        File f=fileChooser.showSaveDialog(null);

        Path p= Path.of(f.getPath());

        try {
            FileWriter o1 = new FileWriter(p.toFile());
            o1.write(textField.getText());
            System.out.println("File created.");
            o1.close();



        }
        catch (Exception er) {
            System.out.println("File creating error :" + er);
        }
    }
    public void SaveAs(ActionEvent e){
        fileChooser=new FileChooser();
        fileChooser.setTitle("Save as");
        File f=fileChooser.showSaveDialog(null);

        Path p= Path.of(f.getPath());

        try {
            FileWriter o1 = new FileWriter(p.toFile());
            o1.write(textField.getText());
            System.out.println("File created.");
            o1.close();
        }
        catch (Exception er) {
            System.out.println("File creating error :" + er);
        }
    }
    public void Exit(ActionEvent e){
        System.out.println("Exit");
        System.exit(0);
    }

    // * * * * * * * * * * Menu Edit * * * * * * * * *
    public void SelectAll(ActionEvent e){
        textField.selectAll();
    }
    public void Copy(ActionEvent e){
        textField.copy();
    }
    public void Cut(ActionEvent e){
        textField.cut();
    }
    public void Paste(ActionEvent e){
        textField.paste();
    }
    public void Redo(ActionEvent e){
        textField.redo();
    }
    public void Undo(ActionEvent e){
        textField.undo();
    }
    public void Delete(ActionEvent e){
        textField.clear();
    }

    // * * * * * * * * * * Menu Help * * * * * * * * *
    public void Help(ActionEvent e){
        Alert a=new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Help");
        a.setContentText("This is a simple notepad.\nMade with JavaFX.\nFor more information visit\nhttp://www.notepad.com/help");
        a.setHeaderText(null);
        a.show();
    }
}