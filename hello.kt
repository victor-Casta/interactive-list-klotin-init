fun main() {
    val inmutableFrameworks = listOf(
        "Vue",
        "Laravel",
        "Mockito",
        "Ruby on Rails",
        "Express.js",
        "Spring Boot",
        "Flask",
        "Ember.js",
        "ASP.NET",
        "Symfony",
        "ASP.NET Core",
        "Play Framework",
        "Meteor",
        "CakePHP",
        "Struts",
        "Sails.js",
        "Aurelia"
    )
    val mutableFrameworks = inmutableFrameworks.toMutableList()
    println("Original List: $inmutableFrameworks")

    while (true) {
        println("\nChoose an option:")
        println("1. Add Framework")
        println("2. Remove Framework")
        println("3. Search Framework")
        println("4. Verify Framework")
        println("5. List Frameworks")
        println("6. Total Frameworks")
        println("7. Most Ten Elements")
        println("8. Less Two Elements")
        println("9. Quit")

        val option = readLine()?.toIntOrNull()

        if (option == null || option !in 1..9) {
            println("Invalid option. Please choose a valid option.")
            continue
        }

        if (option == 9) {
            println("Exiting the program.")
            break
        }

        interactiveList(option, mutableFrameworks)
    }
}

fun interactiveList(index: Int, listOfFrameworks: MutableList<String>) {
    when (index) {
        1 -> addFrameworks(listOfFrameworks)
        2 -> removeFrameworks(listOfFrameworks)
        3 -> searchFrameworks(listOfFrameworks)
        4 -> verifyFrameworks("Vue", listOfFrameworks)
        5 -> frameworksInList(listOfFrameworks)
        6 -> totalFrameworks(listOfFrameworks)
        7 -> mostTenElements(listOfFrameworks)
        8 -> lessTwoElements(listOfFrameworks)
        else -> println("Incorrect option")
    }
}

//function for add frameworks
fun addFrameworks(listOfFrameworks: MutableList<String>) {
    println("Enter the name of the framework you want to add:")
    val newFramework = readLine()?.trim()

    if (newFramework.isNullOrEmpty()) {
        println("Invalid input. Please enter a valid framework name.")
        return
    }

    if (listOfFrameworks.contains(newFramework)) {
        println("$newFramework already exists in the list.")
    } else {
        listOfFrameworks.add(newFramework)
        println("$newFramework added to the list.")
    }
}


//funtion for remove frameworks
fun removeFrameworks(listOfFrameworks: MutableList<String>) {
    println("Enter the name of the framework you want to remove:")
    val frameworkToRemove = readLine()?.trim()

    if (frameworkToRemove.isNullOrEmpty()) {
        println("Invalid input. Please enter a valid framework name.")
        return
    }

    if (listOfFrameworks.contains(frameworkToRemove)) {
        listOfFrameworks.remove(frameworkToRemove)
        println("$frameworkToRemove removed from the list.")
    } else {
        println("$frameworkToRemove was not found in the list.")
    }
}


//search frameworks for positions
fun searchFrameworks(listOfFrameworks: List<String>) {
    println("Enter the position (index) of the framework you want to search:")
    val position = readLine()?.toIntOrNull()

    if (position == null || position !in 0 until listOfFrameworks.size) {
        println("Invalid position. Please enter a valid index.")
        return
    }

    val result = listOfFrameworks[position]
    println("The framework at position $position is: $result")
}


//verify that the framework is in the list of frameworks
fun verifyFrameworks(framework: String, listOfFrameworks: MutableList<String>) {
    val result: Boolean = listOfFrameworks.contains(framework)
    println("this is the framework in first the list of frameworks? $result")
}

//frameworks in the list of frameworks
fun frameworksInList(listOfFrameworks: List<String>) {
    println("frameworks saved: ")
    for(framework in listOfFrameworks) {
        println("- $framework")
    }
}

//total frameworks saved
fun totalFrameworks(listOfFrameworks: List<String>) {
    var total = 0
    for(framework in listOfFrameworks) {
        total++
    }
    println("total frameworks: $total")
}

//most ten elements in the list
fun mostTenElements(listOfFrameworks: List<String>) {
    val totalElements = listOfFrameworks.size
    if(totalElements > 10) {
        println("what a long list, use the delete function")
    } else {
        println("the list has less than ten elements")
    }
}

//less than two items
fun lessTwoElements(listOfFrameworks: List<String>) {
    val totalElements = listOfFrameworks.size
    if(totalElements < 2) {
        println("you need to make a longer list, use the add function")
    } else {
        println("the list has most two elements")
    }
}
