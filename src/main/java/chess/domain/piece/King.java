package chess.domain.piece;

import chess.domain.board.position.Position;
import chess.domain.piece.movable.KingMovable;

public class King extends Piece {

	public King(Position position, String name, Color color) {
		super(position, name, new KingMovable(), color, 0);
	}

	@Override
	public boolean isKing() {
		return true;
	}
}
