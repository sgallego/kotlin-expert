
data class Note(
    val title: String,
    val description: String,
    val type: Type
){

    enum class Type{
        TEXT, AUDIO
    }

}



fun getNotes(): List<Note>{

    val notes = mutableListOf<Note>()
    for(i in 1..10){
        notes.add(Note(
            "Title $i",
            "Description $i",
            if(i%3 ==0) Note.Type.AUDIO else Note.Type.TEXT
        ))
    }
    return notes

}