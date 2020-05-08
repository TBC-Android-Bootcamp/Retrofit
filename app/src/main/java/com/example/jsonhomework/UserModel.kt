package com.example.jsonhomework

class UserModel {
    var page:Int=0
    var perPage=0
    var total=0
    var totalPages=0
    lateinit var dataList:MutableList<Data>
    lateinit var adlist:MutableList<Ad>


    class Data( var id:Int=0,
                var email:String="",
                var firstName:String="",
                var lastName:String="",
                var avatar:String=""){

    }

    class Ad {
        var company:String=""
        var url:String=""
        var text:String=""
    }
}