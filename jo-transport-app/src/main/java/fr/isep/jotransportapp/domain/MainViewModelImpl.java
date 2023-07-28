package fr.isep.jotransportapp.domain;

import javafx.event.ActionEvent;

public class MainViewModelImpl implements MainViewModel {
    @Override
    public void onTap(ActionEvent event) {
        labelTitle.set("Tapped");
    }
}
