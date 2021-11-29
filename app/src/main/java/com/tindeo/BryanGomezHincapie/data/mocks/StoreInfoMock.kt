package com.tindeo.BryanGomezHincapie.data.mocks

import com.tindeo.BryanGomezHincapie.data.models.StoreInfo
// fuentes de datos
class StoreInfoMock {
    fun loadInfo(): StoreInfo {
        return StoreInfo(
            "1",
            "Mi tienda",
            "https://cdn.pixabay.com/photo/2016/03/22/09/08/online-store-1272390_960_720.png",
            "calle Falsa 123",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
            null,
            null,
            5,
        )
    }
}