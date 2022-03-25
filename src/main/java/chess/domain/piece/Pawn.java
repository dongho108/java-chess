package chess.domain.piece;

import chess.domain.piece.property.Color;
import chess.domain.piece.state.started.StartedPawn;

public final class Pawn extends Piece {
    private static final String NAME = "p";

    public Pawn(Color color) {
        super(color, NAME, new StartedPawn(color.forward()));
    }

    // private Pawn(Color color, State state) {
    //     super(color, NAME, state);
    //     // 1 : 0
    //     // true : false
    //     // Enum
    //     // Color (1, true);
    //     // Black (Direction.Down)
    //     // forward = color.getDirection()
    // }

    // public static Pawn of(Color color) {
    //     return new Pawn(color)
        // if (color == Color.White) {
        //     return new Pawn(color, new StartedWhitePawn());
        // }
        // return new Pawn(color, new StartedBlackPawn());
    // }
}
