
package com.ibm.mobileappbuilder.travelanalyser1.pkg120161001081254.ds;
import java.net.URL;
import com.ibm.mobileappbuilder.travelanalyser1.pkg120161001081254.R;
import ibmmobileappbuilder.ds.RestService;
import ibmmobileappbuilder.util.StringUtils;

/**
 * "DataDSService" REST Service implementation
 */
public class DataDSService extends RestService<DataDSServiceRest>{

    public static DataDSService getInstance(){
          return new DataDSService();
    }

    private DataDSService() {
        super(DataDSServiceRest.class);

    }

    @Override
    public String getServerUrl() {
        return "https://ibm-pods.buildup.io";
    }

    @Override
    protected String getApiKey() {
        return "zoOZxMxP";
    }

    @Override
    public URL getImageUrl(String path){
        return StringUtils.parseUrl("https://ibm-pods.buildup.io/app/57ef713e57acb003000664b7",
                path,
                "apikey=zoOZxMxP");
    }

}

