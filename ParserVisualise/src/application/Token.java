package application;

public class Token implements Comparable<Token> {
	private int index;

	public Token(final int index) {
    this.index = index;
	}
	
	public int getIndex() {
        return index;
    }
	
	@Override
	public int compareTo(Token o) {
		return index - o.getIndex();
	}

}
