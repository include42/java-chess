package chess.domain.pieces;

import chess.domain.position.Position;
import chess.domain.Team;

public class King extends Piece {
    private static final double SCORE = 0;
    private static final int DISTANCE_FOR_FOUR_DIRECTION = 1;
    private static final int DISTANCE_FOR_DIAGONAL_DIRECTION = 2;

    public King(Position position, Team team) {
        super(position, team);
    }

    @Override
    public boolean canMove(Position position) {
        return this.position.getDistanceSquare(position) == DISTANCE_FOR_FOUR_DIRECTION
                || this.position.getDistanceSquare(position) == DISTANCE_FOR_DIAGONAL_DIRECTION;
    }

    @Override
    public double getScore() {
        return SCORE;
    }

    @Override
    public String getSymbol() {
        return "k";
    }

    @Override
    public String toString() {
        return "KING";
    }
}