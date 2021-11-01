package bikedetail.controller;

import java.util.*;

import javax.swing.*;

import abstractdata.controller.IDataSearchController;
import bikedetail.gui.BikeListPane;
import abstractdata.gui.ADataSearchPane;
import abstractdata.gui.ADataSinglePane;
import abstractdata.gui.*;
import api.EBRApi;
import com.ebr.bean.Bike;
import bikedetail.gui.*;
import bikedetail.gui.ListBikeDataPagePane;

import java.util.List;
import java.util.Map;

public class ListBikeInfoController {
    private ListBikeDataPagePane pagePane;

    private int id;
    private List<Bike> list;
    public int getId(){ return id;}
    public void setId(int id){ this.id = id;}

    public ListBikeInfoController(int id){
        setId(id);
        BikeListPane listPane = createListPane();

        ADataSearchPane searchPane = createSearchPane();

        searchPane.setController(new IDataSearchController() {
            @Override
            public void search(Map<String, String> searchParams) {
                list = ListBikeInfoController.this.getBike(searchParams);
                listPane.updateData(list);
            }
        });

        searchPane.fireSearchEvent();

        pagePane = new ListBikeDataPagePane(searchPane, listPane);
    }

    public JPanel getDataPagePane() {
        return pagePane;
    }

    public List<Bike> getBike(Map<String, String> searchParams) {
            return new EBRApi().searchBikes(searchParams,this.id);
    }


    public BikeListPane createListPane(){
        return new BikeListPane(this);
    }

    public ADataSinglePane createSinglePane(){
        return new BikeSinglePane();
    }

    public ADataSearchPane createSearchPane(){
        return new BikeSearchPane();
    }

}
