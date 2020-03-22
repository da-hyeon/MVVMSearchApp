package com.example.mvvmsearchapp.model.response

//
//{
//    "documents": [
//    {
//        "collection": "blog",
//        "datetime": "2017-05-19T01:10:00.000+09:00",
//        "display_sitename": "네이버블로그",
//        "doc_url": "http://blog.naver.com/************/221009090..........",
//        "height": 250,
//        "image_url": "http://postfiles1.naver.net/MjAxNzA2MDdfMj..........",
//        "thumbnail_url": "https://search1.kakaocdn.net/argon/130..........",
//        "width": 250
//    }
//    ],
//    "meta": {
//    "is_end": false,
//    "pageable_count": 3977,
//    "total_count": 5675
//}
//}

data class ImageSearchResponse(
    var documents: ArrayList<Document>,
    var meta: Meta
) {
    data class Document(
        var collection: String,
        var thumbnail_url: String,
        var image_url: String,
        var width: Int,
        var height: Int,
        var display_sitename: String,
        var doc_url: String,
        var datetime: String
    )

    data class Meta(
        var total_count: Int,
        var pageable_count: Int,
        var is_end: Boolean
    )
}