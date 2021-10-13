package other;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResultEntity {
    private float x;
    private float y;
    private float r;
    private LocalDateTime start;
    private long scriptTime;
    private String result;
    private int xPx;
    private int yPx;

    public ResultEntity(float x, float y,float r, LocalDateTime start) {
        this.x = x;
        this.y = y;
        this.r = r;
        xPx = (int) ((100*this.x)/this.r+150);
        yPx = (int) (150-(100*this.y)/this.r);
        this.start = start;
    }

}
