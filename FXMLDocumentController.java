/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_books;

import java.sql.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author Madhan Kumar S
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button button;

    @FXML
    private TextArea output;

    @FXML
    private Label label;

    @FXML
    private TextField bid;

    @FXML
    void Print(ActionEvent event) throws ClassNotFoundException, SQLException {
        String id=bid.getText();
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:1433/madhandatabase","root","root");
        String s2,s3,s4;
        Class.forName("com.mysql.jdbc.Driver");
        Statement stmt=con.createStatement();
        
        ResultSet rs=stmt.executeQuery("select * from books where bookid='"+id+"'");
        
        if(rs.next()){
      s2=rs.getString(2);
      s3=rs.getString(3);
      s4=rs.getString(4);
      String s5=rs.getString(5);
 output.setText(id+"\n"+s2+"\n"+s3+"\n"+s4+"\n"+s5);
    }
    else{
output.setText("nothing");
        
        
    }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
