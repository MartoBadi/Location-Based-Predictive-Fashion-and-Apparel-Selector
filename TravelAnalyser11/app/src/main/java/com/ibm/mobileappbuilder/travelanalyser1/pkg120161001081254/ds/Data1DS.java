
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
 * "Data1DS" static data source (85495451-eb07-4207-ad04-06cc894f7bc7)
 */
public class Data1DS implements Datasource<Data1DSSchemaItem>, Count,
            Pagination<Data1DSSchemaItem>, Distinct {

    private static final int PAGE_SIZE = 20;

    private SearchOptions searchOptions;

    public static Data1DS getInstance(SearchOptions searchOptions){
        return new Data1DS(searchOptions);
    }

    private Data1DS(SearchOptions searchOptions){
        this.searchOptions = searchOptions;
    }

    @Override
    public void getItems(Listener<List<Data1DSSchemaItem>> listener) {
        listener.onSuccess(Data1DSItems.ITEMS);
    }

    @Override
    public int getPageSize(){
        return PAGE_SIZE;
    }

    @Override
    public void getItem(String id, Listener<Data1DSSchemaItem> listener) {
        final int pos = Integer.parseInt(id);
        if(Data1DSItems.ITEMS.size() <= pos){
        	listener.onSuccess(new Data1DSSchemaItem());
        }
        else {
	        Data1DSSchemaItem dc = Data1DSItems.ITEMS.get(pos);
	        if( dc != null)
	            listener.onSuccess(dc);
	        else
	            listener.onFailure(new IllegalArgumentException("Data1DSSchemaItem not found: " + pos));
	    }
    }

    @Override public int getCount(){
        return Data1DSItems.ITEMS.size();
    }

    @Override
    public void getItems(int pagenum, Listener<List<Data1DSSchemaItem>> listener) {
        int first = pagenum * PAGE_SIZE;
        int last = first + PAGE_SIZE;
        ArrayList<Data1DSSchemaItem> result = new ArrayList<Data1DSSchemaItem>();
        List<Data1DSSchemaItem> filteredList = applySearchOptions(Data1DSItems.ITEMS);
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

    private List<Data1DSSchemaItem> applySearchOptions(List<Data1DSSchemaItem> result) {
        List<Data1DSSchemaItem> filteredList = result;

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

    private List<Data1DSSchemaItem> applySearch(List<Data1DSSchemaItem> items, String searchText) {
        List<Data1DSSchemaItem> filteredList = new ArrayList<>();

        for (Data1DSSchemaItem item : items) {
                        
            if (FilterUtils.searchInString(item.id, searchText) ||
            FilterUtils.searchInString(item.name, searchText) ||
            FilterUtils.searchInString(item.type, searchText))
            {
                filteredList.add(item);
            }
        }

        return filteredList;

    }

    private List<Data1DSSchemaItem> applyFilters(List<Data1DSSchemaItem> items, List<Filter> filters) {
        List<Data1DSSchemaItem> filteredList = new ArrayList<>();

        for (Data1DSSchemaItem item : items) {
            if (
                FilterUtils.applyFilters("id", item.id, filters) &&
                FilterUtils.applyFilters("name", item.name, filters) &&
                FilterUtils.applyFilters("type", item.type, filters)
                ){

                filteredList.add(item);
            }
        }

        return filteredList;
    }

    // Distinct interface

    @Override
    public void getUniqueValuesFor(String columnName, Listener<List<String>> listener) {
        List<Data1DSSchemaItem> filteredList = applySearchOptions(Data1DSItems.ITEMS);
        listener.onSuccess(mapItems(filteredList, columnName));
    }

    private List<String> mapItems(List<Data1DSSchemaItem> items, String columnName){
        // return only unique values
        ArrayList<String> res = new ArrayList();
        for (Data1DSSchemaItem item: items){
            String mapped = mapItem(item, columnName);
            if(mapped != null && !res.contains(mapped))
                res.add(mapped);
        }

        return res;
    }

    private String mapItem(Data1DSSchemaItem item, String columnName){
        // get fields
        switch (columnName){
                        
            case "id":
                return item.id;
            
            case "name":
                return item.name;
            
            case "type":
                return item.type;
            default:
               return null;
        }
    }
}


