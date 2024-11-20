fun main(args: Array<String>) {
    val options = arrayOf("Rock","Paper","Scissors")
    val gameChoice = getGameChoice(options)
    val userChoice = getUserChoice(options)
    printResult(userChoice,gameChoice)
}

fun getGameChoice(optionsParam: Array<String>) = optionsParam[(Math.random()*optionsParam.size).toInt()]

fun getUserChoice(optionsParam: Array<String>): String {
    var isValidChoice = false
    var userChoice = ""
    while (!isValidChoice) {
        print("Enter one of the following:")
        for (item in optionsParam) print(" $item")
        println(".")
        val userInput = readLine()
        if(userInput != null && userInput in optionsParam) {
            isValidChoice = true
            userChoice = userInput
        }
        if(!isValidChoice) {
            println("You must enter a valid choice!")
        }
    }

    return userChoice
}

fun printResult(userChoice:String, gameChoice:String) {
    val result: String
    if(userChoice == gameChoice) result = "Draw"
    else if ((userChoice=="Rock" && gameChoice=="Scissors")||
        (userChoice=="Scissors" && gameChoice=="Paper")||
        (userChoice=="Paper" && gameChoice=="Rock"))
        result = "You Win!"

    else result = "You Lose!"

    println(result)
}