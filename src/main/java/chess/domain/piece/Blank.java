package chess.domain.piece;

import chess.domain.piece.movable.Directions;
import chess.domain.piece.movable.UnblockedMovable;
import chess.domain.position.PositionFactory;


public class Blank extends Piece {

	public static final String BLANK_DEFAULT_POSITION = "a1";

	public Blank() {
		super(PositionFactory.of(BLANK_DEFAULT_POSITION), PieceType.BLANK, new UnblockedMovable(Directions.NONE), Color.NONE);
	}

	@Override
	public String getResource() {
		return getPieceType().getResource();// TODO: 2020/03/28 빈 칸에 대한 리소스값은 이후 다시 검토할것
	}
}
