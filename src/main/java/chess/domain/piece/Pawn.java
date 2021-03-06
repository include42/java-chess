package chess.domain.piece;

import chess.domain.board.position.Position;
import chess.domain.piece.movable.PawnMovable;

public class Pawn extends Piece {
	public Pawn(Position position, String name, Color color) {
		super(position, name, new PawnMovable(), color, 1);
	}

	@Override
	public boolean isPawn() {
		return true;
	}
}
