class Song(val title:String,val artist:String) {
    fun play() {
        println("Playing the song $title by artist $artist")
    }
    fun stop() {
        println("Stop playing $title")
    }
}

fun main(args:Array<String>) {
    val songOne = Song("Cry","Cigarettes after sex")
    val songTwo = Song("Sweet","Cigarettes after sex")

    songOne.play()
    songTwo.play()
    songTwo.stop()
}