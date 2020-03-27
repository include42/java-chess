package chess.domain.piece;

import chess.domain.piece.movable.KnightMovable;
import chess.domain.position.Position;

public class Knight extends Piece {
	public Knight(Position position, String name, Color color) {
		super(position, name, new KnightMovable(), color, 2.5);
	}
}
