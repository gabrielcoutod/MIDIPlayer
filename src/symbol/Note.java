package symbol;

//Symbol from input text that represents a Note.
public class Note extends Symbol {
 private Notes note;

 public Note(Notes note) {
	 this.note = note;
 }

 public Notes getNote() {
	 return note;
 }
}