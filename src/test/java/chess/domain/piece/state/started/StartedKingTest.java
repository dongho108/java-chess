package chess.domain.piece.state.started;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import chess.domain.game.state.position.File;
import chess.domain.game.state.position.Position;
import chess.domain.game.state.position.Rank;
import chess.domain.piece.King;
import chess.domain.piece.Piece;
import chess.domain.piece.property.Color;
import chess.domain.piece.state.Dead;
import chess.domain.piece.state.PieceState;

class StartedKingTest {

    private Map<Position, Piece> board;
    private Position source;
    private Piece sourcePiece;

    @Test
    @DisplayName("Started상태에서 die시 dead로 변해야한다. ")
    void die() {
        PieceState pieceState = new StartedKing();
        assertThat(pieceState.die()).isInstanceOf(Dead.class);
    }

    @Test
    @DisplayName("Started상태에서 updateState시 자신의 상태로 돌아와야 한다.")
    void updateState() {
        PieceState pieceState = new StartedKing();
        assertThat(pieceState.updateState()).isInstanceOf(StartedKing.class);
    }

    @Test
    @DisplayName("현재 상태에서 가능한 Positions 을 가져와야 한다.")
    void findMovablePositions() {
        initBoard();
        List<Position> positions = sourcePiece.findMovablePositions(source, board);
        assertThat(positions)
            .hasSize(7)
            .contains(
                Position.of(File.d, Rank.Four),
                Position.of(File.d, Rank.Three),
                Position.of(File.d, Rank.Two),
                Position.of(File.c, Rank.Two),
                Position.of(File.b, Rank.Two),
                Position.of(File.b, Rank.Three),
                Position.of(File.b, Rank.Four)
            );
    }

    void initBoard() {
        board = new HashMap<>();
        source = Position.of(File.c, Rank.Three);
        sourcePiece = new King(Color.White);

        board.put(source, sourcePiece);
        board.put(Position.of(File.c, Rank.Four), new King(Color.White));
        board.put(Position.of(File.f, Rank.Six), new King(Color.Black));
        board.put(Position.of(File.g, Rank.Seven), new King(Color.Black));
    }
}