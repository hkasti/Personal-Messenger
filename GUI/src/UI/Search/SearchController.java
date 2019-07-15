package UI.Search;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.Scanner;

public class SearchController {
    public TextField searchUser;
    public Button searchB;
    Scanner scanner=new Scanner(System.in);
    public void Search(){

    }
    public void setSearchUser(){
        searchUser.accessibleTextProperty().setValue(scanner.nextLine());
    }
}
