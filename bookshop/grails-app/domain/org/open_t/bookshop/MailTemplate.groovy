package org.open_t.bookshop

import java.util.Date;

class MailTemplate {
    static listProperties=['name','subject','dateCreated']

    // Fields
    String name
    String subject
    String body
    String fromAddress=null

    Date dateCreated
    Date lastUpdated

    static constraints = {
        dateCreated		nullable:true
        lastUpdated		nullable:true
        fromAddress		nullable:true
        body			size:0..50000

    }
}