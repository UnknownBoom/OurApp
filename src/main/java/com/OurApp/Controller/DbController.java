
package com.OurApp.Controller;

import java.net.URL;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.ResourceBundle;

import com.OurApp.Controller.Sql.SqlQuery;
import com.OurApp.InitApp.Connect_Statement;
import com.OurApp.InitApp.javaFxLaunch;
import com.OurApp.Model.DbContext.Authors;
import com.OurApp.Model.DbContext.Books;
import com.OurApp.Model.DbContext.Readers;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class DbController {
    Unity unity = Unity.getInstance();
    Connect_Statement connect_statement = Connect_Statement.getInstance();
    SqlQuery sqlQuery = SqlQuery.getInstance();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView notes;

    @FXML
    private ImageView Roll;

    @FXML
    private ImageView BClose;

    @FXML
    private ImageView AddImage;

    @FXML
    private ImageView UpDateImage;

    @FXML
    private ImageView DeleteImage;

    @FXML
    private ImageView AuthorsExecuteImage;

    @FXML
    private TextField Author_Id_Field;

    @FXML
    private TextField Author_F_Name_Field;

    @FXML
    private TextField Author_L_Name_Field;

    @FXML
    private TextField Author_Lang_Field;

    @FXML
    private TextArea Author_sql_field;

    @FXML
    private Label Author_Error_Label;

    @FXML
    private TableView<Authors> Authors_Table;

    @FXML
    private TableColumn<Authors, Integer> Author_Id_Col;

    @FXML
    private TableColumn<Authors, String> Author_F_Name_Col;

    @FXML
    private TableColumn<Authors, String> Author_L_Name_Col;

    @FXML
    private TableColumn<Authors, String> Author_Lang_Col;

    @FXML
    private TableView<Readers> Readers_Table;

    @FXML
    private TableColumn<Readers, Integer> Readers_id_Col;

    @FXML
    private TableColumn<Readers,String> Readers_F_Name_Col;

    @FXML
    private TableColumn<Readers, String> Readers_L_Name_Col;

    @FXML
    private TableColumn<Readers, String> Readers_Email_Col;

    @FXML
    private ImageView ReadersExecuteimage;

    @FXML
    private TextField Readers_Id_Field;

    @FXML
    private TextField Readers_F_Name_field;

    @FXML
    private TextField Readers_L_Name_Field;

    @FXML
    private TextField Readers_Email_Field;

    @FXML
    private TextArea Readers_sql_Field;

    @FXML
    private Label Readers_Error_Label;
    @FXML
    private TableView<Books> Books_Table;

    @FXML
    private TableColumn<Books, Integer> Books_Id_col;

    @FXML
    private TableColumn<Books, String> Books_Title_col;

    @FXML
    private TableColumn<Books, Integer> Books_Author_Id_col;

    @FXML
    private TableColumn<Books, Integer> Books_Rent_Price_col;

    @FXML
    private ImageView BooksExecuteimage;

    @FXML
    private TextField Books_Id_Field;

    @FXML
    private TextField Books_Title_Field;

    @FXML
    private TextField Books_Author_Id_Field;

    @FXML
    private TextField Books_Rent_Price_Field;

    @FXML
    private TextArea Books_sql_Field;

    @FXML
    private Label Books_Error_Label;
//Rents
    @FXML
    private TableView<?> ATable21;

    @FXML
    private TableColumn<?, ?> AId21;

    @FXML
    private TableColumn<?, ?> AFN21;

    @FXML
    private TableColumn<?, ?> ALN21;

    @FXML
    private TableColumn<?, ?> AL21;

    @FXML
    private TableColumn<?, ?> AL211;

    @FXML
    private ImageView AEx21;

    @FXML
    private TextField AIdFielText21;

    @FXML
    private TextField AFNameFiledText21;

    @FXML
    private TextField ALNameFieldText21;

    @FXML
    private TextField ALanfFieldText21;

    @FXML
    private TextArea ATA21;
    //RentsEnd

    @FXML
    private Label AErrorLabel21;
    public void closeApp(){
        try {
            if(connect_statement.getConnection()!=null){
                connect_statement.getConnection().close();
            }
        } catch (Exception throwables) {
            System.out.println("\n" + Arrays.toString(throwables.getStackTrace()));
            System.out.println(throwables.getMessage());

        }finally {
            javaFxLaunch.get_primaryStage().close();
        }
    }
    
    private void Binding(){
        //Authors
        Authors_Table.setItems(unity.getObservableListForAuthors());
        Author_Id_Col.setCellValueFactory(v->v.getValue()._idProperty().asObject());
        Author_F_Name_Col.setCellValueFactory(v->v.getValue()._f_nameProperty());
        Author_L_Name_Col.setCellValueFactory(v->v.getValue()._l_nameProperty());
        Author_Lang_Col.setCellValueFactory(v->v.getValue()._langProperty());
        //Readers
        Readers_Table.setItems(unity.getObservableListForReaders());
        Readers_id_Col.setCellValueFactory(v->v.getValue()._idProperty().asObject());
        Readers_F_Name_Col.setCellValueFactory(v->v.getValue()._f_nameProperty());
        Readers_L_Name_Col.setCellValueFactory(v->v.getValue()._l_nameProperty());
        Readers_Email_Col.setCellValueFactory(v->v.getValue()._emailProperty());
        //Books
        Books_Table.setItems(unity.getObservableListForBooks());
        Books_Id_col.setCellValueFactory(v->v.getValue()._idProperty().asObject());
        Books_Title_col.setCellValueFactory(v->v.getValue()._titleProperty());
        Books_Author_Id_col.setCellValueFactory(v->v.getValue()._author_idProperty().asObject());
        Books_Rent_Price_col.setCellValueFactory(v->v.getValue()._rent_priceProperty().asObject());
    }
    private void setValueForAuthors(ResultSet authors){
        if(authors!=null){
            try{
                while(authors.next()){
                    unity.addObservableListForAuthors(Authors.newBuilder().setId(authors.getInt(1))
                            .setF_Name(authors.getString(2)).setL_Name(authors.getString(3))
                    .setLang(authors.getString(4)).Build());
                }
            } catch (Exception throwables) {
                System.out.println(throwables.getMessage());
                Author_Error_Label.setText("Error unpack Result set");
            }
        }

    }
    private void setValueForReaders(ResultSet readers){
        if(readers!=null){
            try{
                while(readers.next()){
                    unity.addObservableListForReaders(Readers.newBuilder().setId(readers.getInt(1))
                            .setF_Name(readers.getString(2)).setL_Name(readers.getString(3))
                            .setEmail(readers.getString(4)).Build());
                }
            } catch (Exception throwables) {
                System.out.println(throwables.getMessage());
                Readers_Error_Label.setText("Error unpack Result set");
            }
        }

    }
    private void setValueForBooks(ResultSet books){
        if(books!=null){
            try{
                while(books.next()){
                    unity.addObservableListForBooks(Books.newBuilder().setId(books.getInt(1))
                            .setTitle(books.getString(2)).setAuthor_Id(books.getInt(3))
                            .setRent_Price(books.getInt(4)).Build());
                }
            } catch (Exception throwables) {
                System.out.println(throwables.getMessage());
                Books_Error_Label.setText("Error unpack Result set");
            }
        }
    }


    @FXML
    void initialize() {
        Binding();
        BClose.setOnMouseClicked(e-> closeApp());
        sqlQuery.setStatement(connect_statement.getStatement());
        ResultSet authors = sqlQuery.ExecuteAllSelectAuthors();
        setValueForAuthors(authors);
        ResultSet readers= sqlQuery.ExecuteAllSelectReaders();
        setValueForReaders(readers);
        ResultSet books= sqlQuery.ExecuteAllSelectBooks();
        setValueForBooks(books);


    }

}

