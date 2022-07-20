package project.board;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleBoardTest {

    @Test
    void classique(){
        RectangleBoard board = new RectangleBoard(100,100, 0);
        Position position = new Position(board, 25, 50);
        assertTrue(position.move(10, 20));

        assertEquals(35, position.getX());
        assertEquals(70, position.getY());
    }

    @Test
    void depassement(){
        assertThrows(IllegalArgumentException.class, () ->
                new RectangleBoard(-5, 2, 0));

        assertThrows(IllegalArgumentException.class, () ->
                new RectangleBoard(5, -2, 0));

        Board board = new RectangleBoard(10, 10, 0);

        assertThrows(IllegalArgumentException.class, () ->
                new Position(board, -3, 2));

        assertThrows(IllegalArgumentException.class, () ->
                new Position(board, 3, -2));

        Position position = new Position(board, 3, 2);
        assertFalse(position.move(-4, 0));

        Position position2 = new Position(board, 3, 2);

        assertFalse(position2.move(7, 0));
    }
}