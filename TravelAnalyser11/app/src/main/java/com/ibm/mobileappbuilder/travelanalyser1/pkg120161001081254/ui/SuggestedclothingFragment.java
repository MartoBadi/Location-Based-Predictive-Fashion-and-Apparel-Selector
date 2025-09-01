
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

public class SuggestedclothingFragment extends ibmmobileappbuilder.ui.DetailFragment<Data1DSSchemaItem>  {

    private Datasource<Data1DSSchemaItem> datasource;
    private SearchOptions searchOptions;

    public static SuggestedclothingFragment newInstance(Bundle args){
        SuggestedclothingFragment card = new SuggestedclothingFragment();
        card.setArguments(args);

        return card;
    }

    public SuggestedclothingFragment(){
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
        return R.layout.suggestedclothing_custom;
    }

    @Override
    @SuppressLint("WrongViewCast")
    public void bindView(final Data1DSSchemaItem item, View view) {
        
        TextView view0 = (TextView) view.findViewById(R.id.view0);
        view0.setText("Tops");
        
        
        TextView view1 = (TextView) view.findViewById(R.id.view1);
        view1.setText("Sportswear");
        
        
        TextView view2 = (TextView) view.findViewById(R.id.view2);
        view2.setText("Festive wear");
        
    }

    @Override
    protected void onShow(Data1DSSchemaItem item) {
        // set the title for this fragment
        getActivity().setTitle("suggested clothing");
    }

}

