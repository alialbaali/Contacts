class Contact(
    // Contact Attributes
    var firstName: String? = null,
    var lastName: String? = null,
    var phoneNumber: String?,
    var address: String? = null,
    var email: String? = null
) {
    // Overridden toString method
    override fun toString(): String {
        return "$firstName $lastName\n"
    }

    // Display all contact's info Method
    fun reviewContact(): String {
        return """
            ${println()}
            Name: ${firstName + " " + lastName}
            Phone number: $phoneNumber
            Address: $address
            Email: $email
            ${println()}
        """.trimIndent()
    }
}