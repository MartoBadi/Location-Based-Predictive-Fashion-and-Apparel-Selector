
package com.ibm.mobileappbuilder.travelanalyser1.pkg120161001081254.ds;
import java.util.List;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;
import retrofit.http.POST;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.Path;
import retrofit.http.PUT;

public interface DataDSServiceRest{

	@GET("/app/57ef713e57acb003000664b7/r/dataDS")
	void queryDataDSItem(
		@Query("skip") String skip,
		@Query("limit") String limit,
		@Query("conditions") String conditions,
		@Query("sort") String sort,
		@Query("select") String select,
		@Query("populate") String populate,
		Callback<List<DataDSItem>> cb);

	@GET("/app/57ef713e57acb003000664b7/r/dataDS/{id}")
	void getDataDSItemById(@Path("id") String id, Callback<DataDSItem> cb);

	@DELETE("/app/57ef713e57acb003000664b7/r/dataDS/{id}")
  void deleteDataDSItemById(@Path("id") String id, Callback<DataDSItem> cb);

  @POST("/app/57ef713e57acb003000664b7/r/dataDS/deleteByIds")
  void deleteByIds(@Body List<String> ids, Callback<List<DataDSItem>> cb);

  @POST("/app/57ef713e57acb003000664b7/r/dataDS")
  void createDataDSItem(@Body DataDSItem item, Callback<DataDSItem> cb);

  @PUT("/app/57ef713e57acb003000664b7/r/dataDS/{id}")
  void updateDataDSItem(@Path("id") String id, @Body DataDSItem item, Callback<DataDSItem> cb);

  @GET("/app/57ef713e57acb003000664b7/r/dataDS")
  void distinct(
        @Query("distinct") String colName,
        @Query("conditions") String conditions,
        Callback<List<String>> cb);
}

