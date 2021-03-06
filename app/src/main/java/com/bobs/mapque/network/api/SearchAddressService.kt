package com.bobs.mapque.network.api

import com.bobs.mapque.network.response.coord.CoordInfoResponse
import com.bobs.mapque.network.response.keyword.SearchKeyWordResponse
import com.bobs.mapque.network.response.searchaddress.SearchAddressResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchAddressService {
    // 주소 검색 API
    @GET("/v2/local/search/address.json")
    fun searchAddress(
        @Query("query") query: String
    ) : Single<SearchAddressResponse>

    // 키워드 검색 API
    @GET("/v2/local/search/keyword.json")
    fun searchKeyword(
        @Query("query") query: String,
        @Query("y") latitude: Double,
        @Query("x") longitude: Double,
        @Query("radius") radius: Int
    ) : Single<SearchKeyWordResponse>

    // 좌표 -> 주소 변환 API
    @GET("/v2/local/geo/coord2address.json")
    fun getCoordInfo(
        @Query("x") longitude: Double,
        @Query("y") latitude: Double,
        @Query("input_coord") input: String = "WGS84"
    ) : Single<CoordInfoResponse>
}