package patternMatcher;

public class Note {
private int id;
private String to;
private String from;
private String heading;
private String body;

@Override
public String toString() {
	return "Note [id=" + id + ", to=" + to + ", from=" + from + ", heading=" + heading + ", body=" + body + "]";
}

public static class Builder{
	private Note note;

public Builder() {
	note=new Note();
}
public Builder setId(int id){
	note.id=id;
	return this;
}

public Builder setTo(String to){
	note.to=to;
	return this;
}
public Builder setFrom(String from){
	note.from=from;
	return this;
}
public Builder setHeading(String heading){
	note.heading=heading;
	return this;
}
public Builder setBody(String body){
	note.body=body;
	return this;
}
public Note build(){
	return note;
}
}
}
