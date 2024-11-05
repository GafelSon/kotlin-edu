class Book(
        var title: String,
        var author: String,
        var yearPublished: Int,
        var isAvailable: Boolean = true // Default Setup!
) {
  fun borrow() {
    if (isAvailable) {
      isAvailable = false
      println("You've successfully borrowed '$title' by $author.")
    } else {
      println("Sorry, '$title' is currently not available for borrowing.")
    }
  }

  fun returnBook() {
    isAvailable = true
    println("Thank you for returning '$title'.")
  }

  fun displayInfo() {
    println("Title: '$title'")
    println("Author: $author")
    println("Year Published: $yearPublished")
    println("Available: ${if (isAvailable) "Yes" else "No"}")
  }
}

class Library {
  private val books = mutableListOf<Book>()

  fun addBook(book: Book) {
    books.add(book)
    println("Added '${book.title}' to the library collection.")
  }

  /*
  fun listAvailableBooks() {
      println("Available Books in the Library:")
      var hasAvailableBooks = false

      for (book in books) {
          if (book.isAvailable) {
              book.displayInfo()
              println()
              hasAvailableBooks = true
          }
      }

      if (!hasAvailableBooks) {
          println("No books are currently available.")
      }
  }
  */

  fun listAvailableBooks() {
    println("Available Books in the Library:")
    val availableBooks = books.filter { it.isAvailable }
    if (availableBooks.isNotEmpty()) {
      availableBooks.forEach {
        it.displayInfo()
        println()
      }
    } else {
      println("No books are currently available.")
    }
  }

  fun listNotAvailableBooks() {
    // Todo :: make function to list not availalble books
  }
}

fun main() {

  fun spacer() {
    return println("-".repeat(40)) // For better vesion
  }

  spacer()
  println("Soheil Fouladvandi")
  spacer()

  val library = Library()

  val book1 = Book("Sophie’s World", "Jostein Gaarder", 1949)
  val book2 = Book("soheil’s World - soheil", "soheil Fouladvandi", 2024)
  val book3 = Book("amir’s World - amir", "EMI", 2025)

  library.addBook(book1)
  library.addBook(book2)
  library.addBook(book3)
  spacer()

  book1.borrow()
  book2.borrow()
  spacer()

  library.listAvailableBooks()
}
