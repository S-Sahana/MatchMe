package games.dev.matchme;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Items {
    private static final List<Items1> images = new ArrayList<Items1>() {{
        add(new Items1(1,R.drawable.image_1));
        add(new Items1(2,R.drawable.image_2));
        add(new Items1(3,R.drawable.image_3));
        add(new Items1(4,R.drawable.image_4));
        add(new Items1(5,R.drawable.image_5));
        add(new Items1(6,R.drawable.image_6));
        add(new Items1(7,R.drawable.image_7));
        add(new Items1(8,R.drawable.image_8));
        add(new Items1(1,R.drawable.image_1));
        add(new Items1(2,R.drawable.image_2));
        add(new Items1(3,R.drawable.image_3));
        add(new Items1(4,R.drawable.image_4));
        add(new Items1(5,R.drawable.image_5));
        add(new Items1(6,R.drawable.image_6));
        add(new Items1(7,R.drawable.image_7));
        add(new Items1(8,R.drawable.image_8));


    }};

    public static List<Items1> getImages() {
        Collections.shuffle(images);
        return images;
    }

    public static class Items1 {
        public final int name;
        public final int drawableId;

        Items1(int name, int drawableId) {
            this.name = name;
            this.drawableId = drawableId;
        }
    }

}

