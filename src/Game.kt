fun main(args: Array<String>) {
    val options = arrayOf("Rock", "Paper", "Scissors")
    val emojiMap = mapOf("Rock" to "🪨", "Paper" to "📄", "Scissors" to "✂️")

    var userScore = 0
    var computerScore = 0
    var roundsPlayed = 0
    var playAgain: String

    do {
        val gameChoice = getGameChoice(options)
        val userChoice = getUserChoice(options, emojiMap)
        val result = determineResult(userChoice, gameChoice)

        println("\nYou chose: ${emojiMap[userChoice]} ($userChoice)")
        println("The computer chose: ${emojiMap[gameChoice]} ($gameChoice)")
        println(result)

        // Update scores based on the result
        if (result.contains("Win")) userScore++
        else if (result.contains("Lose")) computerScore++

        roundsPlayed++
        println("\nScore: You $userScore - $computerScore Computer (Rounds: $roundsPlayed)")

        // Ask if the user wants to play again
        println("Play again? (yes/no)")
        playAgain = readLine()?.lowercase() ?: "no"
    } while (playAgain == "yes")

    // Final Score
    println("\nFinal Score: You $userScore - $computerScore Computer")
    println(
        if (userScore > computerScore) "🎉 Congratulations! You are the champion! 🎉"
        else if (userScore < computerScore) "😢 Better luck next time! 😢"
        else "🤝 It's a draw! Well played! 🤝"
    )
}

// Get the computer's choice
fun getGameChoice(optionsParam: Array<String>) = optionsParam[(Math.random() * optionsParam.size).toInt()]

// Get and validate the user's choice
fun getUserChoice(optionsParam: Array<String>, emojiMap: Map<String, String>): String {
    var isValidChoice = false
    var userChoice = ""

    while (!isValidChoice) {
        print("Enter one of the following:")
        optionsParam.forEach { print(" ${emojiMap[it]} ($it)") }
        println(".")
        val userInput = readLine()
        if (userInput != null && userInput in optionsParam) {
            isValidChoice = true
            userChoice = userInput
        } else {
            println("You must enter a valid choice!")
        }
    }
    return userChoice
}

// Determine the result of the game
fun determineResult(userChoice: String, gameChoice: String): String {
    return when {
        userChoice == gameChoice -> "🤝 It's a Draw!"
        (userChoice == "Rock" && gameChoice == "Scissors") ||
                (userChoice == "Scissors" && gameChoice == "Paper") ||
                (userChoice == "Paper" && gameChoice == "Rock") -> "🎉 You Win!"
        else -> "😢 You Lose!"
    }
}
