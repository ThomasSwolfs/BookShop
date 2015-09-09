package org.open_t.bookshop

import org.apache.http.*
import org.apache.http.client.*
import org.apache.http.impl.client.DefaultHttpClient
import org.apache.http.auth.*
import org.apache.http.client.methods.*
import org.apache.http.entity.*
import org.springframework.web.multipart.*
import java.net.*
import org.opent.bookdata.enums.*
import com.fasterxml.jackson.databind.ObjectMapper


import groovyx.net.http.HTTPBuilder
import static groovyx.net.http.Method.GET
import static groovyx.net.http.ContentType.TEXT

class ApiHelper {

    def grailsApplication

    /**
     * Retrieves JSON from BookData API
     *
     * @param isbn ISBN of the book to search for.
     * @param path path of the api
     * @return Server HTTP response (JSON) or false if something went wrong
     */

    def getJsonByIsbn(String isbn, String path = "/bookdata/Api/getByIsbn") throws Exception {

        //println 'http://www.google.com'.toURL().text


        def http = new HTTPBuilder("http://213.187.246.178:8080")

        http.get(path: path,
                contentType: TEXT,
                query: [apikey: '9f1fba0b4b5a51a6b583700e5c24699b', isbn: '9789048417957']) { resp, reader ->

            println "response status: ${resp.statusLine}"
            println 'Headers: -----------'
            resp.headers.each { h ->
                System.out.println(" ${h.name} : ${h.value}")
            }
            println 'Response data: -----'
            System.out << reader
            println '\n--------------------'
        }


        /*
        def http = new HTTPBuilder()

        http.request( '213.187.246.178:8080', GET, TEXT ) { req ->
            //uri.port = 8080
            uri.path = '/bookdata/Api/getByIsbn?apikey=9f1fba0b4b5a51a6b583700e5c24699b&isbn=9789048417957'
            //uri.query = [ v:'1.0', q: 'Calvin and Hobbes' ]
            //headers.'User-Agent' = "Mozilla/5.0 Firefox/3.0.4"
            //headers.Accept = 'application/json'

            response.success = { resp, reader ->
                assert resp.statusLine.statusCode == 200
                println "Got response: ${resp.statusLine}"
                println "Content-Type: ${resp.headers.'Content-Type'}"
                println reader.text
            }

            response.'404' = {
                println 'Not found'
            }
        }

*/
        /*
        try{
            // create the http client
            def client=new DefaultHttpClient()

            // define to wich HOST the get should be send
            def httpwrite = new HttpPost(url + path + "?apiKey=" + apiKey + "&isbn=" + isbn)

            // define content type
            httpwrite.addHeader("Content-Type","ANY")

            //create body of request
            def entity = new FileEntity(file,"ANY")

            // execute the request
            HttpResponse response = client.execute(httpwrite)

            return response

        }catch(Exception e){
            //todo ErrorLog errorLog = new ErrorLog(date: new Date(), message: e.toString())
            //todo errorLog.save()
            return false
        }
        */

    }

    /**
     * Converts JSON data based on a given ISBN to an Object instance.
     *
     * @param isbn ISBN of the book to search for.
     * @return Object with the data related to the given isbn.
     */
     Object getBookByIsbn(String isbn) {

        ObjectMapper objectMapper = new ObjectMapper()

        //return getJsonByIsbn(isbn)
        return objectMapper.readValue(getJsonByIsbn(isbn), Object.class)
    }
}
