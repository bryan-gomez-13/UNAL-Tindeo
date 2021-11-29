package com.tindeo.BryanGomezHincapie.data.mocks

import com.tindeo.BryanGomezHincapie.data.models.Product

class ProductMock {
    fun loadProduct(): List<Product> {
        return listOf(
            Product("1","Product 1","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.","$10000", "https://cdn.pixabay.com/photo/2017/03/23/19/57/asparagus-2169305_960_720.jpg"),
            Product("2","Product 2","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.","$10000", "https://cdn.pixabay.com/photo/2013/06/09/06/07/meat-123668_960_720.jpg"),
            Product("3","Product 3","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.","$10000", "https://cdn.pixabay.com/photo/2014/05/05/19/52/charcuterie-338498_960_720.jpg"),
            Product("4","Product 4","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.","$10000", "https://cdn.pixabay.com/photo/2016/05/04/11/20/cheese-1371196_960_720.jpg"),
            Product("5","Product 5","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.","$10000", "https://cdn.pixabay.com/photo/2016/12/06/18/27/cheese-1887233_960_720.jpg"),
            Product("6","Product 6","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.","$10000", "https://cdn.pixabay.com/photo/2017/03/23/19/57/asparagus-2169305_960_720.jpg"),
            Product("7","Product 7","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.","$10000", "https://cdn.pixabay.com/photo/2017/03/23/19/57/asparagus-2169305_960_720.jpg"),
            Product("8","Product 8","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.","$10000", "https://cdn.pixabay.com/photo/2017/03/23/19/57/asparagus-2169305_960_720.jpg"),
            Product("9","Product 9","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.","$10000", "https://cdn.pixabay.com/photo/2017/03/23/19/57/asparagus-2169305_960_720.jpg"),
            Product("10","Product 10","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.","$10000", "https://cdn.pixabay.com/photo/2017/03/23/19/57/asparagus-2169305_960_720.jpg")
        )
    }
}