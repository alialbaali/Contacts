// Contact's List
val contacts: ArrayList<Contact> = ArrayList()

// Main Method
fun main() {
    menu()
}

// User Menu (first thing shows up while running the app)
fun menu() {
    println(
        """
        Pick a number:
        1. View a contact
        2. Add a contact
        3. Remove a contact
        4. Edit a contact
    """.trimIndent()
    )
    when (readLine()) {
        "1" -> viewContact()
        "2" -> addContact()
        "3" -> removeContact()
        "4" -> editContact()
        else -> println("Invalid number! ${menu()}")
    }
}

// View Contact Method
fun viewContact() {
    // Checking the size of the List
    if (contacts.size == 0) {
        println("\nYou don't have any contacts to view")
    } else {
        // Printing the all the contacts available in the list
        getContacts()
        println("\n^^^Viewing Contact^^^")
        println("Pick Contact's number")
        println(contacts.get(readLine()?.toInt()!!.minus(1)).reviewContact())
    }
    menu()
}

// Variables for the "addContact" Method
var firstName: String? = null
var lastName: String? = null
var phoneNumber: String? = null
var address: String? = null
var email: String? = null
// Adding Contact Method
fun addContact() {
    println("\n^^^Adding New Contact^^^")
    print("First Name: ")
    firstName = readLine()
    print("Last Name: ")
    lastName = readLine()
    print("Phone Number: ")
    // Checking if the number only contains numeric value
    if (readLine()?.matches("-?\\d+(\\.\\d+)?".toRegex())!!) {
        phoneNumber = readLine()
    } else {
        println("\nPhone number can not contain letters or be empty")
        menu()
    }
    print("Address: ")
    address = readLine()
    print("Email: ")
    email = readLine()
    println("Adding... ")
    // Creating New Contact
    contacts.add(Contact(firstName, lastName, phoneNumber, address, email))
    println("Contact has been added!")
    println()
    menu()
}

// Removing Contact Method
fun removeContact() {
    if (contacts.size == 0) {
        // Checking the size of the List
        println("\nYou don't have any contacts to remove")
    } else {
        // Printing the all the contacts available in the list
        getContacts()
        println("\n^^^Removing Contact^^^")
        println("Pick Contact's number")
        println(contacts.removeAt(readLine()?.toInt()!!.minus(1)))
    }
    menu()
}

// Editing Contact Method
fun editContact() {
    // Checking the size of the List
    if (contacts.size == 0) {
        println("\nYou don't have any contacts to edit")
    } else {
        // Printing the all the contacts available in the list
        getContacts()
        println("\n^^^Editing Contact^^^")
        println("Pick Contact's number")
        val index = readLine()?.toInt()!!.minus(1)
        println(contacts.get(readLine()?.toInt()!!.minus(1)).reviewContact())
        // Getting input from the user on what they want to edit
        println(
            """
        Edit: 
        1. First Name
        2. Last Name
        3. Phone Number
        4. Address
        5. Email
    """.trimIndent()
        )
        when (readLine()) {
            "1" -> editFirstName(index)
            "2" -> editLastName(index)
            "3" -> editPhoneNumber(index)
            "4" -> editAddress(index)
            "5" -> editEmail(index)
            else -> println("Invalid number! ${menu()}")
        }
    }
    menu()
}

// Method that print all the contacts in the list
fun getContacts() {
    for (contact in contacts) {
        for (a in 1..contacts.size)
            print("\n$a. $contact")
    }
}

// Editing Methods
fun editFirstName(index: Int) {
    print("First Name: ")
    contacts.get(index).firstName = readLine()
}

fun editLastName(index: Int) {
    print("Last Name: ")
    contacts.get(index).lastName = readLine()
}

fun editPhoneNumber(index: Int) {
    print("Phone Number: ")
    contacts.get(index).phoneNumber = readLine()
}

fun editAddress(index: Int) {
    print("Address: ")
    contacts.get(index).address = readLine()
}

fun editEmail(index: Int) {
    print("Email: ")
    contacts.get(index).email = readLine()
}
// That's it.