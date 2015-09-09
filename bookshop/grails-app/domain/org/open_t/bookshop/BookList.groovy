package org.open_t.bookshop

import java.util.Date;

class BookList {

    static listProperties = [ 'name','title','dateCreated','lastUpdated' ]

    //static hasMany = [ bookListItem: BookListItem ]


    // Fields
    String name
    String title

    Date dateCreated
    Date lastUpdated

    String content

    boolean numberedList

    static constraints = {
        title			nullable:true
        content			size:0..50000
        dateCreated		nullable:true, editable:false
        lastUpdated		nullable:true, editable:false
    }


    // Methods
    String toString() {
        return title
    }

}