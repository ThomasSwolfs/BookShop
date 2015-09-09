package org.open_t.bookshop

class Customer {

    static listProperties = ['id','username','firstName','lastName','email','active']

    String username
    String passwd

    String companyName

    String title
    String firstName
    String middleName
    String lastName

    String email
    String phoneNumber
    String mobilePhoneNumber

    String streetName
    String houseNumber
    String houseNumberExtra
    String zipCode
    String city
    String country

    boolean active = true
    boolean newsletter=false


    int badPasswordAttempts=0

    boolean payByInvoice=false

    static constraints = {
        username			blank:false, unique:true
        passwd				blank:false

        companyName			nullable:true, size:1..40

        title				nullable:true
        firstName			blank:false, size:1..40
        middleName			nullable:true, size:0..20
        lastName			blank:false, size:1..40

        email				blank:false, email:true
        phoneNumber			nullable:true
        mobilePhoneNumber	nullable:true

        streetName			blank:false, size:1..40
        houseNumber			blank:false, size:1..20
        houseNumberExtra	blank:true,  size:0..20
        zipCode				blank:false
        city				blank:false, size:1..40
        country				blank:false, size:1..40

/*		active				*/
    }

    //***
    String toString() {
        return "${fullName} (${username})";
    }

    def getFullName() {
        //Vries, Willem de
        def fullName = lastName;
        if ( firstName && false == firstName.trim().isEmpty() ) {
            fullName += ", ${firstName}"
            if ( middleName && false == middleName.trim().isEmpty() ) {
                fullName += " ${middleName}"
            }
        }
        return fullName
    }

    def getAcDescription() {
        return "${username} ${email}"
    }

    def getAcLabel() {
        return fullName
    }
}
