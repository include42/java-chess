package chess.domain.piece.movable;

import chess.domain.board.Board;
import chess.domain.board.position.Column;
import chess.domain.board.position.Position;
import chess.domain.board.position.Row;
import chess.domain.piece.Color;
import chess.domain.piece.Piece;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class KingMovable implements Movable {
	@Override
	public Set<Position> createMovablePositions(Position position, List<Piece> pieces, Color color) {
		List<Direction> moveDirection = Direction.everyDirection();
		Set<Position> movablePositions = new HashSet<>();
		for (Direction direction : moveDirection) {
			Optional<Position> optionalPosition = checkBoundary(position, direction);
			if (optionalPosition.isPresent()) {
				Position movablePosition = optionalPosition.get();
				if (checkMovable(movablePosition, pieces, color)) {
					movablePositions.add(movablePosition);
				}
			}
		}
		return movablePositions;
	}

	private Optional<Position> checkBoundary(Position position, Direction direction) {
		Row row = position.getRow();
		Column column = position.getColumn();
		if (Board.checkBound(position, direction)) {
			Row validRow = row.calculate(direction.getXDegree());
			Column validColumn = column.calculate(direction.getYDegree());
			return Optional.ofNullable(Board.of(validRow, validColumn));
		}
		return Optional.empty();
	}

	private boolean checkMovable(Position position, List<Piece> pieces, Color color) {
		for (Piece piece : pieces) {
			if (piece.isSamePosition(position) && piece.isSameColor(color)) {
				return false;
			}
		}
		return true;
	}
}
