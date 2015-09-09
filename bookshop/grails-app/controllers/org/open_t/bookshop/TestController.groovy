package org.open_t.bookshop

class TestController {

    def index() {
        ApiHelper apiHelper = new ApiHelper()
        def response = apiHelper.getBookByIsbn("1234567891234")
        System.out.println(response)
    }
}
