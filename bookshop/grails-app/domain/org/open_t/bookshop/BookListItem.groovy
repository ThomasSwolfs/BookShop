package org.open_t.bookshop

class BookListItem {

    static listProperties=[ 'position','book','title' ]

    static belongsTo = [ bookList:BookList ]

    // Fields
    String isbn
    String title
    String content
    int position

    static constraints = {
        isbn        size:13..13
        title		nullable:true
        content		size:0..50000

        bookList	display:false
        position	display:false
    }

    // Methods
    String toString() {
        // todo return "${position} - ${book.title}"
    }
}
