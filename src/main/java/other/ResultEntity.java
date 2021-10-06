package other;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResultEntity {
    private int x;
    private float y;
    private int r;
    private LocalDateTime start;
    private LocalDateTime end;

    public ResultEntity(int x, float y, int r, LocalDateTime start) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.start = start;
    }
}
