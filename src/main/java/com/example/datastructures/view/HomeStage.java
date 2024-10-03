package com.example.datastructures.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeStage extends Stage {
    public HomeStage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/datastructures/home-view.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        setScene(scene);
        show();
    }

    private static class HomeStageHolder{
        private static HomeStage INSTANCE;
    }

    public static HomeStage getInstance() throws IOException{
        HomeStageHolder.INSTANCE = HomeStageHolder.INSTANCE != null ? HomeStageHolder.INSTANCE : new HomeStage();

        return HomeStageHolder.INSTANCE;
    }

    public static void deleteInstance(){
        HomeStageHolder.INSTANCE.close();
        HomeStageHolder.INSTANCE = null;
    }
}
