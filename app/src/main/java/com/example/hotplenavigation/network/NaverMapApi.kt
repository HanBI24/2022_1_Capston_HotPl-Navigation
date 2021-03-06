package com.example.hotplenavigation.network

import com.example.hotplenavigation.data.geo.GeoApi
import com.example.hotplenavigation.data.geo_reverse.ReverseGeoApi
import com.example.hotplenavigation.data.get_result_path.GetResultPath
import com.example.hotplenavigation.data.search_result.SearchResultData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

// 20165304 김성곤
// Naver Map API 호출을 위한 interface
interface NaverMapApi {

    // 경로 얻어오기
    @GET("v1/driving")
    fun getResultPath(
        @Header("X-NCP-APIGW-API-KEY-ID") apiKeyID: String,
        @Header("X-NCP-APIGW-API-KEY") apiKey: String,
        @Query("start") start: String,
        @Query("goal") goal: String,
        @Query("option") option: String,
    ): Call<GetResultPath>

    // 위도, 경도 값을 실 주소로 얻어오기
    @GET("v2/gc")
    fun getReverseGeo(
        @Header("X-NCP-APIGW-API-KEY-ID") apiKeyId: String,
        @Header("X-NCP-APIGW-API-KEY") apiKey: String,
        @Query("coords") coords: String,
        @Query("output") output: String = "json",
        @Query("orders") orders: String = "addr"
    ): Call<ReverseGeoApi>

    // 검색 결과 얻어오기
    @GET("v1/search/local.json")
    fun getSearchResult(
        @Header("X-Naver-Client-Id") apiKeyId: String,
        @Header("X-Naver-Client-Secret") apiKey: String,
        @Query("display") display: Int,
        @Query("start") start: Int,
        @Query("sort") sort: String,
        @Query("query") query: String
    ): Call<SearchResultData>

    // 실 주소를 위도, 경도 값으로 얻어오기
    @GET("v2/geocode")
    fun getGeoCode(
        @Header("X-NCP-APIGW-API-KEY-ID") apiKeyId: String,
        @Header("X-NCP-APIGW-API-KEY") apiKey: String,
        @Query("query") query: String
    ): Call<GeoApi>
}
