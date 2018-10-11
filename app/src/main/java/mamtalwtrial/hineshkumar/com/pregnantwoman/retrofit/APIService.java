package mamtalwtrial.hineshkumar.com.pregnantwoman.retrofit;

import mamtalwtrial.hineshkumar.com.pregnantwoman.dtos.FormCrf1DTO;
import mamtalwtrial.hineshkumar.com.pregnantwoman.dtos.LoginDTO;
//import mamtalwtrial.hineshkumar.com.pregnantwoman.dtos.TeamDTO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIService {

      //@POST("user/login")
      //Call<LoginDTO> userLogin(@Body TeamDTO body);


    @POST("/form/crf1/save")
    Call<String> sendCrf1(@Body FormCrf1DTO formCrf1DTO);


   /* @POST("/maamta/islogin.php")
    Call<ArrayList<LoginDto>> login(@Body ArrayList<LoginDto> loginDtos);
*/

    // @POST("/maamta/isLogin.php")
    //Call<String[]> login(@Body FormloginCollection formlogindto );


    //@POST("/maamta/isLogin.php")
   // Call<LoginDto> login(@Body LoginDto loginDto);


   /*@FormUrlEncoded
  @POST("/maamta/islogin.php")
  Call<List<FormloginDTO>> saveaccount(@Field("user_name") String userid,
                                 @Field("password") String password
  ) ;*/

   // @POST("LoginController/Login")
   // Call<LoginResponse> createUser(@Body LoginResponse login);




    /*@POST("/test.php")
    Call<String> request(@Query());
*/


/*
    @GET()
    Call<List<String>> showTheStations(@Url String url);
*/

 /*   @GET();
    Call<FormCrf1DTO> sendCrf1Form(@Body FormCrf1DTO body);
*/
//    @POST("form/crf/2/save")
//    Call<FormCrf2DTO> postCrf2(@Body FormCrf2DTO body);
//
//    @POST("form/crf/3a/save")
//    Call<FormCrf3aDTO> postCrf3a(@Body FormCrf3aDTO body);
//
//    @POST("form/crf/3b/save")
//    Call<FormCrf3bDTO> postCrf3b(@Body FormCrf3bDTO body);
//
//    @POST("form/crf/3c/save")
//    Call<FormCrf3cDTO> postCrf3c(@Body FormCrf3cDTO body);
//
//    @POST("form/crf/4a/save")
//    Call<Crf4Complete> postCrf4Complete(@Body Crf4Complete body);
//
//    @POST("form/crf/5a/save")
//    Call<FormCrf5a> postCrf5a(@Body FormCrf5a body);
//
//
//    @GET("search/site/{s}/para/{p}/block/{b}/structrue/{st}")
//    Call<SearchResult> searchWoman(@Path("s") String site, @Path("p") String para, @Path("b") String block, @Path("st") String structure);
//
//    @POST("register/multi")
//    Call<FormCrf1CollectionDTO> sendCrf1ListToServer(@Body FormCrf1CollectionDTO body);
//
//    @POST("form/crf/5b/save")
//    Call<FormCrf5b> postCrf5b(@Body FormCrf5b body);
//
//    @POST("form/crf/6/save")
//    Call<FormCrf6> postCrf6(@Body FormCrf6 body);



}
