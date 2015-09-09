package org.open_t.bookshop

class Calendar {

    static listProperties=[ 'title','draft','eventStart','eventEnd' ]

    // Fields
    String title

    boolean draft=false

    boolean schedulePublish=false
    Date publishDate
    Date removeDate

    Date eventStart
    Date eventEnd

    String shortContent
    String content

    Date dateCreated
    Date lastUpdated

    static constraints = {
        publishDate		nullable:true
        removeDate		nullable:true
        shortContent	size:0..50000
        content			size:0..50000
        dateCreated		nullable:true, editable:false
        lastUpdated		nullable:true, editable:false
    }

    // Methods
    String toString() {
        return "${title}"
    }


    //Todo controleren of deze niet weg mag
    static List activeItems(params) {

        def theFirstResult=params.offset?new Integer(params.offset):0
        def theMaxResults=params.max?new Integer(params.max):4
        def theOrder=params.order?params.order:"asc"
        def theSort=params.sort?params.sort:"eventStart"
        def theDraft=params.draft?new Boolean(params.draft):false

        def now = new Date();
        def c = Calendar.createCriteria()
        def calendarInstanceList = c.list {
            if (theDraft) {
                eq('draft',false)
            }
            or {
                eq('schedulePublish',false)
                and {
                    eq('schedulePublish',true)
                    le('publishDate',now)
                    ge('removeDate',now)
                }
            }
            order(theSort,theOrder)
            firstResult(theFirstResult)
            maxResults(theMaxResults)
        }
        return calendarInstanceList
    }
}
