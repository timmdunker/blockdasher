package blockdasher;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.graphics.*;


public class BlockUI extends View {

    private MainActivity activity;
    private float x;
    private float y;
    Player p;
    MovingAdapter ma = new MovingAdapter();

    private Cube[] cub;

    public void updateBoard() {
        activity.runOnUiThread(new Runnable() {
            public void run() {
                BlockUI.this.invalidate();
            }
        });

    }

    class MovingAdapter implements OnTouchListener {


        public boolean onTouch(View BlockUI, MotionEvent me) {

            int action = me.getActionMasked();

            switch (action) {
                case MotionEvent.ACTION_DOWN:
                        p.setMyPlayer(me.getX());

                    break;

                case MotionEvent.ACTION_MOVE:


                        p.setMyPlayer(me.getX());

                    break;
            }


            return true;
        }
    }

    public BlockUI(Context context) {
        super(context);
    }

    public BlockUI(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BlockUI(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setActivity(MainActivity activity) {
        this.activity = activity;
    }


    public void setCP(Cube[] c, Player p) {
        cub = c;
        this.p = p;
    }

    public void onDraw(Canvas g) {


        Paint paint1 = new Paint();
        paint1.setColor(Color.WHITE);
        Paint paint2 = new Paint();
        paint2.setColor(Color.BLACK);
        Paint paint3 = new Paint();
        paint3.setColor(Color.MAGENTA);
        Paint paint4 = new Paint();
        paint4.setColor(Color.GREEN);
        Paint paint5 = new Paint();
        paint5.setColor(Color.GRAY);
//        g.drawRect(0,0,this.getWidth(),this.getHeight(), paint3);

//        g.drawRect(100,100,700,700, paint3);
        g.drawRect(700, 0, 1080, 1535, paint5);
//        g.drawRect(p.getMyPlayer(), paint4);

        for (int i = 0; i < cub.length; i++) {
            g.drawRect(cub[i].getRekt(), paint2);
            cub[i].update();
        }

    }
}
