package chess.domain.piece.movable;

import chess.domain.position.PositionFactory;
import chess.domain.position.Column;
import chess.domain.position.Position;
import chess.domain.position.Row;
import chess.domain.piece.Color;
import chess.domain.piece.Piece;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class BishopMovable implements Movable {
	@Override
	public Set<Position> createMovablePositions(Position position, List<Piece> pieces, Color color) {
		Directions moveDirections = Directions.DIAGONAL;
		Set<Position> movablePositions = new HashSet<>();
		for (Direction direction : moveDirections.getDirections()) {
			Position movablePosition = position;
			while (true) {
				Optional<Position> optionalPosition = checkBoundary(movablePosition, direction);
				if (!optionalPosition.isPresent()) {
					break;
				}
				movablePosition = optionalPosition.get();
				if (!checkMovable(movablePosition, pieces, color)) {
					break;
				}
				movablePositions.add(movablePosition);
				if (isPossessed(movablePosition, pieces)) {
					break;
				}
			}
		}
		return movablePositions;
	}

	private boolean isPossessed(Position movablePosition, List<Piece> pieces) {
		for (Piece piece : pieces) {
			if (piece.getPosition().equals(movablePosition)) {
				return true;
			}
		}
		return false;
	}

	private Optional<Position> checkBoundary(Position position, Direction direction) {
		Row row = position.getRow();
		Column column = position.getColumn();
		if (position.checkBound(direction)) {
			Row validRow = row.calculate(direction.getXDegree());
			Column validColumn = column.calculate(direction.getYDegree());
			return Optional.ofNullable(PositionFactory.of(validRow, validColumn));
		}
		return Optional.empty();
	}

	private boolean checkMovable(Position position, List<Piece> pieces, Color color) {
		for (Piece piece : pieces) {
			if (piece.getPosition().equals(position) && piece.getColor().isSame(color)) {
				return false;
			}
		}
		return true;
	}
}
