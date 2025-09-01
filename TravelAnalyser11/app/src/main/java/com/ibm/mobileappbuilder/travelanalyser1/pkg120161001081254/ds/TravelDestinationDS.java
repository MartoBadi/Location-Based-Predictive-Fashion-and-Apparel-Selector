
package com.ibm.mobileappbuilder.travelanalyser1.pkg120161001081254.ds;

import ibmmobileappbuilder.ds.Count;
import ibmmobileappbuilder.ds.Datasource;
import ibmmobileappbuilder.ds.Distinct;
import ibmmobileappbuilder.ds.Pagination;
import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.filter.Filter;
import ibmmobileappbuilder.util.FilterUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * "TravelDestinationDS" static data source (d915ae74-1c01-493d-93ff-1fd5831a3e91)
 */
public class TravelDestinationDS implements Datasource<TravelDestinationDSSchemaItem>, Count,
            Pagination<TravelDestinationDSSchemaItem>, Distinct {

    private static final int PAGE_SIZE = 20;

    private SearchOptions searchOptions;

    public static TravelDestinationDS getInstance(SearchOptions searchOptions){
        return new TravelDestinationDS(searchOptions);
    }

    private TravelDestinationDS(SearchOptions searchOptions){
        this.searchOptions = searchOptions;
    }

    @Override
    public void getItems(Listener<List<TravelDestinationDSSchemaItem>> listener) {
        listener.onSuccess(TravelDestinationDSItems.ITEMS);
    }

    @Override
    public int getPageSize(){
        return PAGE_SIZE;
    }

    @Override
    public void getItem(String id, Listener<TravelDestinationDSSchemaItem> listener) {
        final int pos = Integer.parseInt(id);
        if(TravelDestinationDSItems.ITEMS.size() <= pos){
        	listener.onSuccess(new TravelDestinationDSSchemaItem());
        }
        else {
	        TravelDestinationDSSchemaItem dc = TravelDestinationDSItems.ITEMS.get(pos);
	        if( dc != null)
	            listener.onSuccess(dc);
	        else
	            listener.onFailure(new IllegalArgumentException("TravelDestinationDSSchemaItem not found: " + pos));
	    }
    }

    @Override public int getCount(){
        return TravelDestinationDSItems.ITEMS.size();
    }

    @Override
    public void getItems(int pagenum, Listener<List<TravelDestinationDSSchemaItem>> listener) {
        int first = pagenum * PAGE_SIZE;
        int last = first + PAGE_SIZE;
        ArrayList<TravelDestinationDSSchemaItem> result = new ArrayList<TravelDestinationDSSchemaItem>();
        List<TravelDestinationDSSchemaItem> filteredList = applySearchOptions(TravelDestinationDSItems.ITEMS);
        if(first < filteredList.size())
            for (int i = first; (i < last) && (i < filteredList.size()); i++)
                result.add(filteredList.get(i));

        listener.onSuccess(result);
    }

    @Override
    public void onSearchTextChanged(String s){
        searchOptions.setSearchText(s);
    }

    @Override
    public void addFilter(Filter filter){
        searchOptions.addFilter(filter);
    }

    @Override
    public void clearFilters() {
        searchOptions.setFilters(null);
    }

    private List<TravelDestinationDSSchemaItem> applySearchOptions(List<TravelDestinationDSSchemaItem> result) {
        List<TravelDestinationDSSchemaItem> filteredList = result;

        //Searching options
        String searchText = searchOptions.getSearchText();

        if(searchOptions.getFixedFilters() != null)
            filteredList = applyFilters(filteredList, searchOptions.getFixedFilters());

        if(searchOptions.getFilters() != null)
            filteredList = applyFilters(filteredList, searchOptions.getFilters());

        if (searchText != null && !"".equals(searchText))
            filteredList = applySearch(filteredList, searchText);

        //Sorting options
        Comparator comparator = searchOptions.getSortComparator();
        if (comparator != null) {
            if (searchOptions.isSortAscending()) {
                Collections.sort(filteredList, comparator);
            } else {
                Collections.sort(filteredList, Collections.reverseOrder(comparator));
            }
        }

        return filteredList;
    }

    private List<TravelDestinationDSSchemaItem> applySearch(List<TravelDestinationDSSchemaItem> items, String searchText) {
        List<TravelDestinationDSSchemaItem> filteredList = new ArrayList<>();

        for (TravelDestinationDSSchemaItem item : items) {
                        
            if (FilterUtils.searchInString(item.id, searchText) ||
            FilterUtils.searchInString(item.text1, searchText) ||
            FilterUtils.searchInString(item.text2, searchText) ||
            FilterUtils.searchInString(item.text3, searchText))
            {
                filteredList.add(item);
            }
        }

        return filteredList;

    }

    private List<TravelDestinationDSSchemaItem> applyFilters(List<TravelDestinationDSSchemaItem> items, List<Filter> filters) {
        List<TravelDestinationDSSchemaItem> filteredList = new ArrayList<>();

        for (TravelDestinationDSSchemaItem item : items) {
            if (
                FilterUtils.applyFilters("id", item.id, filters) &&
                FilterUtils.applyFilters("text1", item.text1, filters) &&
                FilterUtils.applyFilters("text2", item.text2, filters) &&
                FilterUtils.applyFilters("picture", item.picture, filters) &&
                FilterUtils.applyFilters("text3", item.text3, filters)
                ){

                filteredList.add(item);
            }
        }

        return filteredList;
    }

    // Distinct interface

    @Override
    public void getUniqueValuesFor(String columnName, Listener<List<String>> listener) {
        List<TravelDestinationDSSchemaItem> filteredList = applySearchOptions(TravelDestinationDSItems.ITEMS);
        listener.onSuccess(mapItems(filteredList, columnName));
    }

    private List<String> mapItems(List<TravelDestinationDSSchemaItem> items, String columnName){
        // return only unique values
        ArrayList<String> res = new ArrayList();
        for (TravelDestinationDSSchemaItem item: items){
            String mapped = mapItem(item, columnName);
            if(mapped != null && !res.contains(mapped))
                res.add(mapped);
        }

        return res;
    }

    private String mapItem(TravelDestinationDSSchemaItem item, String columnName){
        // get fields
        switch (columnName){
                        
            case "id":
                return item.id;
            
            case "text1":
                return item.text1;
            
            case "text2":
                return item.text2;
            
            case "text3":
                return item.text3;
            default:
               return null;
        }
    }
}


