package de.satadev;

public class Token {

    final TokenType tokenType;

    final String lexme;

    final Object literal;

    final int line;

    public Token(TokenType tokenType, String lexme, Object literal, int line) {
        this.tokenType = tokenType;
        this.lexme = lexme;
        this.literal = literal;
        this.line = line;
    }

    @Override
    public String toString() {
        return "Token{" +
                "tokenType=" + tokenType +
                ", lexme='" + lexme + '\'' +
                ", literal=" + literal +
                ", line=" + line +
                '}';
    }
}
