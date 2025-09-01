
package com.ibm.mobileappbuilder.travelanalyser1.pkg120161001081254.ui;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.ibm.mobileappbuilder.travelanalyser1.pkg120161001081254.R;
import ibmmobileappbuilder.ds.Datasource;
import android.widget.TextView;
import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.filter.Filter;
import java.util.Arrays;
import com.ibm.mobileappbuilder.travelanalyser1.pkg120161001081254.ds.Data1DSSchemaItem;
import com.ibm.mobileappbuilder.travelanalyser1.pkg120161001081254.ds.Data1DS;

public class TravelDestinationScreen1Fragment extends ibmmobileappbuilder.ui.DetailFragment<Data1DSSchemaItem>  {

    private Datasource<Data1DSSchemaItem> datasource;
    private SearchOptions searchOptions;

    public static TravelDestinationScreen1Fragment newInstance(Bundle args){
        TravelDestinationScreen1Fragment card = new TravelDestinationScreen1Fragment();
        card.setArguments(args);

        return card;
    }

    public TravelDestinationScreen1Fragment(){
        super();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            searchOptions = SearchOptions.Builder.searchOptions().build();
    }

    @Override
    public Datasource getDatasource() {
      if (datasource != null) {
          return datasource;
      }
          datasource = Data1DS.getInstance(searchOptions);
          return datasource;
    }

    // Bindings

    @Override
    protected int getLayout() {
        return R.layout.traveldestinationscreen1_custom;
    }

    @Override
    @SuppressLint("WrongViewCast")
    public void bindView(final Data1DSSchemaItem item, View view) {
        if (item.name != null){
            
            TextView view0 = (TextView) view.findViewById(R.id.view0);
            view0.setText(item.name);
            
        }
        if (item.type != null){
            
            TextView view1 = (TextView) view.findViewById(R.id.view1);
            view1.setText(item.type);
            
        }
    }

    @Override
    protected void onShow(Data1DSSchemaItem item) {
        // set the title for this fragment
        getActivity().setTitle("Travel Destination");
    }

}

