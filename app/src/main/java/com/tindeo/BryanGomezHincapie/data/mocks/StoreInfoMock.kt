package com.tindeo.BryanGomezHincapie.data.mocks

import com.tindeo.BryanGomezHincapie.data.models.StoreInfo
// fuentes de datos
class StoreInfoMock {
    fun loadInfo(): StoreInfo {
        return StoreInfo(
            "1",
            "La curiteña",
            "https://cdn.pixabay.com/photo/2014/04/02/13/07/choctaw-bluff-305932_960_720.jpg",
            "Calle 20 #10-15 Bogotá",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
            null,
            null,
            5,
        )
    }
}