
data class Note(
    val title: String,
    val description: String,
    val type: Type
){

    enum class Type{
        TEXT, AUDIO
    }

}



fun getNotes(callback: (List<Note>) -> Unit){

    Thread.sleep(2000)

    val notes = (0..10).map{
        Note(
            "Title $it",
            "Description $it",
            if(it%3 ==0) Note.Type.AUDIO else Note.Type.TEXT
        )
    }
    callback(notes)


}