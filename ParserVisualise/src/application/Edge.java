package application;

public class Edge {
	
private Token from;
private Token to;
private String label;
private String description = "No Description";

public Edge(Token from, Token to, String label, String description) {
	this.from = from;
	this.to = to;
	this.label = label;
	this.description = description;

}

public String getDescription() {
    return description;
}

public Token getFrom() {
    return from;
}

public void setDescription(String description) {
    this.description = description;
}

public Token getTo() {
    return to;
}

public String getLabel() {
    return label;
}

public int getLength() {
    return Math.abs(from.getIndex() - to.getIndex());
}
}